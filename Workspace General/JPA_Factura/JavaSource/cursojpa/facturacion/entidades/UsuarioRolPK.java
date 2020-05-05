package cursojpa.facturacion.entidades;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class UsuarioRolPK implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="uro_id_usuario")
	private Usuario usuario;
	
	@Id
	@ManyToOne
	@JoinColumn(name="uro_id_rol")
	private Rol rol;

}
