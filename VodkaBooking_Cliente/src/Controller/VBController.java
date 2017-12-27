package Controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ServiceLocator.RMIServiceLocator;
import DTO.VueloDTO;

public class VBController {
	private RMIServiceLocator rsl;
	public VBController(String[] args) throws RemoteException {
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		
	}
	public List<VueloDTO> buscarVuelo(String origen, String Destino, Date fecha){
		List<VueloDTO> vuelos= new ArrayList<VueloDTO>();
		rsl.getService();
		try {
			vuelos = rsl.getService().buscarVuelo(origen, Destino, fecha);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(VueloDTO v: vuelos)
			System.out.println(v.toString());
		return vuelos;
	}
	public boolean login(String Username, String passwd){
		boolean logged=false;
	try {
		logged=	rsl.getService().login(Username, passwd);
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if(logged==true)
		System.out.println("logged in");
	else
		System.out.println("login failed");
	return logged;

	}
	
	public void registrar(String Username, String passwd, String AeroXdefecto ){
		
		try {
			rsl.getService().registrar(Username, passwd, AeroXdefecto);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws RemoteException{
		VBController controller= new VBController(args);
		
			System.out.println("registrate");
			String Username ="Ander";
			String passwd= "12345";
			String AeroXdefecto="bilbao";
			System.out.println(Username + " "+ passwd + " "+AeroXdefecto);
			controller.registrar(Username, passwd, AeroXdefecto);
			System.out.println("buscando vuelo: bilbao-heathrow, 2017/01/29");
			controller.buscarVuelo("Bilbao", "Heathrow", new Date(2017, 1, 29));
			
			
		
	}
}