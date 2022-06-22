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
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    public ClienteController(ClienteRepository clienteRepository){
    
        this.clienteRepository = clienteRepository;
    }
    
   /* 
    @PostMapping("/")
    public CustomResponse createCliente(@RequestBody ClienteModel clienteModel){
        CustomResponse customResponse= new CustomResponse();
        clienteService.createCliente(clienteModel);
        return customResponse;
    }*/
    
    @GetMapping("/show")
    public List<ClienteModel> getClientes(){
    
        /*CustomResponse customResponse = new CustomResponse();
        customResponse.setDato(clienteService.getClientes());
        return customResponse;*/
        
        return clienteService.getClientes();
    }
    
    // get client by id
    @GetMapping("/show/{idCliente}")
    public ResponseEntity<ClienteModel> getClientById(@PathVariable String idCliente){
        ClienteModel cliente = clienteRepository.findById(Integer.parseInt(idCliente))
                .orElseThrow(() -> new IllegalStateException("Cliente no existe con el id: "+ idCliente));
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
    
    @PostMapping("/")
    public ResponseEntity<ClienteModel> createCliente(@RequestBody ClienteModel clienteModel){
        ClienteModel cliente = clienteRepository.save(clienteModel);
        if(clienteModel == null)
        
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
        
    }
    
    @Transactional
    @PutMapping("/{idCliente}")
    public ResponseEntity<ClienteModel> put(@PathVariable String idCliente,
            @RequestBody ClienteModel cliente){
        ClienteModel clienteModel = clienteRepository.findById(Integer.parseInt(idCliente))
                .orElseThrow(() -> new IllegalStateException("El cliente no existe"));
        clienteModel.setNombre(cliente.getNombre());
        clienteModel.setPrimerApellido(cliente.getPrimerApellido());
        clienteModel.setSegundoApellido(cliente.getSegundoApellido());
        clienteModel.setRfc(cliente.getRfc());
        clienteRepository.save(clienteModel);
        return new ResponseEntity<>(clienteModel, HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/update/{idCliente}")
    public ResponseEntity<ClienteModel> updateCliente(@PathVariable Integer idCliente, @RequestBody ClienteModel clienteModel){
        ClienteModel cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new IllegalStateException("Cliente no existe con el id : "+idCliente));
        
               cliente.setNombre(clienteModel.getNombre());
        cliente.setPrimerApellido(clienteModel.getPrimerApellido());
        cliente.setSegundoApellido(clienteModel.getSegundoApellido());
        cliente.setRfc(clienteModel.getRfc());
        ClienteModel updatedCliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(updatedCliente);
        
    }
    
    /*@DeleteMapping("/delete/{id_cliente}")
    public ResponseEntity<ClienteModel> delete(@PathVariable String idCliente){
             return new ResponseEntity<>(null, HttpStatus.OK);
        try{
        clienteRepository.deleteById(Integer.parseInt(idCliente));
        //ClienteModel clienteModel = clienteRepository.deleteById(Integer.parseInt(idCliente));
        return new ResponseEntity<>(null, HttpStatus.OK);
        }catch(Exception e){
            System.out.println(e);
                    return new ResponseEntity<>(null, HttpStatus.OK);

        }
        
    }*/
    
    @CrossOrigin
    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<ClienteModel> delete(@PathVariable String idCliente){
        System.out.println("Sext");
        //ClienteModel cliente = clienteService.deleteCliente(Integer.parseInt(idCliente))
                //.orElseThrow(() -> new IllegalStateException("Error al obtener el cliente"));
        clienteService.deleteCliente(Integer.parseInt(idCliente));
        //cliente.setPaymentStatus('D');
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
    /*
    @DeleteMapping("/delete/{idCliente}")
    public CustomResponse deleteCliente(@PathVariable Integer idCliente){
    
        CustomResponse customResponse = new CustomResponse();
        clienteService.deleteCliente(idCliente);
        return customResponse;
    }*/

}
