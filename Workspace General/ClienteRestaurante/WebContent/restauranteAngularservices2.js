 (function () {
     "use strict";
     var mod = angular.module("ModuloServices", []);

     mod.service("serviceProvider",
         function ($http, $q) {
             //Consultar
             this.recuperarTodos = function () {
                 var dif = $q.defer();
                 $http.get("http://localhost:8080/ProyectoRestaurante/rest/restauranteService/recuperarTodos").success(
                     function (data, status) {
                         console.log(status);
                         /*$scope.restaurantes = data;*/  /*el scope ahora lo manejamos en el controller  */
                         dif.resolve(data);
                     }).error(
                     function (status) {
                         console.log(status);
                         /* alert("horror");*/
                         dif.reject();
                     }
                 );
                 return dif.promise;
             },

             //ConsultarCategorias
             this.recuperarCategorias = function () {
                 var dif = $q.defer();
                 $http.get("http://localhost:8080/ProyectoRestaurante/rest/categorias/recuperar").success(
                     function (data, status) {
                         console.log(status);
                         /*$scope.categorias = data;*/
                         dif.resolve(data);
                     }).error(
                     function (status) {
                         console.log(status);
                        /* alert("horror");*/
                         dif.reject();
                     }
                 );
                  return dif.promise;
             },

             //Insertar
             this.insertar = function (restaurant1) {
                 var dif = $q.defer();
                 $http.put("http://localhost:8080/ProyectoRestaurante/rest/restauranteService/insertar",restaurant1).success(
                     function (data, status) {
                         console.log(status);
                         /* alert("Insertado");
                        $scope.recuperarTodos();
                         $scope.restaurant1 = {};
                         $scope.mostrar = "lista";*/
                         dif.resolve();
                     }).error(
                     function (status) {
                         console.log(status);
                       /*  alert("error al insertar");
                         $scope.actualizar();*/
                         dif.reject();

                     }
                 );
                 return dif.promise;
             },


             //Update
             this.actualizar = function (restaurant1) {
                 var dif = $q.defer();
                 $http.post("http://localhost:8080/ProyectoRestaurante/rest/restauranteService/actualizar", restaurant1).success(
                     function (data, status) {
                         console.log(status);
                       /* alert("Actualizado");
                         $scope.recuperarTodos();
                         $scope.restaurant1 = {};
                         $scope.mostrar = "lista";*/
                         dif.resolve();
                     }).error(
                     function (status) {
                         console.log(status);
                       /*  alert("error al actualizar");*/
                          dif.reject();
                     }
                 );
                 return dif.promise;
             }
         }

     )

 }());