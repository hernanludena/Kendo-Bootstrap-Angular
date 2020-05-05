package cursojpa.facturacion.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.servicios.ClienteServicio;
import cursojpa.facturacion.utils.Constantes;

@ManagedBean
@ViewScoped
public class BuscarClienteControlador {

	@EJB
	private ClienteServicio clienteServicio;

	private List<Cliente> clientes;

	private int desde;

	public void anterior() {
		desde = desde - Constantes.filas;

		if (desde < 0) {
			desde = 0;
		} else {
			consultar();
		}
	}

	public void siguiente() {
		desde = desde + Constantes.filas;
		consultar();
	}

	public void consultar() {
		clientes = clienteServicio.buscarTodos(desde);

	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
