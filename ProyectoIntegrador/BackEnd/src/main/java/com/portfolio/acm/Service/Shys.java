/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Service;

import com.portfolio.acm.Entity.hys;
import com.portfolio.acm.Repository.Rhys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acm1ux3r0
 */

@Transactional
@Service
public class Shys {
    
    @Autowired
    Rhys rhys;
    
    public List<hys> list(){
        return rhys.findAll(); //Que nos busque todos.
    }
    
    public Optional<hys> getOne(int id){
        return rhys.findById(id); //Que lo busque por ID
    }
    
    public Optional<hys> getByNombre(String nombre){
        return rhys.findByNombre(nombre); //Busqueda por nombre.(.findByName)
    }
    
    public void save(hys skill){
        rhys.save(skill); 
    }
    
    public void delete(int id){
        rhys.deleteById(id); //Eliminar por Id
    }
    
    //Para checar si existe el ID.
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    
    // Check de existencia del nombre
    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }
}
