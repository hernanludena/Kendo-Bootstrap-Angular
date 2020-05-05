package cursojpa.facturacion.entidades;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Factura {

	@Id
	@Column(name = "fac_codigo")
	private String codigo;

	@Column(name = "fac_fecha")
	private Date fecha;

	@Column(name = "fac_total")
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "fac_id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "factura", cascade = CascadeType.PERSIST)
	private List<FacturaDetalle> detalles;
	
	public Factura() {
		
	}

	public Factura(Cliente cliente) {
		super();
		this.cliente = cliente;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FacturaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalle> detalles) {
		this.detalles = detalles;
	}

}
