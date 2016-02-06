(function() {
	"use strict";
	
	var crTranslations = {
		"en": {
			"COMMON": {
				"HOME":"Home",
				"ABOUT" : "About",
				"OFFER" : "Offer",
				"TITLE" : "Insurance sale site",
				"SOCIALS": "Socials",
				"CONTACTS": "Contacts",
				"LINKS": "Links",
				"OUR_TEAM": "Our team",

			},
			"MAIN": {
				"T1":"Buy our insurance",
				"T2" : "We offer the best insurance",
				"WELCOME" : "Welcome"
			},

			"ABOUT": {
				"TEAM":"Team Kodzo",
				"MESSAGE" : "Meesage!",
			},

			"OFFER": {
				"PRICE":"Price:",
				"SEPT1_TITLE": "FILL OUT THE FORM FOR THE PURCHASE OF INSURANCE",
				"FIRST_STEP": "First step",
				"REGION": "Region",
				"INSURANCE_DURATION": "Duration",
				"NUMBER_OF_PEOPLE": "Number of people",
				"PERSON":"Person",
				"PEOPLE_INFORMATION": "Information about customers",
				"NAME": "Name",
				"LASTNAME": "Lastname",
				"PASSPORT_NUMBER": "Passport number",
				"CITIZEN_ID": "Citizen ID",
				"ADDRESS": "Address",
				"PHONE_NUMBER": "Phone number",
				"SPORT": "Sport",
				"AGE": "Age",
				"AMOUNT": "Amount",
				"STEP3_TITLE": "Confirmation of purchase",
				"CONFIRM_MESSAGE": "Do you want to confirm the purchase of insurance?",
				"AMOUNT_MESSAGE": "Total amount:",
				"NEXT_BTN": "Next",
				"PREV_BTN": "Previous",
				"SUBMIT_BTN": "Submit",
				"EMAIL": "Email"

			},



			"JEZIK": "English"
		},




		"sr-latn": {
			"COMMON": {
				"HOME":"Početna",
				"ABOUT" : "O nama",
				"OFFER" : "Ponuda",
				"TITLE" : "Sajt za prodaju osiguranja",
				"SOCIALS": "Društvene mreže",
				"CONTACT": "Kontakt",
				"LINKS": "Linkovi",
				"OUR_TEAM": "Naš tim",
				
			
			},
			"MAIN": {
				"T1":"Kupite osiguranje kod nas",
				"T2" : "Nudimo vam najpovoljnije osiguranje",
				"WELCOME" : "Dobrodošli"
			},

			"ABOUT": {
				"TEAM":"Tim Kodzo",
				"MESSAGE" : "Poruka!",
			},

			"OFFER": {
				"SEPT1_TITLE": "POPUNITE OBRAZAC ZA KUPOVINU OSIGURANJA",
				"FIRST_STEP": "Prvi korak",
				"REGION": "Region",
				"INSURANCE_DURATION": "Trajanje osiguranja",
				"NUMBER_OF_PEOPLE": "Broj osoba",
				"PERSON":"Osoba",
				"PEOPLE_INFORMATION": "Informacije o osiguranicima",
				"NAME": "Ime",
				"LASTNAME": "Prezime",
				"PASSPORT_NUMBER": "Broj pasoša",
				"CITIZEN_ID": "JMBG",
				"ADDRESS": "Adresa",
				"PHONE_NUMBER": "Broj telefona",
				"SPORT": "Sport",
				"AGE": "Broj godina",
				"AMOUNT": "Iznos",
				"STEP3_TITLE": "Potvrda kupovine",
				"CONFIRM_MESSAGE": "Da li želite da potvrfite kupovinu osiguranja?",
				"AMOUNT_MESSAGE": "Ukupan iznos:",
				"NEXT_BTN": "Sledeći",
				"PREV_BTN": "Prethodni",
				"SUBMIT_BTN": "Potvrdi",
				"EMAIL": "Email"

			},


			"JEZIK": "Srpski"
		},
	};

	angular
		.module('merchantApp.i18n.constants')
		.constant("crTranslations", crTranslations);
})();