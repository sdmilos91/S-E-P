(function() {
	"use strict";
	
	var crTranslations = {
		"en": {
			"COMMON": {
				"HOME":"Home",
				"ABOUT" : "About",
				"OFFER" : "Offer",
				"TITLE" : "Insurance sale site"
			},
			"MAIN": {
				"T1":"Buy our insurance",
				"T2" : "We offer the best insurance",
				"T3" : "Learn more"
			},

			"ABOUT": {
				"TEAM":"Team Kodzo",
				"MESSAGE" : "Meesage!",
			},

			"OFFER": {
				"TITLE":"Your offer:",
			},



			"JEZIK": "English"
		},




		"sr-latn": {
			"COMMON": {
				"HOME":"Početna",
				"ABOUT" : "O nama",
				"OFFER" : "Ponuda",
				"TITLE" : "Sajt za prodaju osiguranja"
			
			},
			"MAIN": {
				"T1":"Kupite osiguranje kod nas",
				"T2" : "Nudimo vam najpovoljnije osiguranje",
				"T3" : "Saznajte više"
			},

			"ABOUT": {
				"TEAM":"Tim Kodzo",
				"MESSAGE" : "Poruka!",
			},

			"OFFER": {
				"TITLE":"Vaša ponuda:",
			},


			"JEZIK": "Srpski"
		},
	};

	angular
		.module('merchantApp.i18n.constants')
		.constant("crTranslations", crTranslations);
})();