/**
 * mainPage.html
 */
var mainApp = angular.module('mainApp', ['commonModule']);

mainApp.controller('mainCtrl', function($scope, $interval, commonService) {

	$scope.nowTime = new Date().toLocaleTimeString();

	// Init
	commonService.ajax('/loadMainPage', null, function(res) {
		$scope.copyright = res.returnObj.copyright;
		$scope.menu = res.returnObj.menu;
		$scope.currentPage = res.returnObj.currentPage;
	});

	$scope.clickMenu = function(url) {
		$scope.currentPage = url;
	};

	// display nowTime
	$interval(function() {
		$scope.nowTime = new Date().toLocaleTimeString();
	}, 1000);

});

mainApp.directive('loadPage', function() {
	return {
		restrict: 'AE',
		replace: true,
		scope: true,
		template: '<div ng-include src="getURL()" ></div>',
		// <div ng-include="'html/views/nba.html'" ng-controller="nbaCtrl"></div>
		link: function(scope, element, attrs) {
			scope.getURL = function() {
				return scope.currentPage;
			}
		}
	};
});
