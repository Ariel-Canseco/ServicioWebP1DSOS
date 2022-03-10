/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.servicioweb.service;

import edu.mx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import java.util.List;

/**
 *
 * @author maste
 */

public interface ClienteService {

    public void createCliente(ClienteModel cliente);
    public List getClientes();
}
