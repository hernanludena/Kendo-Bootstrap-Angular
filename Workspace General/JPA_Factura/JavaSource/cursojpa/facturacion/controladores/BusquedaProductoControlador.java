package cursojpa.facturacion.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.servicios.ProductoServicio;

@ManagedBean
public class BusquedaProductoControlador {

	@EJB
	private ProductoServicio productoServicio;

	private List<Producto> productos;
	private List<Producto> productosLigero;

	public BusquedaProductoControlador() {
		productos = new ArrayList<Producto>();
	}

	public void buscarTodos() {
		productos = productoServicio.buscarProductos();
		productosLigero = new ArrayList<Producto>();
	}

	public void buscarLigero() {
		productosLigero = productoServicio.buscarProductosLigero();
		productos = new ArrayList<Producto>();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Producto> getProductosLigero() {
		return productosLigero;
	}

	public void setProductosLigero(List<Producto> productosLigero) {
		this.productosLigero = productosLigero;
	}

}
