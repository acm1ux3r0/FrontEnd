/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Security.Controller;

import com.portfolio.acm.Security.Dto.JwtDto;
import com.portfolio.acm.Security.Dto.LoginUsuario;
import com.portfolio.acm.Security.Dto.NuevoUsuario;
import com.portfolio.acm.Security.Entity.Rol;
import com.portfolio.acm.Security.Entity.Usuario;
import com.portfolio.acm.Security.Enums.RolNombre;
import com.portfolio.acm.Security.Service.RolService;
import com.portfolio.acm.Security.Service.UsuarioService;
import com.portfolio.acm.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acm1ux3r0
 */

            //ES EL QUE SE VA A TERMINAR COMUNICANDO CON EL FRONT.

@RestController
@RequestMapping("/auth") //Desde donde lo vamos a llamar.
@CrossOrigin(origins = "http://localhost:4200")

public class AuthController {

    // INYECCIONES
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    //CREAR UN USUARIO NUEVO
    @PostMapping("/nuevo") //Para indicar la ruta.

    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Mensaje("Email inválido o campo mal puesto"),
                                        HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new Mensaje("Ese nombre de usuario ya existe"),
                                                    HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByEmail(nuevoUsuario.getEmail())) {
            return new ResponseEntity(new Mensaje("Este email ya existe"), HttpStatus.BAD_REQUEST);
        }

        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(), passwordEncoder.encode(nuevoUsuario.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());/* Por defecto todos van a tener
                                                                            ROL_USER*/

        if (nuevoUsuario.getRoles().contains("admin")) 
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get()); /* A menos que contenga "admin",
                                                                                  y ahí se le asiganrá el
                                                                                  ROL_ADMIN*/        
        usuario.setRoles(roles);
        usuarioService.save(usuario);

        return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login") //La ruta (Endpoint) al que se accederá
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) 
            return new ResponseEntity(new Mensaje("Campos mal puestos"), HttpStatus.BAD_REQUEST);        

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
                        loginUsuario.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
