/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.abr.Controller;

import com.portfolio.abr.Dto.DtoProyectos;
import com.portfolio.abr.Entity.Proyectos;
import com.portfolio.abr.Security.Contoller.Mensaje;
import com.portfolio.abr.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Belen
 */
@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = {"https://frontend-portfolio-romero.web.app", "http://localhost:4200"})
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoProyectos){
        if(StringUtils.isBlank(dtoProyectos.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        //Yo tengo mas de una experiencia en una misma empresa, por lo que si pongo este control, no puedo agregarlas
        //if(sExperiencia.existsByNombreExp(dtoExperiencia.getNombreExp()))
            //ESTA LINEA ES PARA NO REPETIR LA MISMA EXPERIENCIA LABORAL
            //return new ResponseEntity(new Mensaje("La experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        Proyectos proyectos = new Proyectos(dtoProyectos.getNombreProyecto(), dtoProyectos.getLinkDeployProyecto(),
                dtoProyectos.getLinkRepoProyecto(), dtoProyectos.getDescripcionProyecto());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoProyectos){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        //if(sHyS.existsByNombre(dtoHyS.getNombre()) && sHyS.getByNombre(dtoHyS.getNombre()).get().getId()!= id)
            //return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoProyectos.getNombreProyecto()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreProyecto(dtoProyectos.getNombreProyecto());
        proyectos.setLinkDeployProyecto(dtoProyectos.getLinkDeployProyecto());
        proyectos.setLinkRepoProyecto(dtoProyectos.getLinkRepoProyecto());
        proyectos.setDescripcionProyecto(dtoProyectos.getDescripcionProyecto());
        
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Informacion de proyecto actualizada"), HttpStatus.OK);
        
        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}
