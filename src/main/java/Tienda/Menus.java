package Tienda;

import Util.Utils;

public class Menus {
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
    public static int menuClientes() {
        System.out.println(
                "\n\tMENU CLIENTES \n" +
                        "1.- Alta de Clientes\n" +
                        "2.- Listado de Clientes\n" +
                        "3.- Modificación de Clientes\n" +
                        "4.- Baja de Clientes\n" +
                        "5.- Buscar por DNI\n " +
                        "6.- Volver al Menú Principal\n" +
                        "7.- Salir"
        );
        return Utils.pedirEntero("Elige una opción: ");
    }
    public static int menuMascotas() {
        System.out.println(
                "\n\tMENU MASCOTAS \n" +
                        "1.- Alta de Mascotas\n" +
                        "2.- Búsqueda de Mascotas (Filtros)\n" +
                        "3.- Modificación de Precios\n" +
                        "4.- Baja de Mascotas\n" +
                        "5.- Volver al Menú Principal\n" +
                        "6.- Salir"
        );
        return Utils.pedirEntero("Elige una opción: ");
    }
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
