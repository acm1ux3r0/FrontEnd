/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Service;

import com.portfolio.acm.Entity.Hys;
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
public class SHys {
    
    @Autowired
    Rhys rhys;
    
    //      <<<<<<<<<<<<<   Métodos    >>>>>>>>>>>>>>>>   
    
    public List<Hys> list(){
        return rhys.findAll(); //Que nos busque todos.
    }
    
    public Optional<Hys> getOne(int id){
        return rhys.findById(id); //Que lo busque por ID
    }
    
    public Optional<Hys> getByNombre(String nombre){
        return rhys.findByNombre(nombre); //Busqueda por nombre.(.findByName)
    }
    
    public void save(Hys skill){
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
