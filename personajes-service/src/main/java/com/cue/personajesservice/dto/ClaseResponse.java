package com.cue.personajesservice.dto;

public class ClaseResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private String rolPrincipal;
    private Integer dadoDeVida;

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
