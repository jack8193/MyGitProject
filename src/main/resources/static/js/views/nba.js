/**
 * nba.js
 */

// console.log(mainApp);

mainApp.controller('nbaCtrl', function($scope, commonService) {

	$scope.currentPage = "nbaCtrl html/views/nba.html";

	$scope.gameDate = new Date();
	$scope.games = [];

	$scope.getGames = function() {
		commonService.ajax('/getNBAGames', { gameDate: $scope.gameDate }, function(res) {
			$scope.gameDate = res.returnObj.gameDate;

			$scope.games = res.returnObj.nbaGame;
		}, function(error) {
			$scope.currentPage = error.message;
		});
	};
	
	// Init	
	$scope.getGames();

});
