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
public class MensajeError {
    
    @JsonView(Views.Public.class)
    private String code;
    
    @JsonView(Views.Public.class)
    private String message;

    public MensajeError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
