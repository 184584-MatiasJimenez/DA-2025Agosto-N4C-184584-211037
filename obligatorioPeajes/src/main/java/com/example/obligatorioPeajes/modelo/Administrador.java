package com.example.obligatorioPeajes.modelo;

public class Administrador extends Usuario {

    private String cedula;
    private String nombreCompleto;
    private String contrasenia;

    public Administrador(String cedula, String nombreCompleto, String contrasenia) {
        super(cedula, nombreCompleto, contrasenia);
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.contrasenia = contrasenia;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

}