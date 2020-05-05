  (function () {
      "use strict";
      var mod = angular.module("ModuloApp",["ModuloControllers","ModuloServices","ngRoute"]);  
      
       mod.config(function ($routeProvider) {
                 /* $routeProvider.when("/editar", {templateUrl: 'edicionRestaurante.html'});*/
                  $routeProvider.when("/editar/:codigo/:param2",{templateUrl: 'edicionRestaurante.html'});
                  $routeProvider.when("/listar", {templateUrl: 'listaRestaurante.html'});
                  $routeProvider.otherwise({redirectTo: "/listar"});
          });

  }());


/*


when("/editar/:idProducto")
/editar/80
$routeParams.idProducto


:param2"
*/