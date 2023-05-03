package org.ratoncio.entity;

import javax.servlet.annotation.WebServlet;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;


@WebServlet(urlPatterns = "/pets")
public class EjbEntityManagerLocalServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @EJB
    private EjbEntityManager ejb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            int petId = Integer.parseInt(request.getParameter("id"));
            EjbEntityBean pet = ejb.getPetById(petId);
            //String petName= request.getParameter("name");
            //EjbEntityBean pet = ejb.getPetByName(petName);

            response.setContentType("text/plain");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("resultado: " + pet.getName());
            response.getWriter().write("\n");
            response.getWriter().flush();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    
}
