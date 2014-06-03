package ejb.sandbox.service;

import javax.ejb.Stateless;

@Stateless
public class Calculator implements CalculatorRemote {

	public int soma(int a, int b) {
		return a + b;
	}

}
