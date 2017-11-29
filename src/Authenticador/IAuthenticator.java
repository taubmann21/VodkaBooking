package Authenticador;

public interface IAuthenticator {
	public boolean login(String name, String passwd);
	public void register(String name, String passwd);
}
