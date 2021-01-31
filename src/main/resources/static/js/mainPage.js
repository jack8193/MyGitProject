/**
 * mainPage.html
 */
var mainApp = angular.module('mainApp', ['ngSanitize', 'commonModule']);

mainApp.controller('mainCtrl', function($scope, $interval, $sce, commonService) {

	$scope.currentPage = 'html/views/stock.html';

	$scope.mainCtrlString = "This is from mainCtrl : mainCtrlString";

	$scope.init = function() {
		$scope.nowTime = new Date().toLocaleTimeString();

		commonService.ajax('/loadMainPage', null, function(res) {
			$scope.menu = res.returnObj.menu;
		});
	};

	$scope.clickMenu = function(url) {
		$scope.currentPage = url;
	};

	$scope.init();

	// display nowTime
	$interval(function() {
		$scope.nowTime = new Date().toLocaleTimeString();
	}, 1000);

});

mainApp.directive('loadMyPage', function() {
	return {
		restrict: 'AE',
		replace: true,
		scope: true,
		template: '<div ng-include src="getURL()" ></div>',
		link: function(scope, element, attrs) {
			scope.getURL = function() {
				return scope.currentPage;
			}
		}
	};
});
