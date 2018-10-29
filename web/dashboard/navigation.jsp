<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="apple-touch-icon" sizes="57x57"
              href="static/images/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60"
              href="static/images/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72"
              href="static/images/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76"
              href="static/images/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114"
              href="static/images/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120"
              href="static/images/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144"
              href="static/images/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152"
              href="static/images/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180"
              href="static/images/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192"
              href="static/images/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32"
              href="static/images/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96"
              href="static/images/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16"
              href="static/images/favicon-16x16.png">
        <link rel="manifest" href="static/images/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">
        <title>Baseline - Dashboard</title>
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <!-- Font Awesome -->
        <link rel="stylesheet"
              href="static/css/font-awesome.min.css">
        <!-- Bootstrap core CSS -->
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" id="compiled.css-css" href="static/css/compiled.min.css" type="text/css" media="all">

        <!-- Your custom styles (optional) -->
        <link href="static/css/style.css" rel="stylesheet">

        <!-- dataTables.bootstrap4 -->
        <link href="static/css/dataTables.bootstrap4.min.css" rel="stylesheet">

        <!-- select.bootstrap4 -->
        <link href="static/css/select.bootstrap4.min.css" rel="stylesheet">

        <!-- responsive.dataTables -->
        <link href="static/css/responsive.dataTables.css" rel="stylesheet">

        <!-- buttons.dataTables -->
        <link href="static/css/buttons.dataTables.min.css" rel="stylesheet">

        <link href="static/css/dataTables.checkboxes.css" rel="stylesheet" />

        <link rel="stylesheet" href="static/css/leaflet.css" rel="stylesheet" />

        <script src="static/js/angular.min.js"></script>

    </head>
    <%
        String url_string = request.getQueryString();
    %>
    
    <style>
        ul {
            list-style-type: none;
        }
    </style>
    <body class="fixed-sn light-blue-skin">
        <!--Double navigation-->
    <header> <!-- Sidebar navigation -->
        <div id="slide-out" class="side-nav sn-bg-4 fixed mdb-sidenav">
            <ul class="custom-scrollbar list-unstyled" style="max-height: 100vh;">
                <!-- Logo -->
                <li>
                    <div class="logo-wrapper waves-light">
                        <a href="navigation.jsp?<%=url_string%>"><img
                                src="static/images/baselineLogo.png"
                                class="img-fluid flex-center"></a>
                    </div>
                </li>
                <!--/. Logo -->
                <!-- Side navigation links -->
                <li>
                    <ul class="collapsible collapsible-accordion">
                        <li><a class="collapsible-header waves-effect arrow-r"><i
                                    class="fa fa-chevron-right"></i>Informazioni Paziente<i
                                    class="fa fa-angle-down rotate-icon"></i></a>
                            <div class="collapsible-body">
                                <ul>
                                    <li><a href="tabulato.jsp?<%=url_string%>" class="waves-effect">Tabulato Pazienti</a></li>
                                    </li>
                                </ul>
                            </div></li>
                    </ul>
                    <ul class="collapsible collapsible-accordion">
                        <li><a class="collapsible-header waves-effect arrow-r"><i
                                    class="fa fa-chevron-right"></i>WorkFlow Engine<i
                                    class="fa fa-angle-down rotate-icon"></i></a>
                            <div class="collapsible-body">
                                <ul>
                                    <li><a href="primaValutazione.jsp?<%=url_string%>" class="waves-effect">Deployment BPMN</a></li>
                                    <li><a href="arruolaPaziente.jsp?<%=url_string%>" class="waves-effect">Arruola Paziente</a></li>
                                    <li><a href="visualizzaStato.jsp?<%=url_string%>" class="waves-effect">Visualizza Stato paziente</a></li>
                                    <li><a href="avanzamentoStato.jsp?<%=url_string%>" class="waves-effect">Avanzamento Stato paziente</a></li>
                                </ul>
                            </div></li>
                    </ul>
                </li>
                <!--/. Side navigation links -->
            </ul>
            <div class="sidenav-bg mask-strong"></div>
        </div>
        <!--/. Sidebar navigation --> <!-- Navbar --> <nav
            class="navbar fixed-top navbar-toggleable-md navbar-expand-lg scrolling-navbar double-nav">
            <!-- SideNav slide-out button -->
            <div class="float-left">
                <a href="#" data-activates="slide-out" class="button-collapse"><i
                        class="fa fa-bars"></i></a>
            </div>
            <!-- Breadcrumb-->
            <div class="breadcrumb-dn mr-auto">
                <p>Dashboard di Baseline</p>
            </div>
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <li>
                    <ul class="collapsible collapsible-accordion" style="padding-top: 6px">
                        <li class="nav-item">
                            <a class="collapsible-header waves-effect arrow-r">
                                <i class="fa fa-bar-chart"></i> 
                                <span class="clearfix d-none d-sm-inline-block">Fattori Inquinanti</span>
                            </a>    
                            <div class="collapsible-body">
                                <a class="nav-link" style="background-color: #6f96bc;" href="inquinamento?<%=url_string%>">PM 10</a>
                                <a class="nav-link" style="background-color: #6f96bc;" href="inquinamentoPM25.jsp?<%=url_string%>">PM 2.5</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="impostazioni.jsp?<%=url_string%>">
                        <input type="hidden" id="impostazioni" name="impostazioni" value="null" />
                        <i class="fa fa-cogs"></i> 
                        <span class="clearfix d-none d-sm-inline-block">Configurazioni</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contatti.jsp?<%=url_string%>">
                        <input type="hidden" id="contatti" name="contatti" value="null" />
                        <i class="fa fa-envelope"></i> 
                        <span class="clearfix d-none d-sm-inline-block">Contatti</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="supporto.jsp?<%=url_string%>" >
                        <input type="hidden" id="supporto" name="supporto" value="null" />
                        <i class="fa fa-comments-o"></i> 
                        <span class="clearfix d-none d-sm-inline-block">Supporto</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/Baseline">
                        <input type="hidden" id="esci" name="esci" value="null" />
                        <i class="fa fa-sign-out"></i>
                        <span class="clearfix d-none d-sm-inline-block">Esci</span>
                    </a>
                </li>
            </ul>
        </nav> <!-- /.Navbar --> </header>
    <!--/.Double navigation-->

    <!--Main Layout-->

    <!--Main Layout-->

    <!-- SCRIPTS -->
    <!-- JQuery -->
    <script type="text/javascript" src="static/js/jquery-3.2.1.min.js"></script>

    <!-- Tooltips -->
    <script type="text/javascript" src="static/js/popper.min.js"></script>

    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="static/js/bootstrap.min.js"></script>

    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="static/js/compiled.min.js"></script>
    <script>

        var app = angular.module("myApp", []);
        var SCOPE;
        app.controller("myCtrl", function ($scope, $compile) {
            $scope.firstName = "baseline";
            $scope.lastName = "2018";
            SCOPE = $scope;
            $scope.compile = function (elem_from, elem_to) {
                var content = $compile(angular.element(elem_from))($scope);
                angular.element(elem_to).append(content);
            }
        });

        $(document).ajaxError(function (event, jqxhr, settings, exception) {
            if (jqxhr.status === 401) {
                location.href = '/Baseline';
            }
        });

        // SideNav Initialization
        jQuery(".button-collapse").sideNav();
        
        var sideNavScrollbar = document.querySelector('.custom-scrollbar');
        Ps.initialize(sideNavScrollbar);

        $(document).ready(function () {

            var url_string = document.URL;

            var url = new URL(url_string);
            var access_token = url.searchParams.get("authToken");
            var username = url.searchParams.get("username");

            var queryParams = {
                authToken: access_token,
                username: username
            };

            if (access_token) {
                verificaUtente(queryParams);
            } else {
                location.href = '/Baseline';
            }

        });

        function verificaUtente(queryParams) {
            var me = this;
            me.authToken = queryParams.authToken;
            me.username = queryParams.username;
            var encodedToken = "Bearer " + me.authToken;

            $.ajax({
                url: '../rest/users/' + me.username,
                method: 'GET',
                disableCaching: false,
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': encodedToken
                },
                success: function (response) {
                    var obj = response;
                    me.utente = obj;

                },
                failure: function (response) {

                    if (response.status === 401) {
                        location.href = '/Baseline';
                    }
                }
            });
        }

    </script>

    <!-- jquery.dataTables -->
    <script type="text/javascript" src="static/js/jquery.dataTables.min.js"></script>

    <!-- dataTables.bootstrap4 -->
    <script type="text/javascript" src="static/js/dataTables.bootstrap4.min.js"></script>

    <!-- dataTables.select -->
    <script type="text/javascript" src="static/js/dataTables.select.min.js"></script>

    <!-- dataTables.responsive -->
    <script type="text/javascript" src="static/js/dataTables.responsive.js"></script>

    <script type="text/javascript" src="static/js/dataTables.buttons.min.js"></script>

    <script type="text/javascript" src="static/js/buttons.flash.min.js"></script>

    <script type="text/javascript" src="static/js/jszip.min.js"></script>

    <script type="text/javascript" src="static/js/pdfmake.min.js"></script>

    <script type="text/javascript" src="static/js/vfs_fonts.js"></script>

    <script type="text/javascript" src="static/js/buttons.html5.min.js"></script>

    <script type="text/javascript" src="static/js/buttons.print.min.js"></script>

    <script type="text/javascript" src="static/js/d3.v3.js"></script>

    <script type="text/javascript" src="static/js/moment.js"></script>

    <script type="text/javascript" src="static/js/dataTables.checkboxes.min.js"></script>

    <script type="text/javascript" src="static/js/bpmn-viewer.development.js"></script>

    <script type="text/javascript" src="static/js/leaflet.js"></script>

    <script type="text/javascript" src="static/js/md5.js"></script>

</body>

</html>