package server;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.jdo.Query;

import Data.Reserva;
import Data.Usuario;
import Data.Vuelo;


import javax.jdo.Extent;



public class DBManager implements IDBManager {
	private PersistenceManagerFactory pmf;
	
	public DBManager() {
		super();
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}
	
	
	

	public void guardarVuelo(Vuelo v){
		this.guardarObjeto(v);
	}
	private void guardarObjeto(Object object) {
		javax.jdo.PersistenceManager pm = pmf.getPersistenceManager();
		javax.jdo.Transaction tx = pm.currentTransaction();

		try {
			tx.begin();
			System.out.println("   * guardando objeto: " + object);
			pm.makePersistent(object);
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error storing an object: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
	}
	public List<Vuelo> getVuelo() {
		PersistenceManager pm = pmf.getPersistenceManager();
		// By default only 1 level is retrieved from the db so if we
		// wish to fetch more than one level, we must indicate it
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Vuelo> vuelos = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Vuelos.");

			tx.begin();
			Extent<Vuelo> extent = pm.getExtent(Vuelo.class, true);
			for (Vuelo v : extent) {
				vuelos.add(v);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return vuelos;
	}
	public Usuario getUsuario(String nombre) {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		Usuario usuario = null;

	

		try {
			System.out.println("   * Querying Reservations from: " + nombre);

			tx.begin();
			Query query = pm.newQuery(Usuario.class, "SELECT FROM " + Usuario.class.getName() + "WHERE username == "+ nombre);
			query.setUnique(true);
			usuario =(Usuario) query.execute();
			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return usuario;
	}

	public List<Reserva> getReserva() {
		PersistenceManager pm = pmf.getPersistenceManager();
		pm.getFetchPlan().setMaxFetchDepth(3);

		Transaction tx = pm.currentTransaction();
		List<Reserva> reservas = new ArrayList<>();

		try {
			System.out.println("   * Retrieving an Extent for Vuelos.");

			tx.begin();
			Extent<Reserva> extent = pm.getExtent(Reserva.class, true);
			for (Reserva r : extent) {
				reservas.add(r);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("   $ Error retrieving an extent: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}
		return reservas;
	}

	public void guardarUsuario(Usuario u) {
		
		this.guardarObjeto(u);	
	}
	public void guardarReserva(Reserva r) {
		this.guardarObjeto(r);
		
	}






	
}
