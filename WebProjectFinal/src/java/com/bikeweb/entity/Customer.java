package com.bikeweb.entity;
// Generated Mar 5, 2017 10:44:25 AM by Hibernate Tools 4.3.1



/**
 * Customer generated by hbm2java
 */
public class Customer  implements java.io.Serializable {


     private int customerId;
     private String customerName;
     private String customerEmail;
     private String customerPhone;
     private String customerAddress;

    public Customer() {
    }

	
    public Customer(int customerId) {
        this.customerId = customerId;
    }
    public Customer(int customerId, String customerName, String customerEmail, String customerPhone, String customerAddress) {
       this.customerId = customerId;
       this.customerName = customerName;
       this.customerEmail = customerEmail;
       this.customerPhone = customerPhone;
       this.customerAddress = customerAddress;
    }
   
    public int getCustomerId() {
        return this.customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerEmail() {
        return this.customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String getCustomerPhone() {
        return this.customerPhone;
    }
    
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public String getCustomerAddress() {
        return this.customerAddress;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }




}


