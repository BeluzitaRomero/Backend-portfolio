/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.abr.Entity;

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
 * @author Belen
 */

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Debe tener mas de 1 caracter y menos de 50")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Debe tener mas de 1 caracter y menos de 50")
    private String apellido;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Debe tener mas de 1 caracter y menos de 50")
    private String img;
    
    
    
}
