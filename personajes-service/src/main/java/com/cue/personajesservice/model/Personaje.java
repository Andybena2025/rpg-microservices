package com.cue.personajesservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "personajes")
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nombre;

    @Column(nullable = false)
    private Integer nivel;

    @Column(nullable = false)
    private Integer puntosDeVida;

    @Column(nullable = false)
    private Long claseId;

    public Personaje() {}

    public Personaje(String nombre, Integer nivel, Integer puntosDeVida, Long claseId) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
        this.claseId = claseId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getNivel() { return nivel; }
    public void setNivel(Integer nivel) { this.nivel = nivel; }

    public Integer getPuntosDeVida() { return puntosDeVida; }
    public void setPuntosDeVida(Integer puntosDeVida) { this.puntosDeVida = puntosDeVida; }

    public Long getClaseId() { return claseId; }
    public void setClaseId(Long claseId) { this.claseId = claseId; }
}
