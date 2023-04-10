/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.acm.Repository;

import com.portfolio.acm.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acm1ux3r0
 */

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long > {
    
}
