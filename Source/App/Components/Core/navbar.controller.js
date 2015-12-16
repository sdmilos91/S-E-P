(function() {
	"use strict";
	
	angular
		.module('merchantApp.core')
		.controller('NavbarController', NavbarController);

	NavbarController.$inject = ['$translate', 'tmhDynamicLocale', 'crTranslations'];
	function NavbarController($translate, tmhDynamicLocale, crTranslations) {
		var nc = this;
		nc.currentLanguage = crTranslations[$translate.use()].LANGUAGE;
		nc.setLanguage = setLanguage;

		function setLanguage(language) {
			$translate.use(language);
			tmhDynamicLocale.set(language);
			nc.currentLanguage = crTranslations[language].LANGUAGE;
		}
	}
})();