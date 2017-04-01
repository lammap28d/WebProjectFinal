<%-- 
    Document   : checkout-content-page
    Created on : Mar 26, 2017, 2:30:50 PM
    Author     : Lam Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<div>
    <form name="checkout" method="post" action="<c:url value="/cart.html?action=save"/>" >
        <div class="col2-set">
            <div class="col-1">
                <div >
                    <h3>Địa chỉ thanh toán</h3>
                    <p><label for="billing_first_name" class="">Họ <abbr class="required" title="bắt buộc">*</abbr></label><input class="input-text " name="first_name" id="billing_first_name" placeholder="" value="" type="text"></p>
                    <p><label for="billing_last_name" class="">Tên <abbr class="required" title="bắt buộc">*</abbr></label><input class="input-text " name="last_name" id="billing_last_name" placeholder="" value="" type="text"></p><div class="clear"></div>
                    <p><label for="billing_email" class="">Địa chỉ email <abbr class="required" title="bắt buộc">*</abbr></label><input class="input-text " name="email" id="billing_email" placeholder="" value="" type="email"></p>
                    <p><label for="billing_phone" class="">Số điện thoại <abbr class="required" title="bắt buộc">*</abbr></label><input class="input-text " name="phone" id="billing_phone" placeholder="" value="" type="tel"></p><div class="clear"></div>
                    <p><label for="billing_address_1" class="">Địa chỉ <abbr class="required" title="bắt buộc">*</abbr></label><input class="input-text " name="address" id="billing_address_1" placeholder="Địa chỉ" value="" type="text"></p>
                </div>			
            </div>
           
        </div>
        <h3 >Đơn hàng của bạn</h3>
        <div >
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
                <c:forEach items="${cart.cartDetails}" var="cartDetail">


                    <tr class="cart_item">



                        <td class="product-thumbnail">
                            <img width="105" height="70" src="data:image/png;base64,${cartDetail.bike.imageBase64}" >					</td>

                        <td class="product-name">
                            ${cartDetail.bike.bikeName}	</td>

                        <td class="product-price">
                            <span class="amount">${cartDetail.cartDetailPrice}</span>					</td>

                        <td class="product-quantity">
                            <div class="quantity-adder">
                                <div class="quantity">${cartDetail.cartDetailQuantity}

                                </div>
                            </div>					</td>

                        <td class="product-subtotal">
                            <span class="amount">${cartDetail.cartDetailTotal}</span>					</td>
                    </tr>
                </c:forEach>

                </tbody>

            </table>
        </div>
        <input class="button alt" name="woocommerce_checkout_place_order" id="place_order" value="Đặt hàng" data-value="Đặt hàng" type="submit">
    </form>
</div>
