package cursojpa.facturacion.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.Categoria;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.servicios.CategoriaServicio;
import cursojpa.facturacion.servicios.ProductoServicio;

@ManagedBean
@ViewScoped
public class ProductoControlador {

	private Producto producto;

	private int idCategoriaSeleccionada;
	private List<Categoria> categorias;

	@EJB
	private ProductoServicio productoServicio;

	@EJB
	private CategoriaServicio categoriaServicio;

	public ProductoControlador() {
		producto = new Producto();
	}

	@PostConstruct
	public void init() {
		// invocar a servicio categorias y traerse todas
		categorias = categoriaServicio.recuperarTodos();
		System.out.println("Categorias: " + categorias.size());
	}

	public void insertar() {
		// traer la categoria por id
		Categoria categoria = categoriaServicio
				.buscarPorId(idCategoriaSeleccionada);
		// Categoria categoria=

		// setear la categoria encontrada al producto

		producto.setCategoria(categoria);
		// insertar el producto
		productoServicio.insertar(producto);
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getIdCategoriaSeleccionada() {
		return idCategoriaSeleccionada;
	}

	public void setIdCategoriaSeleccionada(int idCategoriaSeleccionada) {
		this.idCategoriaSeleccionada = idCategoriaSeleccionada;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
