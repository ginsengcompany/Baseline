/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.inquinamento.servlet;

import com.google.gson.Gson;
import it.gesan.inquinamento.inquinamento.CsvComuniReader;
import it.gesan.inquinamento.inquinamento.DatiInquinamento;
import it.gesan.inquinamento.inquinamento.Luogo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Fabrizio
 */
@WebServlet(name = "inquinamento", urlPatterns = {"/dashboard/inquinamento"})
public class Dati extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Dati</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Dati at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard/fattoriInquinanti.jsp");
        DatiInquinamento dati = new DatiInquinamento();
        Document doc = Jsoup.connect("http://88.45.133.130/meteoambientecampania/php/pubblicazione_dati_centraline_valori_medi.php").get();
        dati.populate(doc);
        CsvComuniReader comuni = new CsvComuniReader();
        Luogo luoghi = new Luogo();
        Gson gson = new Gson();
        request.setAttribute("pm10", gson.toJson(dati.getPm10()));
        request.setAttribute("luoghi", gson.toJson(luoghi));
        request.setAttribute("comuni", gson.toJson(comuni.getComuni()));
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
