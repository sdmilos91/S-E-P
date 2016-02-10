(function() {
	'use strict';

	angular
		.module('merchantApp.insurance')
		.factory('carModal', carModal);

	carModal.$inject = ['$uibModal'];
	function carModal($uibModal) {
		return {
			open: openFlatModal
		};

		function openFlatModal(data) {
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: 'App/Components/Insurance/Modal/car.modal.html',
				controller: 'CarModalController',
				controllerAs: 'cmc',
                resolve:{
                    carRisks: getCarRisks,
                    data: function(){
                        return data;
                    }
                }
			});

			return modalInstance.result.then(function(flag) {
				return flag;
			});
		}
	}
})();


getCarRisks.$inject = ['Insurance'];
function getCarRisks(Insurance) {
    return Insurance.get({id: 'carRisks'}).$promise;
    //return {"risks":[{"risk_Id":8,"value":"Odbojka","validFrom":1451602800000,"validTo":1483225200000,"coef":200,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/8"}]},{"risk_Id":9,"value":"Kosarka","validFrom":1451602800000,"validTo":1483225200000,"coef":400,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/9"}]},{"risk_Id":10,"value":"Fudbal","validFrom":1451602800000,"validTo":1483225200000,"coef":700,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/10"}]}],"links":[]};
}