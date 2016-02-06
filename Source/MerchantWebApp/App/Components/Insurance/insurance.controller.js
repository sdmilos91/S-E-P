(function() {
	"use strict";
	
	angular
		.module('merchantApp.insurance')
		.controller('InsuranceController', InsuranceController);

	
	InsuranceController.$inject = ['$scope','$window', '$location', '$state', '$uibModal', 'Insurance', 'regions', 'sports', 'ages', 'amounts', 'flatModal', 'notifyModal', 'submitModal', 'carModal'];

	function InsuranceController($scope, $window, $location, $state, $uibModal, Insurance, regions, sports, ages, amounts, flatModal, notifyModal, submitModal, carModal){
		var ic = this;

		ic.duration = 1;
		ic.durationCoef = 1.0;
        
		/******************************* BROJ OSOBA I GODINE *********************************/
		ic.ages = ages.risks;

		ic.agesInputs = initNopInputs();

		ic.hideSelectNoP = true;		

		ic.toggleNoPForm = function(){
			ic.hideSelectNoP = !ic.hideSelectNoP;
			
		};

		ic.nopCoef = 1;

		ic.countNoP = function(){
			var totalNumberOfPeople = 0;
			for (var i = 0; i < ic.ages.length; i++) {
				var number = ic.agesInputs[ic.ages[i].risk_Id] || 0;
				totalNumberOfPeople += number;
			};
			
			ic.numberOfPeople = totalNumberOfPeople;
			ic.refreshPrice();
		}

		/******************************* SPORT *********************************************/
		ic.hideSelectSports = true;
		ic.selectedSports = [];
		ic.sports = sports.risks;
		ic.sportPrice = 0;
		ic.currentSportSelected = ic.sports[0].risk_Id;

		ic.toggleSportsForm = function(){
			ic.hideSelectSports = !ic.hideSelectSports;
		};

		ic.addSport = function(){

			for(var i = 0; i < ic.sports.length; i++){
				if(ic.sports[i].risk_Id == ic.currentSportSelected){
					ic.selectedSports.push(ic.sports[i]);
				}
			}

			ic.refreshPrice();
			ic.currentSportSelected = getFreeSportId();

		}

		 function getFreeSportId(){
		 	for(var i = 0; i < ic.sports.length; i++){
				if(ic.selectedSports.indexOf(ic.sports[i]) == -1){
					return ic.sports[i].risk_Id;
				}
			}
			return -1;
		 }

		ic.removeSelectedSport = function(id){

			for(var j = 0; j < ic.selectedSports.length; j++){
				if(id == ic.selectedSports[j].risk_Id){
					ic.selectedSports.splice(j, 1);
				}
			}

			ic.refreshPrice();
			ic.currentSportSelected = getFreeSportId();
		}

		ic.sportsFilter = function(item){

			var sportsLength = ic.sports.length;
			
			for(var j = 0; j < ic.selectedSports.length; j++){

				if(ic.selectedSports[j].risk_Id == item.risk_Id){
					return false;
				}
			}
			return true;
		}


		/******************************* REGION *********************************************/
		ic.regions = regions.risks;
	    ic.selectedRegion = ic.regions[0];

		ic.hideSelectRegion = true;		

		ic.toggleRegionsForm = function(){
			ic.hideSelectRegion = !ic.hideSelectRegion;
		};

		ic.selectRegion = function(item){
			ic.selectedRegion = item;
			ic.hideSelectRegion = true;
			ic.refreshPrice();
		};

		/******************************* IZNOS NA KOJI SE OSIGURAVA ***************************/
		ic.amounts = amounts.risks;
 		ic.amountSelected = ic.amounts[0].risk_Id;

 		/******************************* KUPCI ************************************************/
 		ic.customers = new Array();
 		ic.isContractor = function(index){
 			return index == 0;
 		}
 		ic.forms;

	    ic.price = getPrice();

	    ic.refreshPrice = function(){
			ic.price = getPrice();
		};

        
        
        /************************************* OSIGURANJE STANA ********************************/
        ic.isFlat = false;
        ic.openHomeInsuranceModal = function(){
            flatModal.open(ic.FlatInsurance).then(function(flat){
                ic.FlatInsurance = flat;
                if(typeof ic.FlatInsurance != 'undefined'){
                    ic.isFlat = true;
                }else{
                    ic.isFlat = false;
                }
            });
        }

        /************************************* OSIGURANJE AUTA *********************************/
        ic.isCar = false;
        ic.openCarInsuranceModal = function(){
            carModal.open(ic.CarInsurance).then(function(car){
                ic.CarInsurance = car;
                if(typeof ic.CarInsurance != 'undefined'){
                    ic.isCar = true;
                }else{
                    ic.isCar = false;
                }
            });
        }
        /************************************** POTVRDA KUPOVINE ********************************/
        
		ic.getServiceData = function(){
			
            var risks = new Array;
			risks.push({risk_Id: ic.selectedRegion.risk_Id, value: 1});
			risks.push({risk_Id: ic.amountSelected, value: 1});
			
            for (var i = ic.selectedSports.length - 1; i >= 0; i--) {
				risks.push({risk_Id: ic.selectedSports[i].risk_Id, value: 1});	
			}
			
            for (var i = 0; i < ic.ages.length; i++) {
				var number = ic.agesInputs[ic.ages[i].risk_Id] || 0;
				if(number > 0){
					risks.push({risk_Id: ic.ages[i].risk_Id, value: number});
				}
			}			

			var serviceData = {
				risks: risks,
				duration: ic.duration,
				amount: ic.price,
				customers: ic.customers,
                car: ic.CarInsurance,
                flat: ic.FlatInsurance
			};
            
   			Insurance.sendInsuranceData({}, serviceData).$promise.then(function (result) {
   				console.log(result);
   				if(!result.error){
                    var paymentUrl = result.paymentURL;
   					submitModal.open().then(function(flag){
                        if(flag)
                        {
                            $window.location.href = paymentUrl;
                        }
                    });
   				}
   			}, function(error){
                $state.go('main.error');
            });
   		
			
		}

   
/******************************* HELPER FUNCTIONS ******************************************/		

		function getPrice(){
            
			var price = ic.selectedRegion.coef;
            
			ic.durationCoef = (1 + ic.duration / 10).toFixed(2);
			price = (1 + ic.duration / 10) * price;
			
			//Racunanje cene za sportove
			var sportPrice = 0;
			for (var i = ic.selectedSports.length - 1; i >= 0; i--) {
				if(ic.selectedSports[i].flag){
					sportPrice += ic.selectedSports[i].coef;	
				}else{
                    if(i == ic.selectedSports.length - 1)
                        sportPrice = 1;
                    sportPrice = (sportPrice * ic.selectedSports[i].coef)
                }
			}
            
			ic.sportPrice = sportPrice;
			price = price + sportPrice;
			
            
			//Racunanje cene za broj osoba
			var numberOfPeoplePrice = new Array();
			ic.nopCoef = 1;
			for (var i = 0; i < ic.ages.length; i++) {
				var number = ic.agesInputs[ic.ages[i].risk_Id] || 0;
				var age = ic.ages[i];
				var tempPrice = 0;
				if(age.flag)
				{
					tempPrice = age.coef * number;
					if(i == 1)
						ic.nopCoef = 0;
					ic.nopCoef = (ic.nopCoef + tempPrice).toFixed(2);;	
					tempPrice = price + tempPrice;
				}else{
					if (number > 0)
						ic.nopCoef = (ic.nopCoef * age.coef * number).toFixed(2);;
					tempPrice = price * age.coef * number;
				}
				
				numberOfPeoplePrice.push(tempPrice);
			};

			price = 0;

			for (var i = 0; i < numberOfPeoplePrice.length; i++) {
				price += numberOfPeoplePrice[i];
			};

			//Cena za osigurani iznos
			for (var i = ic.amounts.length - 1; i >= 0; i--) {
				if(ic.amounts[i].risk_Id == ic.amountSelected){
					if(ic.amounts[i].flag){
						price +=  ic.amounts[i].coef;
					}else{
						price =  price * ic.amounts[i].coef;
					}
					ic.amountsValue =  ic.amounts[i].coef.toFixed(2);	
				}
			}

			return price.toFixed(2);
		}

		function initNopInputs(){
			var retVal = [];
			
			for (var i = 0; i < ic.ages.length; i++) {
					if (i==1) {
						retVal[ic.ages[i].risk_Id] = 1;	
					}else{
						retVal[ic.ages[i].risk_Id] = 0;	
					}		
			};

			ic.numberOfPeople = 1;

			return retVal;
		}
};

})();
