/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.modelo;

/**
 *
 * @author amk-diseno
 */
public class Domicilio {
    
    private String calle;
    private String numeroInt;
    private String numeroExt;
    private String colonia;

    public Domicilio(String calle, String numeroInt, String numeroExt, String colonia) {
        this.calle = calle;
        this.numeroInt = numeroInt;
        this.numeroExt = numeroExt;
        this.colonia = colonia;
    }

    public Domicilio() {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

    public String getNumeroExt() {
        return numeroExt;
    }

    public void setNumeroExt(String numeroExt) {
        this.numeroExt = numeroExt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
}
