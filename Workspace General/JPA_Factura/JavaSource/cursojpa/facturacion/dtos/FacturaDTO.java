package cursojpa.facturacion.dtos;

import java.util.List;

public class FacturaDTO {

	private String codigo;
	private String cedula;
	private String fecha;
	
	private List<FacturaDetalleDTO> detalles;
	
	public FacturaDTO() {
		super();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}





	public List<FacturaDetalleDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalleDTO> detalles) {
		this.detalles = detalles;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "FacturaDTO [codigo=" + codigo + ", cedula=" + cedula
				+ ", fecha=" + fecha + ", detalles=" + detalles + "]";
	}
	
	
}
