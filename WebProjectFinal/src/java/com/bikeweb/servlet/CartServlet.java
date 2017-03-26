/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikeweb.servlet;

import com.bikeweb.entity.Bike;
import com.bikeweb.entity.User;
import com.bikeweb.entity.Order;
import com.bikeweb.entity.OrderDetail;
import com.bikeweb.helper.BikeHelper;
import com.bikeweb.helper.CategoryHelper;
import com.bikeweb.helper.UserHelper;
import com.bikeweb.helper.OrderHelper;
import com.bikeweb.model.Cart;
import com.bikeweb.model.CartItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lam Nguyen
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart.html", "/checkout.html", "/orderComplete.html"})
public class CartServlet extends HttpServlet {

    private BikeHelper bikeHelper;
    private OrderHelper orderHelper;
    private UserHelper userHelper;

    public CartServlet() {

        this.bikeHelper = new BikeHelper();
        this.orderHelper = new OrderHelper();
        this.userHelper = new UserHelper();
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

        response.setContentType("text/html;charset=UTF-8");

        String uri = request.getRequestURI();
        if ((uri.equals("/WebProjectFinal/checkout.html"))) {
            HttpSession session = request.getSession(true);
            Cart cart = (Cart) session.getAttribute("cart");
            request.setAttribute("cart", cart);

            request.getRequestDispatcher("/checkout.jsp").forward(request, response);

        } else if ((uri.equals("/WebProjectFinal/orderComplete.html"))) {
            request.getRequestDispatcher("/order-complete.jsp").forward(request, response);
        } else {
            String action = request.getParameter("action");
            switch (action) {
                case "add": {
                    String bikeId = request.getParameter("bikeID");
                    int bikeIdVal = Integer.parseInt(bikeId);

                    String quantity = request.getParameter("qty");
                    int qty = Integer.parseInt(quantity);

                    HttpSession session = request.getSession(true);
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart == null) {
                        cart = new Cart();

                        session.setAttribute("cart", cart);
                    }

                    Set<CartItem> cartDetails = cart.getCartDetails();
                    Iterator<CartItem> iter = cartDetails.iterator();

                    boolean exist = false;
                    while (iter.hasNext()) {
                        CartItem cartItemTemp = iter.next();

                        if (cartItemTemp.getBike().getBikeId() == bikeIdVal) {
                            cartItemTemp.setCartDetailQuantity(cartItemTemp.getCartDetailQuantity() + qty);
                            exist = true;
                            break;
                        }
                    }

                    if (!exist) {
                        CartItem cartItem = new CartItem();

                        Bike bike = bikeHelper.find(bikeIdVal);
                        cartItem.setBike(bike);

                        cartItem.setCartDetailQuantity(qty);
                        cartItem.setCartDetailPrice(bike.getPrice());

                        cartDetails.add(cartItem);
                    }

                    cart.setCartDetails(cartDetails);

                    request.setAttribute("cart", cart);

                    //request.getRequestDispatcher("/cart.jsp").forward(request, response);
                    response.sendRedirect("cart.html?action=view");
                }
                break;
                case "view": {
                    HttpSession session = request.getSession(true);
                    Cart cart = (Cart) session.getAttribute("cart");
                    request.setAttribute("cart", cart);
                    request.getRequestDispatcher("/cart.jsp").forward(request, response);
                }
                break;
                case "save": {
                    HttpSession session = request.getSession(true);
                    Cart cart = (Cart) session.getAttribute("cart");

                    Order order = new Order();
                    User user = new User();
                    user.setFirstName(request.getParameter("first_name"));
                    user.setLastName(request.getParameter("last_name"));
                    user.setEmail(request.getParameter("email"));
                    user.setPhone(request.getParameter("phone"));
                    user.setAddress(request.getParameter("address"));
                    userHelper.save(user);

                    order.setOrderTotal(cart.getCartTotal());
                    order.setOrderQuantity(cart.getCartQuantity());

                    Set<OrderDetail> orderDetails = order.getOrderDetails();

                    Iterator<CartItem> iter = cart.getCartDetails().iterator();
                    while (iter.hasNext()) {
                        CartItem cartItem = iter.next();

                        OrderDetail orderDetail = new OrderDetail();
                        orderDetail.setBike(cartItem.getBike());
                        orderDetail.setOrder(order);
                        orderDetail.setOrderDetailPrice(cartItem.getCartDetailPrice());
                        orderDetail.setOrderDetailQuantity(cartItem.getCartDetailQuantity());
                        orderDetail.setOrderDetailTotal(cartItem.getCartDetailTotal());

                        orderDetails.add(orderDetail);
                    }
                    order.setOrderDetails(orderDetails);
                    order.setUser(user);
                    orderHelper.save(order);
                    session.removeAttribute("cart");
                    response.sendRedirect("orderComplete.html");

                }
                break;
            }
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
