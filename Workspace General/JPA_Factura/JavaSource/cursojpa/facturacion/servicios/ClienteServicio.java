package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.utils.Constantes;

@Stateless
public class ClienteServicio {

	@PersistenceContext
	private EntityManager em;

	/***
	 * Recupera todos los clientes cuyo Apellido comience con la cadena que
	 * recibe como par�metro.La b�squeda no hace distinci�n de may�sculas y
	 * min�sculas
	 * 
	 * @param cadena
	 *            Cadena para b�squeda
	 * @return Lista de clientes que coincidan con el criterio de b�squeda
	 */
	public List<Cliente> buscarPorApellido(String cadena) {
		Query q = em
				.createQuery("SELECT c FROM Cliente c WHERE UPPER(c.apellido) LIKE UPPER(:paramApellido)");
		q.setParameter("paramApellido", cadena + "%");
		return q.getResultList();
	}

	// puedo requerir que reciba solo el nombre y apellido del cliente

	public Cliente buscarPorCedula(String cedula) {
		Cliente cliente=null;
		Query q = em
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula LIKE :paramCedula");
		q.setParameter("paramCedula", cedula);
		try{
			cliente=(Cliente) q.getSingleResult();
		}catch(NoResultException ex){
			ex.printStackTrace();
		}
		return cliente;
	}

	public List<Cliente> buscarTodos(int desde) {
		Query q = em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre");
		q.setFirstResult(desde);
		q.setMaxResults(Constantes.filas);
		return q.getResultList();
	}

}
