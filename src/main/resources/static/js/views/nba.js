/**
 * nba.js
 */

// console.log(mainApp);

mainApp.controller('nbaCtrl', function($scope, commonService) {
	commonService.testF();

	$scope.nbaString = "nbaCtrl done";
	
	$scope.nbaMyString = $scope.mainCtrlString;
	
	$scope.init = function() {
		alert('nbaCtrl init');
	}
	
	$scope.init();
});
