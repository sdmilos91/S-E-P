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
					resolve: {
							regions: getRegions,
							sports: getSports,
							ages: getAges,
							amounts: getAmounts
						},
						views:{
							'main@':{
								templateUrl:'App/Components/Insurance/offer.html',
								controller:'InsuranceController',
								controllerAs: 'ic'
							}
						}
			}).state('main.offer.steps', {
				abstract: true,
				views: {
					'progresBar':{
						templateUrl:'app/components/Insurance/offer.progressBar.html',
                        controller:'OfferStepsController',
                        controllerAs: 'osc'
					},
					'progresControls':{
						templateUrl: 'app/components/Insurance/offer.progressControls.html',
                        controller:'OfferStepsController',
                        controllerAs: 'osc'
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
			}).state('main.offer.steps.step4',{
				url: '/offerStep4',
				views: {
					'steps@main.offer':{
						templateUrl: 'app/components/Insurance/offer.steps/offer.step4.html',
					}
				}
			});

			getRegions.$inject = ['Insurance'];
			function getRegions(Insurance) {
				//return Insurance.get({id: 'regions'}).$promise;
				return {"risks":[{"risk_Id":1,"value":"Austrija","validFrom":1451602800000,"validTo":1483225200000,"coef":1000,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/1"}]},{"risk_Id":2,"value":"Nemacka","validFrom":1451602800000,"validTo":1483225200000,"coef":2000,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/2"}]},{"risk_Id":3,"value":"Francuska","validFrom":1451602800000,"validTo":1483225200000,"coef":2500,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/3"}]},{"risk_Id":4,"value":"Brazil","validFrom":1451602800000,"validTo":1483225200000,"coef":5000,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/4"}]},{"risk_Id":5,"value":"Meksiko","validFrom":1451602800000,"validTo":1483225200000,"coef":5500,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/5"}]},{"risk_Id":6,"value":"SAD","validFrom":1451602800000,"validTo":1483225200000,"coef":3500,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/6"}]},{"risk_Id":7,"value":"Tanzanija","validFrom":1451602800000,"validTo":1483225200000,"coef":7000,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/7"}]}],"links":[]};
			}
			getSports.$inject = ['Insurance'];
			function getSports(Insurance) {
				//return Insurance.get({id: 'sports'}).$promise;
				return {"risks":[{"risk_Id":8,"value":"Odbojka","validFrom":1451602800000,"validTo":1483225200000,"coef":200,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/8"}]},{"risk_Id":9,"value":"Kosarka","validFrom":1451602800000,"validTo":1483225200000,"coef":400,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/9"}]},{"risk_Id":10,"value":"Fudbal","validFrom":1451602800000,"validTo":1483225200000,"coef":700,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/10"}]}],"links":[]};
			}
			getAges.$inject = ['Insurance'];
			function getAges(Insurance) {
				//return Insurance.get({id: 'ages'}).$promise;
				return {"risks":[{"risk_Id":11,"value":"Do 18","validFrom":1451602800000,"validTo":1483225200000,"coef":0.7,"flag":false,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/11"}]},{"risk_Id":12,"value":"18 - 60","validFrom":1451602800000,"validTo":1483225200000,"coef":1,"flag":false,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/12"}]},{"risk_Id":13,"value":"Preko 60","validFrom":1451602800000,"validTo":1483225200000,"coef":0.8,"flag":false,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/13"}]}],"links":[]};
			}
			getAmounts.$inject = ['Insurance'];
			function getAmounts(Insurance) {
				return {"risks":[{"risk_Id":14,"value":"50000","validFrom":1451602800000,"validTo":1483225200000,"coef":1,"flag":false,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/14"}]},{"risk_Id":15,"value":"100000","validFrom":1451602800000,"validTo":1483225200000,"coef":1.2,"flag":false,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/15"}]},{"risk_Id":16,"value":"150000","validFrom":1451602800000,"validTo":1483225200000,"coef":1.5,"flag":false,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/16"}]}],"links":[]};
				//return Insurance.get({id: 'amounts'}).$promise;
			}
		}

})();