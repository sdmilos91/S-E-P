(function(){
	"use strict";

	angular.module('acquirerApp.core').config(config);

	function config($stateProvider, $urlRouterProvider){
		$urlRouterProvider.otherwise('/home');

			$stateProvider
				.state('main',{
					abstract:true,
					views:{
						'header':{
							templateUrl: 'App/Components/Core/header.html',
                            controller: 'HeaderController',
                            controllerAs: 'hc'
						},
						'footer':{
							templateUrl: 'App/Components/Core/footer.html'
						}

					}
					})

					.state('main.home',{
					url: '/home',
						views:{
							'main@':{
								templateUrl:'App/Components/Core/form.html',
                                controller:'FormController',
							    controllerAs: 'fc'
							}
						}
					});




	}


	


})();