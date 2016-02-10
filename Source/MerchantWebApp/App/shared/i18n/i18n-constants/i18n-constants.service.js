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
                "SELECTED_SPORTS": "Selected sports",
				"AGE": "Age",
				"AMOUNT": "Amount",
				"STEP3_TITLE": "Confirmation of purchase",
				"CONFIRM_MESSAGE": "Do you want to confirm the purchase of insurance?",
				"AMOUNT_MESSAGE": "Total amount:",
				"NEXT_BTN": "Next",
				"PREV_BTN": "Previous",
				"SUBMIT_BTN": "Submit",
				"EMAIL": "Email",
                "CAR_FLAT_TITLE": "You can choose FLAT insurance and CAR insurance",
                "CONTRACTOR" : "This person is contractor. Please enter contractor email.",
                "CONTRACTOR_TITLE" : "CONTRACTOR"

			},
            
            "ERROR_MSGS": {
                "REQUIRED_MSG" : "This field is required!",
                "NUMBER_ERR": "This field must be a number!",
                "MIN_NUMBER_ERR": "Minimum value of this filed is ",
                "NAME_REQ" : "Name is required!",
                "LASTNAME_REQ" : "Lastname is required!",
                "PASSPORT_NUM_REQ" : "Passport number is required!",
                "CITIZEN_ID_REQ" : "Citizen ID is required!",
                "ADDRESS_REQ" : "Address is required!",
                "PHONE_REQ" : "Phone is required!",
                "EMAIL_REQ" : "Email address is required!",
                "CITIZEN_ID_13" : "Citizen ID value must have 13 digits!",
                "EMAIL_FORMAT": "Bad email address format!"
                
            },
            
            "MESSAGESS" : {
                "SUCCESS_MSG": "Insurance is successfully purchased. Thank you for using services.",
                "ERROR_MSG": "An error occurred while processing transactions",
                "TRY_AGAIN_MSG": "Please try again to buy an insurance"
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
				"CONTACTS": "Kontakt",
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
                "SELECTED_SPORTS": "Izabrani sportovi",
				"AGE": "Broj godina",
				"AMOUNT": "Iznos",
				"STEP3_TITLE": "Potvrda kupovine",
				"CONFIRM_MESSAGE": "Da li želite da potvrfite kupovinu osiguranja?",
				"AMOUNT_MESSAGE": "Ukupan iznos:",
				"NEXT_BTN": "Sledeći",
				"PREV_BTN": "Prethodni",
				"SUBMIT_BTN": "Potvrdi",
				"EMAIL": "Email",
                "CAR_FLAT_TITLE": "Pored putničkog možete izabrati osiguranje stana i osiguranje automobila",
                "CONTRACTOR" : "Ova osoba je ugovarač. Molimo Vas unesite njegovu email adresu.",
                "CONTRACTOR_TITLE" : "Ugovarač"

			},
            
            "ERROR_MSGS": {
                "REQUIRED_MSG" : "Morate popuniti ovo polje!",
                "NUMBER_ERR": "Vrednost ovog polja mora biti ceo broj!",
                "MIN_NUMBER_ERR": "Vrednost ovog polja ne sme biti manja od ",
                "NAME_REQ" : "Obavezno je uneti ime!",
                "LASTNAME_REQ" : "Obavezno je uneti prezime!",
                "PASSPORT_NUM_REQ" : "Obavezno je uneti broj pasoša!",
                "CITIZEN_ID_REQ" : "Obavezno je uneti JMBG!",
                "ADDRESS_REQ" : "Obavezno je uneti adresu!",
                "PHONE_REQ" : "Obavezno je uneti telefon!",
                "EMAIL_REQ" : "Obavezno je uneti email adresu!",
                "CITIZEN_ID_13" : "JMBG mora imati 13 cifara!",
                "EMAIL_FORMAT": "Loš format email adrese!"
                
            },
            
            
            "MESSAGESS" : {
                "SUCCESS_MSG": "Osiguranje je uspešno kupljeno. Hvala Vam što ste koristili naše usluge.",
                "ERROR_MSG": "Došlo je do greške prilikom obrade transkacije.",
                "TRY_AGAIN_MSG": "Pokušajte ponovo sa kupovinom"
            },


			"JEZIK": "Srpski"
		},
	};

	angular
		.module('merchantApp.i18n.constants')
		.constant("crTranslations", crTranslations);
})();