/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.modelo;

import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author aco-ec-029
 */
public class Client {
    @JsonView(Views.Public.class)
    private String id;
    @JsonView(Views.Public.class)
    private String name;
    @JsonView(Views.Public.class)
    private String firstName;
    @JsonView(Views.Public.class)
    private String lastName;
    @JsonView(Views.Public.class)
    private String address;
    @JsonView(Views.Public.class)
    private String phone;
    @JsonView(Views.Public.class)
    private String mobilePhone;
    @JsonView(Views.Public.class)
    private String office;
    @JsonView(Views.Public.class)
    private String status;
    @JsonView(Views.Public.class)
    private String document;

    public Client(String id, String name, String firstName, String lastName, String address, String phone, String mobilePhone, String office, String status, String document) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.mobilePhone = mobilePhone;
        this.office = office;
        this.status = status;
        this.document = document;
    }

    public Client() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
