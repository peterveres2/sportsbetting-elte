/*jshint esversion: 6 */

var app = angular.module('regApp', []);

app.directive('passwordMatch', [function () {
    return {
        restrict: 'A',
        scope:true,
        require: 'ngModel',
        link: function (scope, elem , attrs,control) {
            var checker = function () {
                 var e1 = scope.$eval(attrs.ngModel); 
                 var e2 = scope.$eval(attrs.passwordMatch);
                return e1 == e2;
            };
            scope.$watch(checker, function (n) {
 
                control.$setValidity("unique", n);
            });
        }
    };
}]);

app.controller('registrationController', function($scope, $http, $httpParamSerializerJQLike) {

	$scope.showAdditionalField=false;

	$scope.showAdditionalFieldToggle = function() {
	    $scope.showAdditionalField = !$scope.showAdditionalField;
	}

	$scope.switchDefaultMoneyAmount = function() {
	    currency =  $scope.player.currency;	    
	    switch (currency) {
	      case 'HUF':	    	  
	    	  $scope.player.balance=32000;
	        break;
	      case 'EUR':
	    	  $scope.player.balance=100;
	        break;
	      case 'USD':
	    	$scope.player.balance=120;
	        break;
    }
}
	
	$scope.isDisabled = false;
    $scope.disableButton = function() {
        if($scope.isDisabled){
        	$scope.isDisabled=false;
        } else {
        	$scope.isDisabled=true;
        }
    }
    
	$scope.send = function(player) {
		$http.post('registration', correct(player)).then(
			function onSuccess(response) {
				$http({
					method : 'post',
					url : 'login',
					data : $httpParamSerializerJQLike({username:player.userName, password:player.password}),
					headers : {	'Content-Type' : 'application/x-www-form-urlencoded' }
				}).then(function() {location.replace('home');});
				console.log(response.data);
	    }, function onError(response) {
	        console.log(response.data);
	        console.log(response.message);
	        $scope.registerForm.userName.$setValidity("registeredUsername",false);
	        $scope.isDisabled = false;
	    });
	};

    $scope.showAdditionalText = function() {
        angular.element('#additionalText').html("<div>The answer is 42</div>");
    }


	let correct = function(player) {
		if(!player.dateOfBirth){
			let dob = document.getElementsByName('dateOfBirth')[0];
			dob.type = 'text';
			player.dateOfBirth = new Date(...dob.value.split(/\D/));
		} else {
			player.dateOfBirth.setDate(player.dateOfBirth.getDate() + 1);
		}
		player.dateOfBirth.setMonth(player.dateOfBirth.getMonth() - 1);
		return player;
	};
});
