/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.servicioweb.implement_service;

import edu.mx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import edu.mx.tecnm.oaxaca.servicioweb.repository.ClienteRepository;
import edu.mx.tecnm.oaxaca.servicioweb.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author maste
 */
@Service
public class ClienteServiceImplement implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public void createCliente(ClienteModel cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List getClientes() {
        return clienteRepository.findAll();
    }
    
}
