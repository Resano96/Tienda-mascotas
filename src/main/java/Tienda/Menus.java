package Tienda;

import Util.Utils;

/**
 * Clase que contiene los menús principales del sistema.
 * Cada método imprime un menú por consola y solicita al usuario que seleccione una opción.
 */
public class Menus {

    /**
     * Muestra el menú principal de la aplicación.
     *
     * @return La opción seleccionada por el usuario.
     */
    public static int menuPrincipal() {
        System.out.println(
                "\n\tTIENDA \n" +
                        "1.- Gestion de Clientes\n" +
                        "2.- Gestion de Mascotas\n" +
                        "3.- Gestion de Ventas\n" +
                        "4.- Cargar Datos de Ejemplo\n" +
                        "5.- Salir"
        );
        return Utils.pedirEntero("Elige una opción: ");
    }

    /**
     * Muestra el menú de gestión de clientes.
     *
     * @return La opción seleccionada por el usuario.
     */
    public static int menuClientes() {
        System.out.println(
                "\n\tMENU CLIENTES \n" +
                        "1.- Alta de Clientes\n" +
                        "2.- Listado de Clientes\n" +
                        "3.- Modificación de Clientes\n" +
                        "4.- Baja de Clientes\n" +
                        "5.- Volver al Menú Principal\n" +
                        "6.- Salir"
        );
        return Utils.pedirEntero("Elige una opción: ");
    }

    /**
     * Muestra el menú de gestión de mascotas.
     *
     * @return La opción seleccionada por el usuario.
     */
    public static int menuMascotas() {
        System.out.println(
                "\n\tMENU MASCOTAS \n" +
                        "1.- Alta de Mascotas\n" +
                        "2.- Lista de mascotas\n" +
                        "3.- Modificación de Precios\n" +
                        "4.- Baja de Mascotas\n" +
                        "5.- Volver al Menú Principal\n" +
                        "6.- Salir"
        );
        return Utils.pedirEntero("Elige una opción: ");
    }

    /**
     * Muestra el menú de gestión de ventas.
     *
     * @return La opción seleccionada por el usuario.
     */
    public static int menuVentas() {
        System.out.println(
                "\n\tMENU VENTAS \n" +
                        "1.- Vender\n" +
                        "2.- Mostrar Ventas\n" +
                        "3.- Filtrar ventas por cliente\n" +
                        "4.- Volver al Menú Principal\n" +
                        "5.- Salir"
        );
        return Utils.pedirEntero("Elige una opción: ");
    }
}
