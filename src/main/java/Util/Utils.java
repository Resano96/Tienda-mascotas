package Util;

import java.util.Scanner;
import java.time.LocalDate;

public class Utils {

    public static final Scanner scanner = new Scanner(System.in);

    /// Función para pedir un número entero y verificar si lo es
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

    /// Función para pedir un texto y verificar si lo es
    public static String pedirString(String mensaje) {
        String texto = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim(); // quitamos espacios en blanco al inicio/final

            if (texto.isEmpty()) {
                System.out.println("⚠️ ERROR: Debes introducir un texto.");
            } else {
                entradaValida = true;
            }
        }
        return texto;
    }

}
