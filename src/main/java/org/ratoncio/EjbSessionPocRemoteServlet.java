package org.ratoncio;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= "/remote")
public class EjbSessionPocRemoteServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @EJB(beanName = "EjbSessionRemotePoc")
    private EjbSessionPocRemote ejb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      try {

        ejb.increment(2);
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("\nresultado: " + ejb.result());
        response.getWriter().write("\n");
        response.getWriter().flush();
        //ejb.insertDb(ejb.result());
      }
      //catch (SQLException e){
      //  e.printStackTrace();;
      //}
      catch (Exception ex){
        ex.printStackTrace();
      }
    }
    
}
