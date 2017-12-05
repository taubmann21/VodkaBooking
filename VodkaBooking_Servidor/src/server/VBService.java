package server;




import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Compania.*;
import DTO.Assembler;
import DTO.VueloDTO;
import Data.*;
import Data.Vuelo;
import Gateway.*;


public class VBService extends UnicastRemoteObject implements IVBAdmin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<VueloDTO> vuelos = new ArrayList<VueloDTO>();

	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			IVBAdmin objServidor = new VBService();
			Naming.rebind(name,(Remote) objServidor);
			System.out.println("* Servidor de Easy bookingsrvidor '" + name
					+ "' activo y esperando...");
		} catch (Exception e) {
			System.err.println("- Exception ejecutando el servidor: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}
	public VBService() throws RemoteException{


	}
	public synchronized boolean login(String username, String passwd) throws RemoteException{

		IAuthenticador gtw = new AuthenticatorGateway();
		return gtw.login(username, passwd);

	}
	public synchronized void registrar(String username, String passwd, String AeropuertoXdefecto)throws RemoteException{

		IAuthenticador gtw = new AuthenticatorGateway();
		gtw.register(username, passwd);
		Usuario u = new Usuario(username, AeropuertoXdefecto);
		IDBManager db= new DBManager();
		db.guardarUsuario(u);
		System.out.println("registrado exitosamente");
	}
	public synchronized List<VueloDTO>buscarVuelo(String origen, String destino, Date fecha){
		IGateway gtw;
		List<Compania.Vuelo> fligth=new ArrayList<Compania.Vuelo>();
		IDBManager db= new DBManager();
		try {
			gtw = GatewayFactory.getInstance().CreateGateway("buscarVuelo");
			fligth = gtw.buscarVuelo(origen, destino, fecha);
			for(Compania.Vuelo v : fligth){
				
				Vuelo vuelo= new Data.Vuelo();
				vuelo.setOrigen(v.getOrigen());
				vuelo.setDestino(v.getDestino());
				vuelo.setFecha(v.getFecha());
				vuelo.setPlazasLibres(v.getPlazasLibres());
				vuelo.setCodigoVuelo(v.getCodigoVuelo());
				
				db.guardarVuelo(vuelo);
			}
			vuelos =new Assembler().assemble(db.getVuelo());

		} catch ( RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return vuelos;
	}


	@Override
	public void reservarVuelo(Data.Vuelo v, Usuario u, String nombre) throws RemoteException {
		// TODO Auto-generated method stub
		Reserva r = new Reserva();
		r.crearCodigoReserva();
		r.setVuelo(v);
		r.setNombre(nombre);
		r.setUsuario(u);
		IDBManager db= new DBManager();
		db.guardarReserva(r);

	}
}
