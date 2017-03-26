/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikeweb.model;

import com.bikeweb.entity.Bike;
import com.bikeweb.entity.Order;
import java.math.BigDecimal;

/**
 *
 * @author Lam Nguyen
 */
public class CartItem {

    private String bikeName;
    private BigDecimal bikePrice;
    private Bike bike;
    private Cart cart;
    private BigDecimal cartDetailPrice;
    private Integer cartDetailQuantity;
    private BigDecimal cartDetailTotal;

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }

    public BigDecimal getBikePrice() {
        return bikePrice;
    }

    public void setBikePrice(BigDecimal bikePrice) {
        this.bikePrice = bikePrice;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public BigDecimal getCartDetailPrice() {
        return cartDetailPrice;
    }

    public void setCartDetailPrice(BigDecimal cartDetailPrice) {
        this.cartDetailPrice = cartDetailPrice;
    }

    public Integer getCartDetailQuantity() {
        return cartDetailQuantity;
    }

    public void setCartDetailQuantity(Integer cartDetailQuantity) {
        this.cartDetailQuantity = cartDetailQuantity;
    }

    public BigDecimal getCartDetailTotal() {
        BigDecimal quantiy = new BigDecimal(this.getCartDetailQuantity());
        return this.bike.getPrice().multiply(quantiy);

    }

    public void setCartDetailTotal(BigDecimal cartDetailTotal) {
        this.cartDetailTotal = cartDetailTotal;
    }

}
