package org.ratoncio.stateless;

import javax.servlet.annotation.WebServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet(urlPatterns= "/statelesslocal")
public class EjbStatelessLocalServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @EJB //(beanName = "EjbStatelessLocalPoc")
    private EjbStatelessLocal ejb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      try {
        ejb.increment(2);
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("resultado: " + ejb.result());
        response.getWriter().write("\n");
        response.getWriter().flush();
      }
      catch (Exception ex){
        ex.printStackTrace();
      }
    }
    
}
