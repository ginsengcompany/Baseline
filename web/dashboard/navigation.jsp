<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
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
      
        
        <link rel="stylesheet" href="static/css/MarkerCluster.Default.css" />
        
        <link rel="stylesheet" href="static/css/MarkerCluster.css"/>
        
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
        .relative {
            position: relative;
        }

        .absolute-center {
          position:absolute;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
        }

        .text-center{
          text-align: center;
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
                                    class="fa fa-chevron-right"></i>Creazione BPMN<i
                                    class="fa fa-angle-down rotate-icon"></i></a>
                            <div class="collapsible-body">
                                <ul>
                                    <li><a href="creaBpmn.jsp?<%=url_string%>" class="waves-effect">Crea</a></li>
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
                                <a class="nav-link" style="background-color: #6f96bc;" href="inquinamentoPM25?<%=url_string%>">PM 2.5</a>
                                <a class="nav-link" style="background-color: #6f96bc;" href="inquinamentoPM25Global.jsp?<%=url_string%>">Global Annual PM 2.5 (1998-2016)</a>
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
    <main style="display:none">

        <div class="card card-cascade">

            <!-- Card image -->
            <div class="view gradient-card-header blue-gradient">

                <!-- Title -->
                <h2 class="card-header-title mb-3">Adesso</h2>
                <!-- Subtitle -->
                <p class="card-header-subtitle mb-0">Processi in esecuzione</p>

            </div>

            <!-- Card content -->
            <div class="card-body text-center">

                <div class="row">
                    <div class="col-md-4">
                        <label class="bmd-label-floating" for="myChart4" style="color:black">Esecuzione di istanze di processo</label>
                        <br>
                        <canvas id="myChart4" width="400" height="400"></canvas>
                        <div class="absolute-center text-center">
                            <br>
                            <h1 id="total"></h1>
                            <p style="font-size: 1.5rem;"><span class="badge red">Istanze Processi</span></p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label class="bmd-label-floating" for="myChart1" style="color:black">Incidenti aperti</label>
                        <br>
                        <canvas id="myChart1" width="400" height="400"></canvas>
                        <div class="absolute-center text-center">
                            <br>
                            <h1 id="total2"></h1>
                            <p style="font-size: 1.5rem;"><span class="badge purple darken-2">Incidenti aperti</span></p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <label class="bmd-label-floating" for="myChart2" style="color:black">Human Tasks</label>
                        <br>
                        <canvas id="myChart2" width="400" height="400"></canvas>
                        <div class="absolute-center text-center">
                            <br>
                            <h1 id="total1"></h1>
                            <p style="font-size: 1.5rem;"><span class="badge amber darken-2">Human Tasks</span></p>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        <br>
        <div class="card card-cascade">

            <!-- Card image -->
            <div class="view gradient-card-header blue-gradient">

                <!-- Title -->
                <h2 class="card-header-title mb-3">Line up</h2>
                <!-- Subtitle -->
                <p class="card-header-subtitle mb-0">Deployd bpmn</p>

            </div>

            <!-- Card content -->
            <div class="card-body text-center">

                <table class="table">
                    <thead class="peach-gradient black-text">
                        <tr>
                            <th scope="col">Process Definitions</th>
                            <th scope="col">Decision Definitions</th>
                            <th scope="col">Case Definitions</th>
                            <th scope="col">Deployments</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th id="processdefinition" scope="row" style='font-size:50px'></th>
                            <td id="decisiondefinition" style='font-size:50px'></td>
                            <td id="casedefinition" style='font-size:50px'></td>
                            <td id="deployments" style='font-size:50px'></td>
                        </tr>
                    </tbody>
                </table>

            </div>

        </div>
    </main>     
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
            };
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

            if (url.pathname === '/Baseline/dashboard/navigation.jsp') {
                
                var newArrayLabelProcess = [];
                        
                var newArrayDataProcess = [];
                
                var newArrayDataIncidents = [];
                
                var ctx4 = $("#myChart4");

                var ctx1 = $("#myChart1");

                var ctx2 = $("#myChart2");

                $.ajax({
                    url: 'http://192.168.125.38:8080/engine-rest/process-definition/statistics?rootIncidents=true',
                    method: 'GET',
                    processData: false,
                    contentType: false,
                    headers: {
                        'Accept': 'application/json'
                    },
                    success: function (response) {
                        
                        var total = 0;
                        
                        for(var i = 0; i< response.length; i++){
                            var a = response[i].definition.key;
                            newArrayLabelProcess.push(a);
                        }
                        
                        for(var j = 0; j< response.length; j++){
                            var b = response[j].instances;
                            total = total + b;
                            newArrayDataProcess.push(b);
                        }
                        
                        for(var k = 0; k< response.length; k++){
                            var c = response[k].incidents;
                            newArrayDataIncidents.push(c);
                        }
                        
                        var myLineChart4 = new Chart(ctx4, {
                            type: 'doughnut',
                            data: {
                                labels: newArrayLabelProcess,
                                datasets: [{
                                        data: newArrayDataProcess,
                                        backgroundColor: [
                                            'rgba(255, 99, 132, 0.2)',
                                            'rgba(54, 162, 235, 0.2)',
                                            'rgba(255, 206, 86, 0.2)',
                                            'rgba(75, 192, 192, 0.2)',
                                            'rgba(153, 102, 255, 0.2)',
                                            'rgba(255, 159, 64, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(255,99,132,1)',
                                            'rgba(54, 162, 235, 1)',
                                            'rgba(255, 206, 86, 1)',
                                            'rgba(75, 192, 192, 1)',
                                            'rgba(153, 102, 255, 1)',
                                            'rgba(255, 159, 64, 1)'
                                        ],
                                        borderWidth: 1
                                    }]
                            },
                            options:{
                                segmentShowStroke : true,
                                segmentStrokeColor : "#fff",
                                segmentStrokeWidth : 2,
                                percentageInnerCutout : 50,
                                animationSteps : 100,
                                animationEasing : "easeOutBounce",
                                animateRotate : true,
                                animateScale : false,
                                responsive: true,
                                maintainAspectRatio: true,
                                showScale: true,
                                animateScale: true
                            }
                        });
                        
                        $('#total').html(total);
                        
                        var myLineChart1 = new Chart(ctx1, {
                            type: 'doughnut',
                            data: {
                                labels: [],
                                datasets: [{
                                        data: newArrayDataIncidents,
                                        backgroundColor: [
                                            'rgba(153, 102, 255, 0.2)',
                                            'rgba(255, 159, 64, 0.2)'
                                        ],
                                        borderColor: [
                                            'rgba(153, 102, 255, 1)',
                                            'rgba(255, 159, 64, 1)'
                                        ],
                                        borderWidth: 1
                                    }]
                            },
                            options:{
                                segmentShowStroke : true,
                                segmentStrokeColor : "#fff",
                                segmentStrokeWidth : 2,
                                percentageInnerCutout : 50,
                                animationSteps : 100,
                                animationEasing : "easeOutBounce",
                                animateRotate : true,
                                animateScale : false,
                                responsive: true,
                                maintainAspectRatio: true,
                                showScale: true,
                                animateScale: true
                            }
                        });
                        
                        $('#total2').html(0);


                    },
                    failure: function (response) {

                    }
                });

                $.ajax({
                    url: 'http://192.168.125.38:8080/engine-rest/task/count?unfinished=true&assigned=true',
                    method: 'GET',
                    processData: false,
                    contentType: false,
                    headers: {
                        'Accept': 'application/json'
                    },
                    success: function (response) {

                        $.ajax({
                            url: 'http://192.168.125.38:8080/engine-rest/process-definition/count?unfinished=true&assigned=false',
                            method: 'GET',
                            processData: false,
                            contentType: false,
                            headers: {
                                'Accept': 'application/json'
                            },
                            success: function (response1) {

                                var myLineChart2 = new Chart(ctx2, {

                                    type: 'doughnut',
                                    data: {
                                        labels: ["Assegnato a un utente","Non assegnato"],
                                        datasets: [{
                                                data: [response.count,response1.count],
                                                backgroundColor: [
                                                    'rgba(255, 206, 86, 0.2)',
                                                    'rgba(75, 192, 192, 0.2)',
                                                    'rgba(153, 102, 255, 0.2)',
                                                    'rgba(255, 159, 64, 0.2)'
                                                ],
                                                borderColor: [
                                                    'rgba(255, 206, 86, 1)',
                                                    'rgba(75, 192, 192, 1)',
                                                    'rgba(153, 102, 255, 1)',
                                                    'rgba(255, 159, 64, 1)'
                                                ],
                                                borderWidth: 1
                                            }]
                                    },
                                    options:{
                                        segmentShowStroke : true,
                                        segmentStrokeColor : "#fff",
                                        segmentStrokeWidth : 2,
                                        percentageInnerCutout : 50,
                                        animationSteps : 100,
                                        animationEasing : "easeOutBounce",
                                        animateRotate : true,
                                        animateScale : false,
                                        responsive: true,
                                        maintainAspectRatio: true,
                                        showScale: true,
                                        animateScale: true
                                    }

                                });
                                
                                $('#total1').html(response.count + response1.count);


                            },
                            failure: function (response1) {

                            }
                        });


                    },
                    failure: function (response) {

                    }
                });

                $.ajax({
                    url: 'http://192.168.125.38:8080/engine-rest/process-definition/count?latestVersion=true',
                    method: 'GET',
                    processData: false,
                    contentType: false,
                    headers: {
                        'Accept': 'application/json'
                    },
                    success: function (response) {

                        var processdefinition = response.count;
                        $('#processdefinition').html(processdefinition);


                    },
                    failure: function (response) {

                    }
                });

                $.ajax({
                    url: 'http://192.168.125.38:8080/engine-rest/decision-definition/count?latestVersion=true',
                    method: 'GET',
                    processData: false,
                    contentType: false,
                    headers: {
                        'Accept': 'application/json'
                    },
                    success: function (response) {

                        var decisiondefinition = response.count;
                        $('#decisiondefinition').html(decisiondefinition);


                    },
                    failure: function (response) {

                    }
                });

                $.ajax({
                    url: 'http://192.168.125.38:8080/engine-rest/case-definition/count?latestVersion=true',
                    method: 'GET',
                    processData: false,
                    contentType: false,
                    headers: {
                        'Accept': 'application/json'
                    },
                    success: function (response) {

                        var casedefinition = response.count;
                        $('#casedefinition').html(casedefinition);


                    },
                    failure: function (response) {

                    }
                });

                $.ajax({
                    url: 'http://192.168.125.38:8080/engine-rest/deployment/count',
                    method: 'GET',
                    processData: false,
                    contentType: false,
                    headers: {
                        'Accept': 'application/json'
                    },
                    success: function (response) {

                        var deployments = response.count;
                        $('#deployments').html(deployments);


                    },
                    failure: function (response) {

                    }
                });


                $("main").css("display", "block");

                
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
    
    <script src="static/js/leaflet.markercluster.js"></script>
    
    <script src="static/js/spin.min.js"></script>
    
    <script src="static/js/leaflet.spin.min.js"></script>

    <script type="text/javascript" src="static/js/Chart.bundle.js"></script>

    <script type="text/javascript" src="static/js/Chart.bundle.min.js"></script>

    <script type="text/javascript" src="static/js/Chart.js"></script>

    <script type="text/javascript" src="static/js/Chart.min.js"></script>

</body>

</html>