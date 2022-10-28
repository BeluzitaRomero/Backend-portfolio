/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.abr.Service;

import com.portfolio.abr.Entity.Persona;
import com.portfolio.abr.Interface.IPersonaService;
import com.portfolio.abr.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Belen
 */
@Service
public class ImpPersonaService implements IPersonaService {
    //inyecta 
    @Autowired IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> getPersona() {
       List<Persona> persona = iPersonaRepository.findAll();
       return persona;
    }

    @Override
    public void savePersona(Persona persona) {
       iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = iPersonaRepository.findById(id).orElse(null);
        return persona;
    }
    
}
