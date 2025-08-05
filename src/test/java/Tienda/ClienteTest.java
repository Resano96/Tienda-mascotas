package Tienda;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

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
    void testCrearCliente() {
        Cliente cliente = Cliente.crearCliente("Ana", "12345678A", 600000000, "ana@email.com");

        assertNotNull(cliente);
        assertEquals("Ana", cliente.getNombre());
        assertEquals("12345678A", cliente.getDNI());
        assertEquals(600000000, cliente.getTelefono());
        assertEquals("ana@email.com", cliente.getEmail());

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("Nuevo Cliente"));
        assertTrue(salida.contains("Nombre:Ana"));
    }

    @Test
    void testEliminarCliente() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Cliente c1 = new Cliente("Pepe", "111A", 123, "pepe@correo.com");
        Cliente c2 = new Cliente("Lola", "222B", 456, "lola@correo.com");

        lista.add(c1);
        lista.add(c2);

        Cliente.eliminarCliente(lista, "111A");

        assertEquals(1, lista.size());
        assertEquals("222B", lista.get(0).getDNI());
    }

    @Test
    void testMostrarClientes() {
        ArrayList<Cliente> lista = new ArrayList<>();
        Cliente c1 = new Cliente("Juan", "333C", 789, "juan@correo.com");
        lista.add(c1);

        Cliente.mostrarCLientes(lista);

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("Listado Completo de Clientes"));
        assertTrue(salida.contains("Nombre: Juan"));
        assertTrue(salida.contains("DNI: 333C"));
    }

    @Test
    void testAñadirMascotasACliente() {
        Cliente cliente = new Cliente("Ana", "444D", 123456789, "ana@test.com");
        List<Integer> mascotas = List.of(1, 2, 3);

        cliente.AñadirMascotasACliente(new ArrayList<>(mascotas));

        assertEquals(3, cliente.getMascotas().size());
        assertTrue(cliente.getMascotas().contains(2));
    }

    @Test
    void testCambiarTelefonoClienteExistente() {
        Datos.ListadoDeClientes = new ArrayList<>();
        Cliente cliente = new Cliente("Mario", "555E", 999, "mario@test.com");
        Datos.ListadoDeClientes.add(cliente);

        Cliente.CambiarTelefono("555E", 777);
        assertEquals(777, cliente.getTelefono());
    }

    @Test
    void testCambiarTelefonoClienteNoExistente() {
        Datos.ListadoDeClientes = new ArrayList<>();
        Cliente.CambiarTelefono("NO_EXISTE", 123);

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("no corresponde a ningun cliente"));
    }

    @Test
    void testCambiarEmailClienteExistente() {
        Datos.ListadoDeClientes = new ArrayList<>();
        Cliente cliente = new Cliente("Lucía", "666F", 888, "lucia@old.com");
        Datos.ListadoDeClientes.add(cliente);

        Cliente.CambiarEmail("666F", "lucia@new.com");

        assertEquals("lucia@new.com", cliente.getEmail());
    }

    @Test
    void testCambiarEmailClienteNoExistente() {
        Datos.ListadoDeClientes = new ArrayList<>();


        Cliente.CambiarEmail("CUALQUIER COSA QUE NO SEA EL DNI VALIDO", "nuevo@email.com");

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("no corresponde a ningun cliente"));
    }
}