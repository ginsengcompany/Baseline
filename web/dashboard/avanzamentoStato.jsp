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
        .iqa-ico {
            width: 11px;
            height: 11px;
        }
        .iqa-ico {
            float: left;
            width: 20px;
            height: 20px;
            border-radius: 10px;
            -moz-border-radius: 10px;
            -webkit-border-radius: 10px 10px 10px 10px;
            box-shadow: 0 0 2px 0 rgba(8,8,8,.84);
            font-size: 7px;
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

            <div class="row">
                
                <div class="col-md-2">
                   <button type="button" id="avanza" name="submit" class="btn btn-primary" onclick="openModal()" data-toggle="modal" data-target="#fullHeightModalRight"  style="display: none">Avanzamento<i class="fa fa-upload ml-2"></i></button>
                </div>
                
                <div class="col-md-3">
                   <button type="button" id="clima" onclick="openClima()" class="btn btn-primary" style="display: none" data-toggle="modal" data-target="#centralModalClima">Analizza Fattori Ambientali<i class="fa fa-sun-o ml-2"></i></button>
                </div>
                
            </div>
            
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
    
    <!-- Central Modal Medium Clima -->
    <div class="modal fade" id="centralModalClima" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-notify modal-fluid modal-success" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Header-->
                <div class="modal-header">
                    <p class="heading lead">Fattori Ambientali</p>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" class="white-text">&times;</span>
                    </button>
                </div>

                <!--Body-->
                <div class="modal-body">
                    <div class="">
                        <div class="text-center">
                            <i class="fa fa-sun-o fa-4x mb-3 animated rotateIn"></i>
                        </div>
                        <p class="text-center">Per Malattia Renale Cronica (MRC) si intende una alterazione strutturale o funzionale presente da più di 3 mesi, può consistere in:</p>
                        <p class="text-center">1. Danno renale, con o senza riduzione della velocità di filtrazione glomerulare (GFR).</p>
                        <p class="text-center">2. Velocità di filtrazione glomerulare < 60ml / min / 1.73 m^2, con o senza danno renale.</p>
                        
                        <div class="row">
                            <div class="col-md-6">
                                <div style="padding:5px;background:#D9EBF5">
                                    <div style="font-weight:bold;color:#1F8BC4;margin-bottom:10px;font-size:1.1em" class="text-center">Legenda dettagliata</div>
                                    <div>
                                        <div class="iqa-ico" style="background:#00A0FF"></div>
                                        <div style="font-weight:bold">&nbsp;&nbsp;Ottima - Molto buona</div>
                                    </div>
                                    <div>La qualità dell'aria è molto buona e non produce rischi per la salute.</div>
                                    <div>
                                        <div class="iqa-ico" style="background:#00DC00"></div>
                                        <div style="font-weight:bold">&nbsp;&nbsp;Buona - Discreta</div>
                                    </div>
                                    <div>La qualità dell'aria è considerata soddisfacente e l'inquinamento non produce rischi rilevanti per la salute.</div>
                                    <div>
                                        <div class="iqa-ico" style="background:#E6DC32"></div>
                                        <div style="font-weight:bold">&nbsp;&nbsp;Accettabile - Mediocre</div>
                                    </div>
                                    <div>La qualità dell'aria è accettabile, comunque per alcuni inquinanti ci potrebbe essere un impatto moderato sulla salute per un piccolo numero di persone. Per esempio, persone che sono particolarmente sensibili all'ozono possono avere sintomi di problemi respiratori. </div>
                                    <div>
                                        <div class="iqa-ico" style="background:#F08228"></div>
                                        <div style="font-weight:bold">&nbsp;&nbsp;Scadente - Inquinaa</div>
                                    </div>
                                    <div>Sebbene il generico pubblico non sia affetto da sintomi, gruppi specifici di persone (con malattie cardiache e respiratorie come asma, bronchite cronica, enfisema, anziani e bambini) sono a rischio maggiore in seguito ad esposizione a polveri (PM10) e a ozono.</div>
                                    <div>
                                        <div class="iqa-ico" style="background:#FA3C3C"></div>
                                        <div style="font-weight:bold">&nbsp;&nbsp;Molto inquinata</div>
                                    </div>
                                    <div>Ognuno può cominciare a riscontrare effetti negativi sulla salute, più seri nel caso dei gruppi specifici.</div>
                                    <div>
                                        <div class="iqa-ico" style="background:#F00082"></div>
                                        <div style="font-weight:bold">&nbsp;&nbsp;Pessima</div>
                                    </div>
                                    <div class="iqa-dett">Condizioni di emergenza per la salute, è probabile che sia colpita da sintomi l'intera popolazione.</div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                 <img src="" id="fattori"> 
                            </div>
                        </div>    
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
    <!-- Central Modal Medium Clima-->
    
    <button type="button" id="modalSuccess" name="submit" class="btn btn-primary" data-toggle="modal" data-target="#centralModalSuccess"  style="display: none">Avanzamento<i class="fa fa-upload ml-2"></i></button>

    <script>
                $('.mdb-select').material_select();

                var url_string = document.URL;

                var url = new URL(url_string);
                var access_token = url.searchParams.get("authToken");

                $.ajax({
                    url: 'http://192.168.125.38:8080/engine-rest/process-definition',
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
                $('#clima').css("display", "none");

                var bpmnViewer = new BpmnJS({
                    container: '#canvas'
                });

                $('.bjs-powered-by').hide();

                function openDiagram(bpmnXML, task) {
                    $('#canvas').css("display", "block");
                    $('#avanza').css("display", "block");
                    $('#clima').css("display", "block");
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
                        url: 'http://192.168.125.38:8080/engine-rest/task',
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
                                        url: 'http://192.168.125.38:8080/engine-rest/task/' + response[i].id + '/form-variables',
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
                        url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val(),
                        method: 'GET',
                        processData: false,
                        contentType: false,
                        headers: {
                            'Accept': 'application/json'
                        },
                        success: function (response) {

                            var task = response.taskDefinitionKey;

                            $.ajax({
                                url: 'http://192.168.125.38:8080/engine-rest/process-definition/' + response.processDefinitionId + '/xml',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/assignee',
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
                                    url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/claim',
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
                                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/rendered-form',
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
                                                    url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/form-variables',
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
                        url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/assignee',
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
                                url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/claim',
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
                                        url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/rendered-form',
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
                                                url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/form-variables',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                            url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/submit-form',
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
                
                function openClima(){
                    
                    $.ajax({
                        url: 'http://192.168.125.38:8080/engine-rest/task/' + $('#paziente1').val() + '/form-variables',
                        method: 'GET',
                        processData: false,
                        contentType: false,
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json'
                        },
                        success: function (datas) {
                            
                            var url_string = document.URL; 
            
                            var url = new URL(url_string);
                            var access_token = url.searchParams.get("authToken");

                            $.ajax({
                                url: '../rest/distretti/comune/findByCodiceIstat?codiceIstatComune='+datas.localitaNascita.value,
                                method: 'GET',
                                headers: {
                                    'Content-Type': 'application/json',
                                    'Authorization': "Bearer " +access_token
                                },
                                dataType: "json",
                                success: function (response) {
                                   if(response.esito === true){  
                                       var myJson = JSON.parse(response.object);
                                       
                                       var regione = myJson.comune.regioneDescrizione.toLowerCase();
                                       regione = regione.substring(0,3);
                                       
                                       
                                        $.ajax({
                                            url: '../rest/distretti/clima/img?namePng='+regione,
                                            method: 'GET',
                                            headers: {
                                                'Content-Type': 'application/json',
                                                'Authorization': "Bearer " +access_token
                                            },
                                            dataType: "json",
                                            success: function (response1) {
                                               if(response1.esito === true){  
                                                   
                                                  var bta = "data:image/png;base64,"+response1.object;
                                                  $('#fattori').attr("src",bta);

                                               }
                                            },
                                            failure: function (response1) { 
                                                if (response1.status === 401 || response1.status === 400 || response1.status === 500) {  
                                                    console.log(response1);
                                                }      
                                            }
                                        });

                                       
                                       
                                   }
                                },
                                failure: function (response) { 
                                    if (response.status === 401 || response.status === 400 || response.status === 500) {  
                                        console.log(response);
                                    }      
                                }
                            });

                        },
                        failure: function (datas) {
                 
                        }
                    });
                    
                    
                    
                }

    </script> 
</main>