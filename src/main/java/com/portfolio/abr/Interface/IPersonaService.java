/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.abr.Interface;

import com.portfolio.abr.Entity.Persona;
import java.util.List;


/**
 *
 * @author Belen
 */
public interface IPersonaService {
    /*METODOS*/
    public List<Persona> getPersona();
            
    /*GUARDAR*/
    public void savePersona(Persona persona);
            
    /*Eliminar*/
    public void deletePersona(Long id);

/*Buscar por id*/    
    public Persona findPersona(Long id);
}
