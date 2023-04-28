/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.acm.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author acm1ux3r0
 */


public class dtoHys {

    
    @NotBlank //Para indicar que no puede estar vacío
    private String nombre;
    
    @NotBlank //Para indicar que no puede estar vacío
    private int porcentaje;
    
    //  <<<<<<<<<<<       Constructores     >>>>>>>>>>>>>>>>

    public dtoHys() {
    }

    public dtoHys(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    
    //<<<<<<<<<<<       Getters & Setters      >>>>>>>>>>>>>

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
