package Compania;
import java.io.Serializable;
import java.util.Date;

public class Vuelo implements Serializable {
	private String origen;
	private String destino;
	private String codigoVuelo;
	private Date fecha;
	private int plazasLibres;

	public Vuelo(String origen, String destino, String codigoVuelo, Date fecha, int plazasLibres) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.codigoVuelo = codigoVuelo;
		this.fecha=fecha;
		this.plazasLibres=plazasLibres;
		
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getPlazasLibres() {
		return plazasLibres;
	}
	public void setPlazasLibres(int plazasLibres) {
		this.plazasLibres = plazasLibres;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getCodigoVuelo() {
		return codigoVuelo;
	}
	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}
	
}
