/**
 * nba.js
 */

// console.log(mainApp);

mainApp.controller('nbaCtrl', function($scope, commonService) {

	$scope.currentPage = "nbaCtrl html/views/nba.html";
	
	$scope.gameDate = new Date();
	$scope.games = [];
	
	// Init	
	commonService.ajax('/loadNBA', null, function(res) {
		$scope.gameDate = res.returnObj.gameDate;
		
		$scope.games = res.returnObj.nbaGame;
	}, function(error) {
		$scope.currentPage = error.message;
	});

});
