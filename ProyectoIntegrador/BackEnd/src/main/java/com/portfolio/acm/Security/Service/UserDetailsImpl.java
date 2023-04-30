/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Security.Service;

import com.portfolio.acm.Security.Entity.Usuario;
import com.portfolio.acm.Security.Entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author acm1ux3r0
 */

@Service

public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    UsuarioService usuarioService;

    //"IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS."
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario); /*Construimos un Usuario principal con los datos 
                                                    que vienen de usuario */

    }

}
