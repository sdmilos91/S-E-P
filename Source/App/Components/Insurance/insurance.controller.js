(function() {
	"use strict";
	
	angular
		.module('merchantApp.insurance')
		.controller('InsuranceController', InsuranceController);

	
	InsuranceController.$inject = ['$scope', '$location', '$state'];

	function InsuranceController($scope, $location, $state){
		var ic = this;

		ic.isActiveStep = function(path){
			return $location.path().indexOf(path) != -1;
		}

		ic.hideSelectRegion = true;		

		ic.toggleRegionsForm = function(){
			ic.hideSelectRegion = !ic.hideSelectRegion;
		};


		ic.regions = [
		{
		        'name': 'Brazil'
		    }, {
		        'name': 'Japan'
		    }, {
		        'name': 'Engleska'
		    }, {
		        'name': 'Rusija'
		    }, {
		        'name': 'Meksiko'
		    }, {
		        'name': 'Portugalija'
		    }, {
		        'name': 'Danska'
		    }, {
		        'name': 'Tanzanija'
		    }
	     ];


		ic.selectRegion = function(item){
			ic.selectedRegion = item;
			ic.hideSelectRegion = true;
		};

		ic.selectedRegion = ic.regions[0];

		ic.numberOfPeople = ic.numberOfPeople || 1;

		ic.previousState;
		ic.nextState;
		ic.currentState;
		
		$scope.$on('$stateChangeSuccess', function(ev, to, toParams, from, fromParams) {
		    ic.currentState = to.name;
		});

	

		ic.goBack = function(){

			var stepIndex = parseInt(ic.currentState.split('steps.step')[1]);
			if(stepIndex != 'NaN'){
				if(stepIndex > 1)
					stepIndex = stepIndex -1;

				$state.go(ic.currentState.split('step')[0] + 'steps.step' + stepIndex);
			}
		};

		ic.goNext = function(){

		var stepIndex = parseInt(ic.currentState.split('steps.step')[1]);
				
			if(stepIndex != 'NaN'){

				if(stepIndex < 3)
					stepIndex = stepIndex  + 1;

				$state.go(ic.currentState.split('step')[0] + 'steps.step' + stepIndex);

			}
		};
};
})();