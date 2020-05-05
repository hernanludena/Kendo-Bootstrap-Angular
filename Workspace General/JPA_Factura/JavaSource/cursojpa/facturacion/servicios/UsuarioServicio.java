package cursojpa.facturacion.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Usuario;

@Stateless
public class UsuarioServicio {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Busca el usuario que coincida con el usuario y password que recibe como
	 * parámetro
	 * 
	 * @param usuario
	 *            Usuario con datos para la búsqueda
	 * @return Usuario encontrado, si no encuentra retorna null
	 */
	public Usuario buscar(Usuario usuario) {

		Query query = em
				.createQuery("SELECT us FROM Usuario us WHERE us.usuario = :paramUsuario AND us.clave= :paramClave");
		query.setParameter("paramUsuario", usuario.getUsuario());
		query.setParameter("paramClave", usuario.getClave());
		Usuario encontrado = null;
		try {
			encontrado = (Usuario) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		return encontrado;
	}
}
