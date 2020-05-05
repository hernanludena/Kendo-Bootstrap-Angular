package curso.restaurantes.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import curso.restaurantes.entidades.Categoria;


@Stateless
public class CategoriasServicios {
	@PersistenceContext
	private EntityManager em;

	public List<Categoria> recuperar(){
		Query query = em.createQuery("SELECT c FROM Categoria c");
		return query.getResultList();
	}
}
