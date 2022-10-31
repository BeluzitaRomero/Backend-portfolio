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
    @NotBlank
    private String img1;
    private String img2;
    private String img3;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombreProyecto, String linkDeployProyecto, String linkRepoProyecto, String descripcionProyecto, String img1, String img2, String img3) {
        this.nombreProyecto = nombreProyecto;
        this.linkDeployProyecto = linkDeployProyecto;
        this.linkRepoProyecto = linkRepoProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.img1 = img1;
        this.img2 = img2;
        this.img3=img3;
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

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }
    
    
    
}
