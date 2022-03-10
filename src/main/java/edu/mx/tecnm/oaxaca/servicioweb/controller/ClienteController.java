package edu.mx.tecnm.oaxaca.servicioweb.controller;

import edu.mx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import edu.mx.tecnm.oaxaca.servicioweb.repository.ClienteRepository;
import edu.mx.tecnm.oaxaca.servicioweb.service.ClienteService;
import edu.mx.tecnm.oaxaca.servicioweb.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author maste
 */
@RestController
@RequestMapping(path="/api/v1/cliente")
public class ClienteController {
    
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    public ClienteController(ClienteRepository clienteRepository){
    
        this.clienteRepository = clienteRepository;
    }
    
    
    @PostMapping("/")
    public CustomResponse createCliente(@RequestBody ClienteModel clienteModel){
        CustomResponse customResponse= new CustomResponse();
        clienteService.createCliente(clienteModel);
        return customResponse;
    }
    
    @GetMapping("/show")
    public CustomResponse getClientes(){
    
        CustomResponse customResponse = new CustomResponse();
        customResponse.setDato(clienteService.getClientes());
        return customResponse;
    }
    
    @DeleteMapping("/delete/{id_cliente}")
    public ResponseEntity<ClienteModel> delete(@PathVariable String id_cliente){
        clienteRepository.deleteById(Integer.parseInt(id_cliente));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
