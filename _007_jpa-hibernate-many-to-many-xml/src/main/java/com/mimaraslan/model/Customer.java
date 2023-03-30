package com.mimaraslan.model;

import java.util.HashSet;
import java.util.Set;

public class Customer {

    private int customerId;
    private String title;
    private String name;
    private Set<Address> addresses = new HashSet<Address>(0);

    public Customer() {
    }

    public Customer(String title, String name, Set<Address> addresses) {
        this.title = title;
        this.name = name;
        this.addresses = addresses;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}