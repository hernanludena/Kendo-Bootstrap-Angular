package curso.restaurantes.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import curso.restaurantes.entidades.Restaurante;



@Stateless
public class RestaurantesServicios {
	@PersistenceContext 
	private EntityManager em;
	
	public List<Restaurante> recuperarTodos() {
		Query query = em.createQuery("SELECT c FROM Restaurante c");
		return query.getResultList();
	}
	
	public void insertar(Restaurante restaurante){
		em.persist(restaurante);
	}
	
	public Restaurante buscar(int codigo){
		return em.find(Restaurante.class,codigo);
	}
	
	public void actualizar(Restaurante restaurante){
		em.merge(restaurante);
	}


}
