var productos = [];
var detalle = [];

function buscarPorCedula() { 	
	var accion = "PUT";	
	var url = "http://localhost:8080/JPA_Factura/rest/clientes/buscar";
	
	
	 var cliente = {
			 cedula: document.getElementById('cedulaBusqueda').value	         
	 };
	  
	  
	invocarRest(accion,url,cliente,function(listaR){		
				
		document.getElementById('cedula').value = listaR.codigo;
		document.getElementById('nombre').value = listaR.cedula;
		document.getElementById('apellido').value = listaR.apellido;
		document.getElementById('direccion').value = listaR.direccion;
		document.getElementById('telefono').value = listaR.telefono;
		
		 
	});
	
}


function buscarPorCodigo() { 	
	var accion = "PUT";	
	var url = "http://localhost:8080/JPA_Factura/rest/productos/buscar";
	
	
	 var producto = {
			 codigo: document.getElementById('codigoBusqueda').value	         
	 };
	  
	  
	invocarRest(accion,url,producto,function(listaR){		
				
		document.getElementById('codigo').value = listaR.codigo;
		document.getElementById('nombreP').value = listaR.nombre;
		document.getElementById('precio').value = listaR.precioVenta;
		document.getElementById('categoria').value = listaR.categoria.nombre;		
	});
	
}

function agregarProducto(){
	var p1 = {
			codigo: document.getElementById('codigo').value,
			nombre: document.getElementById('nombreP').value,
			precio: document.getElementById('precio').value,
			categoria: document.getElementById('categoria').value,
			cantidad: document.getElementById('cantidad').value
	     };
	
	productos.push(p1);
	
	
	
	var det = {
			idProducto: document.getElementById('codigo').value,
			cantidad:  document.getElementById('cantidad').value
	};
	detalle.push(det);
	
	dibujarTabla();
}


function dibujarTabla() {

    var table = document.getElementById("listaProductos");  
    table.innerHTML="";
    //Creación de filas
    //  table.appendChild(document.createElement('tbody'));
    for (var j = 0; j < productos.length; j++) {
        //  var row2 = table.tBodies[0].insertRow(-1);
        var row1 = table.insertRow(j); //j
        var cell1 = row1.insertCell(0);
        var cell2 = row1.insertCell(1);
        var cell3 = row1.insertCell(2);
        var cell4 = row1.insertCell(3);
        var cell5 = row1.insertCell(4);
       
        
       cell1.innerHTML = productos[j].codigo;
       cell2.innerHTML = productos[j].nombre;
       cell3.innerHTML = productos[j].precio;
       cell4.innerHTML = productos[j].categoria;
       cell5.innerHTML = productos[j].cantidad;     
        
    }


    var header = table.createTHead();
    
    var row2 = header.insertRow(0);
    row2.innerHTML = "<b>PRODUCTOS</b>";
    row2.style.textAlign = 'right';
    
    var row3 = header.insertRow(1);
    var cell = row3.insertCell(0);
    cell.innerHTML = "<b>CODIGO</b>";
    
    var cell2 = row3.insertCell(1);
    cell2.innerHTML = "<b>NOMBRE</b>";
    
     var cell3 = row3.insertCell(2);
    cell3.innerHTML = "<b>PRECIO</b>";
    
     var cell4 = row3.insertCell(3);
    cell4.innerHTML = "<b>CATEGORIA</b>";
    
    var cell5 = row3.insertCell(4);
    cell5.innerHTML = "<b>CANTIDAD</b>";    
    
}

function guardarFactura() {
	var accion = "POST";	
	var url = "http://localhost:8080/JPA_Factura/rest/serviciofactura/insertar";
	
	
	 var facturaDTO = {
			 codigo: document.getElementById('numFactura').value,
			 cedula: document.getElementById('cedulaBusqueda').value,
			 detalles:detalle
			 
	 };
	  
	  
	invocarRest(accion,url,facturaDTO);
}





/*function buscarRestaurante(){ 
	
	 var restaurante = {
				codigo: document.p.codigo.value		         
	 };
	  var request = new XMLHttpRequest();    
	  request.open(
	      "POST","http://localhost:8080/ProyectoRestaurante/rest/restauranteService/consultar",
	      true); 
	  var cadenaJson = JSON.stringify(restaurante);	
	  request.setRequestHeader("Content-Type", "application/json");	
	  request.send(cadenaJson);
	  
	  request.onreadystatechange = function(){  //llama a este metodo cada vez que cambia de estado
		  if(request.readyState == 4){ //El 4 es porque termino de responder
			  var respuesta = request.responseText;	
			  var listaRest = JSON.parse(respuesta);  //array de objetos			  
			  
			  if(request.status == 200){
					document.p.codigoC.value = listaRest.codigo;
					document.p.nombre.value = listaRest.nombre;
					document.p.telefono.value = listaRest.telefono;
			  }else{				  
				  console.log(respuesta + " " + request.status + " : " + request.statusText);
			  }
				
			 
		  }
	  	};  	  	
	  
	}
*/

