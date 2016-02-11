(function() {
	"use strict";

	angular
		.module('acquirerApp.core')
		.factory('Form', Form);

	Form.$inject = ['$resource'];
	function Form($resource) {
		
		var formService = $resource("http://localhost:58643/api/Pcc/", {}, 
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