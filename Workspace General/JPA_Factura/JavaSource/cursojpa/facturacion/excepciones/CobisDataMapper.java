package cursojpa.facturacion.excepciones;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CobisDataMapper implements ExceptionMapper<CobisException>
{
	
	@Override
	public Response toResponse(CobisException ce)
	{
		return Response.serverError().entity(ce.getMessage()).build();
	}
	
}
