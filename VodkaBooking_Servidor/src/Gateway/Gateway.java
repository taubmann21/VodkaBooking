package Gateway;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Compania.*;



public class Gateway  implements IGateway {
	
	private ICompania server;

	public  Gateway() throws  RemoteException {
		String ip="127.0.0.1";
		String port="1099";
		String servername = "Iberia";
	
		try {
			String name = "//" + ip + ":" + port + "/" + servername;
			server = (ICompania) java.rmi.Naming.lookup(name);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Compania.Vuelo> buscarVuelo(String Origen, String Destino, Date fecha){
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		try {
			vuelos=server.buscarVuelo(Origen, Destino, fecha);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return vuelos;
	}
}
