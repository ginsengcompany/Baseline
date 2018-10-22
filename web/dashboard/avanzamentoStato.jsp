<%@ include file="navigation.jsp" %>
<main ng-app="myApp" ng-controller="myCtrl">
    <style>
        html, body, #canvas {
            height: 100%;
            padding: 0;
            margin: 0;
        }
        .diagram-note {
            background-color: rgba(66, 180, 21, 0.7);
            color: White;
            border-radius: 5px;
            font-family: Arial;
            font-size: 12px;
            padding: 5px;
            min-height: 16px;
            width: 50px;
            text-align: center;
        }
        .highlight:not(.djs-connection) .djs-visual > :nth-child(1) {
            fill: green !important; /* color elements as green */
        }
    </style>
    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Avanzamento Stato paziente</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">WorkFlow Engine</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <select id="bpmnList1" class="mdb-select colorful-select dropdown-primary mx-2 initialized" onchange="changeList()">
                <option value="" disabled selected>Seleziona BPMN</option>
            </select>

            <select id="paziente1" class="mdb-select colorful-select dropdown-primary mx-2 initialized" onchange="getXml()">
                <option value="" disabled selected>Seleziona Paziente</option>
            </select>

            <div id="canvas" style="height: 1000px;"></div> 

            <button type="button" id="avanza" name="submit" class="btn btn-primary" onclick="openModal()" data-toggle="modal" data-target="#fullHeightModalRight"  style="display: none">Avanzamento<i class="fa fa-upload ml-2"></i></button>
        </div>

    </div>

    <!-- Full Height Modal Right -->
    <div class="modal fade right" id="fullHeightModalRight" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

        <!-- Add class .modal-full-height and then add class .modal-right (or other classes from list above) to set a position to the modal -->
        <div class="modal-dialog modal-full-height modal-right" role="document">


            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title w-100" id="myModalLabel">Avanzamento</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="renderForm">

                </div>
                <div class="modal-footer justify-content-center">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Chiudi</button>
                    <button type="button" id="submitForm" class="btn btn-primary">Salva</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Full Height Modal Right -->

    <!-- Central Modal Medium Success -->
    <div class="modal fade" id="centralModalSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-notify modal-success" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Header-->
                <div class="modal-header">
                    <p class="heading lead">Avanzamento Stato paziente</p>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" class="white-text">&times;</span>
                    </button>
                </div>

                <!--Body-->
                <div class="modal-body">
                    <div class="text-center">
                        <i class="fa fa-check fa-4x mb-3 animated rotateIn"></i>
                        <p>Avanzamento Stato paziente eseguita con successo.</p>
                    </div>
                </div>

                <!--Footer-->
                <div class="modal-footer justify-content-center">
                    <a type="button" class="btn btn-outline-primary waves-effect" data-dismiss="modal">Chiudi</a>
                </div>
            </div>
            <!--/.Content-->
        </div>
    </div>
    <!-- Central Modal Medium Success-->
    <button type="button" id="modalSuccess" name="submit" class="btn btn-primary" data-toggle="modal" data-target="#centralModalSuccess"  style="display: none">Avanzamento<i class="fa fa-upload ml-2"></i></button>

    <script>
                $('.mdb-select').material_select();

                var url_string = document.URL;

                var url = new URL(url_string);
                var access_token = url.searchParams.get("authToken");

                $.ajax({
                    url: 'http://localhost:8080/engine-rest/process-definition',
                    method: 'GET',
                    processData: false,
                    contentType: false,
                    headers: {
                        'Accept': 'application/json'
                    },
                    success: function (response) {

                        $('.mdb-select').material_select('destroy');

                        var arrayUser = response;

                        var materialUserAddID1 = document.getElementById('bpmnList1');

                        $.each(arrayUser, function (i) {
                            var option = document.createElement("option");
                            option.text = arrayUser[i].key;
                            option.value = arrayUser[i].id;
                            materialUserAddID1.add(option);
                        });

                        $('.mdb-select').material_select();


                    },
                    failure: function (response) {

                    }
                });

                $('#canvas').css("display", "none");
                $('#avanza').css("display", "none");

                var bpmnViewer = new BpmnJS({
                    container: '#canvas'
                });

                $('.bjs-powered-by').hide();

                function openDiagram(bpmnXML, task) {
                    $('#canvas').css("display", "block");
                    $('#avanza').css("display", "block");
                    // import diagram
                    bpmnViewer.importXML(bpmnXML, function (err) {
                        if (err) {
                            return console.error('could not import BPMN 2.0 diagram', err);
                        }
                        // access viewer components
                        var canvas = bpmnViewer.get('canvas');


                        // zoom to fit full viewport
                        canvas.zoom('fit-viewport');

                        // add marker
                        canvas.addMarker(task, 'highlight');
                    });

                    $("#avanza").css("display", "block");
                }

                function changeList() {

                    var dati = {
                        "processDefinitionId": ""
                    };

                    dati.processDefinitionId = $('#bpmnList1').val();

                    $('#canvas').css("display", "none");
                    $('#avanza').css("display", "none");

                    document.getElementById('paziente1').options.length = 1;

                    $.ajax({
                        url: 'http://localhost:8080/engine-rest/task',
                        method: 'POST',
                        processData: false,
                        contentType: false,
                        data: JSON.stringify(dati),
                        dataType: "json",
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json'
                        },
                        success: function (response) {


                            for (var i = 0; i < response.length; i++) {

                                (function (index) {
                                    $.ajax({
                                        url: 'http://localhost:8080/engine-rest/task/' + response[i].id + '/form-variables',
                                        method: 'GET',
                                        processData: false,
                                        contentType: false,
                                        headers: {
                                            'Accept': 'application/json'
                                        },
                                        success: function (data) {

                                            var arrayUser = data;
                                            var idTask = response[index].id;

                                            $('.mdb-select').material_select('destroy');

                                            var a = document.getElementById('paziente1');
                                            var option = document.createElement("option");

                                            var b = arrayUser.cognome.value + " " + arrayUser.nome.value;
                                            option.text = b;
                                            option.value = idTask;
                                            a.add(option);
                                            $('.mdb-select').material_select();



                                        },
                                        failure: function (response) {

                                        }
                                    });
                                })(i);

                            }


                        },
                        failure: function (response) {

                        }
                    });

                }

                function getXml() {

                    $.ajax({
                        url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val(),
                        method: 'GET',
                        processData: false,
                        contentType: false,
                        headers: {
                            'Accept': 'application/json'
                        },
                        success: function (response) {

                            var task = response.taskDefinitionKey;

                            $.ajax({
                                url: 'http://localhost:8080/engine-rest/process-definition/' + response.processDefinitionId + '/xml',
                                method: 'GET',
                                processData: false,
                                contentType: false,
                                headers: {
                                    'Accept': 'application/json'
                                },
                                success: function (response) {

                                    openDiagram(response.bpmn20Xml, task);


                                },
                                failure: function (response) {

                                }
                            });


                        },
                        failure: function (response) {

                        }
                    });

                }

                function handleError(xhr, status, error) {

                    if (xhr.responseJSON.type === 'TaskAlreadyClaimedException') {

                        var dati = {
                            "userId": "baseline2018"
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/assignee',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(dati),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $.ajax({
                                    url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/claim',
                                    method: 'POST',
                                    processData: false,
                                    contentType: false,
                                    data: JSON.stringify(dati),
                                    dataType: "json",
                                    headers: {
                                        'Content-Type': 'application/json',
                                        'Accept': 'application/json'
                                    },
                                    success: function (response) {

                                        $.ajax({
                                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/rendered-form',
                                            method: 'GET',
                                            processData: false,
                                            contentType: false,
                                            dataType: "text",
                                            headers: {
                                                'Accept': 'application/xhtml+xml'
                                            },
                                            success: function (data) {

                                                $("#renderForm").html("");
                                                SCOPE.compile(data, document.getElementById("renderForm"));

                                                $.ajax({
                                                    url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/form-variables',
                                                    method: 'GET',
                                                    processData: false,
                                                    contentType: false,
                                                    headers: {
                                                        'Content-Type': 'application/json',
                                                        'Accept': 'application/json'
                                                    },
                                                    success: function (datas) {

                                                        $("[cam-variable-name=prestazione]").val(datas.prestazione.value);

                                                    },
                                                    failure: function (datas) {

                                                    }
                                                });

                                            },
                                            failure: function (data) {

                                            }
                                        });

                                    },
                                    failure: function (response) {

                                    }
                                });

                            },
                            failure: function (response) {



                            }
                        });

                    }


                }

                function openModal() {

                    var dati = {
                        "userId": "baseline2018"
                    };

                    $("#renderForm").html("");

                    $.ajax({
                        url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/assignee',
                        method: 'POST',
                        processData: false,
                        contentType: false,
                        data: JSON.stringify({"userId": null}),
                        dataType: "json",
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json'
                        },
                        success: function (response1) {

                            $.ajax({
                                url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/claim',
                                method: 'POST',
                                processData: false,
                                contentType: false,
                                data: JSON.stringify(dati),
                                dataType: "json",
                                headers: {
                                    'Content-Type': 'application/json',
                                    'Accept': 'application/json'
                                },
                                success: function (response) {

                                    $.ajax({
                                        url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/rendered-form',
                                        method: 'GET',
                                        processData: false,
                                        contentType: false,
                                        dataType: "text",
                                        headers: {
                                            'Accept': 'application/xhtml+xml'
                                        },
                                        success: function (data) {

                                            $("#renderForm").html("");
                                            SCOPE.compile(data, document.getElementById("renderForm"));

                                            $.ajax({
                                                url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/form-variables',
                                                method: 'GET',
                                                processData: false,
                                                contentType: false,
                                                headers: {
                                                    'Content-Type': 'application/json',
                                                    'Accept': 'application/json'
                                                },
                                                success: function (datas) {
                                                    
                                                    if(datas.approfondimento.value === '-'){
                                                        $("[cam-variable-name=dataNascita]").val(datas.dataNascita.value);
                                                        $("[cam-variable-name=cognome]").val(datas.cognome.value);
                                                        $("[cam-variable-name=provinciaNascita]").val(datas.provinciaNascita.value);
                                                        $("[cam-variable-name=nome]").val(datas.nome.value);
                                                        $("[cam-variable-name=id]").val(datas.id.value);
                                                        $("[cam-variable-name=localitaNascita]").val(datas.localitaNascita.value);
                                                        $("[cam-variable-name=mmg]").val(datas.mmg.value);
                                                        $("[cam-variable-name=primaValutazione]").val(datas.primaValutazione.value);
                                                    }
                                                    
                                                    if(datas.valutazioneSpecialistica.value === '-'){
                                                        $("[cam-variable-name=dataNascita]").val(datas.dataNascita.value);
                                                        $("[cam-variable-name=cognome]").val(datas.cognome.value);
                                                        $("[cam-variable-name=provinciaNascita]").val(datas.provinciaNascita.value);
                                                        $("[cam-variable-name=nome]").val(datas.nome.value);
                                                        $("[cam-variable-name=id]").val(datas.id.value);
                                                        $("[cam-variable-name=localitaNascita]").val(datas.localitaNascita.value);
                                                        $("[cam-variable-name=mmg]").val(datas.mmg.value);
                                                        $("[cam-variable-name=primaValutazione]").val(datas.primaValutazione.value);
                                                        $("[cam-variable-name=approfondimento]").val(datas.approfondimento.value);
                                                        $("[cam-variable-name=ambNefrologico]").val(datas.ambNefrologico.value);
                                                    }
                                                    
                                                    if(datas.presaInCarico.value === '-'){
                                                        $("[cam-variable-name=dataNascita]").val(datas.dataNascita.value);
                                                        $("[cam-variable-name=cognome]").val(datas.cognome.value);
                                                        $("[cam-variable-name=provinciaNascita]").val(datas.provinciaNascita.value);
                                                        $("[cam-variable-name=nome]").val(datas.nome.value);
                                                        $("[cam-variable-name=id]").val(datas.id.value);
                                                        $("[cam-variable-name=localitaNascita]").val(datas.localitaNascita.value);
                                                        $("[cam-variable-name=mmg]").val(datas.mmg.value);
                                                        $("[cam-variable-name=primaValutazione]").val(datas.primaValutazione.value);
                                                        $("[cam-variable-name=approfondimento]").val(datas.approfondimento.value);
                                                        $("[cam-variable-name=ambNefrologico]").val(datas.ambNefrologico.value);
                                                        $("[cam-variable-name=valutazioneSpecialistica]").val(datas.valutazioneSpecialistica.value);
                                                        $("[cam-variable-name=mrc3b]").val(datas.mrc3b.value);
                                                        $("[cam-variable-name=monitoraggioPaziente]").val(datas.monitoraggioPaziente.value);
                                                        $("[cam-variable-name=ambMalattia]").val(datas.ambMalattia.value);
                                                    }

                                                },
                                                failure: function (datas) {

                                                }
                                            });

                                        },
                                        failure: function (data) {

                                        }
                                    });

                                },
                                error: handleError
                            });

                        },
                        failure: function (datas1) {

                        }
                    });


                }

                $('#submitForm').click(function () {

                    var myForm = document.getElementById('renderForm');

                    var switchLab = myForm.childNodes[0][0].name;

                    if (switchLab === 'mmg') {

                        var value = $("[cam-variable-name=mmg]").val();

                        var jsonObj = {
                            variables: {
                                mmg: {
                                    type: "String",
                                    value: value,
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonObj),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    } 
                    else if (switchLab === 'primaValutazione') {

                        var jsonPrest = {
                            variables: {
                                primaValutazione: {
                                    type: "String",
                                    value: $("[cam-variable-name=primaValutazione]").val(),
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonPrest),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (switchLab === 'ambNefrologico') {

                        var jsonPrest = {
                            variables: {
                                ambNefrologico: {
                                    type: "String",
                                    value: $("[cam-variable-name=ambNefrologico]").val(),
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonPrest),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    } 
                    else if (switchLab === 'mrc3b') {

                        var jsonPrest = {
                            variables: {
                                mrc3b: {
                                    type: "String",
                                    value: $("[cam-variable-name=mrc3b]").val(),
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonPrest),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (switchLab === 'mrc13') {

                        var jsonPrest = {
                            variables: {
                                mrc13: {
                                    type: "String",
                                    value: $("[cam-variable-name=mrc13]").val(),
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonPrest),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (switchLab === 'condivisionePercorsoOne') {

                        var jsonPrest = {
                            variables: {
                                condivisionePercorsoOne: {
                                    type: "String",
                                    value: $("[cam-variable-name=condivisionePercorsoOne]").val(),
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonPrest),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (switchLab === 'monitoraggioPaziente') {

                        var value = "";
                        
                        if ($("[cam-variable-name=mrcTwo]").is(":checked"))
                        {
                            value = true;
                        }
                        else{
                             value = false;
                        }
                        
                        var jsonObj = {
                            variables: {
                                monitoraggioPaziente: {
                                    type: "String",
                                    value: $("[cam-variable-name=monitoraggioPaziente]").val(),
                                    valueInfo: {}
                                },
                                mrcTwo: {
                                    type: "Boolean",
                                    value: value,
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonObj),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (switchLab === 'ambMalattia') {

                        var jsonObj = {
                            variables: {
                                ambMalattia: {
                                    type: "String",
                                    value: $("[cam-variable-name=ambMalattia]").val(),
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonObj),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (myForm.childNodes[0][8].name === 'approfondimento') {

                        var value = "";
                        var value1 = "";
                        
                        if ($("[cam-variable-name=mrc]").is(":checked"))
                        {
                            value = true;
                        }
                        else{
                             value = false;
                        }
                        
                        if ($("[cam-variable-name=urgenza]").is(":checked"))
                        {
                            value1 = true;
                        }
                        else{
                             value1 = false;
                        }
                        
                        var jsonObj = {
                            variables: {
                                approfondimento: {
                                    type: "String",
                                    value: $("[cam-variable-name=approfondimento]").val(),
                                    valueInfo: {}
                                },
                                mrc: {
                                    type: "Boolean",
                                    value: value,
                                    valueInfo: {}
                                },
                                urgenza: {
                                    type: "Boolean",
                                    value: value1,
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonObj),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (myForm.childNodes[0][10].name === 'valutazioneSpecialistica') {

                        var value = "";
                        
                        if ($("[cam-variable-name=mrcOne]").is(":checked"))
                        {
                            value = true;
                        }
                        else{
                             value = false;
                        }
                        
                        var jsonObj = {
                            variables: {
                                valutazioneSpecialistica: {
                                    type: "String",
                                    value: $("[cam-variable-name=valutazioneSpecialistica]").val(),
                                    valueInfo: {}
                                },
                                mrcOne: {
                                    type: "Boolean",
                                    value: value,
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonObj),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    else if (myForm.childNodes[0][13].name === 'presaInCarico') {
                        
                        var jsonObj = {
                            variables: {
                                presaInCarico: {
                                    type: "String",
                                    value: $("[cam-variable-name=presaInCarico]").val(),
                                    valueInfo: {}
                                }
                            }
                        };

                        $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
                            method: 'POST',
                            processData: false,
                            contentType: false,
                            data: JSON.stringify(jsonObj),
                            dataType: "json",
                            headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                            },
                            success: function (response) {

                                $("#renderForm").html("");
                                $('#fullHeightModalRight').modal('hide');
                                $('.modal-backdrop').remove();
                                $("#modalSuccess").click();

                            },
                            faliure: function (response) {

                            }
                        });

                    }
                    

                });

                $('#centralModalSuccess').on('hidden.bs.modal', function () {
                    location.reload();
                });           

    </script> 
</main>