package com.example.obligatorioPeajes.servicios;

import com.example.obligatorioPeajes.modelo.*;

import java.time.LocalDateTime;

public class ServicioPrecarga {

	public void cargarDatosIniciales() {
		ServicioUsuario sistemaUsuario = ServicioUsuario.getInstancia();
		ServicioTransito sistemaTransito = ServicioTransito.getInstancia();
		ServicioBonificacion sistemaBonificacion = ServicioBonificacion.getInstancia();

		// Precarga de estados de propietarios
		sistemaUsuario.precargaEstados();

		// precarga de categorías de vehiculos
		CategoriaVehiculo categoriaAuto = new CategoriaVehiculo("Automóvil");
		CategoriaVehiculo catCamioneta = new CategoriaVehiculo("Camioneta");
		CategoriaVehiculo categoriaMoto = new CategoriaVehiculo("Moto");

		sistemaTransito.agregarCategoria(categoriaAuto);
		sistemaTransito.agregarCategoria(catCamioneta);
		sistemaTransito.agregarCategoria(categoriaMoto);

		//tipos de bonificaciones
		sistemaBonificacion.precargarTiposBonificacion();

		// agregar puestos
		PuestoDePeaje puesto1 = sistemaTransito.agregarPuestoDePeaje("Puesto Central", "Ruta 1 km 20");
		PuestoDePeaje puesto2 = sistemaTransito.agregarPuestoDePeaje("Puesto Norte", "Ruta 5 km 50");
        PuestoDePeaje puesto3 = sistemaTransito.agregarPuestoDePeaje("Puesto Sur", "Ruta 10 km 100");
        PuestoDePeaje puesto4 = sistemaTransito.agregarPuestoDePeaje("Puesto Este", "Ruta 15 km 150");

        
        //agregar tarifas - Puesto Central (puesto1)
        sistemaTransito.agregarTarifa(puesto1, categoriaAuto, 100.0);
        sistemaTransito.agregarTarifa(puesto1, catCamioneta, 150.0);
        sistemaTransito.agregarTarifa(puesto1, categoriaMoto, 50.0);
        //agregar tarifas - Puesto Norte (puesto2)
        sistemaTransito.agregarTarifa(puesto2, categoriaAuto, 120.0);
        sistemaTransito.agregarTarifa(puesto2, catCamioneta, 170.0);
        sistemaTransito.agregarTarifa(puesto2, categoriaMoto, 60.0);
        //agregar tarifas - Puesto Sur (puesto3)
        sistemaTransito.agregarTarifa(puesto3, categoriaAuto, 110.0);
        sistemaTransito.agregarTarifa(puesto3, catCamioneta, 160.0);
        sistemaTransito.agregarTarifa(puesto3, categoriaMoto, 55.0);
        //agregar tarifas - Puesto Este (puesto4)
        sistemaTransito.agregarTarifa(puesto4, categoriaAuto, 130.0);
        sistemaTransito.agregarTarifa(puesto4, catCamioneta, 180.0);
        sistemaTransito.agregarTarifa(puesto4, categoriaMoto, 65.0);

		// agregar tarifas - Puesto Central (puesto1)
		sistemaTransito.agregarTarifa(puesto1, categoriaAuto, 100.0);
		sistemaTransito.agregarTarifa(puesto1, catCamioneta, 150.0);
		sistemaTransito.agregarTarifa(puesto1, categoriaMoto, 50.0);
		// agregar tarifas - Puesto Norte (puesto2)
		sistemaTransito.agregarTarifa(puesto2, categoriaAuto, 120.0);
		sistemaTransito.agregarTarifa(puesto2, catCamioneta, 170.0);
		sistemaTransito.agregarTarifa(puesto2, categoriaMoto, 60.0);
		// agregar tarifas - Puesto Sur (puesto3)
		sistemaTransito.agregarTarifa(puesto3, categoriaAuto, 110.0);
		sistemaTransito.agregarTarifa(puesto3, catCamioneta, 160.0);
		sistemaTransito.agregarTarifa(puesto3, categoriaMoto, 55.0);
		// agregar tarifas - Puesto Este (puesto4)
		sistemaTransito.agregarTarifa(puesto4, categoriaAuto, 130.0);
		sistemaTransito.agregarTarifa(puesto4, catCamioneta, 180.0);
		sistemaTransito.agregarTarifa(puesto4, categoriaMoto, 65.0);

		// Agregar administradores
		sistemaUsuario.agregarAdministrador("52345679", "Usuario Admin", "Admin.123");
		sistemaUsuario.agregarAdministrador("53345670", "Maria Lopez", "Admin.456");

		// agregar propietarios
		sistemaUsuario.agregarPropietario("19345678", "Carolina Perez", "Prop.123", 2000, 400);
		sistemaUsuario.agregarPropietario("20345676", "Juan Gomez", "Prop.456", 1500, 300);
		sistemaUsuario.agregarPropietario("22345675", "Luis Rodriguez", "Prop.789", 1800, 350);
		sistemaUsuario.agregarPropietario("23345674", "Ana Martinez", "Prop.321", 2200, 500);
		sistemaUsuario.agregarPropietario("24345673", "Pedro Sanchez", "Prop.654", 1700, 250);

		Propietario propA = (Propietario) sistemaUsuario.buscarUsuarioPorCI("19345678");
		Propietario propB = (Propietario) sistemaUsuario.buscarUsuarioPorCI("20345676");
		Propietario propC = (Propietario) sistemaUsuario.buscarUsuarioPorCI("22345675");
		Propietario propD = (Propietario) sistemaUsuario.buscarUsuarioPorCI("23345674");
		Propietario propE = (Propietario) sistemaUsuario.buscarUsuarioPorCI("24345673");

        EstadoPropietario estadoDeshabilitado = sistemaUsuario.getEstadoDeshabilitado();
        propB.setEstado(estadoDeshabilitado);
		// Agregar vehiculos - *** USO DIRECTO DE VARIABLES DE CATEGORÍA ***
        sistemaUsuario.agregarVehiculo(propA, "ABC123", "Toyota", "Corolla", "Rojo", 2020, categoriaAuto);
        sistemaUsuario.agregarVehiculo(propB, "DEF456", "Honda", "Civic", "Azul", 2019, categoriaAuto);
        sistemaUsuario.agregarVehiculo(propC, "GHI789", "Ford", "Focus", "Negro", 2021, categoriaAuto);
        
        sistemaUsuario.agregarVehiculo(propD, "MOTO1", "Yamaha", "YZF-R3", "Blanco", 2021, categoriaMoto);
        
        sistemaUsuario.agregarVehiculo(propC, "CAMIONETA1", "Chevrolet", "Trax", "Gris", 2022, catCamioneta);
        sistemaUsuario.agregarVehiculo(propA, "CAMIONETA2", "Jeep", "Renegade", "Blanco", 2018, catCamioneta);

		sistemaTransito.registrarTransito("ABC123", "Puesto Central", new DateTime(LocalDateTime.of(2024, 6, 1, 8, 30)));
        sistemaTransito.registrarTransito("DEF456", "Puesto Norte", new DateTime(LocalDateTime.of(2024, 6, 1, 9, 15)));
        sistemaTransito.registrarTransito("GHI789", "Puesto Sur", new DateTime(LocalDateTime.of(2024, 6, 1, 10, 0)));
        sistemaTransito.registrarTransito("MOTO1", "Puesto Este", new DateTime(LocalDateTime.of(2024, 6, 1, 11, 45)));
        sistemaTransito.registrarTransito("MOTO2", "Puesto Central", new DateTime(LocalDateTime.of(2024, 6, 1, 12, 30)));
        sistemaTransito.registrarTransito("CAMIONETA1", "Puesto Este", new DateTime(LocalDateTime.of(2024, 6, 1, 13, 15)));
        sistemaTransito.registrarTransito("CAMIONETA2", "Puesto Este", new DateTime(LocalDateTime.of(2024, 6, 1, 14, 0)));
		
		//buscar bonificaciones
        Bonificacion bonifExonerado = sistemaBonificacion.buscarBonificacionPorNombre("Exonerado");
        Bonificacion bonifFrecuente = sistemaBonificacion.buscarBonificacionPorNombre("Frecuente");
        Bonificacion bonifTrabajador = sistemaBonificacion.buscarBonificacionPorNombre("Trabajador");
        //asignar bonificaciones a propietarios
        sistemaBonificacion.asignarBonificacion(propE, puesto4, bonifExonerado);
        sistemaBonificacion.asignarBonificacion(propA, puesto1, bonifFrecuente);
        sistemaBonificacion.asignarBonificacion(propB, puesto2, bonifTrabajador);
    
		// Agregar vehiculos
		categoriaAuto = sistemaTransito.buscarCategoriaPorNombre("Automóvil");
		sistemaUsuario.agregarVehiculo(propA, "ABC123", "Toyota", "Corolla", "Rojo", 2020, categoriaAuto);
		sistemaUsuario.agregarVehiculo(propB, "DEF456", "Honda", "Civic", "Azul", 2019, categoriaAuto);
		sistemaUsuario.agregarVehiculo(propC, "GHI789", "Ford", "Focus", "Negro", 2021, categoriaAuto);

		categoriaMoto = sistemaTransito.buscarCategoriaPorNombre("Moto");
		sistemaUsuario.agregarVehiculo(propD, "MOTO1", "Yamaha", "YZF-R3", "Blanco", 2021, categoriaMoto);
    }

}
