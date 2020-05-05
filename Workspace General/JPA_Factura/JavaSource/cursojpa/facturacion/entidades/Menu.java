package cursojpa.facturacion.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@Column(name = "me_id")
	private int id;
	private String nombre;
	private Boolean visible;
	private String url;

	@JoinColumn(name = "me_id_padre")
	@ManyToOne
	private Menu menuPadre;

	@OneToMany(mappedBy = "menuPadre")
	private List<Menu> hijos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getMenuPadre() {
		return menuPadre;
	}

	public void setMenuPadre(Menu menuPadre) {
		this.menuPadre = menuPadre;
	}

	public List<Menu> getHijos() {
		return hijos;
	}

	public void setHijos(List<Menu> hijos) {
		this.hijos = hijos;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", nombre=" + nombre + ", visible=" + visible
				+ ", url=" + url + ", menuPadre=" + menuPadre + "]";
	}
}
