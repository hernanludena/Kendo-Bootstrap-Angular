package cursos.rest.servicios;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

//Restful:
//Primero: el patron en el web.xml
//Segundo: los path
//Tercero:la accion /GET/
//Es decir Necesitamos url y una acción
@Path("/ServicioBienvenida")
public class Bienvenida {
	
	@Path("/saludo")
	//@GET
	@POST
	public String saludar(){  //?Valor=12
		return "Bienvenido Hernansito!!";
	}

}
/*
 * POST: http://localhost:8083/Rest_Introduccion/rest/ServicioBienvenida/saludo
 * 
 * 
 */