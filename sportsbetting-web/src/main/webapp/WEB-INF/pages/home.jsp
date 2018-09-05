<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<spring:message code="home.home" var="homeLink"></spring:message>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>SportsBetting Home</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/home.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="favicon.ico">
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
<base href="/sportsbetting-web/">
</head>
<body ng-app="homeApp" ng-cloak>

	<header>			
		<div id="menu">
			<div id="logo">
				<h2><spring:message code="home.sportsbetting"/></h2>
			</div>
			<div class="menu-item"><a href="home">${homeLink}</a></div>
			<div class="menu-item"><a href="events"><spring:message code="home.events"/></a></div>
			<select class="langSelect" ng-controller="homeController" ng-model="selected" ng-change="switchLanguage()">
			 	<option value="" selected disabled hidden><spring:message code="home.changelanguage"/></option>
				<option value="hu">HU</option>
				<option value="en">EN</option>
			</select>
			<div class="menu-item" id="logout"><a href="logout"><spring:message code="home.logout"/></a></div>
		</div>
	</header>
	<main>
	<div ng-view></div>

	</main>

	<script src="js/home.js"></script>
	<script src="js/status.component.js"></script>
	<script src="js/events.component.js"></script>
	<script src="js/bet.component.js"></script>
	<script src="js/wager.component.js"></script>
</body>
</html>
