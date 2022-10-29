/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.abr.Controller;


import com.portfolio.abr.Dto.DtoExperiencia;
import com.portfolio.abr.Entity.Experiencia;
import com.portfolio.abr.Security.Contoller.Mensaje;
import com.portfolio.abr.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/explab")
@CrossOrigin(origins= {"https://frontend-portfolio-romero.web.app", "http://localhost:4200"})
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoExperiencia){
        if(StringUtils.isBlank(dtoExperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        //Yo tengo mas de una experiencia en una misma empresa, por lo que si pongo este control, no puedo agregarlas
        //if(sExperiencia.existsByNombreExp(dtoExperiencia.getNombreExp()))
            //ESTA LINEA ES PARA NO REPETIR LA MISMA EXPERIENCIA LABORAL
            //return new ResponseEntity(new Mensaje("La experiencia laboral ya existe"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = new Experiencia(dtoExperiencia.getNombreExp(), dtoExperiencia.getDescripcionExp(), dtoExperiencia.getImgExp());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia laboral agregada"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoExperiencia){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        
        //if(sExperiencia.existsByNombreExp(dtoExperiencia.getNombreExp()) && sExperiencia.getByNombreExp(dtoExperiencia.getNombreExp()).get().getId()!= id)
            //return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(dtoExperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre no puede estar en blanco"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoExperiencia.getNombreExp());
        experiencia.setDescripcionExp(dtoExperiencia.getDescripcionExp());
        
        //agregado
        experiencia.setImgExp(dtoExperiencia.getImgExp());
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia laboral actualizada"), HttpStatus.OK);
        
        
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
