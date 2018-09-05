angular.module('wager',[]).component('wager',{
	templateUrl: 'wager_form',
	controller: function($scope, $http, $httpParamSerializerJQLike, $rootScope, $interval, $location) {
		$scope.event = $rootScope.selectedEvent;
		$scope.bet = $rootScope.selectedBet;
		$scope.limit = $rootScope.player.balance;
		$scope.wager = {player:$rootScope.player, betId:$rootScope.selectedBet.id, currency:$rootScope.player.currency};
		$scope.Math = window.Math;

		$http({
			method : 'post',
			url : 'loadOutcomes',
			data : $httpParamSerializerJQLike({
				'betId' : $scope.bet.id
			}),
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).then(function success(response) {
			$scope.outcomes = response.data;
	    }, function error(response) {
	        console.log(response.data);
	        console.log(response.message);
	    });

		$scope.send = function(wager) {
			wager.timestamp = new Date();
			wager.outcomeId = wager.outcome.id;
			delete wager.outcome;

		$http.post('addWager', wager).then(function success(response) {
				$location.path('home');
			}, function error(response) {
					console.log(response.data);
					console.log(response.message);
			});
		};
	}
});