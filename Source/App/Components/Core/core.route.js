(function(){
	"use strict";

	angular.module('merchantApp.core').config(config);

	function config($stateProvider, $urlRouterProvider){
		$urlRouterProvider.otherwise('/home');

			$stateProvider
				.state('main',{
					abstract:true,
					views:{
						'navbar':{
							templateUrl: 'App/Components/Core/navbar.html',
							controller:'NavbarController',
							controllerAs: 'nc'
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
								templateUrl:'App/Components/Core/home.html'
							}
						}
					})
					.state('main.about',{
					url: '/about',
						views:{
							'main@':{
								templateUrl:'App/Components/Core/about.html'
							}
						}
					});




	}


	


})();