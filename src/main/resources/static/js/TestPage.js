/**
 * Angular JS
 */
var testApp = angular.module('testApp', []);
testApp.controller('testCtrl', function($scope, $http) {
	$scope.angularString = "angularString";

	$scope.testAngularJS = function() {
		$http({
			method: 'POST',
			url: '/testAngularJS',
			data: null
		}).then(function(res) {
			alert("res.data.returnCode : " + res.data.returnCode + "!!!");
			console.log("---testAngularJS()---");
			console.log(res);

			if (res.data.returnCode == "SUCCESS") {
				console.log(res.data.returnCode.code); // undefined
				console.log("==SUCCESS");
			}
			$scope.angularString = res.data.returnObj.testAngularJSKey;
		}).catch(function(e) {
			alert("error testAngularJS().");
		});
	}
});

/**
 * JavaScript
 */
function testJSAjax() {
	$.ajax({
		type: "POST",
		//data: {id: id, status: status},
		url: "/testJSAjax",
		success: function(data) {
			alert("data.returnCode : " + data.returnCode + "!!!");
			name = "testJSAjax() success!!!"; // doesn't work
			console.log("---testJSAjax()---");
			console.log(data);
			console.log(data.returnObj);
		},
		error: function(e) {
			alert("error testJSAjax().");
		}
	});
}
