package com.example.obligatorioPeajes.modelo;

public abstract class Usuario {

	public Usuario(String cedula2, String nombreCompleto2, String contrasenia2) {
        this.cedula = cedula2;
        this.nombreCompleto = nombreCompleto2;
        this.contrasenia = contrasenia2;
    }

    private String cedula;

	private String nombreCompleto;

	private String contrasenia;


    public String getCedula() {
        return cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getContrasenia() {
        return contrasenia;
    }
    public boolean verificarContrasenia(String contrasenia) {
        System.out.println("[DEBUG] Comparando: stored='" + this.contrasenia + "' input='" + contrasenia + "'");
        System.out.println("[DEBUG] Trim stored='" + this.contrasenia.trim() + "' Trim input='" + contrasenia.trim() + "'");
        if(contrasenia == null) {
            return false;
        }
        return this.contrasenia.equalsIgnoreCase(contrasenia.trim());
    }



}
