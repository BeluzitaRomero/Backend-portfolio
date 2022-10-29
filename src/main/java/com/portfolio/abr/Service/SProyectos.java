/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.abr.Service;

import com.portfolio.abr.Entity.Proyectos;
import com.portfolio.abr.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Belen
 */
@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyectos rProyectos;
    
     public List<Proyectos> list(){
        return rProyectos.findAll();
    }
         
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByNombreProyecto(String nombreProyecto){
        return rProyectos.findByNombreProyecto(nombreProyecto);
    }
    
    public void save(Proyectos experiencia){
        rProyectos.save(experiencia);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
    
    public boolean existsByNombreProyecto(String nombreProyecto){
        return rProyectos.existsByNombreProyecto(nombreProyecto);
    }
}
