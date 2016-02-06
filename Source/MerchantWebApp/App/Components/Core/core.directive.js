(function(){
	angular.module('merchantApp.core').directive('banner', banner);

	Banner.$inject = ['scope', 'element', 'attrs']; 

	function banner() {
	    return function (scope, element, attrs) {
	        element.height($(window).height() - $('.header').outerHeight());
	    	}
	};
})();
