<%-- 
    Document   : cart-content-page
    Created on : Mar 19, 2017, 2:30:42 PM
    Author     : Lam Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<table>
    <thead>

        <tr>

            <th class="product-thumbnail">&nbsp;</th>
            <th class="product-name">Sản phẩm</th>
            <th class="product-price">Giá</th>
            <th class="product-quantity">Số lượng</th>
            <th class="product-subtotal">Tổng</th>
        </tr>

    </thead>
    <tbody>
        <c:forEach items="${order.orderDetails}" var="orderDetail">


            <tr class="cart_item">



                <td class="product-thumbnail">
                    <img width="105" height="70" src="data:image/png;base64,${orderDetail.bike.imageBase64}" >					</td>

                <td class="product-name">
                    ${orderDetail.bike.bikeName}	</td>

                <td class="product-price">
                    <span class="amount">${orderDetail.orderDetailPrice}</span>					</td>

                <td class="product-quantity">
                    <div class="quantity-adder">
                        <div class="quantity">${orderDetail.orderDetailQuantity}

                        </div>
                    </div>					</td>

                <td class="product-subtotal">
                    <span class="amount">${orderDetail.orderDetailTotal}</span>					</td>
            </tr>
        </c:forEach>

    </tbody>

</table>
<div class="cart-collaterals">

    <div class="cart_totals ">


        <h2>Tổng số trong giỏ</h2>

        <table cellspacing="0">

            <tbody>

                <tr class="order-total">
                    <th>Tổng</th>
                    <td><strong><span class="amount">${order.orderTotal}</span></strong> </td>
                </tr>


            </tbody></table>


        <div class="wc-proceed-to-checkout">

            <a href="<c:url value="/checkout.html"/>" class="checkout-button button alt wc-forward" >
                Thanh toán</a>

        </div>


    </div>

</div>
