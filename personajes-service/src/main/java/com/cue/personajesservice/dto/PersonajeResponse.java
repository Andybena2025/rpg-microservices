package com.cue.personajesservice.dto;

import com.cue.personajesservice.model.Personaje;

public class PersonajeResponse {

    private Long id;
    private String nombre;
    private Integer nivel;
    private Integer puntosDeVida;
    private Long claseId;

    public PersonajeResponse(Personaje personaje) {
        this.id = personaje.getId();
        this.nombre = personaje.getNombre();
        this.nivel = personaje.getNivel();
        this.puntosDeVida = personaje.getPuntosDeVida();
        this.claseId = personaje.getClaseId();
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public Integer getNivel() { return nivel; }
    public Integer getPuntosDeVida() { return puntosDeVida; }
    public Long getClaseId() { return claseId; }
}
