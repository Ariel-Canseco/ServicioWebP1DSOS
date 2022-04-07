package edu.mx.tecnm.oaxaca.servicioweb.controller;

import edu.mx.tecnm.oaxaca.servicioweb.model.ClienteModel;
import edu.mx.tecnm.oaxaca.servicioweb.repository.ClienteRepository;
import edu.mx.tecnm.oaxaca.servicioweb.service.ClienteService;
import edu.mx.tecnm.oaxaca.servicioweb.utils.CustomResponse;
import java.util.List;
import javax.transaction.Transactional;
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
@CrossOrigin(origins="*")//"http://127.0.0.1:5500" or "*"
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
    public List<ClienteModel> getClientes(){
    
        /*CustomResponse customResponse = new CustomResponse();
        customResponse.setDato(clienteService.getClientes());
        return customResponse;*/
        
        return clienteService.getClientes();
    }
    
    @Transactional
    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteModel> put(@PathVariable String idCliente,
            @ModelAttribute ClienteModel cliente){
        ClienteModel clienteModel = clienteRepository.findById(Integer.parseInt(idCliente))
                .orElseThrow(() -> new IllegalStateException("El cliente no existe"));
        clienteModel.setNombre(cliente.getNombre());
        clienteModel.setPrimerApellido(cliente.getPrimerApellido());
        clienteModel.setSegundoApellido(cliente.getSegundoApellido());
        clienteModel.setRfc(cliente.getRfc());
        clienteRepository.save(clienteModel);
        return new ResponseEntity<>(clienteModel, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{idCliente}")
    public CustomResponse deleteCliente(@PathVariable Integer idCliente){
    
        CustomResponse customResponse = new CustomResponse();
        clienteService.deleteCliente(idCliente);
        return customResponse;
    }
/*
    @DeleteMapping("/delete/{id_cliente}")
    public ResponseEntity<ClienteModel> delete(@PathVariable String idCliente){
        clienteRepository.deleteById(Integer.parseInt(idCliente));
        //ClienteModel clienteModel = clienteRepository.deleteById(Integer.parseInt(idCliente));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
   */


}
