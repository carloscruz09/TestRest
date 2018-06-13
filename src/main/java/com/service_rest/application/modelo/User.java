/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.modelo;

import com.fasterxml.jackson.annotation.JsonView;

/**
 *
 * @author amk-diseno
 */
public class User {
    
    @JsonView(Views.Public.class)
    private String id;
    @JsonView(Views.Public.class)
    private String username;
    @JsonView(Views.Internal.class)
    private String password;
    @JsonView(Views.Public.class)
    private Role role;
    @JsonView(Views.Public.class)
    private Domicilio domicilio;
    

    public User() {
    }

    public User(String id, String username, String password, Role role, Domicilio domicilio) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.domicilio = domicilio;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }
    
    
}
