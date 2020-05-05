package cursojpa.facturacion.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.servicios.ClienteServicio;


@Path("/clientes")
@Stateless
public class ClienteRest {

	
	@EJB
	private ClienteServicio servicio;
	
	@PUT
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Cliente buscar(ConsultaCedula consulta){
		return servicio.buscarPorCedula(consulta.getCedula());
	}
}
