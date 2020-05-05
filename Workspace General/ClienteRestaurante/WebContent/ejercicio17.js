function buscarRestaurante() { 	
	var accion = "POST";	
	var url = "http://localhost:8080/ProyectoRestaurante/rest/restauranteService/consultar";
	
	
	 var restaurante = {
				codigo: document.p.codigo.value		         
	 };
	  
	  
	invocarRest(accion,url,restaurante,function(listaR){		
				
			document.p.codigoC.value = listaR.codigo;
			document.p.nombre.value = listaR.nombre;
			document.p.telefono.value = listaR.telefono;
		 
	});
	
}




function heredar(hija,padre){	
		hija.prototype = new padre();  
		hija.prototype.constructor = hija; //.prototype.constructor;
}


function test1(){ 
    heredar(Jugador,Persona);
    var j = new Jugador;
}
function Persona(){ 
    
}
function Jugador(){ 
    
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

