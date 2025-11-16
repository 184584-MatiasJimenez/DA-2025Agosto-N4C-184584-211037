package com.example.obligatorioPeajes.modelo;

public class SistemaPrecarga {


	public void cargarDatosIniciales() {
		SistemaUsuario sistemaUsuario = SistemaUsuario.getInstancia();
		SistemaTransito sistemaTransito = SistemaTransito.getInstancia();
		SistemaBonificacion sistemaBonificacion = SistemaBonificacion.getInstancia();

		//Precarga de estados de propietarios
		sistemaUsuario.precargaEstados();

		//precarga de categorías de vehiculos
		CategoriaVehiculo categoriaAuto = new CategoriaVehiculo("Automóvil");
		CategoriaVehiculo catCamioneta = new CategoriaVehiculo("Camioneta");
		CategoriaVehiculo categoriaMoto = new CategoriaVehiculo("Moto");

		//tipos de bonificaciones
		sistemaBonificacion.precargaTiposBonificaciones();

		//agregar puestos
		PuestoDePeaje puesto1 = sistemaTransito.agregarPuestoDePeaje("Puesto Central", "Ruta 1 km 20");
		PuestoDePeaje puesto2 = sistemaTransito.agregarPuestoDePeaje("Puesto Norte", "Ruta 5 km 50");
        PuestoDePeaje puesto3 = sistemaTransito.agregarPuestoDePeaje("Puesto Sur", "Ruta 10 km 100");
        PuestoDePeaje puesto4 = sistemaTransito.agregarPuestoDePeaje("Puesto Este", "Ruta 15 km 150");

		//Agregar administradores
		sistemaUsuario.agregarAdministrador("52345679", "Usuario Admin", "Admin.123");
		sistemaUsuario.agregarAdministrador("53345670", "Maria Lopez", "Admin.456");

		//agregar propietarios
		sistemaUsuario.agregarPropietario("19345678", "Carolina Perez", "Prop.123", 2000, 400);
		sistemaUsuario.agregarPropietario("20345676", "Juan Gomez", "Prop.456", 1500, 300);
		sistemaUsuario.agregarPropietario("22345675", "Luis Rodriguez", "Prop.789", 1800, 350);
		sistemaUsuario.agregarPropietario("23345674", "Ana Martinez", "Prop.321", 2200, 500);
		sistemaUsuario.agregarPropietario("24345673", "Pedro Sanchez", "Prop.654", 1700, 250);

		Propietario propA = sistemaUsuario.buscarPropietarioPorCI("19345678");
		Propietario propB = sistemaUsuario.buscarPropietarioPorCI("20345676");
		Propietario propC = sistemaUsuario.buscarPropietarioPorCI("22345675");
		Propietario propD = sistemaUsuario.buscarPropietarioPorCI("23345674");
		Propietario propE = sistemaUsuario.buscarPropietarioPorCI("24345673");

		//Agregar vehiculos
		categoriaAuto = sistemaTransito.buscarCategoriaPorNombre("Automóvil");
		sistemaUsuario.agregarVehiculo(propA, "ABC123", "Toyota", "Corolla", "Rojo", 2020, categoriaAuto);
		sistemaUsuario.agregarVehiculo(propB, "DEF456", "Honda", "Civic", "Azul", 2019, categoriaAuto);
		sistemaUsuario.agregarVehiculo(propC, "GHI789", "Ford", "Focus", "Negro", 2021, categoriaAuto);
        
		categoriaMoto = sistemaTransito.buscarCategoriaPorNombre("Moto");
		sistemaUsuario.agregarVehiculo(propD, "MOTO1", "Yamaha", "YZF-R3", "Blanco", 2021, categoriaMoto);
		sistemaUsuario.agregarVehiculo(propE, "MOTO2", "Kawasaki", "Ninja 400", "Verde", 2020, categoriaMoto);  
		catCamioneta = sistemaTransito.buscarCategoriaPorNombre("Camioneta");
		sistemaUsuario.agregarVehiculo(propC, "CAMIONETA1", "Chevrolet", "Trax", "Gris", 2022, catCamioneta);
		sistemaUsuario.agregarVehiculo(propA, "CAMIONETA2", "Jeep", "Renegade", "Blanco", 2018, catCamioneta);


	}

}
