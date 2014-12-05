package com.ryabokon.helloworld;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/activemq/hello", activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
		@ActivationConfigProperty(propertyName = "clientId", propertyValue = "clientID"),
		@ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "subscriberID") })
public class HelloMessageBean implements MessageListener {

	public HelloMessageBean() {
	}

	private int count = 0;

	public void onMessage(Message message) {
		try {
			if (message instanceof TextMessage) {
				TextMessage txtMsg = (TextMessage) message;
				System.out.println("Received text message " + count + " from activeMQ:\n" + txtMsg.getText());
			} else {
				System.out.println("Received a message, it just isnt a textMessage!");
			}
		} catch (JMSException jmse) {
			System.out.println("There was a error with the JMS");
			jmse.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}