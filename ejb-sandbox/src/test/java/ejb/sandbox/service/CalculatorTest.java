package ejb.sandbox.service;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class CalculatorTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addClasses(CalculatorRemote.class, Calculator.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	CalculatorRemote calculadora;

	@Test
	public void shouldCalculateOnePlusOneAndReturnTwo() {
		Assert.assertEquals(2, calculadora.soma(1, 1));
	}

}
