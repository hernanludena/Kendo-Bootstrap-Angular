 (function () {
     "use strict";
     var traduccionesES = {
         Ingrese: 'Ingrese el código',
         Codigo: 'Codigo:',
         Nombre: 'Nombre:',
         Precio: 'Precio:',
         Cantidad: 'Cantidad:'

     };
     var traduccionesEN = {
         Ingrese: 'Insert the code',
         Codigo: 'Code:',
         Nombre: 'Name:',
         Precio: 'Price:',
         Cantidad: 'Amount:'
     };
     var mod = angular.module("FacturaApp", ["FacturaApp.controllers", "FacturaApp.services", , "pascalprecht.translate",'kendo.directives']);
     
     mod.config(function ($translateProvider) { 
         $translateProvider.translations('en', traduccionesEN);
         $translateProvider.translations('es', traduccionesES);

         $translateProvider.preferredLanguage('en');
     });

 }());