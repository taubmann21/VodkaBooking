package Authenticador;

import java.rmi.Naming;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;


public class Authenticator  extends UnicastRemoteObject implements IAuthenticator {
	Map<String, String> listusers;
	private static final long serialVersionUID = 1L;

	protected Authenticator() throws RemoteException {
		super();

		listusers = new HashMap<String, String>();
	}

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
			IAuthenticator objServidor = new Authenticator();
			Naming.rebind(name, (Remote) objServidor);
			System.out.println("* Servidor de Autenticacion '" + name
					+ "' activo y esperando...");
		} catch (Exception e) {
			System.err.println("- Exception ejecutando el servidor: "
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean login(String name, String passwd){
		if(listusers.get(name)!=null && listusers.get(name).equals(passwd))
			return true;
		return false;


	}

	public void register(String name, String psswd){
		listusers.put(name, psswd);
		System.out.println("sucsesfully registered");
	}
}
