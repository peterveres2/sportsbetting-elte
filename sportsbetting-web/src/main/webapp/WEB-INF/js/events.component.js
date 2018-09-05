angular.module('events',[]).component('events', {
	templateUrl: 'events',
	controller: function($scope, $http, $httpParamSerializerJQLike, $rootScope, $interval, $location) {
		document.getElementsByClassName('menu-item')[0].className = 'menu-item';
		document.getElementsByClassName('menu-item')[1].className += ' active';

		$http.get('loadEvents').then(function(response) {
			$scope.events = response.data;
			for(let i = 0; i < $scope.events.length; i++) {
				$scope.events[i].start[1]--;
				$scope.events[i].end[1]--;
				$scope.events[i].start = new Date(...$scope.events[i].start);
				$scope.events[i].end = new Date(...$scope.events[i].end);
			}
		});

		let timeUntil = function() {
			let seconds = Math.floor((this.end.getTime() - new Date().getTime()) / 1000);
			let hours = Math.floor(seconds / 3600);
			seconds -= hours * 3600;
			let minutes = Math.floor(seconds / 60);
			seconds -= minutes * 60;
			if (seconds < 10) {seconds = '0' + seconds;}
			if (minutes < 10) {minutes = '0' + minutes;}
			this.countdown = ((hours + ':' + minutes + ':' + seconds));
		};

		$scope.eventLeft = function() {
			let anyLeft = false;
			if ($scope.events) {
				for(let event of $scope.events) {
					if($scope.yet(event)) {
						anyLeft = true;
						if(!event.timeUntil) {
							event.timeUntil = timeUntil;
							event.trigger = $interval(function(){event.timeUntil();},1000);
						}
					}
				}
			} else {console.log('EVENTS FALSY');}
			return anyLeft;
		};

		$scope.yet = function(event) {
			return new Date().getTime() < event.end.getTime();
		};

		$scope.betOnEvent = function(event) {
			$rootScope.selectedEvent = event;
			$location.path('bet');
		};
	}
});
