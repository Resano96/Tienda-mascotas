package Tienda;

import java.util.ArrayList;

import static Tienda.Cliente.crearCliente;
import static Tienda.Mascota.crearMascota;

public class Datos {
    public static ArrayList<Cliente> ListadoDeClientes = new ArrayList<>();
    public static ArrayList<Mascota> ListadoDeMascotas = new ArrayList<>();
    public static ArrayList<Venta> ListadoDeVentas = new ArrayList<>();

public static void CargarDatos(){
    ListadoDeMascotas.add(crearMascota("Perro", "Labrador Retriever", "Amarillo", 2, 550));
    ListadoDeMascotas.add(crearMascota("Gato", "Siamés", "Crema con puntos marrones", 1, 350));
    ListadoDeMascotas.add(crearMascota("Perro", "Pastor Alemán", "Negro y fuego", 3, 650));
    ListadoDeMascotas.add(crearMascota("Gato", "Maine Coon", "Gris atigrado", 2, 500));
    ListadoDeMascotas.add(crearMascota("Perro", "Beagle", "Marrón y blanco", 1, 400));
    ListadoDeMascotas.add(crearMascota("Gato", "Persa", "Blanco", 2, 300));
    ListadoDeMascotas.add(crearMascota("Perro", "Labrador Retriever", "Negro", 4, 520));
    ListadoDeMascotas.add(crearMascota("Gato", "Siamés", "Crema con puntos marrones", 1, 360));
    ListadoDeMascotas.add(crearMascota("Perro", "Beagle", "Marrón y blanco", 2, 420));
    ListadoDeMascotas.add(crearMascota("Gato", "Persa", "Blanco", 3, 310));

    ListadoDeClientes.add(crearCliente("Juan Pérez", "12345678A", 600123456, "juan.perez@email.com"));
    ListadoDeClientes.add(crearCliente("María López", "87654321B", 611987654, "maria.lopez@email.com"));
    ListadoDeClientes.add(crearCliente("Carlos García", "11223344C", 622345678, "carlos.garcia@email.com"));
    ListadoDeClientes.add(crearCliente("Laura Sánchez", "99887766D", 633456789, "laura.sanchez@email.com"));
    ListadoDeClientes.add(crearCliente("Pedro Martínez", "55443322E", 644567890, "pedro.martinez@email.com"));
    ListadoDeClientes.add(crearCliente("Ana Torres", "44332211F", 655678901, "ana.torres@email.com"));
    ListadoDeClientes.add(crearCliente("Javier Ruiz", "66778899G", 666789012, "javier.ruiz@email.com"));
    ListadoDeClientes.add(crearCliente("Elena Gómez", "33445566H", 677890123, "elena.gomez@email.com"));
    ListadoDeClientes.add(crearCliente("Sergio Navarro", "22113344I", 688901234, "sergio.navarro@email.com"));
    ListadoDeClientes.add(crearCliente("Marta Fernández", "77889900J", 699012345, "marta.fernandez@email.com"));
}
}