(function () {
    'use strict';
    var mod = angular.module('FacturaApp.services', []);

    mod.service("serviceProvider",
         function ($http, $q) {
             //Consultar
             this.buscarPorCedula = function (cliente) {
                 var dif = $q.defer();
                 $http.put("http://localhost:8080/JPA_Factura/rest/clientes/buscar",cliente).success(
                     function (data, status) {
                         console.log(status);                        
                         dif.resolve(data);
                     }).error(
                     function (status) {
                         console.log(status);                         
                         dif.reject();
                     }
                 );
                 return dif.promise;
             },
             this.buscarPorCodigo = function (producto) {
                 var dif = $q.defer();
                 $http.put("http://localhost:8080/JPA_Factura/rest/productos/buscar",producto).success(
                     function (data, status) {
                         console.log(status);                        
                         dif.resolve(data);
                     }).error(
                     function (status) {
                         console.log(status);                         
                         dif.reject();
                     }
                 );
                 return dif.promise;
             },
             this.guardarFactura = function (facturaDTO) {
                 var dif = $q.defer();
                 $http.post("http://localhost:8080/JPA_Factura/rest/serviciofactura/insertar",facturaDTO).success(
                     function (data, status) {
                         console.log(status);                        
                         dif.resolve(data);
                     }).error(
                     function (status) {
                         console.log(status);                         
                         dif.reject();
                     }
                 );
                 return dif.promise;
             }             
           
            

         })
    
    
    
    
    mod.service("servicioProductos", [

        function () {
            this.consultarProducto = function (codigoProducto) {
                var producto = {};
                if (codigoProducto === 1) {
                    producto = {
                        codigo: 1,
                        nombre: "Doritos",
                        precioVenta: 0.50,
                        categoria: {
                            id: 100,
                            nombre: "snacks"
                        }
                    };
                } else {
                    producto = {
                        codigo: 2,
                        nombre: "Sanduches",
                        precioVenta: 1.50,
                        categoria: {
                            id: 100,
                            nombre: "snacks"
                        }
                    };
                }
                return producto;
            };
        }]);



    mod.service("servicioClientes", [

        function () {
            this.consultarClientePorCedula = function (cedulaCliente) {
                var cliente = {};
                if (cedulaCliente === "1104011786") {
                    cliente = {
                        cedula: "1104011786",
                        nombre: "Hernan",
                        apellido: "Ludena",
                        telefono: "0997742400",
                        direccion: "UIO"
                    };
                } else {
                    cliente = {
                        cedula: "1234567890",
                        nombre: "Santiago",
                        apellido: "Mosquera",
                        telefono: "0982100187",
                        direccion: "UIO"
                    };
                }
                return cliente;
            };
        
     /*  function ($http, $q) { 
      this.consultarClientePorCedula = function (cliente) {
                 var dif = $q.defer();
                 $http.put("http://localhost:8080/JPA_Factura/rest/clientes/buscar",cliente).success(
                     function (data, status) {
                         console.log(status);                        
                         dif.resolve(data);
                     }).error(
                     function (status) {
                         console.log(status);                         
                         dif.reject();
                     }
                 );
                 return dif.promise;
             }*/
       
        }]);

    mod.provider("servicioFactura",
        function () {
            return {
                $get: function ($http, $q) {
                    return {
                        insertar: function (factura) {
                            /*$var d = $q.defer();
                            http.post("http://localhost:8080/JPA_Factura/rest/serviciofactura/insertar", factura).success(
                                function (data, status) {
                                    console.log("Success con status: " + status);
                                    d.resolve(data);
                                }
                            ).error(function (data, status) {
                                console.log("Error con status: " + status);
                                d.reject();
                            });
							
                            return d.promise;*/
                             var dif = $q.defer();
                            $http.post("http://localhost:8080/JPA_Factura/rest/serviciofactura/insertar", factura).success(
                                function (data, status) {
                                    console.log(status);
                                    dif.resolve(data);
                                }).error(
                                function (status) {
                                    console.log(status);
                                    dif.reject();
                                }
                            );
                            return dif.promise;
                        },
                    };
                }
            };
        });

})();