package ejb.sandbox;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/salutationQueue") })
public class SalutationMessageBean implements MessageListener {
	public SalutationMessageBean() {
	}

	@Override
	public void onMessage(Message message) {
		try {
			String name = message.getStringProperty("name");
			Logger.getLogger("SalutationLog").log(Level.INFO,
					"Salutation processed", "");
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}