package ejb.sandbox.service;

import javax.ejb.Remote;

@Remote
public interface CalculatorRemote {

	public int soma(int a, int b);
	
}
