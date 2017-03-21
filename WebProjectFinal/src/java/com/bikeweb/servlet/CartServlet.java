///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.bikeweb.servlet;
//
//import com.bikeweb.entity.Bike;
//import com.bikeweb.entity.Customer;
//import com.bikeweb.entity.Order;
//import com.bikeweb.entity.OrderDetail;
//import com.bikeweb.helper.BikeHelper;
//import com.bikeweb.helper.CategoryHelper;
//import com.bikeweb.helper.CustomerHelper;
//import com.bikeweb.helper.OrderHelper;
//import com.bikeweb.model.Cart;
//import com.bikeweb.model.CartItem;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.util.HashSet;
//import java.util.Set;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author Lam Nguyen
// */
//@WebServlet(name = "CartServlet", urlPatterns = {"/cart.html", "/checkout.html"})
//public class CartServlet extends HttpServlet {
//
//    private BikeHelper bikeHelper;
//     private OrderHelper orderHelper;
//      private CustomerHelper customerHelper;
//    public CartServlet() {
//
//        this.bikeHelper = new BikeHelper();
//        this.orderHelper= new OrderHelper();
//        this.customerHelper=new CustomerHelper();
//    }
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        String uri = request.getRequestURI();
//        if ((uri.equals("/WebProjectFinal/checkout.html"))) {
//            request.getRequestDispatcher("/checkout.jsp").forward(request, response);
//            
//            HttpSession session = request.getSession(true);
//            Order order = (Order) session.getAttribute("order");
//            Customer cus = this.customerHelper.find(1);
//            order.setCustomer(cus);
//            orderHelper.save(order);
//            
//            
//        } else {
//            String bikeid = request.getParameter("bikeID");
//            int id = Integer.parseInt(bikeid);
//
//            String quantity = request.getParameter("qty");
//            int qty = Integer.parseInt(quantity);
//
//            HttpSession session = request.getSession(true);
//            Cart cart = (Cart) session.getAttribute("cart");
//            if (cart == null) {
//                cart = new Cart();
//
//                session.setAttribute("cart", cart);
//            }
//
//            CartItem cartItem = new CartItem();
//
//            Bike bike = bikeHelper.find(id);
//            cartItem.s
//
//            orderDetail.setOrderDetailQuantity(qty);
//            orderDetail.setOrderDetailPrice(bike.getPrice());
//
//            Set<OrderDetail> orderdetails = order.getOrderDetails();
//            orderdetails.add(orderDetail);
//
//            order.setOrderDetails(orderdetails);
//
//            request.setAttribute("order", order);
//
//            request.getRequestDispatcher("/cart.jsp").forward(request, response);
//        }
//
//    }
//
//// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//}
