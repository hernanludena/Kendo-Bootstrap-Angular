package cursojpa.facturacion.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;

	// @OneToMany(mappedBy="categoria",fetch=FetchType.EAGER)
	// private List<Producto> prodcutos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*
	 * public List<Producto> getProdcutos() { return prodcutos; }
	 * 
	 * public void setProdcutos(List<Producto> prodcutos) { this.prodcutos =
	 * prodcutos; }
	 */

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}

}
