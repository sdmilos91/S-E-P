(function(){

	angular.module('merchantApp.insurance').controller('CarModalController', CarModalController);

	CarModalController.$inject = ['$scope', '$uibModalInstance', 'carRisks', 'data'];

	function CarModalController($scope, $uibModalInstance, carRisks, data) {

		var cmc = this;

		cmc.carInsurance = {};
        cmc.hasData = false;
        if(typeof data != 'undefined'){
            cmc.carInsurance = data;
            cmc.hasData = true;
            for(var j = 0; j < carRisks.risks.length > 0; j++){
                for(var i = 0; i < data.Risks.length > 0; i++){
                    if(carRisks.risks[j].risk_Id == data.Risks[i].risk_Id){
                        var risk = carRisks.risks[j];
                        cmc.selectedRisks.push(risk);    
                    }
                    
                }
            }
        }
        
        cmc.carInsurance.Risks = new Array();

        cmc.hideSelectRisks = true;
		cmc.selectedRisks = [];
		cmc.risks = carRisks.risks;
		cmc.riskPrice = 0;
		cmc.currentRiskSelected = cmc.risks[0].risk_Id;

		cmc.toggleRisksForm = function(){
			cmc.hideSelectRisks = !cmc.hideSelectRisks;
		};

		cmc.addRisk = function(){

			for(var i = 0; i < cmc.risks.length; i++){
				if(cmc.risks[i].risk_Id == cmc.currentRiskSelected){
					cmc.selectedRisks.push(cmc.risks[i]);
				}
			}

			//cmc.refreshPrice();
			cmc.currentRiskSelected = getFreeRiskId();

		}

		 function getFreeRiskId(){
		 	for(var i = 0; i < cmc.risks.length; i++){
				if(cmc.selectedRisks.indexOf(cmc.risks[i]) == -1){
					return cmc.risks[i].risk_Id;
				}
			}
			return -1;
		 }

		cmc.removeSelectedRisk = function(id){

			for(var j = 0; j < cmc.selectedRisks.length; j++){
				if(id == cmc.selectedRisks[j].risk_Id){
					cmc.selectedRisks.splice(j, 1);
				}
			}

			//cmc.refreshPrice();
			cmc.currentRiskSelected = getFreeRiskId();
		}

		cmc.risksFilter = function(item){

			var risksLength = cmc.risks.length;
			
			for(var j = 0; j < cmc.selectedRisks.length; j++){

				if(cmc.selectedRisks[j].risk_Id == item.risk_Id){
					return false;
				}
			}
			return true;
		}
     
       cmc.ok = function () {
            for(var j = 0; j < cmc.selectedRisks.length; j++){
				cmc.carInsurance.Risks.push({risk_Id: cmc.selectedRisks[j].risk_Id, value: 1});
			}
           if(cmc.carForm.$valid && cmc.selectedRisks.length > 0)
                $uibModalInstance.close(cmc.carInsurance);
        };
        
        cmc.remove = function () {
            cmc.carInsurance = (function () { return; })();
            $uibModalInstance.close(cmc.carInsurance);
        };

        cmc.cancel = function () {
            $uibModalInstance.dismiss();
        };
        
	}

})();