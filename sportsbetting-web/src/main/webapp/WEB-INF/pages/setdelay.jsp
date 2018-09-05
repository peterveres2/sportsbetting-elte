<%@page contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Setting delay</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
<script src="https://rawgit.com/rzajac/angularjs-slider/master/dist/rzslider.js"></script>
<link rel="stylesheet" href="https://rawgit.com/rzajac/angularjs-slider/master/dist/rzslider.css">
<script src="js/setdelay.js"></script>	
</head>
<body>
<main>
<div ng-app="delayApp">
	<div ng-controller="setDelayController">
	<h2>Delay in ms: {{delayAmount}}</h2>
     <div style="height: 250px" >
     	
        <rzslider rz-slider-model="verticalSlider.value" rz-slider-options="verticalSlider.options"></rzslider>
	</div>
</div>
</main>
	
</body>
</html>
