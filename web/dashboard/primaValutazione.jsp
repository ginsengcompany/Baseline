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
            <h2 class="card-header-title mb-3">Valutazione</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">Prima valutazione del paziente</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <select id="paziente" class="mdb-select colorful-select dropdown-primary mx-2 initialized" onchange="changeSezione()">
                <option value="" disabled selected>Seleziona Paziente</option>
            </select>

            <form id="uploadPdta" class="md-form">
                <div class="file-field">
                    <div class="btn btn-primary btn-sm float-left">
                        <span>Scegli PDTA</span>
                        <input id="pdta" type="file" required>
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text" placeholder="Carica il tuo PDTA" >
                    </div>
                </div>
                <div class="text-center mt-4 mb-2">
                    <button type="submit" name="submit" class="btn btn-primary">Carica
                        <i class="fa fa-upload ml-2"></i>
                    </button>
                </div>    
            </form>

            <div id="canvas" style="height: 1500px;"></div>         

        </div>

    </div>

    <br>



    <script>
        $('.mdb-select').material_select();

        var url_string = document.URL;

        var url = new URL(url_string);
        var access_token = url.searchParams.get("authToken");

        $.ajax({
            url: '../rest/anagrafica',
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': "Bearer " + access_token
            },
            success: function (response) {

                $('.mdb-select').material_select('destroy');


                var arrayUser = response.object;

                var materialUserAddID = document.getElementById('paziente');
                $.each(arrayUser, function (i) {
                    var option = document.createElement("option");
                    option.text = arrayUser[i].cognome + " " + arrayUser[i].nome;
                    option.value = arrayUser[i].id;
                    materialUserAddID.add(option);

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

        function openDiagram(bpmnXML) {
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
                canvas.addMarker('Task_1hdc93y', 'highlight');
            });
        }

        function loadFileAsText() {

            var fileToLoad = document.getElementById("pdta").files[0];

            var reader = new FileReader;
            reader.readAsText(fileToLoad);
            reader.onload = function (e) {
                var rawLog = reader.result;
                console.log(rawLog);
                openDiagram(rawLog);
            };
        }

        $('#uploadPdta').on('submit', function () {
            var fileToLoad = document.getElementById("pdta").files[0];
            console.log(fileToLoad);
            
            var arrayInsert = {'descrizioneServizio': fileToLoad.name, 'codiceAzienda': '0000', 'id': '0000', 'codiceServizio': '0000'};
            
            
            $.ajax({
                url: '../rest/servizi/bpnm',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + access_token
                },
                dataType: "json",
                data: JSON.stringify(arrayInsert),
                success: function (response) {
                    
                    consle.log(response);
                    
                },
                failure: function (response) {
                    
                }
            });
            
            //loadFileAsText();
            return false;
        });

    </script>
</main>