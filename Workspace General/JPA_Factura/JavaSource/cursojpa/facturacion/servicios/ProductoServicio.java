package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.entidades.adicionales.ProductoItem;

@Stateless
public class ProductoServicio {

	@PersistenceContext
	private EntityManager em;

	public Producto buscarPorId(String id) {
		Query q = em
				.createQuery("SELECT P FROM Producto p WHERE p.codigo = :paramId");
		q.setParameter("paramId", id);
		return (Producto) q.getSingleResult();
	}

	public List<Producto> buscarProductos() {
		Query q = em.createQuery("select p from Producto p");
		return q.getResultList();
	}

	public List<Producto> buscarProductosLigero() {
		TypedQuery<Producto> q = em.createQuery(
				"select new Producto(p.codigo, p.nombre) from Producto p",
				Producto.class);
		return q.getResultList();
	}

	// con objeto
	public ProductoItem buscarObjeto(String nombre) {
		TypedQuery<ProductoItem> q = em
				.createQuery(
						"SELECT new cursojpa.facturacion.entidades.adicionales.ProductoItem(p.nombre,p.categoria) FROM Producto p WHERE p.nombre = :paramNombre",
						ProductoItem.class);
		q.setParameter("paramNombre", nombre);
		return (ProductoItem) q.getSingleResult();
	}

	// con lista de objetos
	public List<ProductoItem> buscarListaObjetos(String nombre) {
		TypedQuery<ProductoItem> q = em
				.createQuery(
						"SELECT new cursojpa.facturacion.entidades.adicionales.ProductoItem(p.nombre,p.categoria) FROM Producto p WHERE p.nombre LIKE :paramNombre",
						ProductoItem.class);
		q.setParameter("paramNombre", nombre + "%");
		return q.getResultList();
	}

	public List<Object[]> buscarResultado() {
		Query q = em
				.createQuery("SELECT p.nombre,p.categoria.nombre FROM Producto p");
		List<Object[]> resultado = q.getResultList();
		for (Object[] arreglo : resultado) {
			System.out.println("pos0:" + arreglo[0]);
			System.out.println("pos1" + arreglo[1]);
		}
		return q.getResultList();
	}

	public void insertar(Producto producto) {
		em.persist(producto);
	}
}
