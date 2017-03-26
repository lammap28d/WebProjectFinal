/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bikeweb.model;

import com.bikeweb.entity.User;
import com.bikeweb.entity.OrderDetail;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Lam Nguyen
 */
public class Cart {

    private User user;
    private Integer cartQuantity;
    private Set<CartItem> cartDetails = new HashSet<CartItem>(0);

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getCartTotal() {
        Iterator<CartItem> itr = cartDetails.iterator();
        BigDecimal total = BigDecimal.ZERO;
        while (itr.hasNext()) {
            CartItem o = itr.next();
            total = total.add(o.getCartDetailTotal());
        }
        return total;

    }

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Set<CartItem> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(Set<CartItem> cartDetails) {
        this.cartDetails = cartDetails;
    }

}
