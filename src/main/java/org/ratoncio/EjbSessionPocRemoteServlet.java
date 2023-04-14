package org.ratoncio;

import javax.servlet.annotation.WebServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns= "/remote")
public class EjbSessionPocRemoteServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @EJB(beanName = "EjbSessionRemotePoc")
    private EjbSessionPocRemote ejb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      ejb.increment(2);
      //response.getWriter().append(ejb.result());
      response.setContentType("text/plain");
      response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().write("resultado: " + ejb.result());
      response.getWriter().flush();
      try {
        ejb.insertDb(ejb.result());
      }
      catch (SQLException e){
        e.printStackTrace();;
      }
    }
    
}
