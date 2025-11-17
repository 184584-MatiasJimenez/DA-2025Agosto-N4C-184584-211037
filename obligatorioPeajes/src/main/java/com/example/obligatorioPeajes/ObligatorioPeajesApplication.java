package com.example.obligatorioPeajes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.obligatorioPeajes.servicios.fachada.Fachada;

@SpringBootApplication
public class ObligatorioPeajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObligatorioPeajesApplication.class, args);
	}
	@Bean
	public CommandLineRunner inicializarDatos() {
		return args -> {
            // Obtener la instancia de la Fachada (es un Singleton, por eso getInstance())
			Fachada fachada = Fachada.getInstance();
            
            // Llama al método de precarga de datos
			fachada.precargaDatosIniciales();
			
			System.out.println("✅ Datos iniciales cargados correctamente.");
            
            // Opcional: Podrías poner aquí un usuario de prueba para verificar
            // Propietario testUser = fachada.buscarPropietarioPorCI("1234567-8"); 
            // if (testUser != null) { System.out.println("Propietario de prueba listo."); }
		};
	}
}
