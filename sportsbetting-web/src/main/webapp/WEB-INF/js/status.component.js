angular.module('status',[]).component('status', {
	templateUrl: 'status',
	controller: function($scope, $http, $httpParamSerializerJQLike, $route, $rootScope, $window) {
		document.getElementsByClassName('menu-item')[0].className += ' active';
		document.getElementsByClassName('menu-item')[1].className = 'menu-item';

		$http.get('loadPlayer').then(function(response) {
			console.log(response.data);
			$scope.player = response.data;
			$scope.player.dateOfBirth = new Date(...$scope.player.dateOfBirth);
			$rootScope.player = $scope.player;

				$http({
					method : 'post',
					url : 'loadWagers',
					data : $httpParamSerializerJQLike({
						'playerId' : $rootScope.player.id
					}),
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).then(function(response) {
					$scope.wagers = response.data;
				});

		});


		$scope.send = function(player) {
			$http.post('updatePlayer', correct(player)).then(function success(response) {
				if(response.data.alert) {
					$window.alert(response.data.alert);
				}
				$route.reload();
		    }, function error(response) {
		        console.log(response.data);
		        console.log(response.message);
		    });
		};

		$scope.removeWager = function(wagerId) {
			$http({
				method : 'post',
				url : 'wagerControl',
				data : $httpParamSerializerJQLike({
					'wagerId' : wagerId
				}),
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).then(function(response) {
				$route.reload();
			});
		};

		let correct = function(player) {
			player.dateOfBirth.setDate(player.dateOfBirth.getDate() + 1);
			player.dateOfBirth.setMonth(player.dateOfBirth.getMonth() - 1);
			return player;
		};
	}
});
