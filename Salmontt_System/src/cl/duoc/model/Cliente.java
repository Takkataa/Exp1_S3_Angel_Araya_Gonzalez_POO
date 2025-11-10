package cl.duoc.model;

import cl.duoc.utils.Validador;

/**
 * Clase Cliente que extiende de Persona.
 * Representa a un cliente con atributos personales más un número de teléfono.
 * Incluye validación adicional específica para el campo teléfono.
 */
public class Cliente extends Persona {

    // Atributo adicional exclusivo de Cliente
    private String telefono;

    /**
     * Constructor de Cliente.
     * Inicializa los atributos heredados y el teléfono.
     * 
     * @param nombre     Nombre del cliente
     * @param apellido   Apellido del cliente
     * @param rut        Rut del cliente (objeto Rut)
     * @param direccion  Dirección del cliente (objeto Direccion)
     * @param correo     Correo electrónico del cliente
     * @param telefono   Número de teléfono del cliente
     */
    public Cliente(String nombre, String apellido, Rut rut, Direccion direccion, String correo, String telefono) {
        super(nombre, apellido, rut, direccion, correo); // Llama al constructor de Persona
        this.telefono = telefono;
    }

    /**
     * Método que valida si los datos del cliente son válidos.
     * Valida los campos heredados y el formato del teléfono.
     * 
     * @return true si todos los datos son válidos, false en caso contrario
     */
    @Override
    public boolean esValida() {
        return super.esValida() // Valida los campos de Persona
            && new Validador<>(telefono) // Valida el teléfono
                .isNotNull()             // No debe ser nulo
                .isNotEmpty()            // No debe estar vacío
                .matches("^\\+?\\d{8,15}$") // Debe tener entre 8 y 15 dígitos, opcionalmente con "+"
                .isValido();
    }

    // Métodos getter y setter para el atributo teléfono

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}