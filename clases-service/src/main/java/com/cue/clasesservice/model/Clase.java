package com.cue.clasesservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "clases")
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false, length = 30)
    private String rolPrincipal;

    @Column(nullable = false)
    private Integer dadoDeVida;

    public Clase() {}

    public Clase(String nombre, String descripcion, String rolPrincipal, Integer dadoDeVida) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rolPrincipal = rolPrincipal;
        this.dadoDeVida = dadoDeVida;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRolPrincipal() { return rolPrincipal; }
    public void setRolPrincipal(String rolPrincipal) { this.rolPrincipal = rolPrincipal; }

    public Integer getDadoDeVida() { return dadoDeVida; }
    public void setDadoDeVida(Integer dadoDeVida) { this.dadoDeVida = dadoDeVida; }
}
