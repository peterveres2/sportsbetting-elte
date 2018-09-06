<%@page contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SportsBet Login</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
</head>
<body>
	<header>
		
		<div class="langChanger">
			<a href=login?lang=hu>Magyar</a> <a href=login?lang=en>English</a>
		</div>
		<span><spring:message code="header.title" /></span>
		<p><spring:message code="header.sportsbetting" /></p>
	</header>
	<main>
	<p>
		<a href="#email"><spring:message code="login.login" /></a> <spring:message code="login.or" /> <a href="register"><spring:message code="login.registration" /></a> <spring:message code="login.start" />
		
	</p>
	<div class="box" id="login-box" ng-app="loginApp" ng-controller="loginController">
		<div class="box-header"><spring:message code="login.login" /></div>
		<section id="userinfo" class="box-content">
			<form ng-submit="attempt()">
			<fieldset>
			<input type="text" ng-model="credits.username" placeholder=<spring:message code="login.username" />></input>!!!Please provide your name.<br />
			<input type="password" ng-model="credits.password" placeholder=<spring:message code="login.password" />></input>!!!Please provide your password.<br />
			<div class="warning" ng-show="error"><spring:message code="login.wrongcredential" /></div>
			<button id="login-button" ng-disabled="isDisabled" ng-click="disableButton()"><spring:message code="login.login" /></button>
			</fieldset>
			</form>
		</section>
	</div>

<script src="js/login.js"></script>		
	
</main>
	
</body>
</html>
