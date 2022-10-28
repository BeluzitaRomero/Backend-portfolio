/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.abr.Controller;

import com.portfolio.abr.Entity.Persona;
import com.portfolio.abr.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Belen
 */
@RestController
@CrossOrigin(origins = "https://frontend-portfolio-romero.web.app")
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("/personas/get")
    public List<Persona> getPersona(){
    return ipersonaService.getPersona();
    }
    
    @PreAuthorize("hasRole('ADMIN')") //ESTO ES PARA AUTORIZAR A CREAR SOLO AL ADMIN
    @PostMapping("/personas/create")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "Usuario creado";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/delete/{id}")
    public String deletePersona(@PathVariable Long id){
         ipersonaService.deletePersona(id);
         return "Usuario eliminado";
        }
    
    //URL:puerto/personas/put/numero/nombre & apellido & img DESDE LA MISMA URL
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/put/{id}")
    public Persona editPersona(@PathVariable Long id, 
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido, 
            @RequestParam("img") String nuevaImg){
        Persona persona = ipersonaService.findPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevaImg);
        
        ipersonaService.savePersona(persona);
        return persona;
    }
    
    @GetMapping("personas/get/perfil")
    public Persona findPersona(){
        return ipersonaService.findPersona((long) 2);
    }
    
}
