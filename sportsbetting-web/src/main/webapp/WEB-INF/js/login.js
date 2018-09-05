/*jshint esversion: 6 */

var app = angular.module('loginApp', []);

app.controller('loginController', function($scope, $http, $httpParamSerializerJQLike) {

	$scope.isDisabled = false;
    $scope.disableButton = function() {
        if($scope.isDisabled){
        	$scope.isDisabled=false;
        } else {
        	$scope.isDisabled=true;
        }
    }
	
	$scope.attempt = function() {
		$http({
			method : 'post',
			url : 'login',
			data : $httpParamSerializerJQLike($scope.credits),
			headers : {	'Content-Type' : 'application/x-www-form-urlencoded' }
		}).then(function onSuccess(response) {
			if (response.data) {
				location.replace('home');
			} else {
				$scope.error = true;
				$scope.isDisabled = false;
			}
		}, function onError(response) {
			console.log(response.data);
			console.log(response.message);
			
		});
	};
});


