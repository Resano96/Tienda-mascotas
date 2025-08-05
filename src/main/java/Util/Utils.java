package Util;

import java.util.Scanner;
import java.time.LocalDate;

/**
 * Clase utilitaria con funciones estáticas para la entrada de datos desde consola.
 */
public class Utils {

    /**
     * Escáner global para lectura de datos por consola.
     */
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * Solicita al usuario un número entero y valida la entrada.
     * Si el usuario introduce un valor no válido, se le vuelve a pedir.
     *
     * @param mensaje Mensaje que se muestra al usuario para pedir el número.
     * @return Número entero introducido por el usuario.
     */
    public static int pedirEntero(String mensaje) {
        int numero = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println(mensaje);
            try {
                numero = scanner.nextInt();
                scanner.nextLine();
                entradaValida = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("ERROR: Debes introducir un número.");
                scanner.nextLine();
            }
        }
        return numero;
    }

    /**
     * Solicita al usuario una cadena de texto y valida que no esté vacía.
     * Si el usuario no introduce texto, se le vuelve a pedir.
     *
     * @param mensaje Mensaje que se muestra al usuario para pedir el texto.
     * @return Texto introducido por el usuario.
     */
    public static String pedirString(String mensaje) {
        String texto = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            // quitamos espacios en blanco al inicio/final
            texto = scanner.nextLine().trim();

            if (texto.isEmpty()) {
                System.out.println("Debes introducir un texto.");
            } else {
                entradaValida = true;
            }
        }
        return texto;
    }

}
