package cursojpa.facturacion.entidades;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class MenuRolPK implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="mro_id_menu")
	private Menu menu;

	@Id
	@ManyToOne
	@JoinColumn(name="mro_id_rol")
	private Rol rol;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
	//sobreescribir equals y hashCode
	
}
