<%@page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="register.playerreg" /></title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/register.css" rel="stylesheet" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<link rel="icon" href="favicon.ico"/>
</head>
<body>
<header>
		<div class="langChanger">
			<a href=register?lang=hu>Magyar</a> <a href=register?lang=en>English</a>
		</div>
		<span><spring:message code="header.title" /></span>
		<p><spring:message code="header.sportsbetting" /></p>
	</header>
<main>

	<div class="box" id="account-box" ng-app="regApp" ng-controller="registrationController">
		<div class="box-header"><spring:message code="register.playerreg" /></div>
		<form class="box-content" ng-submit="send(player)" name="registerForm">
				<div class="input-with-label">
				<label><spring:message code="register.username" /></label>
				<input type="text" ng-model="player.userName" ng-required="true" placeholder=<spring:message code="register.username" /> name="userName"></input>
				</div>
				<div class="warning" ng-show="registerForm.userName.$dirty && registerForm.userName.$error.required"><spring:message code="errors.usernameneeded" /></div>
				<div class="warning" ng-show="registerForm.userName.$error.registeredUsername"><spring:message code="errors.usernameinuse" /></div>
				<div class="input-with-label">
				<label><spring:message code="register.name" /></label>
				<input type="text" ng-model="player.name" ng-required="true" placeholder=<spring:message code="register.name" /> name="name"></input>
				</div>
				<div class="warning" ng-show="registerForm.name.$dirty && registerForm.name.$error.required"><spring:message code="errors.nameneeded"/></div>
				<div class="input-with-label">
				<label><spring:message code="register.dateofbirth" /></label>
				<input type="date" ng-model="player.dateOfBirth" placeholder=<spring:message code="register.dateofbirthexample" /> name="dateOfBirth" ng-required="true"></input>
				</div>
				<div class="input-with-label">
				<label><spring:message code="register.accountnumber" /></label>
				<input type="text" ng-model="player.accountNumber" name="accountNumber" placeholder=<spring:message code="register.accountnumber" /> ng-pattern="/[\s-\d]+$/"></input>
				</div>
				<div class="warning" ng-show="registerForm.accountNumber.$dirty && registerForm.accountNumber.$invalid"><spring:message code="errors.invalidaccountnumber"/></div>
				<div class="input-with-label">
				<label><spring:message code="register.currency" /></label>
				<select ng-model="player.currency" ng-required="true" ng-controller="registrationController" ng-change="switchDefaultMoneyAmount()" >
 				    
 				    <option value="HUF">HUF</option>
  					<option value="EUR">EUR</option>
 					<option value="USD">USD</option>
				</select>
				</div>
				<div class="input-with-label">
				<label><spring:message code="register.balance" /></label>
				<input type="number" ng-model="player.balance" placeholder=<spring:message code="register.balance" /> ng-required="true" ng-disabled="true" ></input>
				</div>
				<div class="input-with-label">
				<label><spring:message code="register.password" /></label>
				<input type="password" ng-model="player.password" name="password" placeholder=<spring:message code="register.password" /> ng-required="true"></input>
				</div>
				<div class="input-with-label">
				<label><spring:message code="register.passwordagain" /></label>
				<input type="password" ng-model="passwordmatcher" password-match="player.password" name="passwordAgain" placeholder=<spring:message code="register.passwordagain" /> ng-required="true"></input>
				</div>
				<div class="warning" ng-show="registerForm.passwordAgain.$error.unique"><spring:message code="errors.passwordmatch"/></div>
				<button ng-disabled="registerForm.passwordAgain.$error.unique || $scope.disabled" ng-click=scope.disableButton()><spring:message code="register.save" /></button>
		</form>

		<button ng-click="showAdditionalFieldToggle()">Provide feedback</button>
        <div model="showAdditionalField" ng-show="showAdditionalField">
           <div class="input-with-label">
            <label>Feedback</label>
            <input></input>
            </div>
        </div>
        <div>
            <button ng-click="showAdditionalText()"> Show it to me </button>
              <div id="additionalText"></div>
         </div>
	    </div>
	</main>
	<script src="js/regApp.js"></script>
</body>
</html>
