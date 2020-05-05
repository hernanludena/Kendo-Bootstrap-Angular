package cursojpa.facturacion.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Producto {

	@Id
	private String codigo;

	private String nombre;

	@Column(name = "precio_venta")
	private BigDecimal precioVenta;

	private Boolean impuesto;

	
	@JoinColumn(name = "id_categoria")
	@ManyToOne
	private Categoria categoria;

	public Producto() {

	}

	public Producto(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Producto(String nombre, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Boolean getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Boolean impuesto) {
		this.impuesto = impuesto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
