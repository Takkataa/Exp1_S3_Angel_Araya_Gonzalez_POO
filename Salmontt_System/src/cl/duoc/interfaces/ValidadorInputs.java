package cl.duoc.interfaces;

import java.util.Scanner;
import cl.duoc.utils.Validador;

/**
 * Clase utilitaria para leer y validar entradas del usuario desde consola.
 * Utiliza Scanner para capturar datos y la clase Validador<T> para aplicar reglas de validación.
 */
public class ValidadorInputs {

    // Scanner estático para leer desde consola
	private static final Scanner scanner = new Scanner(System.in);

    /**
     * Solicita y valida el nombre del usuario.
     * Aplica validaciones: no nulo, no vacío, formato de letras con espacios, máximo 50 caracteres.
     * 
     * @return nombre en mayúsculas
     */
    public static String leerNombre() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        while (!new Validador<>(nombre)
                    .isNotNull()
                    .isNotEmpty()
                    .matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+(?: [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$")
                    .maxLength(50)
                    .isValido()) {
            System.out.println("Nombre inválido. Intente nuevamente.");
            System.out.print("Ingrese nombre: ");
            nombre = scanner.nextLine();
        }

        return nombre.toUpperCase(); // Normaliza el formato
    }

    /**
     * Solicita y valida el apellido del usuario.
     * Aplica las mismas reglas que el nombre.
     * 
     * @return apellido en mayúsculas
     */
    public static String leerApellido() {
        System.out.print("Ingrese apellido: ");
        String apellido = scanner.nextLine();

        while (!new Validador<>(apellido)
                    .isNotNull()
                    .isNotEmpty()
                    .matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+(?: [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$")
                    .maxLength(50)
                    .isValido()) {
            System.out.println("Apellido inválido. Intente nuevamente.");
            System.out.print("Ingrese apellido: ");
            apellido = scanner.nextLine();
        }

        return apellido.toUpperCase();
    }

    /**
     * Solicita y valida el RUT chileno en formato estándar.
     * Ejemplo válido: 12345678-9
     * 
     * @return RUT ingresado
     */
    public static String leerRut() {
        System.out.print("Ingrese RUT (formato 12345678-9): ");
        String rut = scanner.nextLine();

        while (!new Validador<>(rut)
                    .isNotNull()
                    .isNotEmpty()
                    .matches("^\\d{7,8}-[\\dkK]$")
                    .isValido()) {
            System.out.println("RUT inválido. Intente nuevamente.");
            System.out.print("Ingrese RUT: ");
            rut = scanner.nextLine();
        }

        return rut;
    }

    /**
     * Solicita y valida un número de teléfono chileno sin prefijo nacional.
     * Debe tener 9 dígitos.
     * 
     * @return teléfono ingresado
     */
    public static String leerTelefono() {
        System.out.print("Ingrese teléfono (formato: 912345678, sin identificador nacional): ");
        String telefono = scanner.nextLine();

        while (!new Validador<>(telefono)
                    .isNotNull()
                    .isNotEmpty()
                    .matches("^\\d{9}$")
                    .isValido()) {
            System.out.println("Teléfono inválido. Intente nuevamente.");
            System.out.print("Ingrese teléfono: ");
            telefono = scanner.nextLine();
        }

        return telefono;
    }

    /**
     * Solicita y valida un texto genérico con longitud máxima.
     * Se puede usar para campos como dirección, cargo, etc.
     * 
     * @param campo nombre del campo a mostrar
     * @param maxLength longitud máxima permitida
     * @return texto en mayúsculas
     */
    public static String leerTexto(String campo, int maxLength) {
        System.out.print("Ingrese " + campo + ": ");
        String texto = scanner.nextLine();

        while (!new Validador<>(texto)
                    .isNotNull()
                    .isNotEmpty()
                    .maxLength(maxLength)
                    .isValido()) {
            System.out.println(campo + " inválido. Intente nuevamente.");
            System.out.print("Ingrese " + campo + ": ");
            texto = scanner.nextLine();
        }

        return texto.toUpperCase();
    }

    /**
     * Solicita y valida el sueldo como número decimal.
     * Debe ser mayor que 0.
     * 
     * @return sueldo ingresado
     */
    public static double leerSueldo() {
        System.out.print("Ingrese sueldo: ");
        
        // Validación de tipo numérico
        while (!scanner.hasNextDouble()) {
            System.out.println("Sueldo inválido. Debe ser un número.");
            scanner.next(); // descarta entrada inválida
            System.out.print("Ingrese sueldo: ");
        }

        double sueldo = scanner.nextDouble();
        scanner.nextLine(); // limpia el buffer

        // Validación de valor positivo
        while (!new Validador<>(sueldo).esMayor(0).isValido()) {
            System.out.println("El sueldo debe ser mayor que 0.");
            System.out.print("Ingrese sueldo: ");
            sueldo = scanner.nextDouble();
            scanner.nextLine();
        }

        return sueldo;
    }

    /**
     * Solicita y valida un correo electrónico con formato estándar.
     * 
     * @return correo ingresado
     */
    public static String leerCorreo() {
        System.out.print("Ingrese correo electrónico: ");
        String correo = scanner.nextLine();

        while (!new Validador<>(correo)
                    .isNotNull()
                    .isNotEmpty()
                    .matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
                    .isValido()) {
            System.out.println("Correo inválido. Intente nuevamente.");
            System.out.print("Ingrese correo electrónico: ");
            correo = scanner.nextLine();
        }

        return correo;
    }
}