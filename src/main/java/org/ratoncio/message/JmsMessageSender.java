package org.ratoncio.message;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.*;
import javax.jms.TextMessage;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;


@Singleton
@WebServlet(urlPatterns = "/send")
public class JmsMessageSender extends HttpServlet{

  @Resource(lookup = "jms/JmsFactory")
  private ConnectionFactory jmsFactory;

  @Resource(lookup = "jms/JmsQueue")
  private Queue jmsQueue;

  private Connection connection;
  private Session session;
  private MessageProducer producer;


  public void send(String text) {

    TextMessage message;

    try {
      this.connection = jmsFactory.createConnection();
      this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      this.producer = session.createProducer(jmsQueue);

      message = session.createTextMessage();
      message.setText(text);
      this.producer.send(message);
      this.session.close();

    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      try{
          String message = request.getParameter("msg");
          response.setContentType("text/plain");
          response.setStatus(HttpServletResponse.SC_OK);
          response.getWriter().write("[Read parameter]: " + message +"\n");
          this.send(message);
          response.getWriter().write("[Message sent]: " + message +"\n");
          response.getWriter().flush();
      }
      catch (Exception ex){
          ex.printStackTrace();
      }

  }

}
