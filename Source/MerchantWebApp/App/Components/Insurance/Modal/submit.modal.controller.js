(function(){

	angular.module('merchantApp.insurance').controller('SubmitModalController', SubmitModalController);

	SubmitModalController.$inject = ['$scope', '$uibModalInstance'];

	function SubmitModalController($scope, $uibModalInstance) {

		var smc = this;

	  smc.ok = function () {
	    $uibModalInstance.close(true);
	  };
        
      smc.cancel = function () {
	    $uibModalInstance.close(false);
	  };
        
	}

})();