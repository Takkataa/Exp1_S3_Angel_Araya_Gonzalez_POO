package cl.duoc.interfaces;

import java.util.Scanner;
import cl.duoc.model.Cliente;
import cl.duoc.model.Direccion;
import cl.duoc.model.Empleado;
import cl.duoc.model.Rut;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase InterfazUsuario.
 * Controla la interacción con el usuario a través de consola.
 * Permite crear clientes y empleados, validarlos y mostrar los últimos registros.
 */
public class InterfazUsuario {

    // Scanner para leer entradas desde consola
    private static final Scanner scanner = new Scanner(System.in);

    // Listas para almacenar clientes y empleados registrados
    private final List<Cliente> clientes = new ArrayList<>();
    private final List<Empleado> empleados = new ArrayList<>();

    /**
     * Método principal que inicia el menú de interacción.
     * Permite al usuario seleccionar opciones hasta que decida salir.
     */
    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1 -> crearCliente();
                case 2 -> crearEmpleado();
                case 3 -> mostrarUltimosClientes();
                case 4 -> mostrarUltimosEmpleados();
                case 5 -> System.out.println("\nSaliendo del sistema...");
                default -> System.out.println("\nOpción inválida.");
            }
        } while (opcion != 5);
    }

    /**
     * Muestra el menú principal en consola.
     */
    private void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===\n");
        System.out.println("Opcion 1: Crear Cliente");
        System.out.println("Opcion 2: Crear Empleado");
        System.out.println("Opcion 3: Ver últimos 3 clientes");
        System.out.println("Opcion 4: Ver últimos 3 empleados");
        System.out.println("Opcion 5: Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    /**
     * Lee la opción seleccionada por el usuario.
     * Valida que sea un número entero.
     * 
     * @return número de opción
     */
    private int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("\nDebe ingresar un número.");
            scanner.next();
            System.out.print("\nSeleccione una opción: ");
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return opcion;
    }

    /**
     * Agrega un empleado a la lista si es válido.
     * 
     * @param empleado objeto Empleado
     */
    public void agregarEmpleado(Empleado empleado) {
        if (empleado.esValida()) {
            empleados.add(empleado);
            System.out.println("\nEmpleado creado correctamente.");
        } else {
            System.out.println("\nError al validar empleado.");
        }
    }

    /**
     * Agrega un cliente a la lista si es válido.
     * 
     * @param cliente objeto Cliente
     */
    public void agregarCliente(Cliente cliente) {
        if (cliente.esValida()) {
            clientes.add(cliente);
            System.out.println("\nCliente creado correctamente.");
        } else {
            System.out.println("\nError al validar cliente.");
        }
    }

    /**
     * Crea un nuevo cliente solicitando datos por consola.
     * Valida los datos antes de agregarlo a la lista.
     */
    private void crearCliente() {
        System.out.println("\n--- Crear Cliente ---\n");
        String nombre = ValidadorInputs.leerNombre();
        String apellido = ValidadorInputs.leerApellido();
        String rutStr = ValidadorInputs.leerRut();
        String telefono = ValidadorInputs.leerTelefono();
        String correo = ValidadorInputs.leerCorreo();

        Rut rut = new Rut(rutStr);
        Direccion direccion = new Direccion(
            ValidadorInputs.leerTexto("calle y numeración", 100),
            ValidadorInputs.leerTexto("comuna", 50),
            ValidadorInputs.leerTexto("región", 50)
        );

        Cliente cliente = new Cliente(nombre, apellido, rut, direccion, correo, telefono);

        agregarCliente(cliente);
    }

    /**
     * Crea un nuevo empleado solicitando datos por consola.
     * Valida los datos antes de agregarlo a la lista.
     */
    private void crearEmpleado() {
        System.out.println("\n--- Crear Empleado ---\n");
        String nombre = ValidadorInputs.leerNombre();
        String apellido = ValidadorInputs.leerApellido();
        String rutStr = ValidadorInputs.leerRut();
        String correo = ValidadorInputs.leerCorreo();
        double sueldo = ValidadorInputs.leerSueldo();
        String cargo = ValidadorInputs.leerTexto("cargo", 50);

        Rut rut = new Rut(rutStr);
        Direccion direccion = new Direccion(
            ValidadorInputs.leerTexto("calle y numeración", 100),
            ValidadorInputs.leerTexto("comuna", 50),
            ValidadorInputs.leerTexto("región", 50)
        );

        Empleado empleado = new Empleado(nombre, apellido, rut, direccion, correo, cargo, sueldo);

        agregarEmpleado(empleado);
    }

    /**
     * Muestra los últimos 3 clientes registrados.
     * Si hay menos de 3, muestra todos.
     */
    private void mostrarUltimosClientes() {
        int total = clientes.size();
        if (total == 0) {
            System.out.println("\nNo hay clientes registrados.");
            return;
        }
        System.out.println("\n--- Últimos 3 Clientes ---\n");
        for (int i = Math.max(0, total - 3); i < total; i++) {
            Cliente c = clientes.get(i);
            System.out.println((i + 1) + ". " + c.getNombre() + " " + c.getApellido());
            System.out.println("Teléfono: " + c.getTelefono());
            System.out.println("RUT: " + c.getRut().getNumero());
            System.out.println("Dirección: " + c.getDireccion().getCalle() + ", " +
                               c.getDireccion().getComuna() + ", " + c.getDireccion().getRegion());
        }
    }

    /**
     * Muestra los últimos 3 empleados registrados.
     * Si hay menos de 3, muestra todos.
     */
    private void mostrarUltimosEmpleados() {
        int total = empleados.size();
        if (total == 0) {
            System.out.println("\nNo hay empleados registrados.");
            return;
        }
        System.out.println("\n--- Últimos 3 Empleados ---\n");
        for (int i = Math.max(0, total - 3); i < total; i++) {
            Empleado e = empleados.get(i);
            System.out.println((i + 1) + ". " + e.getNombre() + " " + e.getApellido());
            System.out.println("Cargo: " + e.getCargo());
            System.out.println("Sueldo: $" + e.getSueldo() + " Pesos");
            System.out.println("RUT: " + e.getRut().getNumero());
            System.out.println("Dirección: " + e.getDireccion().getCalle() + ", " +
                               e.getDireccion().getComuna() + ", " + e.getDireccion().getRegion());
        }
    }
}