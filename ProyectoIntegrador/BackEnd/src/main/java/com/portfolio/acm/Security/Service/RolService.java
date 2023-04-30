/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Security.Service;

import com.portfolio.acm.Security.Entity.Rol;
import com.portfolio.acm.Security.Enums.RolNombre;
import com.portfolio.acm.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author acm1ux3r0
 */

@Service
@Transactional /*Nos asegura que vamos a tener los mismos datos que tengamos acá con 
                    lo de la base de datos  ====> "PERSISTENCIA" */

public class RolService {

    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolnombre) {
        return irolRepository.findByRolNombre(rolnombre);
    }

    public void save(Rol rol) {
        irolRepository.save(rol); //(this)
    }
}
