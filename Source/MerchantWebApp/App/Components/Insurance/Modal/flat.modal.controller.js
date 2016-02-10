(function(){

	angular.module('merchantApp.insurance').controller('FlatModalController', FlatModalController);

	FlatModalController.$inject = ['$scope', '$uibModalInstance', 'flatRisks', 'data'];

	function FlatModalController($scope, $uibModalInstance, flatRisks, data) {

		var fmc = this;

		fmc.flatInsurance = {};
        fmc.selectedRisks = [];
        
        fmc.hasData = false;
        if(typeof data != 'undefined'){
            fmc.flatInsurance = data;
            fmc.hasData = true;
            for(var j = 0; j < flatRisks.risks.length > 0; j++){
                for(var i = 0; i < data.Risks.length > 0; i++){
                    if(flatRisks.risks[j].risk_Id == data.Risks[i].risk_Id){
                        fmc.selectedRisks.push(flatRisks.risks[j]);    
                    }
                    
                }
            }
        }
        
        fmc.flatInsurance.Risks = new Array();
        fmc.hideSelectRisks = true;
		
		fmc.risks = flatRisks.risks;
		fmc.riskPrice = 0;
		fmc.currentRiskSelected = fmc.risks[0].risk_Id;

		fmc.toggleRisksForm = function(){
			fmc.hideSelectRisks = !fmc.hideSelectRisks;
		};

		fmc.addRisk = function(){

			for(var i = 0; i < fmc.risks.length; i++){
				if(fmc.risks[i].risk_Id == fmc.currentRiskSelected){
					fmc.selectedRisks.push(fmc.risks[i]);
				}
			}

			//fmc.refreshPrice();
			fmc.currentRiskSelected = getFreeRiskId();

		}

		 function getFreeRiskId(){
		 	for(var i = 0; i < fmc.risks.length; i++){
				if(fmc.selectedRisks.indexOf(fmc.risks[i]) == -1){
					return fmc.risks[i].risk_Id;
				}
			}
			return -1;
		 }

		fmc.removeSelectedRisk = function(id){

			for(var j = 0; j < fmc.selectedRisks.length; j++){
				if(id == fmc.selectedRisks[j].risk_Id){
					fmc.selectedRisks.splice(j, 1);
				}
			}

			//fmc.refreshPrice();
			fmc.currentRiskSelected = getFreeRiskId();
		}

		fmc.risksFilter = function(item){

			var risksLength = fmc.risks.length;
			
			for(var j = 0; j < fmc.selectedRisks.length; j++){

				if(fmc.selectedRisks[j].risk_Id == item.risk_Id){
					return false;
				}
			}
			return true;
		}
        
        fmc.ok = function () {
            for(var j = 0; j < fmc.selectedRisks.length; j++){
				fmc.flatInsurance.Risks.push({risk_Id: fmc.selectedRisks[j].risk_Id, value: 1});
			}
            if(fmc.flatForm.$valid && fmc.selectedRisks.length > 0)
                $uibModalInstance.close(fmc.flatInsurance);
        };
        
         fmc.remove = function () {
            fmc.flatInsurance = (function () { return; })();;
            $uibModalInstance.close(fmc.flatInsurance);
        };

        fmc.cancel = function () {
            $uibModalInstance.dismiss();
        };
        
	}

})();