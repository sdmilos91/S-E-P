(function() {
	"use strict";
	
	angular
		.module('merchantApp.core')
		.controller('NavbarController', NavbarController);

	NavbarController.$inject = ['$translate', 'tmhDynamicLocale', 'crTranslations', '$location'];
	function NavbarController($translate, tmhDynamicLocale, crTranslations, $location) {
		var nc = this;
		
		nc.isActive = function(path){
			return $location.path().indexOf(path) != -1;
		};
		nc.currentLanguage = crTranslations[$translate.use()].LANGUAGE;
		nc.setLanguage = setLanguage;

		function setLanguage(language) {
			$translate.use(language);
			tmhDynamicLocale.set(language);
			nc.currentLanguage = crTranslations[language].LANGUAGE;
		};

		
	}
})();