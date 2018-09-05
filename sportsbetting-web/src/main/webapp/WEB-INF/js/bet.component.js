angular.module('bet',[]).component('bet',{
	templateUrl: 'bet',
	controller: function($scope, $http, $httpParamSerializerJQLike, $rootScope, $location) {
		document.getElementsByClassName('menu-item')[1].className = 'menu-item';
		$scope.event = $rootScope.selectedEvent;

		$http({
			method : 'post',
			url : 'loadBets',
			data : $httpParamSerializerJQLike({
				'eventId' : $scope.event.id
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).then(function success(response) {
			$scope.bets = response.data;
	    }, function error(response) {
	        console.log(response.data);
	        console.log(response.message);
	    });

		$scope.placeWager = function(bet) {
			$rootScope.selectedBet = bet;
			$location.path('wager_form');
		};
	}
});
