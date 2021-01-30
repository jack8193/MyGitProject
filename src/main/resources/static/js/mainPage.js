/**
 * mainPage.html
 */
var mainApp = angular.module('mainApp', ['ngSanitize']);

mainApp.controller('mainCtrl', function($scope, $http, $sce) {
	$scope.myString = "mainCtrl : mainPage.js";

	$scope.init = function() {
		$http({
			method: 'POST',
			url: '/loadMainPage',
			data: null
		}).then(function(res) {
			alert("$scope.init SUCCESS");
			console.log(res);
			$scope.menu = res.data.returnObj.menu;
			$scope.myString = res.data.message;
		}).catch(function(e) {
			console.log(e);
		});
	};
	
	$scope.clickMenu = function(url) {
		$http({
			method: 'POST',
			url: url,
			data: null
		}).then(function(res) {
			alert("$scope.clickMenu SUCCESS");
			console.log(res);
			//$scope.myString = res.data.message;
			
			$scope.loadPage = $sce.trustAsHtml(res.data);
		}).catch(function(e) {
			console.log(e);
		});
	};

	$scope.init();
});
