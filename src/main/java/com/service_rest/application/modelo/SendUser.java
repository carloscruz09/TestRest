/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.modelo;

import java.util.Objects;

/**
 *
 * @author aco-ec-029
 */
public class SendUser {
    
    private String username;
    private String password;
    private String roleName;
    private String roleDescription;
    private String addressStreet;
    private String addressIntNumber;
    private String addressExtNumber;
    private String addressNeighbourhood;

    public SendUser(String username, String password, String roleName, String roleDescription, String addressStreet, String addressIntNumber, String addressExtNumber, String addressNeighbourhood) {
        this.username = username;
        this.password = password;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.addressStreet = addressStreet;
        this.addressIntNumber = addressIntNumber;
        this.addressExtNumber = addressExtNumber;
        this.addressNeighbourhood = addressNeighbourhood;
    }

    public SendUser() {
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressIntNumber() {
        return addressIntNumber;
    }

    public void setAddressIntNumber(String addressIntNumber) {
        this.addressIntNumber = addressIntNumber;
    }

    public String getAddressExtNumber() {
        return addressExtNumber;
    }

    public void setAddressExtNumber(String addressExtNumber) {
        this.addressExtNumber = addressExtNumber;
    }

    public String getAddressNeighbourhood() {
        return addressNeighbourhood;
    }

    public void setAddressNeighbourhood(String addressNeighbourhood) {
        this.addressNeighbourhood = addressNeighbourhood;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SendUser other = (SendUser) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
}
