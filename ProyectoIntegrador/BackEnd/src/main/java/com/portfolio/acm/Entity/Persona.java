/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.acm.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author acm1ux3r0
 */

        // ENTIDAD --> Repositorio --> Interface --> Service --> Controller

@Getter //Con esta Annotation del Lombok nos que el código sea tan extenso.
@Setter //Con esta Annotation del Lombok nos que el código sea tan extenso.
@Entity
public class Persona {

    @Id //Le indicamos que el primer campo va ser una Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Se va a generar de modo automático y no va a ser necesario asignarle un número.
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud requerida.")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud requerida.")
    private String apellido;

    // @NotNull
    //private String descripcion;
    @Size(min = 1, max = 50, message = "No cumple con la longitud requerida.")
    private String img;

    //Forma abreviada de Getters y Setters es colocarlos en forma de @Annotation.
}
