<%@ include file="navigation.jsp" %>
<main>

    <div class="card card-cascade">

        <!-- Card image -->
        <div class="view gradient-card-header blue-gradient">

            <!-- Title -->
            <h2 class="card-header-title mb-3">Importazione BPMN</h2>
            <!-- Subtitle -->
            <p class="card-header-subtitle mb-0">Deploy bpmn</p>

        </div>

        <!-- Card content -->
        <div class="card-body text-center">

            <form id="uploadPdta" class="md-form">
                <div class="file-field">
                    <div class="btn btn-primary btn-sm float-left">
                        <span>Scegli PDTA</span>
                        <input id="pdta" type="file" required>
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" id="inputFileId" type="text" placeholder="Carica il tuo PDTA" >
                    </div>
                </div>
                <div class="text-center mt-4 mb-2">
                    <button type="submit" name="submit" class="btn btn-primary">Carica
                        <i class="fa fa-upload ml-2"></i>
                    </button>
                </div>    
            </form>

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
                    <p class="heading lead">Importazione BPMN</p>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" class="white-text">&times;</span>
                    </button>
                </div>

                <!--Body-->
                <div class="modal-body">
                    <div class="text-center">
                        <i class="fa fa-check fa-4x mb-3 animated rotateIn"></i>
                        <p>Deployment bpmn eseguita con successo.</p>
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

        var url_string = document.URL;

        var url = new URL(url_string);
        var access_token = url.searchParams.get("authToken");

        $('#uploadPdta').on('submit', function () {
            var fileToLoad = document.getElementById("pdta").files[0];

            var data = new FormData();
            data.append('deployment-name', fileToLoad.name);
            data.append('enable-duplicate-filtering', true);
            data.append('deploy-changed-only', true);
            data.append('bpmn', fileToLoad);


            $.ajax({
                url: 'http://192.168.125.38:8080/engine-rest/deployment/create',
                method: 'POST',
                processData: false,
                contentType: false,
                headers: {
                    'Accept': 'application/json'
                },
                data: data,
                success: function (response) {
                    
                    $("#avanza").click();
                    $('#inputFileId').val(null);


                },
                failure: function (response) {

                }
            });

            return false;
        });
        
        $('#centralModalSuccess').on('hidden.bs.modal', function () {
            location.reload();
        });

    </script>
</main>