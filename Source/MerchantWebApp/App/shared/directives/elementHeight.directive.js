(function(){
angular.module('merchantApp.shared').directive('banner', banner);


function banner() {
    return function (scope, element, attrs) {
        element.css('min-height', $(window).height() + 'px');
    	}
	};
})();