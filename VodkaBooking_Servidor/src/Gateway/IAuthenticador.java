package Gateway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuthenticador extends Remote {
	public boolean login(String name, String passwd)throws RemoteException;
	public void register(String name, String passwd);
}
