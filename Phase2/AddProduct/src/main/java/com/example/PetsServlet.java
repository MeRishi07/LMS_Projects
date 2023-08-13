package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebServlet("/PetsServlet")
public class PetsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PetsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            List<Pets> list = session.createQuery("FROM Pets", Pets.class).list();
            session.close();

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<b>Product Listing</b><br>");
            for (Pets pet : list) {
                out.println("ID: " + pet.getId() + ", Name: " + pet.getName() +
                        ", Price: " + pet.getPrice() + ", Color: " + pet.getColor() + "<br>");
            }

            out.println("</body></html>");
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<b>Adding Pet:</b> " + request.getParameter("name") + "<br>");
        out.println("<a href='index.jsp'>Return to Main</a><br>");
        out.println("</body></html>");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String color = request.getParameter("color");
        double price = Double.parseDouble(request.getParameter("price"));
        String petPrice = String.format("%.2f", price);

        try {
            PetShopDAO petShopDAO = new PetShopDAO();
            petShopDAO.addPet(name, color, petPrice);
            response.sendRedirect("AddedPrompt");
        } catch (Exception e) { 
            System.err.println("doPost");
            e.printStackTrace();
        }
    }
}