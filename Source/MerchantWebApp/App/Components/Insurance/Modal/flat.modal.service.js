(function() {
	'use strict';

	angular
		.module('merchantApp.insurance')
		.factory('flatModal', flatModal);

	flatModal.$inject = ['$uibModal'];
	function flatModal($uibModal) {
		return {
			open: openFlatModal
		};

		function openFlatModal(aaaa) {
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: 'App/Components/Insurance/Modal/flat.modal.html',
				controller: 'FlatModalController',
				controllerAs: 'fmc',
                resolve:{
                    flatRisks: getRisks,
                    data: function(){
                        return aaaa;
                    }
                }
			});

			return modalInstance.result.then(function(flag) {
				return flag;
			});
		}
	}
})();

getRisks.$inject = ['Insurance'];
function getRisks(Insurance) {
    return Insurance.get({id: 'flatRisks'}).$promise;
    //return {"risks":[{"risk_Id":8,"value":"Odbojka","validFrom":1451602800000,"validTo":1483225200000,"coef":200,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/8"}]},{"risk_Id":9,"value":"Kosarka","validFrom":1451602800000,"validTo":1483225200000,"coef":400,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/9"}]},{"risk_Id":10,"value":"Fudbal","validFrom":1451602800000,"validTo":1483225200000,"coef":700,"flag":true,"links":[{"rel":"self","href":"http://localhost:8080/testing/rest/risk/10"}]}],"links":[]};
}