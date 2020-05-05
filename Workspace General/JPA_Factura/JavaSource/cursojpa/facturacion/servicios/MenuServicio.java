package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Menu;


@Stateless
public class MenuServicio {
	
	
	@PersistenceContext
	private EntityManager em;
	
	/***
	 * Buscar todos los menues que pertenecen a un usuario
	 * @param idUsuario Id del usuario
	 * @return Los menues del usuario
	 */
	public List<Menu> buscar(int idUsuario){
		//Un usuario tiene muchos roles 
		//Un rol tiene muchos menues
		Query query=em.createQuery("SELECT mr.menu FROM MenuRol mr WHERE mr.rol.id IN ("
				+ "SELECT ur.rol.id FROM UsuarioRol ur WHERE ur.usuario.id = :idUsuarioParam)");
		query.setParameter("idUsuarioParam", idUsuario);
		return query.getResultList();
	}

	
}
