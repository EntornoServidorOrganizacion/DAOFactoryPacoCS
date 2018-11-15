/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.DAO.IAvistamientosDAO;
import es.albarregas.DAOFACTORY.DAOFactory;
import es.albarregas.beans.Avistamientos;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paco
 */
@WebServlet(name = "ControladorDatosSalida", urlPatterns = {"/ControladorDatosSalida"})
public class ControladorDatosSalida extends HttpServlet {

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
        String url = null;
        Properties prop = new Properties();
        prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("seleccionaBBDD.properties"));
        String bbdd = prop.getProperty("tipoBBDD");

        if (request.getParameter("anillaboton") != null && request.getParameter("anilla").length() < 3) {

            url = "entrada.jsp";

        } else if (request.getParameter("anillaboton") != null && request.getParameter("anilla").length() == 3) {

            DAOFactory daof = DAOFactory.getDAOFactory(Integer.parseInt(bbdd));
            IAvistamientosDAO dao = daof.getAvistamientosDAO();
            ArrayList<Avistamientos> avistamiento = dao.getAvistamientos();

            request.setAttribute("avistamiento", avistamiento);
            url = "salida.jsp";

        } else {

            request.setAttribute("error", "No se han pasado parámetros");
            url = "error.jsp";

        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}
