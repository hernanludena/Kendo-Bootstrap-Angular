package cursojpa.facturacion.excepciones;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class FacturaDataMapper implements ExceptionMapper <FacturaException>
{
	
	@Override
	public Response toResponse(FacturaException e)
	{
		return Response.serverError().entity(e.getMessage()).build();
	}
	
}
