
package edu.mx.tecnm.oaxaca.servicioweb.controller;

import java.util.List;
import org.graalvm.compiler.options.Option;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ariel
 */
@RestController
//@RequestMapping("/api/v1/ejemplo")
public class IndexController {
    
    /*public List<Object> getPersonas(){
    
        return List.of(
                "Pedro", 
                "Martinez", 
                "Alvarado", 20 
                );
    }
    
    @RequestMapping(value="/indexController", method = RequestMethod.OPTIONS)
    ResponseEntity<?> collectionOptions(){
    
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,HttpMethod.POST, HttpMethod.OPTIONS)
                .build();
    }
*/
    @GetMapping("/") //Llamada a raiz (dominio princiapl)
    public String index(){
        return "<h1>Holis soy tu servidor en Spring :P</h1>";
    }
    
    /*
    
    @GetMapping("/ParaMiPersonaFavorita") //Llamada a raiz (dominio princiapl)
    public String hani(){
        return "<h1>Si quiero que vayas, pero te quiero dedicar el tiempo que te mereces y no solo ratos esporádicos. \"♥\"</h1>";
    }
    
    @GetMapping("/ejemplo") //Llamada a raiz (dominio princiapl)
    public String ejemploPeticionPost(){
        return "<h1>soy la ruta EJEMPLO</h1>";
    }
    
    @GetMapping("/ejemplo/retorno/numero")
    public Integer ejemploEntero(){
    
        return (int) (Math.random()+1 * 100);
    }
    
    //Haciendo un post
    @PostMapping("/saludar")
    public String saludar(String name){
        String saludo = "Hola soy tu servidor mucho gusto ";
        return saludo.concat(name == null ? "Estaba en null" : name);
    }
    
    @PutMapping("/agregar")
    public String agregar(String frase){
        String add = "Esta es una función para agregar ";
        return add.concat(frase == null ? "Estaba en null" : frase);
    }
    
    @PutMapping("/agregar/lista")
    public List<Object> addLista(){ //(List lista)
        //String add = "Esta es una función para agregar ";
        return getPersonas();
    }
    
    @DeleteMapping("/eliminar")
    public String eliminar(){
        //String del = "Esta es una función para eliminar ";
        return "HTTP DELETE request was sent";//del.concat(frase == null ? "Estaba en null" : frase);
    }
    
    @PatchMapping("/modificar")
    public String actualizar(){
    
        return "HTTP PATCH request was sent";
    }
    */
    //@Option("/ejemplo/opcion")
    //public String opciones()
}
