(function() {
	'use strict';

	angular
		.module('merchantApp.insurance')
		.factory('submitModal', submitModal);

	submitModal.$inject = ['$uibModal'];
	function submitModal($uibModal) {
		return {
			open: openSubmitModal
		};

		function openSubmitModal() {
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: 'App/Components/Insurance/Modal/submit.modal.html',
				controller: 'SubmitModalController',
				controllerAs: 'smc'
			});

			return modalInstance.result.then(function(flag) {
				return flag;
			});
		}
	}
})();