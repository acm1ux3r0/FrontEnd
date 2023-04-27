/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Service;

import com.portfolio.acm.Entity.Hys;
import com.portfolio.acm.Repository.RHys;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acm1ux3r0
 */


@Transactional //Para que haya persistencia de datos tanto en el back como en el front.
@Service

public class SHys {
    
    @Autowired //Para inyectar el servicio 
    RHys rhys;
    
    public List<Hys> list(){
        return rhys.findAll(); //Que busque todos.
    }
    
    public Optional<Hys> getOne(int id){
        return rhys.findById(id); // Para que busque por ID
       
    }
    
    public Optional<Hys> getByNombre(String nombre) {
        return rhys.findByNombre(nombre); //"findByName"
        
    }
    
    public void save(Hys skill){
        rhys.save(skill);
    }
    
    //Eliminar por ID
    public void delete(int id){
        rhys.deleteById(id);
    }
    
    //Para checar que existe el ID
    public boolean existsById(int id){
        return rhys.existsById(id);
    }
    
    
    public boolean existsByNombre(String nombre){
        return rhys.existsByNombre(nombre);
    }
    
}
