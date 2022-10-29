/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.abr.Controller;


import com.portfolio.abr.Dto.DtoHyS;
import com.portfolio.abr.Entity.HySSkills;
import com.portfolio.abr.Security.Contoller.Mensaje;
import com.portfolio.abr.Service.SHySSkills;
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
//cambiar cuando pase al deploy
@RequestMapping("/hys")
@CrossOrigin(origins = {"https://frontend-portfolio-romero.web.app", "http://localhost:4200"})

public class CHyS {
    @Autowired
    SHySSkills sHyS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HySSkills>> list(){
        List<HySSkills> list = sHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHyS dtoHyS){
        if(StringUtils.isBlank(dtoHyS.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        //Yo tengo mas de una experiencia en una misma empresa, por lo que si pongo este control, no puedo agregarlas
        //if(sExperiencia.existsByNombreExp(dtoExperiencia.getNombreExp()))
            //ESTA LINEA ES PARA NO REPETIR LA MISMA EXPERIENCIA LABORAL
            //return new ResponseEntity(new Mensaje("La experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        HySSkills hys = new HySSkills(dtoHyS.getNombre(), dtoHyS.getPorcentaje());
        sHyS.save(hys);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHyS dtoHyS){
        if(!sHyS.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        //if(sHyS.existsByNombre(dtoHyS.getNombre()) && sHyS.getByNombre(dtoHyS.getNombre()).get().getId()!= id)
            //return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoHyS.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        
        HySSkills hys = sHyS.getOne(id).get();
        hys.setNombre(dtoHyS.getNombre());
        hys.setPorcentaje(dtoHyS.getPorcentaje());
        
        sHyS.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
        
        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHyS.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sHyS.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<HySSkills> getById(@PathVariable("id") int id){
        if(!sHyS.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HySSkills hys = sHyS.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
}
