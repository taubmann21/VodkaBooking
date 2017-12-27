package ServiceLocator;

import server.IVBAdmin;

public class RMIServiceLocator{
	// The Cache
	private IVBAdmin Service;
	

    public RMIServiceLocator(){ 
     
    }

    public void setService(String[] args) {
    	
    	// Add your code to get the TARGET reference HERE
    	if (System.getSecurityManager() == null) {
      		 System.setSecurityManager(new SecurityManager());
      		 }
       	
       	 try {
       		 String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
   			Service = (IVBAdmin) java.rmi.Naming.lookup(name);
   		} catch (Exception e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   	
   		}
    	
    }

    public IVBAdmin getService() {
    	return Service;
    }
    
   
}