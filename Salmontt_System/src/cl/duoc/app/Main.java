package cl.duoc.app;

/**
 * Clase principal del programa.
 * Contiene el método main, que es el punto de entrada de la aplicación.
 * Desde aquí se ejecuta el flujo principal del programa, inicializando los objetos,
 * cargando los datos necesarios y llamando a otros métodos o clases según la lógica del sistema.
 */

import cl.duoc.interfaces.*; // Importa la interfaz de usuario
import cl.duoc.model.Direccion; // Importa la clase Direccion
import cl.duoc.model.Empleado;  // Importa la clase Empleado
import cl.duoc.model.Rut;       // Importa la clase Rut

public class Main {
	
	public static void main(String[] args) {
		
		// Se crea una instancia de la interfaz de usuario, que gestiona la interacción con el sistema
		InterfazUsuario interfazUsuario = new InterfazUsuario();
		
		// Se crea el primer empleado con sus datos personales, rut, dirección, correo, cargo y sueldo
		Empleado empleado1 = new Empleado(
			"KAKAROTO", // Nombre
	        "ROJAS",    // Apellido
	        new Rut("12345678-9"), // Rut validado
	        new Direccion("Av. Los Pinos 123", "Paine", "Santiago"), // Dirección completa
	        "KAKAROTOWINS@gmail.com", // Correo electrónico
	        "PELEADOR", // Cargo
	        750000      // Sueldo
	    );
		
		// Se agrega el empleado a la interfaz de usuario
		interfazUsuario.agregarEmpleado(empleado1);
		
	    // Segundo empleado
	    Empleado empleado2 = new Empleado(
	        "MARIO",
	        "CHAMPIÑON",
	        new Rut("87654321-K"),
	        new Direccion("Calle El Roble 456", "Puente Alto", "Santiago"),
	        "MARIOSALTA@gmail.com",
	        "FONTANERO",
	        950000
	    );
	    interfazUsuario.agregarEmpleado(empleado2);
	    
	    // Tercer empleado
	    Empleado empleado3 = new Empleado(
	        "KAIMAN",
	        "MAGIC",
	        new Rut("11223344-5"),
	        new Direccion("Camino Real 789", "La Florida", "Santiago"),
	        "VIVAHOLE@gmail.com",
	        "ASESINO",
	        1200000
	    );
	    interfazUsuario.agregarEmpleado(empleado3);
	    
	    // Se imprime la información de cada empleado en consola
	    System.out.println(empleado1);
        System.out.println(empleado2);
        System.out.println(empleado3); 
		
		// Se inicia la interfaz de usuario, que inicia el menú.
		interfazUsuario.iniciar();
	}

}