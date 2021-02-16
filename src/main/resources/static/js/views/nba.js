/**
 * nba.js
 */

// console.log(mainApp);

mainApp.controller('nbaCtrl', function($scope, commonService) {

	$scope.currentPage = "nbaCtrl html/views/nba.html";
	
	// Init	
	commonService.ajax('/loadNBA', null, function(res) {
		$scope.nbaTeam = res.returnObj.nbaTeam;
		
		console.log(res.returnObj.nbaGame);
	}, function(error) {
		$scope.currentPage = error.message;
	});

});
