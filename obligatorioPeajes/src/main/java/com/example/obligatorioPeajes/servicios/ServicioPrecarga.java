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
        
        sistemaUsuario.agregarVehiculo(propD, "TLN342", "Yamaha", "YZF-R3", "Blanco", 2021, categoriaMoto);
        sistemaUsuario.agregarVehiculo(propD, "QWE567", "Japan", "PRX250", "Negro", 2021, categoriaMoto);

        
        sistemaUsuario.agregarVehiculo(propC, "BFG123", "Chevrolet", "Trax", "Gris", 2022, catCamioneta);
        sistemaUsuario.agregarVehiculo(propA, "BFG456", "Jeep", "Cherokee", "Blanco", 2018, catCamioneta);

		Vehiculo v1 = sistemaUsuario.buscarVehiculoPorMatricula("ABC123");
		if (v1 != null) {
			sistemaTransito.registrarTransito(v1, "Puesto Central", new DateTime(LocalDateTime.of(2024, 6, 1, 8, 30)));
			sistemaTransito.registrarTransito(v1, "Puesto Central", new DateTime(LocalDateTime.of(2025, 10, 1, 8, 30)));
			
		}
		Vehiculo v2= sistemaUsuario.buscarVehiculoPorMatricula("DEF456");
		if(v2 != null) {
        sistemaTransito.registrarTransito(v2, "Puesto Norte", new DateTime(LocalDateTime.of(2025, 6, 1, 9, 15)));	
		}
		Vehiculo v3 = sistemaUsuario.buscarVehiculoPorMatricula("GHI789");
		if (v3 != null) {
			sistemaTransito.registrarTransito(v3, "Puesto Sur", new DateTime(LocalDateTime.of(2024, 9, 1, 10, 0)));
		}
		Vehiculo v4 = sistemaUsuario.buscarVehiculoPorMatricula("TLN342");
		if (v4 != null) {
			sistemaTransito.registrarTransito(v4, "Puesto Este", new DateTime(LocalDateTime.of(2025, 6, 1, 11, 45)));
		}
		Vehiculo v5 = sistemaUsuario.buscarVehiculoPorMatricula("QWE567");
		if (v5 != null) {
			sistemaTransito.registrarTransito(v5, "Puesto Central", new DateTime(LocalDateTime.of(2025, 7, 1, 12, 30)));
		}
		Vehiculo v6 = sistemaUsuario.buscarVehiculoPorMatricula("BFG123");
		if (v6 != null) {
			sistemaTransito.registrarTransito(v6, "Puesto Este", new DateTime(LocalDateTime.of(2025, 11, 1, 13, 15)));
		}
		Vehiculo v7 = sistemaUsuario.buscarVehiculoPorMatricula("BFG456");
		if (v7 != null) {
			sistemaTransito.registrarTransito(v7, "Puesto Este", new DateTime(LocalDateTime.of(2024, 12, 1, 14, 0)));
		}

		//buscar bonificaciones
        Bonificacion bonifExonerado = sistemaBonificacion.buscarBonificacionPorNombre("Exonerados");
        Bonificacion bonifFrecuente = sistemaBonificacion.buscarBonificacionPorNombre("Frecuentes");
        Bonificacion bonifTrabajador = sistemaBonificacion.buscarBonificacionPorNombre("Trabajadores");
        //asignar bonificaciones a propietarios
        sistemaBonificacion.asignarBonificacion(propE, puesto4, bonifExonerado);
        sistemaBonificacion.asignarBonificacion(propA, puesto1, bonifFrecuente);
        sistemaBonificacion.asignarBonificacion(propB, puesto2, bonifTrabajador);
        }

}
