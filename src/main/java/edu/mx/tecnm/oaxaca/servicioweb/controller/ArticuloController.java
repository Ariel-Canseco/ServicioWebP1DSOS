/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.servicioweb.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maste
 */
@RestController
@RequestMapping("/api/v1/articulo")
public class ArticuloController {
    
    @PostMapping("/")
    public String createArticulo(){
        return "Se creo el producto";
    }
}
