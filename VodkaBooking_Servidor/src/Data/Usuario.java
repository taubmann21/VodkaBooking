package Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String aeropuertoXdefecto;
	@Persistent(defaultFetchGroup = "true", mappedBy = "usuario", dependentElement = "true")
	@Join
	private List<Reserva> reservas;
	public Usuario(String username, String aeropuertoXdefecto) {
		super();
		this.username = username;
		this.aeropuertoXdefecto = aeropuertoXdefecto;
		this.reservas= new ArrayList<Reserva>();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAeropuertoXdefecto() {
		return aeropuertoXdefecto;
	}
	public void setAeropuertoXdefecto(String aeropuertoXdefecto) {
		this.aeropuertoXdefecto = aeropuertoXdefecto;
	}
	public List<Reserva> getReservas() {
		return reservas;
	}
	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	public void ReservarVuelo(String nombre){
		Reserva r= new Reserva();
		r.crearCodigoReserva();
		r.setNombre(nombre);
		r.setUsuario(this);
		reservas.add(r);
	}
}
