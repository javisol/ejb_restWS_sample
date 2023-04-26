package org.ratoncio.stateful;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= "/statefullocal")
public class EjbStatefulLocalServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @EJB //(beanName = "EjbStatefulLocalPoc")
    private EjbStatefulLocal ejb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
        ejb.increment(2);
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("resultado: " + ejb.result());
        response.getWriter().write("\n");
        response.getWriter().flush();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
}
