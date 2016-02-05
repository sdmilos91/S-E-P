(function() {
	"use strict";
	
	var crTranslations = {
		"en": {
			"COMMON": {
				"TITLE" : "Online paymnet",
                "TEAM":"Kodzo team 2015",

			},
			"MAIN": {
				"T1":"Payment confirmation",
				"T2" : "If you want to confirm payment please fill the form and choose 'Submit' option."
			},

			"FORM": {
				"ENTER_PAN":"Enter PAN",
				"ENTER_SECURITY_CODE": "Enter security code",
				"CARD_HOLDER_NAME": "Card holder name",
				"CARD_VALID_DATE": "Card valid thru",
				"REQUIRED_FILED": "Required field",
				"CONFIRM": "Confirm",
				"CANCEL":"Cancel",
				"WELCOME_TITLE": "Welcome",
				"WELCOME_MSG": "Transaction amount is ",
				"PAN_REQ_MSG": "PAN is required!",
				"SECURITY_CODE_REQ_MSG": "Security code is required!",
				"HOLDER_NAME_REQ_MSG": "Card holder name is required!",
                "CARD_VALID_REQ_MSG": "Date is required!",

			},



			"LANGUAGE": "en"
		},




		"sr-latn": {
			"COMMON": {
				"TITLE" : "Onlajn plaćanje",
                "TEAM":"Kodzo team 2015",

			},
			"MAIN": {
				"T1":"Potvrda plaćanja",
				"T2" : "Ukoliko želite da potvrdite plaćanje popunite formu izaberite opciju 'Potvrdi'"
			},

			"FORM": {
				"ENTER_PAN":"Unesite PAN",
				"ENTER_SECURITY_CODE": "Unesite zaštitni kod",
				"CARD_HOLDER_NAME": "Naziv vlasnika kartice",
				"CARD_VALID_DATE": "Datum važenja kartice",
				"REQUIRED_FILED": "Obavezno polje",
				"CONFIRM": "Potvrdi",
				"CANCEL":"Otkaži",
				"WELCOME_TITLE": "Dobrodošli",
				"WELCOME_MSG": "Iznos transakcije je ",
				"PAN_REQ_MSG": "Neophodno je uneti PAN!",
				"SECURITY_CODE_REQ_MSG": "Neophodno je uneti zaštitni kod!",
				"HOLDER_NAME_REQ_MSG": "Neophodno je uneti naziv vlasnika kartice!",
                "CARD_VALID_REQ_MSG": "Neophodno je uneti datum važenja kartice!",

			},


			"LANGUAGE": "rs"
		},
	};

	angular
		.module('acquirerApp.i18n.constants')
		.constant("crTranslations", crTranslations);
})();