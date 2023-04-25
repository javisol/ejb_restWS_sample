package org.ratoncio.stateful;

import javax.servlet.annotation.WebServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;

@WebServlet(urlPatterns= "/statefullocal")
public class EjbStatefulLocalServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @EJB(beanName = "EjbSessionLocalPoc")
    private EjbStatefulLocal ejb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      ejb.increment(2);
      //response.getWriter().append(ejb.result());
      response.setContentType("text/plain");
      response.setStatus(HttpServletResponse.SC_OK);
      response.getWriter().write("resultado: " + ejb.result());
      response.getWriter().flush();
    }
    
}
