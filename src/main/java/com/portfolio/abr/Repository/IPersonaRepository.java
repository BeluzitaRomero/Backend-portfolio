/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portfolio.abr.Repository;

import com.portfolio.abr.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Belen
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
    public Optional<Persona> findByNombre(String nombre);
    public boolean existsByNombre(String nombre); 
}
