package ejb.sandbox.service;

import javax.ejb.Stateless;

@Stateless
public class Calculadora implements CalculadoraRemote {

	public int soma(int a, int b) {
		return a + b;
	}

}
