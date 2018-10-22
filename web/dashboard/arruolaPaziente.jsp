<%@ include file="navigation.jsp" %>
<main>
    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Arruola Paziente</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">WorkFlow Engine</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <select id="paziente" class="mdb-select colorful-select dropdown-primary mx-2 initialized">
                <option value="" disabled selected>Seleziona Paziente</option>
            </select>

            <select id="bpmnList" class="mdb-select colorful-select dropdown-primary mx-2 initialized">
                <option value="" disabled selected>Seleziona BPMN</option>
            </select>

            <button type="button" name="aza" class="btn btn-primary" onclick="arruola()">Arruola
                <i class="fa fa-upload ml-2"></i>
            </button>

        </div>

    </div>
    <!-- Central Modal Medium Success -->
    <div class="modal fade" id="centralModalSuccess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-notify modal-success" role="document">
            <!--Content-->
            <div class="modal-content">
                <!--Header-->
                <div class="modal-header">
                    <p class="heading lead">Arruola Paziente</p>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" class="white-text">&times;</span>
                    </button>
                </div>

                <!--Body-->
                <div class="modal-body">
                    <div class="text-center">
                        <i class="fa fa-check fa-4x mb-3 animated rotateIn"></i>
                        <p>Arrulamento paziente a processo bpmn eseguita con successo.</p>
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
    <button type="button" id="avanza" name="submit" class="btn btn-primary" data-toggle="modal" data-target="#centralModalSuccess"  style="display: none">Avanzamento<i class="fa fa-upload ml-2"></i></button>

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
                    option.value = JSON.stringify(arrayUser[i]);
                    materialUserAddID.add(option);

                });

                $('.mdb-select').material_select();

            },
            failure: function (response) {

            }
        });

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

                var materialUserAddID1 = document.getElementById('bpmnList');

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

        function convertDate(inputFormat) {
            function pad(s) {
                return (s < 10) ? '0' + s : s;
            }
            let  d = new Date(inputFormat);
            return [pad(d.getDate()), pad(d.getMonth() + 1), d.getFullYear()].join('/');
        }

        function arruola() {
            var paziente = $('#paziente').val();
            paziente = JSON.parse(paziente);
            var processo = $('#bpmnList').val();
            var dati = {
                "variables": {
                    "cognome": {"type": "String", "value": paziente.cognome, "valueInfo": {}},
                    "dataNascita": {"type": "String", "value": convertDate(paziente.dataNascita), "valueInfo": {}},
                    "id": {"type": "String", "value": paziente.id, "valueInfo": {}},
                    "localitaNascita": {"type": "String", "value": paziente.localitaNascita, "valueInfo": {}},
                    "nome": {"type": "String", "value": paziente.nome, "valueInfo": {}},
                    "provinciaNascita": {"type": "String", "value": paziente.provinciaNascita, "valueInfo": {}}
                }
            };

            console.log(dati);
            console.log(processo);

            $.ajax({
                url: 'http://localhost:8080/engine-rest/process-definition/' + processo + '/submit-form',
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

                    $("#avanza").click();
                    $('#prestazione').val(null);


                },
                failure: function (response) {

                }
            });

        }
        
        $('#centralModalSuccess').on('hidden.bs.modal', function () {
            location.reload();
        });
    </script>
</main>