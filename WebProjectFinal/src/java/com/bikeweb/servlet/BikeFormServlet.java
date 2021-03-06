/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikeweb.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bikeweb.entity.Bike;
import com.bikeweb.entity.Category;
import com.bikeweb.helper.BikeHelper;
import com.bikeweb.helper.CategoryHelper;
import java.io.PrintWriter;
import java.math.BigDecimal;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.hibernate.Session;

/**
 *
 * @author Lam Nguyen
 */
@WebServlet(urlPatterns = {"/bike-form"})
public class BikeFormServlet extends HttpServlet {

    private BikeHelper bikeHelper;
    private CategoryHelper categoryHelper;

    public BikeFormServlet() {
        this.categoryHelper = new CategoryHelper();
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
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Category> categories = categoryHelper.getAll();
        request.setAttribute("categories", categories);
        // Parse the request
        String action = request.getParameter("action");
        if (action == null) {
            request.getRequestDispatcher("/bike-form.jsp").forward(request,
                    response);
        } else {
            
            switch (action) {
                case "update":
                {
                    String bikeId = request.getParameter("bikeId");
                    if (bikeId != null) {
                        Bike bike = bikeHelper.find(Integer.parseInt(bikeId));
                        request.setAttribute("bike", bike);
                        request.getRequestDispatcher("/bike-form-update.jsp").forward(request,
                                response);
                    }
                    break;
                }

                case "save":
                {
                    try {
                        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                        if (isMultipart) {
                            List<FileItem> attachedFiles = new ArrayList<FileItem>();
                            // Create a factory for disk-based file items
                            DiskFileItemFactory factory = new DiskFileItemFactory();

                            // Configure a repository (to ensure a secure temp location is used)
                            ServletContext servletContext = request.getServletContext();
                            File repository = (File) servletContext
                                    .getAttribute("javax.servlet.context.tempdir");
                            factory.setRepository(repository);

                            // Create a new file upload handler
                            ServletFileUpload upload = new ServletFileUpload(factory);
                            List<FileItem> items = upload
                                    .parseRequest(new ServletRequestContext(request));
                            Iterator<FileItem> iter = items.iterator();
                            
                            String bikeId = getBikeId(items);
                            Bike bike;
                            if (bikeId == null) {
                                bike = new Bike();
                            } else {
                                bike = bikeHelper.find(Integer.parseInt(bikeId));
                            }
                            
                            while (iter.hasNext()) {
                                FileItem item = iter.next();
                                String name = item.getFieldName();
                                if (item.isFormField()) {
                                    if (item.getFieldName().equals("p-name")) {
                                        bike.setBikeName(Streams.asString(item.getInputStream(),"UTF-8"));
                                    }
                                    if (item.getFieldName().equals("p-price")) {
                                        String priceStr = item.getString();
                                        Double doubleprice = Double.valueOf(priceStr);

                                        BigDecimal price = BigDecimal.valueOf(doubleprice);
                                        bike.setPrice(price);

                                    }
                                    if (item.getFieldName().equals("p-description")) {
                                        bike.setDescription(Streams.asString(item.getInputStream(),"UTF-8"));

                                    }
                                    if (item.getFieldName().equals("p-brand")) {
                                        bike.setBrand(Streams.asString(item.getInputStream(),"UTF-8"));
                                    }

                                    if (item.getFieldName().equals("p-color")) {
                                        bike.setColor(Streams.asString(item.getInputStream(),"UTF-8"));
                                    }
                                    if (item.getFieldName().equals("p-category")) {

                                        String categoryIdStr = item.getString();
                                        Integer categoryId = Integer.valueOf(categoryIdStr);

                                        Category category = categoryHelper.find(categoryId);
                                        bike.setCategory(category);

                                    }

                                } else {
                                    byte[] bikeImg = item.get();
                                    if (bikeImg != null && bikeImg.length > 0) {
                                        bike.setImages(bikeImg);
                                    }
                                }
                            }

                            bikeHelper.save(bike);
                        }
                    } catch (FileUploadException e) {
                    }
                    response.sendRedirect("bikes.html");

                    break;
                }
                case "delete":
                {
                    String bikeId = request.getParameter("bikeId");
                    Bike bike = bikeHelper.find(Integer.parseInt(bikeId));
                    bikeHelper.delete(bike);
                    response.sendRedirect("bikes.html");
                    break;
                }
            }
        }
    }

    private String getBikeId(List<FileItem> items) {
        String bikeId = null;
        Iterator<FileItem> iter = items.iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            String name = item.getFieldName();
            if (item.isFormField()) {
                if (item.getFieldName().equals("p-id")) {
                    bikeId = item.getString();
                    break;
                }
            }
        }
        
        return bikeId;
    }

    // <editor-fold defaultstate="collapsed"
    // desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

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
