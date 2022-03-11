/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mx.tecnm.oaxaca.servicioweb.repository;

import edu.mx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author maste
 */
@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer >{
    //public ClienteModel findByName(String nombre);
    
    //public ClienteModel findByRFC(String rfc);
}
