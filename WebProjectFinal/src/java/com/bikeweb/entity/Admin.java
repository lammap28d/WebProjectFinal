package com.bikeweb.entity;
// Generated Mar 5, 2017 10:44:25 AM by Hibernate Tools 4.3.1



/**
 * Admin generated by hbm2java
 */
public class Admin  implements java.io.Serializable {


     private int adminId;
     private String adminName;
     private String adminPassword;

    public Admin() {
    }

	
    public Admin(int adminId) {
        this.adminId = adminId;
    }
    public Admin(int adminId, String adminName, String adminPassword) {
       this.adminId = adminId;
       this.adminName = adminName;
       this.adminPassword = adminPassword;
    }
   
    public int getAdminId() {
        return this.adminId;
    }
    
    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }
    public String getAdminName() {
        return this.adminName;
    }
    
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getAdminPassword() {
        return this.adminPassword;
    }
    
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }




}


