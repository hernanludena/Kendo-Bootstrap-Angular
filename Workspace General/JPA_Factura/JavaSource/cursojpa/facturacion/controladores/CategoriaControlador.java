package cursojpa.facturacion.controladores;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.Categoria;
import cursojpa.facturacion.servicios.CategoriaServicio;

@ManagedBean
@ViewScoped
public class CategoriaControlador {

	@EJB
	private CategoriaServicio servicioCategoria;

	private Categoria categoria;

	public CategoriaControlador() {
		categoria = new Categoria();
	}

	public void insertar() {
		// invocar al servicio
		servicioCategoria.insertar(categoria);
		categoria = new Categoria();
	}

	public void actualizar() {
		// invocar al servicio
		servicioCategoria.actualizar(categoria);
		categoria = new Categoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
