package Gateway;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Gateway.IAuthenticador;
import Authenticador.IAuthenticator;


public class AuthenticatorGateway implements  IAuthenticador {
	private IAuthenticator server;

	public  AuthenticatorGateway() throws RemoteException{
		String ip="127.0.0.1";
		String port="1099";
		String servername = "facebook";
		
		try {
			String name = "//" + ip + ":" + port + "/" + servername;
			server = (IAuthenticator) java.rmi.Naming.lookup(name);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void register(String userName, String userPass) {
		server.register(userName, userPass);
	}
	
	public boolean login(String userName, String userPass) {
		return server.login(userName, userPass);
	}

}

