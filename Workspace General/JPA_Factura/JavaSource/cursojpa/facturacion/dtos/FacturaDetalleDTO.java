package cursojpa.facturacion.dtos;

public class FacturaDetalleDTO {


	private String idProducto;
	private int cantidad;

	

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	
	
}
