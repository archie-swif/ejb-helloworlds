package com.ryabokon.helloworld;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/incoming") })
public class HelloMessageBean implements MessageListener {

	public void onMessage(Message message) {
		try {
			System.out.println("Weve received a message: " + message.getJMSMessageID());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}