package org.ratoncio.message;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
  activationConfig = {
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "JmsQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName="acknowledgeMode", propertyValue="Auto-acknowledge")  
  },
  name="JmsMessageReaderMDB"
)
public class JmsMessageReader implements MessageListener {

  @Override
  public void onMessage(Message message) {
    try {
      TextMessage textMessage = (TextMessage) message;
      String incomingTextMessage = textMessage.getText();
      System.out.println("[message read]: " + incomingTextMessage);
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

}