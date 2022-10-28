/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.abr.Repository;

import com.portfolio.abr.Entity.HySSkills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Belen
 */
public interface RHySSkills extends JpaRepository<HySSkills, Integer>{
    Optional<HySSkills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
