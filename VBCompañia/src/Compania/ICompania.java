package Compania;
import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.Date;
import java.util.List;

public interface ICompania extends Remote {
	public List<Vuelo> buscarVuelo(String origen, String detino, Date fecha)throws RemoteException;
}
