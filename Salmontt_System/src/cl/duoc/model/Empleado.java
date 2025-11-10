package cl.duoc.model;

import cl.duoc.utils.Validador; // Importa la clase Validador para aplicar reglas de validación

/**
 * Clase Empleado que extiende de Persona.
 * Representa a un empleado con atributos adicionales como cargo y sueldo.
 */
public class Empleado extends Persona {
    
    // Atributos específicos del empleado
    private String cargo;
    private double sueldo;

    public Empleado(String nombre, String apellido, Rut rut, Direccion direccion, String correo, String cargo, double sueldo) {
        super(nombre, apellido, rut, direccion, correo); // Llama al constructor de la clase Persona
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    /**
     * Método que valida si el empleado tiene datos válidos.
     * Valida los datos heredados y además el cargo y sueldo.
     * 
     * @return true si todos los datos son válidos, false en caso contrario
     */
    @Override
    public boolean esValida() {
        return super.esValida() // Valida los campos de Persona
            && new Validador<>(cargo) // Valida el cargo
                .isNotNull()          // No debe ser nulo
                .isNotEmpty()         // No debe estar vacío
                .maxLength(50)        // Máximo 50 caracteres
                .isValido()
            && new Validador<>(sueldo) // Valida el sueldo
                .esMayor(0)           // Debe ser mayor a 0
                .isValido();
    }
    
    /**
     * Representación en texto del empleado.
     * Incluye nombre, rut, cargo, sueldo y dirección.
     */
    @Override
    public String toString() {
        return "Empleado: " + getNombre() + " " + getApellido() +
               "\n  RUT: " + getRut().getNumero() +
               "\n  Cargo: " + cargo +
               "\n  Sueldo: $" + sueldo +
               "\n  Dirección: " + getDireccion().toString();
    }

    // Métodos getter y setter para los atributos propios

	public String getCargo() {
		return cargo;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
}