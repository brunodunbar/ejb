package ejb.sandbox.service;

import javax.ejb.Remote;

@Remote
public interface CalculadoraRemote {

	public int soma(int a, int b);
	
}
