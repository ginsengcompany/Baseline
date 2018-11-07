/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.inquinamento.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import it.gesan.inquinamento.inquinamento.CsvComuniReader;
import it.gesan.inquinamento.inquinamento.DatiInquinamento;
import it.gesan.inquinamento.inquinamento.Luogo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
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
 * @author aldo
 */
@WebServlet(name = "inquinamentoPM25", urlPatterns = {"/dashboard/inquinamentoPM25"})
public class DatiPm25 extends HttpServlet {

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
            out.println("<title>Servlet DatiPm25</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DatiPm25 at " + request.getContextPath() + "</h1>");
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
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/dashboard/inquinamentoPM25.jsp");
        DatiInquinamento dati = new DatiInquinamento();
        Document doc = Jsoup.connect("http://88.45.133.130/meteoambientecampania/php/pubblicazione_dati_centraline_valori_medi.php").get();
        URL url = new URL("http://localhost:8081/Baseline/dashboard/static/geojson/provinceCalabria.geojson");
        JsonElement jsonProvinceCalabria = new JsonParser().parse(new InputStreamReader(url.openConnection().getInputStream()));
        dati.populate(doc);
        CsvComuniReader comuni = new CsvComuniReader();
        Luogo luoghi = new Luogo();
        Gson gson = new Gson();
        request.setAttribute("pm25", gson.toJson(dati.getPm2_5()));
        request.setAttribute("luoghi", gson.toJson(luoghi));
        request.setAttribute("comuni", gson.toJson(comuni.getComuni()));
        request.setAttribute("provinceCalabria",gson.toJson(jsonProvinceCalabria));
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
