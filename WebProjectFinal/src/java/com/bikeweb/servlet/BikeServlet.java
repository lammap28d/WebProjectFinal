/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikeweb.servlet;

import com.bikeweb.entity.Bike;
import com.bikeweb.entity.Category;
import com.bikeweb.helper.BikeHelper;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lam Nguyen
 */
@WebServlet(urlPatterns = {"/bikes.html", "/bike.html"})
public class BikeServlet extends CommonServlet {

    private BikeHelper bikeHelper;

    public BikeServlet() {
        this.bikeHelper = new BikeHelper();
    }

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
        super.processRequest(request, response);
        String uri = request.getRequestURI();
        
        if (uri.equals("/WebProjectFinal/bikes.html")) {
            List<Bike> bikes;
            String categoryIdStr = request.getParameter("categoryId");
            if (categoryIdStr != null) {
                int categoryId = Integer.parseInt(categoryIdStr);
                bikes = bikeHelper.getBikeByCategoryId(categoryId);

            } else {
                bikes = bikeHelper.getAll();
            }
            request.setAttribute("bikes", bikes);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } else {
            String bikeIdStr = request.getParameter("bikeId");
            int bikeId = Integer.parseInt(bikeIdStr);
            Bike bike = bikeHelper.find(bikeId);
            request.setAttribute("bike", bike);
            request.getRequestDispatcher("/product.jsp").forward(request, response);
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
        processRequest(request, response);
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
