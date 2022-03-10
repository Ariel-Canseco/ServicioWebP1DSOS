
package edu.mx.tecnm.oaxaca.servicioweb.controller;

import edu.mx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import edu.mx.tecnm.oaxaca.servicioweb.service.ClienteService;
import edu.mx.tecnm.oaxaca.servicioweb.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author maste
 */
@RestController
@RequestMapping(path="/api/v1/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @PostMapping("/")
    public CustomResponse createCliente(@RequestBody ClienteModel clienteModel){
        CustomResponse customResponse= new CustomResponse();
        clienteService.createCliente(clienteModel);
        return customResponse;
    }
    
    @GetMapping("/")
    public CustomResponse getClientes(){
    
        CustomResponse customResponse = new CustomResponse();
        customResponse.setDato(clienteService.getClientes());
        return customResponse;
    }
}
