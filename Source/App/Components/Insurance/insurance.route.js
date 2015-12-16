(function() {
	"use strict";

	angular
		.module('merchantApp.insurance')
		.config(config);

	config.$inject = ['$stateProvider'];
	function config($stateProvider) {
		$stateProvider
			.state('main.offer',{
					url: '/offer',
						views:{
							'main@':{
								templateUrl:'App/Components/Insurance/offer.html',
								controller:'InsuranceController',
								controllerAs: 'ic'
							}
						}
			});
		}

})();