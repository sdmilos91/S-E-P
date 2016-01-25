(function() {
	"use strict";
	
	angular
		.module('acquirerApp.core')
		.controller('FormController', FormController);

	FormController.$inject = ['$scope'];
	function FormController($scope) {
        
        var fc = this;
        
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
	}
    
})();

