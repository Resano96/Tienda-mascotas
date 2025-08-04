package Tienda;

import java.util.ArrayList;
import static Tienda.Mascota.*;
import static Tienda.Cliente.*;
import static Tienda.Menus.*;
import static Tienda.Venta.*;
import static Util.Utils.*;
import static Tienda.Datos.*;

public class Main {
    public static void main (String[]args){

        boolean salir = false;

        while (!salir) {
            int opcion = menuPrincipal();

            switch (opcion) {
                case 1 -> {
                    boolean volver = false;
                    while (!volver) {
                        int opCliente = menuClientes();
                        switch (opCliente) {
                            case 1 -> {
                                /// Primero pedimos los valores, luego ejecuta crearCliente con los valores anteriores y finalmente lo añadimos a la lista de clientes
                                //Primero pedimos los valores
                                String NombreCliente = pedirString("Dime el nombre del cliente a añadir");

                                String DNI = pedirString("Dime el DNI del cliente a añadir");

                                int Telefono = pedirEntero("Dime el telefono del cliente a añadir");

                                String Email = pedirString("Dime el email del cliente a añadir");

                                //luego ejecuta crearCliente con los valores anteriores
                                Cliente c1 = crearCliente(NombreCliente,DNI,Telefono,Email);

                                //finalmente, lo añadimos a la lista de clientes
                                ListadoDeClientes.add(c1);}

                            case 2 ->{
                                mostrarCLientes(ListadoDeClientes);
                            }
                            case 3 -> {
                                String DNI =pedirString("A quien quieres cambiarle algo?");

                                String ValorACambiar=pedirString("Que valor quieres cambiar? (telefono o email)");
                                if (ValorACambiar.equalsIgnoreCase("telefono")){
                                    int NuevoTelefono = pedirEntero("Dime el numero de telefono nuevo");
                                    CambiarTelefono(DNI, NuevoTelefono);

                                } else if (ValorACambiar.equalsIgnoreCase("email")) {
                                    String NuevoEmail = pedirString("Dime el email nuevo");
                                    CambiarEmail(DNI,NuevoEmail);

                                } else {
                                    System.out.println("Valor no valido");
                                }
                            }
                            case 4 -> {
                                /// Primero muestra todos los clientes, luego pide el DNI del cliente a borrar y luego lo borra de la lista ListadoDeClientes
                                //Muestra todos los clientes
                                mostrarCLientes(ListadoDeClientes);

                                //Pide un DNI para borrar
                                String DNIABorrar = pedirString("Dime el dni del cliente a borrar");

                                //elimina el Cliente con el dni anterior
                                eliminarCliente(ListadoDeClientes,DNIABorrar);
                            }
                            case 5 -> {

                            }
                            case 6 -> volver = true;
                            case 7 -> System.exit(0);
                            default -> System.out.println("Opcion invalida");
                        }
                    }
                }
                case 2 -> {
                    boolean volver = false;
                    while (!volver) {
                        int opMascota = menuMascotas();
                        switch (opMascota) {
                            case 1 -> {
                                /// Añadir Nueva Mascota
                                //Se crean las variables necesarias
                                String Especie = pedirString("Dime la especie de la mascota a añadir");

                                String Raza = pedirString("Dime la raza de la mascota a añadir");

                                String Color = pedirString("Dime el color de la mascota a añadir");

                                int Edad = pedirEntero("Dime la edad de la mascota a añadir");

                                int Precio = pedirEntero("Dime el precio de la mascota a añadir");
                                //Creamos la mascota
                                Mascota m1 = crearMascota(Especie, Raza, Color, Edad, Precio);


                                //La añadimos a la lista
                                ListadoDeMascotas.add(m1);
                            }
                            case 2 -> {
                                Catalogo(ListadoDeMascotas);
                            }
                            case 3 -> {
                                int IDACambiar = pedirEntero("Dime el ID de la mascota a la que quieres cambiarle el precio");
                                int NuevoPrecio = pedirEntero("Cual es el nuevo precio?");

                                CambiarPrecio(IDACambiar,NuevoPrecio);
                            }
                            case 4 -> {
                                /// Primero muestra todas las mascotas, luego pide el id de la mascota a eliminar y al final ejecuta EliminarMascota para borrarla de la lista ListadoDeMascotas
                                //Primero muestra todas las mascotas
                                Catalogo(ListadoDeMascotas);

                                //luego pide el id de la mascota a eliminar
                                int ID = pedirEntero("Dime el numero de ID de la mascota a eliminar");

                                //al final ejecuta EliminarMascota para borrar la mascota con el id entregado de la lista ListadoDeMascotas
                                EliminarMascota(ListadoDeMascotas,ID);
                            }
                            case 5 -> volver = true;
                            case 6 -> System.exit(0);
                            default -> System.out.println("Opcion no valida");
                        }
                    }
                }
                case 3 -> {
                    boolean volver = false;
                    while (!volver) {
                        int opVentas = menuVentas();
                        switch (opVentas) {
                            case 1 -> {
                                /// Primero pedimos los parametros para crear una venta, luego preguntamos cuantas mascotas y hacemos un array con los id de las mascotas que quiere comprar, finalmente creamos una venta con estos datos
                                String DNICliente = pedirString("Dime el DNI del comprador");

                                //luego preguntamos cuantas mascotas y hacemos un array con los id de las mascotas que quiere comprar
                                int CantidadMascotasCompradas = pedirEntero("Cuantas mascotas quieres vender?");

                                ArrayList<Integer> listaIDs= new ArrayList<>();

                                for (int i = 0; i < CantidadMascotasCompradas; i++) {
                                    int IDMascota = pedirEntero("Dime el id de la "+(i+1)+" mascota a comprar");
                                    listaIDs.add(IDMascota);
                                }
                                //finalmente creamos una venta con estos datos y la añadimos a la lista ListaDeVentas

                                Venta c1=Compra(DNICliente,listaIDs);

                                ListadoDeVentas.add(c1);
                            }
                            case 2 -> {
                                MostrarVentas(ListadoDeVentas);
                            }
                            case 3 ->{
                                String DNI = pedirString("Dime el DNI del cliente que quieres usar de filtro");
                                MostrarVentaConDNI(ListadoDeVentas, DNI);
                                }
                            case 4 -> volver = true;
                            case 5 -> System.exit(0);
                            default -> System.out.println("Opcion no valida");
                        }
                    }
                }
                case 4 -> {
                    CargarDatos();
                }
                case 5 -> {
                    System.out.println( crearCliente("Ander", "123131", 1233123, "asdasdad"));
                    Cliente c1= crearCliente("Ander", "123131", 1233123, "asdasdad");
                    //salir = true;
                }
                default -> System.out.println("Opcion no valida");
            }
        }
        System.out.println("¡Hasta luego!");
    }
}

