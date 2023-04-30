    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.acm.Service;

import com.portfolio.acm.Entity.Persona;
import com.portfolio.acm.Interface.IPersonaService;
import com.portfolio.acm.Repository.IPersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acm1ux3r0
 */

    //  Entidad --> Repositorio --> Interface --> SERVICE --> Controller

@Service
@Transactional
public class ImpPersonaService implements IPersonaService{

    @Autowired //Annotation que sirve para inyectar dependencias.
    IPersonaRepository ipersonaRepository;

    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = ipersonaRepository.findAll();
        return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonaRepository.save(persona)/*(this)*/;
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);//Poruqe si ponemos "deleteByAll" eliminamos todos los usuarios.
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null)/* Por si el ID no existe que devuelva null*/;
        return persona;
    }
}


/*   public List<Persona> list() {
        return ipersonaRepository.findAll();
    }

    public Optional<Persona> getOne(int id) {
        return ipersonaRepository.findById(id);
    }

    public Optional<Persona> getByNombre(String nombre) {
        return ipersonaRepository.findByNombre(nombre);
    }

    

    

    public boolean existsById(int id) {
        return ipersonaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return ipersonaRepository.existsByNombre(nombre);
    }
        */