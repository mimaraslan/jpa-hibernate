package com.mimaraslan.model;

import java.util.Date;

public class CustomerDetail {

    private int customerId;//Hangi tabloya bagliysa ona ait id alani.
    private String address;
    private String tel;
    private Date creationDate;
    private Customer customer;//Bagli oldugu tablo yabanci foreign

    public CustomerDetail() {
    }

    public CustomerDetail(String address, String tel, Date creationDate) {
        this.address = address;
        this.tel = tel;
        this.creationDate = creationDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}