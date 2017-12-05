package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")


public class Vuelo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	Date fecha;
	private String origen;
	private String destino;
	private String codigoVuelo;
	private int plazasLibres;
	@Persistent(defaultFetchGroup = "true", mappedBy = "vuelo", dependentElement = "true")
	@Join
	private List<Reserva> reservas;



	public Vuelo() {
		super();
		this.fecha = null;
		this.origen = null;
		this.destino = null;
		this.codigoVuelo = null;
		this.plazasLibres = 0;
		this.reservas = new ArrayList<Reserva>();
	}
	public String getCodigoVuelo() {
		return codigoVuelo;
	}
	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	public int getPlazasLibres() {
		return plazasLibres;
	}
	public void setPlazasLibres(int plazasLibres) {
		this.plazasLibres = plazasLibres;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	public void addReservas(Reserva r){
		this.reservas.add(r);
	}
	public void cancelarReserva(Reserva r){
		this.reservas.remove(r);
	}

}
