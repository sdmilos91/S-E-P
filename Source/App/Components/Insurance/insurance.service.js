(function() {
	"use strict";

	angular
		.module('merchantApp.insurance')
		.factory('Insurance', Insurance);

	Insurance.$inject = ['$resource'];
	function Insurance($resource) {
		
		var insuranceService = $resource("http://localhost:8080/testing/rest/risks/:id");

		
		return insuranceService;
	}
})();