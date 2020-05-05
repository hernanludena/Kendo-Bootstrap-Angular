package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Categoria;

@Stateless
public class CategoriaServicio {

	@PersistenceContext
	private EntityManager em;

	public void insertar(Categoria categoria) {
		em.persist(categoria);
	}

	public void actualizar(Categoria categoria) {
		em.merge(categoria);
	}

	public Categoria buscarPorId(int id) {
		return em.find(Categoria.class, id);
	}

	public List<Categoria> recuperarTodos() {
		Query query = em.createQuery("SELECT c FROM Categoria c");
		
		return query.getResultList();
	}

}
