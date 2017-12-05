package Gateway;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import Compania.Vuelo;


public interface IGateway {
	public List<Vuelo> buscarVuelo(String origen, String destino, Date fecha)throws RemoteException;
	
}
