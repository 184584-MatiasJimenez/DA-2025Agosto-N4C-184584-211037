package com.example.obligatorioPeajes.excepciones;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.obligatorioPeajes.excepciones.UsuarioException;

@RestControllerAdvice
public class ManejadorException {
    
    // Usamos el mismo código de estado especial del profesor
    private final int errorCodeStatus = 299; 

    /**
     * Intercepta la UsuarioException y devuelve el mensaje de error 
     * con un código de estado no estándar (299).
     * @param ex La excepción de negocio (ej. UsuarioException).
     * @return ResponseEntity con el mensaje de la excepción como cuerpo y código 299.
     */
    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<String> manejarUsuarioException(UsuarioException ex) {
        // Devuelve el mensaje de error (ej. "Acceso denegado") directamente en el cuerpo
        // con el código 299.
        // El frontend vistaWeb.js interpretará esto como un error y llamará a mostrar_error(mensaje).
        return ResponseEntity.status(errorCodeStatus).body(ex.getMessage());
    }
}