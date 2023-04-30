/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.acm.Security.Repository;

import com.portfolio.acm.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acm1ux3r0
 */

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);// Buscar por nombre de usuario.

    boolean existsByNombreUsuario(String nombreUsuario); //Verdadero o Falso si EXISTE el nombre del usuario.

    boolean existsByEmail(String email); //Verdadero o Falso si EXISTE el Email.

}
