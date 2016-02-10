(function() {
	'use strict';

	angular
		.module('merchantApp.insurance')
		.factory('notifyModal', notifyModal);

	notifyModal.$inject = ['$uibModal'];
	function notifyModal($uibModal) {
		return {
			open: openNotifyModal
		};

		function openNotifyModal() {
			var modalInstance = $uibModal.open({
				animation: true,
				templateUrl: 'App/Components/Insurance/Modal/notification.modal.html',
				controller: 'NotifyModalController',
				controllerAs: 'nmc'
			});

			return modalInstance.result.then(function(flag) {
				return flag;
			});
		}
	}
})();