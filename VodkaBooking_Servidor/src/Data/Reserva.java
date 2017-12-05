package Data;

import java.io.Serializable;
import java.util.Random;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(detachable = "true")
public class Reserva implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codReserva;
	private String nombre; //para determinar para quien es el billete, resserva el usuario pero no solo para el sin paramas personas
	@Join
	private Usuario usuario;

	@Persistent(defaultFetchGroup= "true")
	private Vuelo vuelo;


	public String getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(String codReserva) {
		this.codReserva = codReserva;
	}
	public void crearCodigoReserva(){
		Random rnd = new Random();
		this.codReserva= "R"+rnd.nextInt(10000000);
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	public void cancelarReserva(){
		this.vuelo.cancelarReserva(this);
		vuelo=null;
	}

}
