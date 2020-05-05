package cursojpa.facturacion.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Rol {
	
	@Id
	private int id;
	
	
	private String descripcion;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
