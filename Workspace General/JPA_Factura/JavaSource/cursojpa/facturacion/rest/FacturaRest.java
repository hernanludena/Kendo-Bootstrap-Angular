package cursojpa.facturacion.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import cursojpa.facturacion.dtos.FacturaDTO;
import cursojpa.facturacion.dtos.FacturaDetalleDTO;
import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Factura;
import cursojpa.facturacion.entidades.FacturaDetalle;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.excepciones.CobisException;
import cursojpa.facturacion.excepciones.FacturaException;
import cursojpa.facturacion.servicios.ClienteServicio;
import cursojpa.facturacion.servicios.FacturaServicio;
import cursojpa.facturacion.servicios.ProductoServicio;
import cursojpa.facturacion.utils.DateUtils;

@Stateless
@Path("/serviciofactura") 
public class FacturaRest
{
	@EJB
	private FacturaServicio facturaServicio;
	
	@EJB
	private ClienteServicio clienteServicio;	
	
	@EJB
	private ProductoServicio productoServicio;	
	
	@Consumes("application/json")
	@POST		
	@Path("/insertar")		
	public Response insertar(FacturaDTO facturaDTO) throws CobisException
	{
		System.out.println("factura enviada es: "+facturaDTO);
		Factura f = new Factura();
		List<FacturaDetalle> facturaDetalles = new ArrayList<FacturaDetalle>();
		
		Cliente cliente = clienteServicio.buscarPorCedula(facturaDTO.getCedula());
		
		if (cliente==null)
			throw new CobisException("EL CLIENTE NO EXISTE ID=" + facturaDTO.getCedula());
		
		f.setCliente(cliente);
		
		f.setCodigo(facturaDTO.getCodigo());
		f.setFecha(DateUtils.toStringFecha(facturaDTO.getFecha()));
		
		
		for (FacturaDetalleDTO fdd : facturaDTO.getDetalles()) {
			FacturaDetalle fd = new FacturaDetalle();
			
			fd.setCantidad(fdd.getCantidad());
			fd.setCodigo(null);
			fd.setFactura(f);
			
			Producto producto =productoServicio.buscarPorId(fdd.getIdProducto());
			
			if (producto==null)
				throw new CobisException("EL PRODUCTO NO EXISTE ID=" + fdd.getIdProducto());
			
			fd.setProducto(producto);
			
			facturaDetalles.add(fd);
			
		}
		
		f.setDetalles(facturaDetalles);
		
		Response response=null;
		
		try
		{
			facturaServicio.insertar(f);
			response = Response.ok().entity("OK").build();
		}
		catch(Exception e)
		{			
			e.printStackTrace();
			response = Response.serverError().entity("LA FACTURA NO SE PUDO INSERTAR: " + e.getMessage()).build();
			throw new CobisException("LA FACTURA NO SE PUDO INSERTAR: " + e.getMessage());			
		}	
		
		return response;
	}

	
	@GET			
	@Path("/consulta")
	@Produces("application/json")
	public FacturaDTO consultar(@QueryParam(value="codigo") String codigo) throws FacturaException
	{
		FacturaDTO f = new FacturaDTO();
		List<FacturaDetalleDTO> fds = new ArrayList<FacturaDetalleDTO>();
		
		Factura factura = new Factura();
		
		try
		{
			factura = facturaServicio.buscarFactura(codigo);
		}
		catch (Exception e)
		{
			throw new FacturaException("No existe la factura codigo: " + codigo + " -> " + e.getMessage());
		}
		
		
		
		List<FacturaDetalle> facturaDetalles = factura.getDetalles();
		
		
		f.setCedula(factura.getCliente().getCedula());
		f.setCodigo(factura.getCodigo());
		//f.setFecha(DateUtils.fechaToString(factura.getFecha()));
		//f.setTotal(factura.getTotal());
		
		for (FacturaDetalle fd : facturaDetalles) {
			
			FacturaDetalleDTO fdaux = new FacturaDetalleDTO();
			
			fdaux.setCantidad(fd.getCantidad());
			fdaux.setIdProducto(fd.getProducto().getCodigo());
			
			fds.add(fdaux);
			
		}
		
		
		f.setDetalles(fds);
		
		
		return f;
	}		
	
}
