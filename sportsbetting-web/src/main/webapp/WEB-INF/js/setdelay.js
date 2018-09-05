/*jshint esversion: 6 */

var app = angular.module('delayApp', ['rzModule']);

app.controller('setDelayController', function($scope, $rootScope, $http, $httpParamSerializerJQLike) {

	
	$scope.verticalSlider = {
	        value: 0,
	        options: {
	            floor: 0,
	            ceil: 10000,
	            vertical: true,
	            
	            onEnd: function () {
	                $scope.delayAmount = $scope.verticalSlider.value
	                $http({
	        			method : 'post',
	        			url : 'changeDelay',
	        			data : $httpParamSerializerJQLike({'delayAmount':$scope.delayAmount}),
	        			headers : {
	        				'Content-Type' : 'application/x-www-form-urlencoded'
	        			}
	        		}).then(function onSuccess(response) {
	        			if (response.data) {
	        				console.log(response.data);
	        			}
	        		});
	            }
	        }
	    };
});


