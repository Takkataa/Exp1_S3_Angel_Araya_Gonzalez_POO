package cl.duoc.model;

import cl.duoc.utils.Validador;

/**
 * Clase abstracta Persona.
 * Representa una entidad genérica con atributos comunes como nombre, apellido, RUT, dirección y correo.
 * Es utilizada como clase base para otras entidades como Cliente y Empleado.
 */
public class Persona {

    // Atributos comunes a todas las personas
	private String nombre;
	private String apellido;
	private Rut rut;
	private Direccion direccion;
	private String correo;

    /**
     * Constructor de Persona.
     * Inicializa todos los atributos personales.
     * 
     * @param nombre     Nombre de la persona
     * @param apellido   Apellido de la persona
     * @param rut        RUT (objeto Rut)
     * @param direccion  Dirección (objeto Direccion)
     * @param correo     Correo electrónico
     */
	public Persona(String nombre, String apellido, Rut rut, Direccion direccion, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.direccion = direccion;
		this.correo = correo;
	}

    /**
     * Valida los datos básicos de la persona.
     * Verifica nombre, apellido, RUT y dirección.
     * 
     * @return true si todos los campos son válidos, false si alguno falla
     */
	public boolean esValida() {
		return new Validador<>(nombre)
					.isNotNull()
					.isNotEmpty()
					.maxLength(50)
					.isValido()
			&& new Validador<>(apellido)
					.isNotNull()
					.isNotEmpty()
					.maxLength(50)
					.isValido()
			&& rut != null && rut.esValido()
			&& direccion != null && direccion.esValida();
	}

	// Métodos getter para acceder a los atributos

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Rut getRut() {
		return rut;
	}

	public Direccion getDireccion() {
		return direccion;
	}
	
	public String getCorreo() {
		return correo;
	}

	// Métodos setter para modificar los atributos

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setRut(Rut rut) {
		this.rut = rut;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}