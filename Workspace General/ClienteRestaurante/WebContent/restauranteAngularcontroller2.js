  (function () {
      "use strict";
      var mod = angular.module("ModuloControllers", []);
      mod.controller("restauranteController", ["$scope", "$location", "serviceProvider","$routeParams",
        function ($scope, $location, serviceProvider,$routeParams) {
              $scope.restaurant1 = {};
              /* $scope.mostrar = "lista";*/
              $scope.categorias = [];

              $scope.restaurantes = [];


              $scope.restaurantes = [
                  {
                      codigo: 1,
                      nombre: "La Roma",
                      telefono: 2569632
            },
                  {
                      codigo: 2,
                      nombre: "La Tulpa",
                      telefono: 25333330
            },
                  {
                      codigo: 3,
                      nombre: "Argelia Restaurant",
                      telefono: 2965656
            },
                  {
                      codigo: 4,
                      nombre: "Como en Casa",
                      telefono: 25101011
            }
    ];
              $scope.recuperarTodos = function () {
                  var x = serviceProvider.recuperarTodos(); /*retorna una promesa*/
                  x.then(function (data) {
                      $scope.restaurantes = data;
                  }, function () {
                      alert("error al recuperar restaurantes");
                  });
              };

              $scope.recuperarCategorias = function () {
                  var x = serviceProvider.recuperarCategorias(); /*retorna una promesa*/
                  x.then(function (data) {
                      $scope.categorias = data;
                  }, function () {
                      alert("error al recuperar categorias");
                  });
              };

              $scope.insertar = function () {
                  if ($scope.restaurant1.codigo == null) {
                      var x = serviceProvider.insertar($scope.restaurant1); /*retorna una promesa*/
                      x.then(function (data) {
                          alert("Insertado");
                          $scope.recuperarTodos();
                          $scope.restaurant1 = {};
                          /*$scope.mostrar = "lista";*/
                          $location.path("/listar");
                      }, function () {
                          alert("error al insertar");
                          /*$scope.actualizar();*/
                      });
                  } else {
                      $scope.actualizar();
                  }
              };

              $scope.actualizar = function () {
                  var x = serviceProvider.actualizar($scope.restaurant1); /*retorna una promesa*/
                  x.then(function (data) {
                      alert("Actualizado");
                      $scope.recuperarTodos();
                      $scope.restaurant1 = {};
                      /* $scope.mostrar = "lista";*/
                      $location.path("/listar");
                  }, function () {
                      alert("error al actualizar");
                  });
              };


              $scope.mostrarNuevo = function () {
                  /* $scope.mostrar = "edicion";*/
                  $location.path("/editar");
                  /* $location.path("/editar/89");*/
              };

              $scope.cancelar = function () {
                  /* $scope.mostrar = "";*/
                  $location.path("/listar");
              };

              $scope.editar = function (rest) {
                  /* $scope.mostrar = "edicion";*/
                  $location.path("/editar");
                  document.getElementById("txtCodigo").value = rest.codigo;
                  document.getElementById("txtNombre").value = rest.nombre;
                  document.getElementById("txtTelefono").value = rest.telefono;

                  $scope.restaurant1.codigo = rest.codigo;
                  $scope.restaurant1.nombre = rest.nombre;
                  $scope.restaurant1.telefono = rest.telefono;

              };

             $scope.$on("$routeChangeSuccess",
                      function(){
                          if($location.path().indexOf("/editar/")==0){
                              console.log("Parametro 1 "+$routeParams.codigo);
                              console.log("Parametro 2 "+$routeParams.param2);
                              //recuperar parammetros
                            /*  $routeParams.idProducto;*/
                          }                              
                      }                          
      		);
              $scope.recuperarTodos();
              $scope.recuperarCategorias();


     }]);

  }());