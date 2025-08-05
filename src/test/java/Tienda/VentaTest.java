package Tienda;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VentaTest {

    private final ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
    private final PrintStream salidaOriginal = System.out;

    @BeforeEach
    void redirigirSalida() {
        System.setOut(new PrintStream(salidaConsola));
    }

    @AfterEach
    void restaurarSalida() {
        System.setOut(salidaOriginal);
        salidaConsola.reset();
    }

    @Test
    void testCompraExitosa() {
        Datos.ListadoDeClientes = new ArrayList<>();
        Datos.ListadoDeMascotas = new ArrayList<>();

        Cliente cliente = new Cliente("Ander", "12345678A", 600123123, "ander@email.com");
        Mascota mascota1 = new Mascota("Perro", "Boxer", "Negro", 2, 400);
        Mascota mascota2 = new Mascota("Gato", "Sphynx", "Rosa", 1, 600);

        Datos.ListadoDeClientes.add(cliente);
        Datos.ListadoDeMascotas.add(mascota1);
        Datos.ListadoDeMascotas.add(mascota2);

        ArrayList<Integer> idMascotas = new ArrayList<>();
        idMascotas.add(mascota1.getID());
        idMascotas.add(mascota2.getID());

        Venta venta = Venta.Compra("12345678A", idMascotas);

        assertNotNull(venta);
        assertEquals(1000, venta.getPrice());
        assertTrue(mascota1.isVendido());
        assertTrue(mascota2.isVendido());
        assertEquals(List.of(mascota1.getID(), mascota2.getID()), venta.getList_id_pet());

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("El precio total de la compra es de 1000"));
    }

    @Test
    void testCompraConClienteNoExistente() {
        Datos.ListadoDeClientes = new ArrayList<>();
        Datos.ListadoDeMascotas = new ArrayList<>();

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);

        Venta venta = Venta.Compra("NO_EXISTE", ids);

        assertNull(venta);
        assertTrue(salidaConsola.toString().contains("Cliente no encontrado"));
    }

    @Test
    void testCompraConMascotaNoExistente() {
        Datos.ListadoDeClientes = new ArrayList<>();
        Datos.ListadoDeMascotas = new ArrayList<>();

        Cliente cliente = new Cliente("Lucía", "87654321B", 123456789, "lucia@email.com");
        Datos.ListadoDeClientes.add(cliente);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(999);

        Venta venta = Venta.Compra("87654321B", ids);

        assertNull(venta);
        assertTrue(salidaConsola.toString().contains("Mascota no encontrada"));
    }

    @Test
    void testCompraConMascotaVendida() {
        Datos.ListadoDeClientes = new ArrayList<>();
        Datos.ListadoDeMascotas = new ArrayList<>();

        Cliente cliente = new Cliente("Pedro", "11223344C", 123456789, "pedro@email.com");
        Mascota mascota = new Mascota("Perro", "Bulldog", "Blanco", 3, 500);
        mascota.setVendido(true);

        Datos.ListadoDeClientes.add(cliente);
        Datos.ListadoDeMascotas.add(mascota);

        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(mascota.getID());

        Venta venta = Venta.Compra("11223344C", ids);

        assertNull(venta);
        assertTrue(salidaConsola.toString().contains("La mascota ya ha sido vendida"));
    }

    @Test
    void testMostrarVentas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        Venta venta = new Venta(LocalDate.of(2024, 1, 1), "1234", List.of(1, 2), 700);
        ventas.add(venta);

        Venta.MostrarVentas(ventas);

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("NºVenta:"));
        assertTrue(salida.contains("1234"));
        assertTrue(salida.contains("Precio Total: 700"));
    }

    @Test
    void testMostrarVentaConDNI() {
        ArrayList<Venta> ventas = new ArrayList<>();
        Venta v1 = new Venta(LocalDate.now(), "AAA", List.of(3), 300);
        Venta v2 = new Venta(LocalDate.now(), "BBB", List.of(4), 400);
        ventas.add(v1);
        ventas.add(v2);

        Venta.MostrarVentaConDNI(ventas, "BBB");

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("BBB"));
        assertFalse(salida.contains("AAA"));
    }
}