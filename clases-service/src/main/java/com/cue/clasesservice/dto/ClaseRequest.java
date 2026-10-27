package com.cue.clasesservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClaseRequest {

    @NotBlank(message = "nombre is required")
    private String nombre;

    @NotBlank(message = "descripcion is required")
    private String descripcion;

    @NotBlank(message = "rolPrincipal is required")
    private String rolPrincipal;

    @NotNull(message = "dadoDeVida is required")
    @Min(value = 1, message = "dadoDeVida must be at least 1")
    private Integer dadoDeVida;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRolPrincipal() { return rolPrincipal; }
    public void setRolPrincipal(String rolPrincipal) { this.rolPrincipal = rolPrincipal; }

    public Integer getDadoDeVida() { return dadoDeVida; }
    public void setDadoDeVida(Integer dadoDeVida) { this.dadoDeVida = dadoDeVida; }
}
