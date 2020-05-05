package cursos.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cursos.rest.dto.Resultado;
import cursos.rest.dto.Suma;

@Path(value = "/convertidor")
public class Convertidor {
	@GET
	@Path(value = "/convertidorEaD")
	public double convertidorEurosDolares(@QueryParam(value="valor") double euros){
		return euros * 1.3378;
	}
	
	@GET
	@POST	
	@Path(value = "/suma")
	@Produces("application/json")  //MediaType.APPLICATION_JSON
	@Consumes("application/xml")  //MediaType.APPLICATION_XML)
	public double sumar(@QueryParam(value="valor1") double valor1,@QueryParam(value="valor2") double valor2){
		return valor1+valor2;
	}
	/*
	 * POST: http://localhost:8083/Rest_Introduccion/rest/convertidor/suma?valor1=12.6&valor2=2.4
	 */
	
	
	@POST	
	@Path(value = "/sumajson")
	@Produces("application/json")  //MediaType.APPLICATION_JSON
	@Consumes("application/json")  //MediaType.APPLICATION_XML)
	public Resultado sumarJson(Suma suma){
		Resultado r = new Resultado();
		r.setResultado(suma.getValor1() + suma.getValor2()); 		
		return r;
	}
	/**
	 * POST: http://localhost:8083/Rest_Introduccion/rest/convertidor/sumajson
	 *  {"valor1":2,"valor2":3}
	 *  
	 *  salida: {"resultado":5.0}
	 */

}
