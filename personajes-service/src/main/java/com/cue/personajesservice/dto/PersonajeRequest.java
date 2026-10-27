package com.cue.personajesservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PersonajeRequest {

    @NotBlank(message = "nombre is required")
    private String nombre;

    @NotNull(message = "nivel is required")
    @Min(value = 1, message = "nivel must be at least 1")
    private Integer nivel;

    @NotNull(message = "puntosDeVida is required")
    @Min(value = 1, message = "puntosDeVida must be at least 1")
    private Integer puntosDeVida;

    @NotNull(message = "claseId is required")
    private Long claseId;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getNivel() { return nivel; }
    public void setNivel(Integer nivel) { this.nivel = nivel; }

    public Integer getPuntosDeVida() { return puntosDeVida; }
    public void setPuntosDeVida(Integer puntosDeVida) { this.puntosDeVida = puntosDeVida; }

    public Long getClaseId() { return claseId; }
    public void setClaseId(Long claseId) { this.claseId = claseId; }
}
