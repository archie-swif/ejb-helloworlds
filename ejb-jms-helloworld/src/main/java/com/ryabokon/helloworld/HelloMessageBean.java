package com.ryabokon.helloworld;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "jms/queue/incoming") })
public class HelloMessageBean implements MessageListener {

	public void onMessage(Message msg) {
		try {
			TextMessage message = (TextMessage) msg;
			System.out.println("Payload: " + message.getText());
		} catch (JMSException ex) {
			ex.printStackTrace();
		}
	}
}