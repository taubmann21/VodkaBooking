package Gateway;


import java.rmi.RemoteException;

import Gateway.Gateway;

public class GatewayFactory {
	private static GatewayFactory instance;
	public static synchronized GatewayFactory getInstance() {
		if(instance == null) {
			instance = new GatewayFactory();
		}
		
		return instance;
}

public IGateway CreateGateway(String buscar) throws RemoteException{
	if(buscar.equals("buscarVuelo"))
		return new Gateway();
	else
		return null;
}
}
