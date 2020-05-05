var app = angular.module("modulo1", []);
app.controller(
    "restauranteController", function ($scope, $http) {
        $scope.restaurant1  ={}; 
        
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

      //Consultar
         $scope.recuperarTodos = function (){
            $http.get("http://localhost:8080/ProyectoRestaurante/rest/restauranteService/recuperarTodos").success(
                function(data,status){
                    console.log(status);
                    $scope.restaurantes = data;
                }).error(
        		 function(status){
                     console.log(status);
                     alert("horror");
                 }        		 
         );
        };
         
        
         //Insertar
         $scope.insertar = function (){
            $http.put("http://localhost:8080/ProyectoRestaurante/rest/restauranteService/insertar",$scope.restaurant1).success(
                function(data,status){
                    console.log(status); 
                    $scope.recuperarTodos();
                    $scope.restaurant1={};
                }).error(
        		 function(status){
                     console.log(status);
                     alert("horror");
                 }        		 
         );
        };        

         $scope.recuperarTodos();


    });