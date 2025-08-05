package Tienda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MascotaTest {

    private final ByteArrayOutputStream salidaConsola = new ByteArrayOutputStream();
    private final PrintStream salidaOriginal = System.out;

    @BeforeEach
    public void redirigirSalida() {
        System.setOut(new PrintStream(salidaConsola));
    }

    @AfterEach
    public void restaurarSalida() {
        System.setOut(salidaOriginal);
    }

    @Test
    public void testCrearMascota() {
        Mascota mascota = Mascota.crearMascota("Perro", "Labrador", "Negro", 2, 500);
        assertNotNull(mascota);
        assertEquals("Perro", mascota.getEspecie());
        assertEquals("Labrador", mascota.getRaza());
        assertEquals("Negro", mascota.getColor());
        assertEquals(2, mascota.getEdad());
        assertEquals(500, mascota.getPrecio());

        String salida = salidaConsola.toString();
        assertTrue(salida.contains("Mascota:"));
        assertTrue(salida.contains("Labrador"));
    }

    @Test
    public void testCatalogoSoloMuestraNoVendidos() {
        ArrayList<Mascota> lista = new ArrayList<>();
        Mascota m1 = new Mascota("Perro", "Pastor", "Marrón", 3, 450);
        Mascota m2 = new Mascota("Gato", "Siberiano", "Gris", 2, 300);
        m2.setVendido(true);  // este no debe mostrarse

        lista.add(m1);
        lista.add(m2);

        Mascota.Catalogo(lista);
        String salida = salidaConsola.toString();

        assertTrue(salida.contains("Catalogo completo de Mascotas"));
        assertTrue(salida.contains("Pastor"));
        assertFalse(salida.contains("Siberiano"));
    }


    public static class Datos {
        public static ArrayList<Mascota> ListadoDeMascotas;
    }
}