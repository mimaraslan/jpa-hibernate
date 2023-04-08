package com.mimaraslan.model;

import java.util.HashSet;
import java.util.Set;

public class Address {

    private int addressId;
    private String street;
    private String city;
    private String country;
    private String type;
    private Set<Customer> customers = new HashSet<Customer>(0);

    public Address() {
    }

    public Address(String street, String city, String country, String type) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}