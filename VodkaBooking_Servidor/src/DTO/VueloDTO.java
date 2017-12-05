package DTO;

import java.util.Date;

public class VueloDTO {
private Date fecha;
private String origen;
private String destino;
public VueloDTO( String origen, String destino,Date fecha) {
	super();
	this.fecha = fecha;
	this.origen = origen;
	this.destino = destino;
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

}
