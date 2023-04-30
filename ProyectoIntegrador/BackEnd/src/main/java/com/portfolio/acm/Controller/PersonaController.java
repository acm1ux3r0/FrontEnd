/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.acm.Controller;

import com.portfolio.acm.Entity.Persona;
import com.portfolio.acm.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acm1ux3r0
 */

        //  Entidad --> Repositorio --> Interface --> Service --> CONTROLLER

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")

public class PersonaController {
      
    @Autowired
    IPersonaService ipersonaService;    
    
                //<<<<<<<<  MÉTODOS    >>>>>>>>>
    
    //TRAER Lista de Personas.
    @GetMapping("personas/traer")//Lo podrá hacer tanto usuario como admin.
    /* @GetMapping("personas/traer") Es la forma en que el Front, dependiendo de la URL que le pasemos
        (por ejemplo: "personas/traer") va ejecutar el método correspondiente */
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();        
    }
    
    //CREAR una persona en particular.
    @PreAuthorize("hasRole('ADMIN')")//Anotación para que solamente el usuario con ROL ADMIN pueda CREAR.
    @PostMapping("/personas/crear")//Para guardar en la Base de datos (DB).
    public String createPersona(@RequestBody Persona persona){/*@RequestBody: para traer los datos del
                                                                Front al Back */
        ipersonaService.savePersona(persona);
        return "La persona fue creada correctamente";
    }
    
    //BORRAR una persona.
    @PreAuthorize("hasRole('ADMIN')")//Anotación para que solamente el usuario con ROL ADMIN pueda BORRAR
    @DeleteMapping("/personas/borrar/{id}/") //La forma de pasarle el ID es encerrandolo con {variable "id"}.
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    //EDITAR una persona o usuario.    
    @PreAuthorize("hasRole('ADMIN')")
    //Va a quedar: URL:PUERTO/personas/editar/4(id del usuario)/(parámetro)nombre & apellido & img
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,/*nuevoNombre es el nombre de la
                                                                            variable que va a contener 
                                                                            el dato que tiene que poner
                                                                            la otra variable: ("nombre")*/
                               @RequestParam("apellido") String nuevoApellido,/*nuevoApellido es el nombre de la
                                                                            variable que va a contener 
                                                                            el dato que tiene que poner
                                                                            la otra variable: ("apellido")*/                               
                               @RequestParam("img") String nuevoImg){/*nuevoImg es el nombre de la
                                                                            variable que va a contener 
                                                                            el dato que tiene que poner
                                                                            la otra variable: ("img")*/
        Persona persona = ipersonaService.findPersona(id);

        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);

        ipersonaService.savePersona(persona);//para que ipersonaService guarde el objeto Persona de LINE 84.
        return persona;// ipersonaservice se va a ancargar de mandarlo a la ENTIDAD.
    }

      /*
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long)1);
    } */ 
}
  /*
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
}

/*
@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired
    ImpPersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id")int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Persona persona = personaService.getOne(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        //persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());
        
        personaService.save(persona);
        
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
        */
   
