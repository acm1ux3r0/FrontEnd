/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Security.Service;

import com.portfolio.acm.Security.Entity.Usuario;
import com.portfolio.acm.Security.Repository.iUsuarioRepository;
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

public class UsuarioService {

    @Autowired
    iUsuarioRepository iusuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    //Para checar si el nombre del usuario existe.
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    //Para checar si el email existe.
    public boolean existsByEmail(String email) {
        return iusuarioRepository.existsByEmail(email);
    }
    
    //Va a guardar un usario nuevo.
    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }
}
