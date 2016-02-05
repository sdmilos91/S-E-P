(function() {
	"use strict";
	
	angular
		.module('acquirerApp.core')
		.controller('FormController', FormController);

	FormController.$inject = ['$scope','$window', '$stateParams', '$timeout', 'Form'];
	function FormController($scope, $window, $stateParams, $timeout, Form) {
        
        var fc = this;
        fc.isLoad = false;
        fc.error = false;
        fc.errorMessage = "";
        PAN : fc.pan = "";
        fc.securityCode = "";
        fc.cardHolder = "";        
        fc.paymentId = $stateParams.paymentId;


        fc.today = function() {
        fc.dt = new Date();
        };
        fc.today();

        fc.clear = function() {
            fc.dt = null;
        };

        fc.open = function() {
            fc.popup.opened = true;
        };

        fc.setDate = function(year, month, day) {
            fc.dt = new Date(year, month, day);
        };

        fc.dateOptions = {
            formatYear: 'yy',
            startingDay: 1
        };

        fc.popup = {
            opened: false
        };

       

        fc.clickMe = function(){
		 fc.isLoad = true;
            var serviceData = {
            PaymentID : fc.paymentId,
            CardPAN : fc.pan,
            CardSecurityCode : fc.securityCode,
            CardHolderName : fc.cardHolder,
            CardValidThru : fc.dt
        };
            if($scope.bankForm.$valid){
               Form.sendOrder({}, serviceData).$promise.then(function (result) {
                    if(!result.isError){
                        var jsonString = JSON.stringify(result);
                        console.log(jsonString); 
                         fc.getRedirectUrl(jsonString);
                                    
                        //Zovi servis koji Aleksandar treba implementirati da ti posalje link do success strane
                    }else if(result.redirect){
						var jsonString = JSON.stringify(result);
                        console.log(jsonString); 
                         fc.getRedirectUrl(jsonString);
                    }else{
                        console.log(result.Errors);
                    }					 
                });
            }
        }

        fc.getRedirectUrl = function(param){
            Form.sendTransactionResult({}, param).$promise.then(function (resultURL) {
                                console.log(resultURL);
								$window.location.href = resultURL.url;
                            },
                            function (error) {
                                // handle errors here
                                console.log(error);
                            });
        }
	}
    
})();

