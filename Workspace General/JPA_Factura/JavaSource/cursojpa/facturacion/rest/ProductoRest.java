package cursojpa.facturacion.rest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.servicios.ProductoServicio;


@Path("/productos")
@Stateless
public class ProductoRest {

	@EJB
	private ProductoServicio servicio;
	
	@PUT
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Producto buscar(ConsultaCodigo consulta){
		return servicio.buscarPorId(consulta.getCodigo());
	}
}
