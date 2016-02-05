(function() {
	"use strict";
	
	angular
		.module('acquirerApp.core')
		.controller('HeaderController', HeaderController);

	HeaderController.$inject = ['$translate', 'tmhDynamicLocale', 'crTranslations'];
	function HeaderController($translate, tmhDynamicLocale, crTranslations) {
		var hc = this;
        hc.englishLan = false;
		hc.currentLanguage = crTranslations[$translate.use()].LANGUAGE;
        
		hc.setLanguage = setLanguage;
        
        if(hc.currentLanguage == 'en')
        {
           hc.englishLan = true;  
        }
        
		function setLanguage(language) {
            var lng = 'sr-latn';
            if(typeof language == 'undefined' && hc.englishLan){
                lng = 'en';
            }else{
                if(language == 'en'){
                    lng = 'en';
                    hc.englishLan = true;
                }else{
                    hc.englishLan = false;
                }
            }
			$translate.use(lng);
			tmhDynamicLocale.set(lng);
			hc.currentLanguage = crTranslations[lng].LANGUAGE;
		};
		
	}
})();