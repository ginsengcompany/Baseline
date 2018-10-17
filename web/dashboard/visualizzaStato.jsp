<%@ include file="navigation.jsp" %>
<main>
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
            <h2 class="card-header-title mb-3">Visualizza Stato paziente</h2>
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
                    
                    <div id="canvas" style="height: 500px;"></div> 

        </div>

    </div>
    
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
                'Accept' : 'application/json'
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

        var bpmnViewer = new BpmnJS({
            container: '#canvas'
        });

        $('.bjs-powered-by').hide();

        function openDiagram(bpmnXML,task) {
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
        }
        
        function changeList(){
            
            var dati = {
                        "processDefinitionId": ""
                       };
                       
            dati.processDefinitionId = $('#bpmnList1').val();
            
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
                    'Accept' : 'application/json'
                },
                success: function (response) {
                   
                   
                   for(var i=0; i<response.length; i++){     
                       
                       (function (index) {
                           $.ajax({
                            url: 'http://localhost:8080/engine-rest/task/'+response[i].id+'/form-variables',
                            method: 'GET',
                            processData: false,
                            contentType: false,
                            headers: {
                                'Accept' : 'application/json'
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
        
        function getXml(){
            console.log($('#paziente1').val());
            
            $.ajax({
                url: 'http://localhost:8080/engine-rest/task/'+$('#paziente1').val(),
                method: 'GET',
                processData: false,
                contentType: false,
                headers: {
                    'Accept' : 'application/json'
                },
                success: function (response) {

                   var task = response.taskDefinitionKey;
                    
                   $.ajax({
                        url: 'http://localhost:8080/engine-rest/process-definition/'+response.processDefinitionId+'/xml',
                        method: 'GET',
                        processData: false,
                        contentType: false,
                        headers: {
                            'Accept' : 'application/json'
                        },
                        success: function (response) {


                            //console.log(response.bpmn20Xml)
                            openDiagram(response.bpmn20Xml,task);


                        },
                        failure: function (response) {

                        }
                    });

                   
                },
                failure: function (response) {

                }
            });
            
        }
    </script>    
</main>