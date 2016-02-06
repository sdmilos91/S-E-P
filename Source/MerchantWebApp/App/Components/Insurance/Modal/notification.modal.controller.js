(function(){

	angular.module('merchantApp.insurance').controller('NotifyModalController', NotifyModalController);

	NotifyModalController.$inject = ['$scope', '$uibModalInstance'];

	function NotifyModalController($scope, $uibModalInstance) {

		var nmc = this;

	  nmc.ok = function () {
	    $uibModalInstance.dismiss();
	  };
        
	}

})();