(function(){
    angular.module('merchantApp.insurance').controller('OfferStepsController', OfferStepsController);
    
    OfferStepsController.$inject = ['$scope', '$location', '$state', 'notifyModal']
    
    function OfferStepsController($scope, $location, $state, notifyModal) {
        var osc = this;
        osc.parent;
        osc.previousState;
		osc.nextState;
		osc.currentState;
        
        osc.validForms= new Array();
        osc.validForms.push(false);
        osc.validForms.push(false);
        osc.isPrevious = false;
        osc.milos;
		
        osc.isActiveStep = function(path){
			return $location.path().indexOf(path) != -1;
		}
		
		//Funkcije za navigaciju
        $scope.$on('$stateChangeStart', function(ev, to, toParams, from, fromParams) {
             osc.parent = ev.currentScope.$parent.ic;
            if(typeof osc.parent.forms != 'undefined' && typeof osc.parent.forms[0] != 'undefined' && !osc.parent.forms[0].$valid)
            {
                osc.validForms[0] = false;
            }else if(typeof osc.parent.forms != 'undefined' && typeof osc.parent.forms[1] != 'undefined' && !osc.parent.forms[1].$valid)
            {
                osc.validForms[1] = false;
            }
        });
        
		$scope.$on('$stateChangeSuccess', function(ev, to, toParams, from, fromParams) {
            
            osc.parent = ev.currentScope.$parent.ic;
            osc.currentState = to.name;
            
            if (from.name === '' && to.name.indexOf('main.offer.steps') != -1) {
                event.preventDefault();
                $state.go('main.offer.steps.step1');
            }
            
            if(!osc.validForms[0]  && !osc.isPrevious){
                $state.go('main.offer.steps.step1');
                osc.isPrevious = false;
            }else if(!osc.validForms[1]  && !osc.isPrevious){
                $state.go('main.offer.steps.step2');
                osc.isPrevious = false;
            }else{
               $state.go(to.name); 
               osc.isPrevious = false;
            }
            
            
		});

		osc.goBack = function(){
			osc.isPrevious = true;
            var stepIndex = parseInt(osc.currentState.split('steps.step')[1]);
			if(stepIndex != 'NaN'){
				if(stepIndex > 1)
					stepIndex = stepIndex -1;

				$state.go(osc.currentState.split('step')[0] + 'steps.step' + stepIndex);
			}
		};

		osc.goNext = function(nextStep){
			osc.isPrevious = false;
            
            if(typeof nextStep == 'undefined'){
                var stepIndex = parseInt(osc.currentState.split('steps.step')[1]);

                if(stepIndex != 'NaN'){
                    
                    if(stepIndex < 4)
                        stepIndex = stepIndex  + 1;
        
                    nextStep = osc.currentState.split('step')[0] + 'steps.step' + stepIndex;
                }
            }
            if((nextStep == 'main.offer.steps.step2' || osc.currentState == 'main.offer.steps.step1') && typeof osc.parent.forms != 'undefined' && typeof osc.parent.forms[0] != 'undefined' && !osc.parent.forms[0].$valid)
		    {
				$state.go('main.offer.steps.step1');
				notifyModal.open();
		    }else if((nextStep == 'main.offer.steps.step2' || osc.currentState == 'main.offer.steps.step1') && typeof osc.parent.forms != 'undefined' && typeof osc.parent.forms[0] != 'undefined' && osc.parent.forms[0].$valid)
		    {
                osc.validForms[0] = true;
				$state.go(nextStep);				
		    }else if ((nextStep == 'main.offer.steps.step3' || osc.currentState == 'main.offer.steps.step2') && typeof osc.parent.forms != 'undefined' && typeof osc.parent.forms[1] != 'undefined' && !osc.parent.forms[1].$valid) {
                osc.parent.forms[1].$submitted = true;
		    	$state.go('main.offer.steps.step2');
		    	notifyModal.open();
		    }else if ((nextStep == 'main.offer.steps.step3' || osc.currentState == 'main.offer.steps.step2') && typeof osc.parent.forms != 'undefined' && typeof osc.parent.forms[1] != 'undefined' && osc.parent.forms[1].$valid) {
		    	osc.validForms[1] = true;
				$state.go(nextStep);
                osc.milos = osc.parent.forms[1];
		    }else{
                $state.go(nextStep);
            }
			
		};
    }
})();