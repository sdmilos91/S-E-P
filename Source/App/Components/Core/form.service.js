(function() {
	"use strict";

	angular
		.module('acquirerApp.core')
		.factory('Form', Form);

	Form.$inject = ['$resource'];
	function Form($resource) {
		
		var formService = $resource("http://192.168.1.4:58643/api/Bank/SendOrder", {}, 
		{
        	sendOrder: 
        	{
        		method : "POST", 
        		headers: {'Content-Type': 'application/json'}
        	},
        	sendTransactionResult:
        	{
        		url: "http://localhost:8080/testing/rest/travel_insurances/url",
        		method: "POST",		        		
        		headers: {'Content-Type': 'application/json'}	        		
        	}
   		});

		
		return formService;
	}
})();