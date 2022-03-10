/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.servicioweb.utils;

import java.util.LinkedList;

/**
 *
 * @author maste
 */
public class CustomResponse {
    //Comprobar si todo se hizo correctamente
    private Integer httpCode; //Como va a responder
    private Object dato; //El dato que voy a regresar
    private String mensaje;

    public CustomResponse() {
    
        this.httpCode = 200; //Petición exitosa
        this.dato = new LinkedList();
        this.mensaje = "OK";
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
