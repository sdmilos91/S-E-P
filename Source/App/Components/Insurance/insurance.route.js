(function() {
	"use strict";

	angular
		.module('merchantApp.insurance')
		.config(config);

	config.$inject = ['$stateProvider'];
	function config($stateProvider) {
		$stateProvider
			.state('main.offer',{
					abstract: true,
					url: '/offer',
						views:{
							'main@':{
								templateUrl:'App/Components/Insurance/offer.html',
								controller:'InsuranceController',
								controllerAs: 'ic'
							}
						}
			}).state('main.offer.steps', {
				abstract: true,
				controller: 'InsuranceController',
				controllerAs: 'ic',
				views: {
					'progresBar':{
						templateUrl:'app/components/Insurance/offer.progressBar.html'
					},
					'progresControls':{
						templateUrl: 'app/components/Insurance/offer.progressControls.html'
					}
				}
			}).state('main.offer.steps.step1',{
				url: '/offerStep1',
				views: {
					'steps@main.offer':{
						templateUrl: 'app/components/Insurance/offer.steps/offer.step1.html',
					}
				}
			}).state('main.offer.steps.step2',{
				url: '/offerStep2',
				views: {
					'steps@main.offer':{
						templateUrl: 'app/components/Insurance/offer.steps/offer.step2.html',
					}
				}
			}).state('main.offer.steps.step3',{
				url: '/offerStep3',
				views: {
					'steps@main.offer':{
						templateUrl: 'app/components/Insurance/offer.steps/offer.step3.html',
					}
				}
			});
		}

})();