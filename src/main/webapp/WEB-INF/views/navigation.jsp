<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Antonio Biondillo
  Date: 25/04/2018
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="apple-touch-icon" sizes="57x57"
	href="../../static/images/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60"
	href="../../static/images/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="../../static/images/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="../../static/images/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="../../static/images/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="../../static/images/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="../../static/images/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="../../static/images/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180"
	href="../../static/images/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="../../static/images/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="../../static/images/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="../../static/images/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="../../static/images/favicon-16x16.png">
<link rel="manifest" href="../../static/images/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<title>Baseline - Dashboard</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap core CSS -->
<link href="../../static/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="../../static/css/mdb.min.css" rel="stylesheet">
<!-- Your custom styles (optional) -->
<link href="../../static/css/style.css" rel="stylesheet">
</head>
<body class="fixed-sn light-blue-skin">

	<!--Double navigation-->
	<header> <!-- Sidebar navigation -->
	<div id="slide-out" class="side-nav sn-bg-4 fixed mdb-sidenav">
		<ul class="custom-scrollbar list-unstyled" style="max-height: 100vh;">
			<!-- Logo -->
			<li>
				<div class="logo-wrapper waves-light">
					<a href="<c:url value="/dashboard" />"><img
						src="../../static/images/baselineLogo.png"
						class="img-fluid flex-center"></a>
				</div>
			</li>
			<!--/. Logo -->
			<!-- Side navigation links -->
			<li>
				<ul class="collapsible collapsible-accordion">
					<li><a class="collapsible-header waves-effect arrow-r"><i
							class="fa fa-chevron-right"></i> Informazioni Paziente<i
							class="fa fa-angle-down rotate-icon"></i></a>
						<div class="collapsible-body">
							<ul>
								<li><a href="/dashboard/infoPaziente" class="waves-effect">Cerca Paziente</a></li>
								<li><a href="#" class="waves-effect">Registration form</a>
								</li>
							</ul>
						</div></li>
					<li><a class="collapsible-header waves-effect arrow-r"><i
							class="fa fa-hand-pointer-o"></i> Instruction<i
							class="fa fa-angle-down rotate-icon"></i></a>
						<div class="collapsible-body">
							<ul>
								<li><a href="#" class="waves-effect">For bloggers</a></li>
								<li><a href="#" class="waves-effect">For authors</a></li>
							</ul>
						</div></li>
					<li><a class="collapsible-header waves-effect arrow-r"><i
							class="fa fa-eye"></i> About<i
							class="fa fa-angle-down rotate-icon"></i></a>
						<div class="collapsible-body">
							<ul>
								<li><a href="#" class="waves-effect">Introduction</a></li>
								<li><a href="#" class="waves-effect">Monthly meetings</a></li>
							</ul>
						</div></li>
					<li><a class="collapsible-header waves-effect arrow-r"><i
							class="fa fa-envelope-o"></i> Contact me<i
							class="fa fa-angle-down rotate-icon"></i></a>
						<div class="collapsible-body">
							<ul>
								<li><a href="#" class="waves-effect">FAQ</a></li>
								<li><a href="#" class="waves-effect">Write a message</a></li>
								<li><a href="#" class="waves-effect">FAQ</a></li>
								<li><a href="#" class="waves-effect">Write a message</a></li>
								<li><a href="#" class="waves-effect">FAQ</a></li>
								<li><a href="#" class="waves-effect">Write a message</a></li>
								<li><a href="#" class="waves-effect">FAQ</a></li>
								<li><a href="#" class="waves-effect">Write a message</a></li>
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
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/dashboard/contatti" />">
				    <input type="hidden" id="contatti" name="contatti" value="null" />
					<i class="fa fa-envelope"></i> 
						<span class="clearfix d-none d-sm-inline-block">Contatti</span>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/dashboard/supporto" />">
					<input type="hidden" id="supporto" name="supporto" value="null" />
					<i class="fa fa-comments-o"></i> 
						<span class="clearfix d-none d-sm-inline-block">Supporto</span>
				</a>
			</li>
		 	<li class="nav-item">
		 		<a class="nav-link" href="<c:url value="/logout" />">
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
	<script type="text/javascript" src="../../static/js/jquery-3.2.1.min.js"></script>

	<!-- Tooltips -->
	<script type="text/javascript" src="../../static/js/popper.min.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="../../static/js/bootstrap.min.js"></script>

	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="../../static/js/mdb.min.js"></script>
	<script>
        
        // SideNav Initialization
        jQuery(".button-collapse").sideNav();

    </script>
</body>
</html>