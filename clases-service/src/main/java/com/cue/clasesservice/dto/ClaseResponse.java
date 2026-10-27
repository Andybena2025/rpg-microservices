package com.cue.clasesservice.dto;

import com.cue.clasesservice.model.Clase;

public class ClaseResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private String rolPrincipal;
    private Integer dadoDeVida;

    public ClaseResponse(Clase clase) {
        this.id = clase.getId();
        this.nombre = clase.getNombre();
        this.descripcion = clase.getDescripcion();
        this.rolPrincipal = clase.getRolPrincipal();
        this.dadoDeVida = clase.getDadoDeVida();
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getRolPrincipal() { return rolPrincipal; }
    public Integer getDadoDeVida() { return dadoDeVida; }
}
