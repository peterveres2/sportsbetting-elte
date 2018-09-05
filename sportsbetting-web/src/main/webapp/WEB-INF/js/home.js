/*jshint esversion: 6 */

let app = angular.module('homeApp', [ 'ngRoute', 'status', 'events', 'bet', 'wager' ]);
app.config(function($routeProvider, $locationProvider) {

	$routeProvider.when('/home', {
		template : '<status></status>'
	}).when('/events', {
		template : '<events></events>'
	}).when('/bet', {
		template: '<bet></bet>'
	}).when('/wager_form', {
		template: '<wager></wager>'
	}).when('/logout', {
		redirectTo : function(){location = 'logout';}
	}).when('/parameters', {
		templateUrl : 'parameter_list.jsp'
	}).otherwise({redirectTo: function(){location = 'register';}});

	$locationProvider.html5Mode(true);
})
.controller('homeController', function($scope,$location,$window){
		
	$scope.switchLanguage = function() {
	    langKey = $scope.selected;	    
	    switch (langKey) {
	      case 'hu':	    	  
	        $window.location.href ="/sportsbetting-web/home?lang=hu";
	        break;
	      case 'en':
	    	$window.location.href ="/sportsbetting-web/home?lang=en";
	        break;
	    }
	}
});
