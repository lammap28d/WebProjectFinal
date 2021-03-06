package com.bikeweb.entity;
// Generated Mar 26, 2017 3:19:26 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

/**
 * Bike generated by hbm2java
 */
public class Bike  implements java.io.Serializable {


     private int bikeId;
     private Category category;
     private String bikeName;
     private String description;
     private BigDecimal price;
     private String brand;
     private String color;
     private byte[] images;
     private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>(0);

    public Bike() {
    }

	
    public Bike(int bikeId) {
        this.bikeId = bikeId;
    }
    public Bike(int bikeId, Category category, String bikeName, String description, BigDecimal price, String brand, String color, byte[] images, Set<OrderDetail> orderDetails) {
       this.bikeId = bikeId;
       this.category = category;
       this.bikeName = bikeName;
       this.description = description;
       this.price = price;
       this.brand = brand;
       this.color = color;
       this.images = images;
       this.orderDetails = orderDetails;
    }
   
    public int getBikeId() {
        return this.bikeId;
    }
    
    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getBikeName() {
        return this.bikeName;
    }
    
    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public BigDecimal getPrice() {
        return this.price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public byte[] getImages() {
        return this.images;
    }
    
    public void setImages(byte[] images) {
        this.images = images;
    }
    public Set<OrderDetail> getOrderDetails() {
        return this.orderDetails;
    }
    
    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getImageBase64() {
        return new String(Base64.getEncoder().encode(getImages()));
    }

}


