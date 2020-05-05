(function () {
    'use strict';

    var mod = angular.module('FacturaApp.controllers', []);

    mod.controller("FacturaController", ["$scope", "servicioClientes","servicioProductos","servicioFactura","$translate","serviceProvider",
        function ($scope, servicioClientes,servicioProductos,servicioFactura,$translate,serviceProvider) {
            $scope.codigoProducto = 0;
            $scope.factura = {};
            $scope.cliente = {};
            $scope.detalles = [];
            $scope.producto = {};
            $scope.cedulaBuscada = "";
            $scope.productoBuscado = "";
            $scope.total = 0;
            $scope.numFactura =0;
            $scope.detalleFac = [];
            $scope.insertarFactura = function (factura) {
                /*servicioFactura.insertar(factura).then(function () {
                    console.log("Se inserto la Factura");
                }, function () {
                    console.log("No se inserto la factura");
                });*/
            };

            $scope.consultarCliente = function () {
              /*  $scope.clienteC = servicioClientes.consultarClientePorCedula($scope.cedulaBuscada);

                if ($scope.clienteC.nombre == undefined) 
                {
                        alert("No existe Cliente");
                        
                } else {
                    $scope.cliente.cedula = $scope.clienteC.cedula;
                    $scope.cliente.nombre = $scope.clienteC.nombre;
                    $scope.cliente.apellido = $scope.clienteC.apellido;
                    $scope.cliente.telefono = $scope.clienteC.telefono;
                    $scope.cliente.direccion = $scope.clienteC.direccion;
                }   */
                 $scope.cliente = {
          				 cedula: $scope.cedulaBuscada	         
          		  };
                var x = serviceProvider.buscarPorCedula($scope.cliente); /*retorna una promesa*/
                  x.then(function (clienteC) { 
                	  
                		 $scope.cliente.cedula = clienteC.cedula;
                    $scope.cliente.nombre = clienteC.nombre;
                    $scope.cliente.apellido = clienteC.apellido;
                    $scope.cliente.telefono = clienteC.telefono;
                    $scope.cliente.direccion = clienteC.direccion;			
          			
                  }, function () {
                      alert("No existe Cliente");
                  });                
                
               
            };
            
           /* $scope.consultarProducto = function () {
                $scope.productoC = servicioProductos.consultarProducto($scope.productoBuscado);

                if ($scope.productoC.nombre == undefined) 
                {
                        alert("No existe Producto");
                        
                } else {
                    $scope.producto.codigo = $scope.productoC.codigo;
                    $scope.producto.nombre = $scope.productoC.nombre;
                    $scope.producto.precio = $scope.productoC.precioVenta;
                                        
                }                
            };*/
            
            $scope.consultarProducto = function () {
            	  $scope.producto = {
         				 codigo: $scope.productoBuscado	         
         		 };
                  var x = serviceProvider.buscarPorCodigo($scope.producto); /*retorna una promesa*/
                  x.then(function (data) {   
                	  
                      $scope.producto.codigo = data.codigo;
                      $scope.producto.nombre = data.nombre;
                      $scope.producto.precio = data.precioVenta;                	  
                	
          			
                  }, function () {
                      alert("No existe Producto");
                  });
              };
            
            
            $scope.agregar = function () {
                $scope.d1 = {
                            codigoProducto:$scope.producto.codigo,
            			    nombreProducto: $scope.producto.nombre,
            				precioProducto: $scope.producto.precio,
            				cantidad:  $scope.producto.cantidad,
            				subtotal:  ($scope.producto.precio * $scope.producto.cantidad)
          		     };
            	  $scope.detalles.push($scope.d1);
                
                  $scope.total +=  $scope.d1.subtotal;
                
                
                   
            };
            
            $scope.eliminar = function (indice) {               
            	  $scope.detalles.splice(indice,1);
                   
            };
            
             $scope.guardarFactura = function () {                 
                 for(var i=0;i<$scope.detalles.length;i++){
                      $scope.det = {
          				idProducto: $scope.detalles[i].codigoProducto,
          				cantidad:  $scope.detalles[i].cantidad
                      };
                      $scope.detalleFac.push($scope.det);
          		 };                
                 
            	 $scope.facturaDTO = {
         				 codigo: $scope.numFactura,
         				 cedula: $scope.cliente.cedula,
         				 detalles:$scope.detalleFac,
                         fecha: $scope.fecha
         				 
         		 };   
                 
                  var x = servicioFactura.insertar($scope.facturaDTO); /*retorna una promesa*/
                  x.then(function (data) {                      
                	  alert("Factura Guardada");     			
          			
                  }, function () {
                      alert("Error al Guardar factura");
                  });
                 
                   
            };
            
                $scope.cambiarLenguaje = function () {               
            	   $translate.use("es");
                };            
           
            $scope.mostrarTotal = "true";
              $scope.ocultar = function () {               
            	   if($scope.check==true){                       
                       $scope.mostrarTotal = true;                       
                   }else{
                       $scope.mostrarTotal = false;                       
                   }
                };


        }




    ]);

})();