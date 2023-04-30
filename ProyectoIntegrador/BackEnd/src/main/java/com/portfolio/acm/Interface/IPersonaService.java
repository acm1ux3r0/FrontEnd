/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.acm.Interface;

import com.portfolio.acm.Entity.Persona;
import java.util.List;

/**
 *
 * @author acm1ux3r0
 */

    //  Entidad --> Repositorio --> INTERFACE --> Service --> Controller

public interface IPersonaService {

    //Para traer una lista de Personas.
    public List<Persona> getPersona();// El "<Persona> porque refiere a la Class Persona.java del Entity.

    //Guardar objeto del tipo Persona.
    public void savePersona(Persona persona);

    //Eliminar un objeto (usuario) buscándolo por ID.
    public void deletePersona(Long id);

    //Para buscar un objeto (usuario) por ID.
    public Persona findPersona(Long id); //No es void porque nos tiene que devolver una "Persona".
}
