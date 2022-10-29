/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.abr.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String linkDeployProyecto;
    @NotBlank
    private String linkRepoProyecto;
    @NotBlank
    private String descripcionProyecto;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProyecto, String linkDeployProyecto, String linkRepoProyecto, String descripcionProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.linkDeployProyecto = linkDeployProyecto;
        this.linkRepoProyecto = linkRepoProyecto;
        this.descripcionProyecto = descripcionProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getLinkDeployProyecto() {
        return linkDeployProyecto;
    }

    public void setLinkDeployProyecto(String linkDeployProyecto) {
        this.linkDeployProyecto = linkDeployProyecto;
    }

    public String getLinkRepoProyecto() {
        return linkRepoProyecto;
    }

    public void setLinkRepoProyecto(String linkRepoProyecto) {
        this.linkRepoProyecto = linkRepoProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }
    
    
    
}
