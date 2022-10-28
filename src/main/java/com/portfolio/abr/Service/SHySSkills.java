/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.abr.Service;

import com.portfolio.abr.Entity.HySSkills;
import com.portfolio.abr.Repository.RHySSkills;
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
public class SHySSkills {
    @Autowired
    RHySSkills rHySSkills;
    
    public List<HySSkills> list(){
        return rHySSkills.findAll();
    }
    
    public Optional<HySSkills> getOne(int id){
        return rHySSkills.findById(id);
    }
    
    public Optional<HySSkills> getByNombre(String nombre){
        return rHySSkills.findByNombre(nombre);
    }
    
    public void save(HySSkills hys){
        rHySSkills.save(hys);
    }
    
    public void delete(int id){
          rHySSkills.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHySSkills.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rHySSkills.existsByNombre(nombre);
    }
}
