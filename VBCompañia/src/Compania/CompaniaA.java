package Compania;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CompaniaA extends UnicastRemoteObject  implements  ICompania {
/**
	 * 
	 */
	private static final long serialVersionUID = -5950707481538960856L;
private List<Vuelo> vuelos;

protected CompaniaA() throws RemoteException {
	super();
    vuelos = new ArrayList<Vuelo>();
	
	vuelos.add(new Vuelo("Bilbao", "Moscow", "V25A1", new Date(2018, 1, 29), 200));
	vuelos.add(new Vuelo("Madrid-barajas", "St.Petesburgo", "IB171", new Date(2018, 2, 14), 220));
	
}
public static void main(String[] arg) {	
	if (System.getSecurityManager() == null) {
		System.setSecurityManager(new SecurityManager());
	}

	try {
		String name = "//" + arg[0] + ":" + arg[1] + "/" + arg[2];
		ICompania compania = new CompaniaA();
		Naming.rebind(name,(Remote) compania);
		System.out.println(" * Serividro de Iberia: '" + name + "' iniciado y esperando");
	} catch (Exception ex) {
		System.err.println(" # Iberia Server Exception: " + ex.getMessage());
	}

}


public List<Vuelo> buscarVuelo(String origen, String detino, Date fecha){
	List<Vuelo> busqueda = new ArrayList<>();
	for(int i=0; i<vuelos.size();i++){
		if(vuelos.get(i).getOrigen().equals(origen) && vuelos.get(i).getDestino().equals(detino) && vuelos.get(i).getFecha().equals(fecha))
		busqueda.add(vuelos.get(i));	
	}
	return busqueda;
}
}
