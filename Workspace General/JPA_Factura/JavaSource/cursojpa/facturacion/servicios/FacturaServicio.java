package cursojpa.facturacion.servicios;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Factura;

@Stateless
public class FacturaServicio {

	@PersistenceContext
	private EntityManager em;

	public void insertar(Factura factura) {
		em.persist(factura);
	}
	
	

	/**
	 * Busca la factura que corresponde al código que recibe como parámetro. La
	 * factura debe retornar con el detalle incluido
	 * 
	 * @param codigo
	 *            Código para la búsqueda
	 * @return la factura buscada, si no encuentra retorna null.
	 */
	public Factura buscarFactura(String codigo) {
		// Agregar el getDetalles().size(); para que me retorne la factura
		// completa
		Query q = em
				.createQuery("select f from Factura f where f.codigo = :paramCodigo");
		q.setParameter("paramCodigo", codigo);
		// tratar de hacer lo mismo pero con join
		try {
			Factura f = (Factura) q.getSingleResult();
			f.getDetalles().size();
			return f;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// buscarFacturaConJoin
	public Factura buscarFacturaJoin(String codigo) {
		Query q = em
				.createQuery("select f from Factura f join fetch f.detalles where f.codigo = :paramCodigo");
		q.setParameter("paramCodigo", codigo);
		try {
			return (Factura) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
