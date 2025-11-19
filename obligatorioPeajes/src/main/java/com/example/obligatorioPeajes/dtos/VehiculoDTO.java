package com.example.obligatorioPeajes.dtos;
import com.example.obligatorioPeajes.modelo.Vehiculo;
public class VehiculoDTO {
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int anio;
    private int cantidadTransitos; 
    private double montoTotalGastado; 
    private String categoriaNombre;

    public VehiculoDTO(Vehiculo vehiculo) {
        this.matricula = vehiculo.getMatricula();
        this.marca = vehiculo.getMarca();
        this.modelo = vehiculo.getModelo();
        this.color = vehiculo.getColor();
        this.anio = vehiculo.getAnio();
        
        this.cantidadTransitos = vehiculo.getCantidadTransitos(); 
        this.montoTotalGastado = vehiculo.getMontoTotalGastado(); 
        
        if (vehiculo.getCategoria() != null) {
            this.categoriaNombre = vehiculo.getCategoria().getNombre();
        } else {
            this.categoriaNombre = "N/A";
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getAnio() {
        return anio;
    }
    public int getCantidadTransitos() {
        return cantidadTransitos;
    }

    public double getMontoTotalGastado() {
        return montoTotalGastado;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }    
}
