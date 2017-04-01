<%-- 
    Document   : cart-content-page
    Created on : Mar 19, 2017, 2:30:42 PM
    Author     : Lam Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<form method="post" action="<c:url value="/cart.html?action=update"/>" >
<table class="table">
    <thead>

        <tr>
            <th>&nbsp;</th>     
            <th>&nbsp;</th>
            <th>Sản phẩm</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Tổng</th>
        </tr>

    </thead>
    <tbody>
        <c:forEach items="${cart.cartDetails}" var="cartDetail">


            <tr>
                <td>
                    <a href="<c:url value="/cart.html?action=delete&bikeId=${cartDetail.bike.bikeId}"/>">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </a>
                </td>


                <td>
                    <img width="105" height="70" src="data:image/png;base64,${cartDetail.bike.imageBase64}" >					</td>

                <td>
                    ${cartDetail.bike.bikeName}	</td>

                <td class="product-price">
                    <span class="amount">
                        <fmt:formatNumber type="number" 
            pattern="###,### đ" value="${cartDetail.cartDetailPrice}" />
                      </span>					
                </td>

                <td class="product-quantity">
                    <div class="quantity-adder">
                        <div class="quantity">
                            <input class="qty" name="cart[${cartDetail.bike.bikeId}]"step="1" min="0" value="${cartDetail.cartDetailQuantity}" title="SL" type="number" />
                        </div>
                    </div>					
                </td>

                <td class="product-subtotal">
                    <span class="amount">${cartDetail.cartDetailTotal}</span>					</td>
            </tr>

        </c:forEach>
        <tr>
            <td colspan="6" class="actions">
                <button class="btn btn-success" type="submit">Cập nhật Giỏ hàng</button>
            </td>
        </tr>
    </tbody>

</table>
     </form>
<div class="cart-collaterals">

    <div class="cart_totals ">


        <h2>Tổng số trong giỏ</h2>

        <table cellspacing="0">

            <tbody>

                <tr class="order-total">
                    <th>Tổng</th>
                    <td><strong><span class="amount">${cart.cartTotal}</span></strong> </td>
                </tr>


            </tbody></table>


        <div class="wc-proceed-to-checkout">

            <a href="<c:url value="/checkout.html"/>" class="checkout-button button alt wc-forward" >
                Thanh toán</a>

        </div>


    </div>

</div>
               
