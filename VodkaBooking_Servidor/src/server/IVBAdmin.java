package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import DTO.VueloDTO;
import Data.Usuario;
public interface IVBAdmin extends Remote {
public boolean login(String user, String passwd)throws RemoteException;
public  void registrar(String username, String passwd, String AeropuertoXdefecto)throws RemoteException;
public List<VueloDTO> buscarVuelo(String origen, String destino, Date fecha) throws RemoteException;
public void reservarVuelo(Data.Vuelo v, Usuario u, String nombre)throws RemoteException;
}