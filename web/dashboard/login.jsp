<%@ include file="index.jsp"%>
<div class="container-fluid" style="padding-top:50px; width: auto; ">
    <div class="card mx-xl-5">
        <div class="card-body">

            <form id="login">
                <!--Header-->
                <div class="form-header deep-blue-gradient rounded">
                    <h3><i class="fa fa-lock"></i> Autenticazione:</h3>
                    <img src="static/images/baselineLogo.png" width="auto" height="150"/>
                </div>
                <span id="alertErr" class="badge badge-danger" style="display: none">Username e/o password non corretti.</span>
                <!-- Material input email -->
                <div class="md-form font-weight-light">
                    <i class="fa fa-user prefix grey-text"></i> <input id="username" type="text"
                                                                       name="client_id" placeholder="Username" required
                                                                       class="form-control"> <label for="materialFormEmailEx"
                                                                       class="">Il tuo Username</label>
                </div>

                <!-- Material input password -->
                <div class="md-form font-weight-light">
                    <i class="fa fa-lock prefix grey-text"></i> <input id="password" type="password"
                                                                       name="client_secret" placeholder="Password" required
                                                                       class="form-control"> <label for="materialFormPasswordEx"
                                                                       class="">La tua Password</label>
                </div>
                <div class="text-center mt-4">
                    <button class="btn btn-light-blue waves-effect waves-light" type="submit" value="Submit">Entra</button>
                </div>
            </form>    

        </div>

        <!--Footer-->
        <div class="modal-footer">
            <div class="options font-weight-light">
                <p>
                    Password <a href="#">dimenticata?</a>
                </p>
            </div>
        </div>

    </div>
    <script>

        var encodedToken = '';

        $(document).ajaxError(function (event, jqxhr, settings, exception) {
            if (jqxhr.status === 401) {
                document.getElementById('alertErr').style.display = 'block';
            }
        });

        $('#login').on('submit', function () {
            var unencodedToken = $('#username').val() + ":" + $('#password').val();
            encodedToken = "Basic " + btoa(unencodedToken);

            $.ajax({
                url: 'rest/token',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                    'Authorization': encodedToken
                },
                data: {'grant_type': 'client_credentials', 'client_id': $('#username').val(), 'client_secret': $('#password').val()},
                success: function (response) {
                    var obj = response;

                    validate(obj);

                },
                failure: function (response) {

                }
            });
            return false;
        });


        function validate(oauth) {

            $.ajax({
                url: 'rest/validate',
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': "Bearer " + oauth.access_token
                },
                success: function (response) {

                    var link = "";

                    link = 'dashboard/navigation.jsp?authToken=' + oauth.access_token + "&username=" + oauth.username;

                    location.href = link;
                },
                failure: function (response) {
                }
            });

        }

    </script>
</div>



