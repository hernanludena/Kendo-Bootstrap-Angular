package curso.restaurantes.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import curso.restaurantes.entidades.Categoria;
import curso.restaurantes.servicios.CategoriasServicios;


@Stateless
@Path("/categorias")
public class CategoriaRest {
	
	@EJB
	private CategoriasServicios serviciosCategoria;

	@Produces("application/json")
	@Path("recuperar")
	@GET
	public Response recuperar(){
		List<Categoria> categorias=serviciosCategoria.recuperar();
		return Response.ok().entity(categorias).build();
	}
}
