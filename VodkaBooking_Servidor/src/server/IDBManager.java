package server;

import java.util.List;


import Data.Reserva;
import Data.Usuario;
import Data.Vuelo;

public interface IDBManager {
	public void guardarVuelo(Vuelo v);
	public List<Vuelo> getVuelo();
	public Usuario getUsuario(String nombre);
	public List<Reserva> getReserva();
	public void guardarUsuario(Usuario u);
	public void guardarReserva(Reserva r);

}
