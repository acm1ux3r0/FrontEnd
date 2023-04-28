/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Controller;

import com.portfolio.acm.Dto.dtoHys;
<<<<<<< Updated upstream
import com.portfolio.acm.Entity.Hys;
import com.portfolio.acm.Security.Controller.Mensaje;
import com.portfolio.acm.Service.SHys;
=======
import com.portfolio.acm.Entity.hys;
import com.portfolio.acm.Security.Controller.Mensaje;
import com.portfolio.acm.Service.Shys;
>>>>>>> Stashed changes
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acm1ux3r0
 */
<<<<<<< Updated upstream

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skill")
public class CHys {
    @Autowired //Para inyectar el servicio.
    SHys shys;
    
    //Como es parecido al de Experiencia se copia el de CExperiencia.java
    @GetMapping("/lista")
    public ResponseEntity<List<Hys>> list(){
        List<Hys> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //Para traer los datos
    @GetMapping("/detail/{id}/") //para que traiga los detalles de ese ID
    public ResponseEntity<Hys> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        Hys hys = shys.getOne(id).get();/* Hys es la entidad (tipo) de la variable hys. */
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    //Para crear una habilidad.
    @PostMapping("/create/")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys){
        if(StringUtils.isBlank(dtohys.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(shys.existsByNombre(dtohys.getNombre()))
            return new ResponseEntity(new Mensaje("Esa Skill ya existe"), HttpStatus.BAD_REQUEST);
        /*La siguiente línea sería: la Entidad Hys (tipo)  creamos una variable hys; creamos un
        new objeto hys y le pasamos por parámetro el nombre y porcentaje. Luego volvemos al Service (shys)
        y traemos el método "save"*/  
        Hys hys = new Hys(dtohys.getNombre(), dtohys.getPorcentaje());
        shys.save(hys);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}/")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys){
        //Validación si (NO) existe el ID.
        if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        //Comparando nombres de experiencia.
        if(shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese nombre de skill ya existe"), HttpStatus.BAD_REQUEST );
        
        //Exige que no puede estar vacío el campo.
        if (StringUtils.isBlank(dtohys.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Hys hys = shys.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcentaje(dtohys.getPorcentaje());
        
        shys.save(hys);
        return new ResponseEntity(new Mensaje("La Skill ha sido actualizada"), HttpStatus.OK);
    } 
    
    //BORRA por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        //Validación si (NO) existe el ID.
        if(!shys.existsById(id))
            return new ResponseEntity(new Mensaje("El Skill ha sido eliminado"), HttpStatus.BAD_REQUEST);
        
        shys.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
    
=======
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/hys")
public class CHys {

    @Autowired ////Para inyectar el servicio
    Shys shys;

    // Se toma tal cual el de Experiencia (CExperiencia.java) con las modificaciones correspondientes.
    @GetMapping("/lista")
    public ResponseEntity<List<hys>> list() {
        List<hys> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}") // Para que traiga el detalle deL ID
    public ResponseEntity<hys> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        hys hYs = shys.getOne(id).get();// hys: llama a la Entidad - hYs es variable del tipo hys.

        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    //BORRAR
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
        }
        shys.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    // Para crear una habilidad.
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHys dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shys.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre de la skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        /* La siguiente linea haría lo siguiente: creamos un "new" objeto del tipo hYs y le pasamos por parámetro
        el nombre y el porcentaje. Una vez hecho eso se vuelve al service (syhs) y se trae el método
        guardar (save) en la Base de Datos */
        hys hYs = new hys(dtohys.getNombre(), dtohys.getPorcentaje());
        shys.save(hYs);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    //Actualización.
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHys dtohys) {
        //Validación si existe el ID.
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        //Comparando nombres de skills.
        if (shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("El nombre de skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        //Exige que no puede estar vacío el campo.
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        hys hYs = shys.getOne(id).get();
        hYs.setNombre(dtohys.getNombre());
        hYs.setPorcentaje(dtohys.getPorcentaje());

        shys.save(hYs);
        return new ResponseEntity(new Mensaje("La Skill ha sido actualizada"), HttpStatus.OK);
    }
>>>>>>> Stashed changes
}
