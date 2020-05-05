package cursojpa.facturacion.controladores;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyMapper implements ExceptionMapper<CobisException> {
	@Override
	public Response toResponse(CobisException exception) {
		// TODO Auto-generated method stub
		return Response.serverError().entity(exception.getMessage()).build();
	}
}
