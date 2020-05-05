package cursojpa.facturacion.controladores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Factura;
import cursojpa.facturacion.entidades.FacturaDetalle;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.servicios.ClienteServicio;
import cursojpa.facturacion.servicios.FacturaServicio;
import cursojpa.facturacion.servicios.ProductoServicio;
import cursojpa.facturacion.utils.GeneradorMensajes;

@ManagedBean
@ViewScoped
public class FacturaControlador {

	// 1) busqueda por apellido
	// 2) elige uno de los que preseta
	// 3) busqueda por cedula //clave primaria

	// puedo traer todos los clientes con ciertas caracteristicas y ejecutar
	// un cambio con un if??

	// puedo generar una tabla de amortizacion o algo asi
	// una tabla de pagos para el cliente

	private Cliente cliente;
	private String cadenaBusquedaCliente;
	private String cedulaBusquedaCliente;
	private List<Cliente> clientes;
	private String codigoBusquedaProducto;
	private Producto producto;
	private Factura factura;
	private int cantidad;
	private List<FacturaDetalle> detalles;

	@EJB
	private ClienteServicio clienteServicio;

	@EJB
	private ProductoServicio productoServicio;

	@EJB
	private FacturaServicio facServicio;

	// traer los clientes por lotes
	// traer los clientes activos

	public FacturaControlador() {
		cliente = new Cliente();
		producto = new Producto();
		factura = new Factura();
		detalles = new ArrayList<FacturaDetalle>();
		factura.setFecha(new Date());
	}

	public void buscarClientePorCedula() {
		// si es null, mostrar el mensaje no existe el cliente

		cliente = clienteServicio.buscarPorCedula(cedulaBusquedaCliente);
		if (cliente == null) {
			GeneradorMensajes.mostrarInfo("Cliente no encontrado");
		}
	}

	public void buscarClientePorApellido() {
		clientes = clienteServicio.buscarPorApellido(cadenaBusquedaCliente);
	}

	public void buscarProductoPorCodigo() {
		producto = productoServicio.buscarPorId(codigoBusquedaProducto);
		System.out.println("entro a producto");
	}

	// guarda la cabecera de la factura
	// guarda cada detalle de la factura - en el servicio con un for luego con
	// cascade
	// registra en inventario
	// modifica el stock del producto

	public void guardarFactura() {

		// Agregar el cliente a la factura
		factura.setCliente(cliente);
		// Agregar la lista de detalles a la factura
		factura.setDetalles(detalles);
		// invocar al servicio que guarda la factura
		facServicio.insertar(factura);
		// aqui se puede probar la transaccionalidad
		// enviar el correo podria ser en otra transaccion o un metodo que no
		// tiene
		// transaccion, hay que probar...
	}

	public void agregarDetalle() {
		// nuevo detalle de producto
		FacturaDetalle detalle = new FacturaDetalle();
		detalle.setFactura(factura);
		detalle.setProducto(producto);
		detalle.setCantidad(cantidad);
		detalle.setSubTotal(new BigDecimal(cantidad).multiply(producto
				.getPrecioVenta()));

		// agregar producto
		// agregar cantidad

		detalles.add(detalle);
		// Agregar subtotal, eso luego para el transient
		calcularTotal(detalle.getSubTotal());
	}

	public void calcularTotal(BigDecimal subTotal) {
		System.out.println("q paso" + factura);
		if (factura.getTotal() != null) {
			factura.setTotal(factura.getTotal().add(subTotal));
		} else {
			factura.setTotal(subTotal);
		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCadenaBusquedaCliente() {
		return cadenaBusquedaCliente;
	}

	public void setCadenaBusquedaCliente(String cadenaBusquedaCliente) {
		this.cadenaBusquedaCliente = cadenaBusquedaCliente;
	}

	public String getCedulaBusquedaCliente() {
		return cedulaBusquedaCliente;
	}

	public void setCedulaBusquedaCliente(String cedulaBusquedaCliente) {
		this.cedulaBusquedaCliente = cedulaBusquedaCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getCodigoBusquedaProducto() {
		return codigoBusquedaProducto;
	}

	public void setCodigoBusquedaProducto(String codigoBusquedaProducto) {
		this.codigoBusquedaProducto = codigoBusquedaProducto;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<FacturaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalle> detalles) {
		this.detalles = detalles;
	}

}
