/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Security.Entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author acm1ux3r0
 */

    //ESTA CLASE LO QUE VA HACER ES ACCEDER DIRECTAMENTE A LA BASE DE DATOS (DB).

@Entity
public class Usuario {
    
    @Id //Marcamos la columna como "ID"
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que genere el valor automáticamente.
    private int id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    @Column(unique = true) // Le indicamos que la columna sea única.
    private String nombreUsuario;
    
    @NotNull
    private String email;
    
    @NotNull
    private String password;
    
    /*Hay que relacionar la tabla Rol con la tabla Usuario; una Relación de "Muchos a Muchos"; en memoria
        se crea una columna virtual en la que se van a relacionar las mencionadas tablas */
    
    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name="usuario_id"),
              inverseJoinColumns = @JoinColumn(name = "rol_id"))/*Se crea la UNIÓN de DOS tablas que se va a
                                                                  llamar "usuario_rol":
                                                                  1°) Una va a tener la columna "usuario_id" 
                                                                  2°) La otra tabla va a tener la columna 
                                                                    "rol_id" */
     private Set<Rol> roles = new HashSet<>(); //Se asignan las caracterísitcas mencionadas arriba.
    
    //<<<<<<<<<<        CONSTRUCTORES       >>>>>>>>>>

    public Usuario() { }

    public Usuario(String nombre, String nombreUsuario, String email, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
    }
    
    //<<<<<<<<<<        GETTERS & SETTERS       >>>>>>>>>>

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    
    

}
