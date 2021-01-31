/**
 * common.js
 */
var commonModule = angular.module('commonModule', []);

commonModule.service('commonService', function($http) {

	this.ajax = function(url, data, successCallBack, errorCallBack) {
		$http({
			method: 'POST',
			url: url,
			data: data
		}).then(function(res) {
			switch (res.data.returnCode) {
				case 'SUCCESS':
					successCallBack(res.data);
					break;
				case 'WARNING':
					// alert message
					alert('httpPost WARNING');
					break;
				default:
					alert('httpPost DEFAULT');
			}
		}).catch(function(e) {
			if (errorCallBack) {
				errorCallBack(e);
			}
		});
	};

});
