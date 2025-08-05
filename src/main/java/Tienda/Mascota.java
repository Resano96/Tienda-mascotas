package Tienda;

import java.util.ArrayList;

/**
 * Clase que representa una mascota en la tienda.
 * Cada mascota tiene un ID único, especie, raza, color, edad, precio y estado de venta.
 */
public class Mascota {
    /**
     * Contador estático para generar IDs únicos.
     */
    private static int contadorID = 0;

    /**
     * Identificador único de la mascota.
     */
    private int ID;

    /**
     * Especie de la mascota (ej. perro, gato).
     */
    private String especie;

    /**
     * Raza de la mascota.
     */
    private String raza;

    /**
     * Color de la mascota.
     */
    private String color;

    /**
     * Edad de la mascota en años.
     */
    private int edad;

    /**
     * Precio de venta de la mascota.
     */
    private int precio;

    /**
     * Indica si la mascota ha sido vendida.
     */
    private boolean vendido;

    /**
     * Constructor de la clase Mascota.
     *
     * @param Especie Especie de la mascota.
     * @param Raza Raza de la mascota.
     * @param Color Color de la mascota.
     * @param Edad Edad de la mascota.
     * @param Precio Precio de la mascota.
     */

    public Mascota(String Especie, String Raza, String Color, int Edad, int Precio) {
        this.ID = ++contadorID;
        this.especie = Especie;
        this.raza = Raza;
        this.color = Color;
        this.edad = Edad;
        this.precio = Precio;
        this.vendido = false;
    }
    // GETS
    /**
     * Obtiene el ID de la mascota.
     * @return ID único.
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Obtiene la especie de la mascota.
     * @return Especie.
     */
    public String getEspecie() {
        return this.especie;
    }


    /**
     * Obtiene la raza de la mascota.
     * @return Raza.
     */
    public String getRaza() {
        return this.raza;
    }


    /**
     * Obtiene el color de la mascota.
     * @return Color.
     */
    public String getColor() {
        return this.color;
    }


    /**
     * Obtiene la edad de la mascota.
     * @return Edad en años.
     */
    public int getEdad() {
        return this.edad;
    }

    /**
     * Obtiene el precio de la mascota.
     * @return Precio en euros.
     */
    public int getPrecio() {
        return this.precio;
    }

    /**
     * Verifica si la mascota ha sido vendida.
     * @return {@code true} si ha sido vendida, {@code false} si no.
     */
    public boolean isVendido() {
        return vendido;
    }

    /// SETS

    // Sirven para modificar los valores

    /**
     * Establece la especie de la mascota.
     * @param especie Nueva especie.
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }


    /**
     * Establece la raza de la mascota.
     * @param raza Nueva raza.
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Establece el color de la mascota.
     * @param color Nuevo color.
     */
    public void setColor(String color) {
        this.color = color;
    }


    /**
     * Establece la edad de la mascota.
     * @param edad Nueva edad.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Establece el precio de la mascota.
     * @param precio Nuevo precio.
     */
    public void setPrecio(int precio){
        this.precio = precio;
    }


    /**
     * Marca la mascota como vendida o no.
     * @param vendido Estado de venta.
     */
    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    /**
     * Devuelve una representación en texto de la mascota.
     * @return Información detallada de la mascota.
     */
    @Override
    /// Modificamos toString() para que nos de los valores que queremos
    public String toString() {
        return "ID: " + ID + ", Especie: " + especie + ", Raza: " + raza + ", Color: " + color + ", Edad: " + edad + " años, Precio: " + precio + "€" + ", Vendido: " + vendido;
    }

    ///  CREACION DE MASCOTA


    /**
     * Crea una nueva mascota y la imprime por consola.
     *
     * @param Especie Especie de la mascota.
     * @param Raza Raza de la mascota.
     * @param Color Color de la mascota.
     * @param Edad Edad de la mascota.
     * @param Precio Precio de la mascota.
     * @return Nueva instancia de Mascota.
     */    public static Mascota crearMascota(String Especie, String Raza, String Color, int Edad, int Precio){


        Mascota mascota1 = new Mascota(Especie, Raza, Color, Edad, Precio);



        System.out.println(
                "Mascota: "
                        + mascota1.getID()+ ", "
                        + mascota1.getEspecie()+ ", "
                        + mascota1.getRaza() + ", "
                        + mascota1.getColor()+ ", "
                        + mascota1.getEdad() + ", "
                        + mascota1.getPrecio()
        );
        return mascota1;

    }
    /**
     * Elimina una mascota de la lista según su ID.
     *
     * @param ListaAnimales Lista de mascotas.
     * @param ID ID de la mascota a eliminar.
     * @return Lista actualizada sin la mascota eliminada.
     */    public static ArrayList<Mascota> EliminarMascota(ArrayList<Mascota> ListaAnimales, int ID ) {
    ListaAnimales.removeIf(mascota -> mascota.getID() == ID);
        return ListaAnimales;
    }

    /**
     * Muestra en consola todas las mascotas que aún no han sido vendidas.
     *
     * @param ListaAnimales Lista de todas las mascotas.
     */
    public static void Catalogo (ArrayList<Mascota> ListaAnimales){
        System.out.println("Catalogo completo de Mascotas");
        ArrayList<Mascota> ListaFiltrada = new ArrayList<>();


        for (Mascota m1:ListaAnimales){
            if(!m1.isVendido()){
                ListaFiltrada.add(m1);
            }
        }
        for (Mascota Animal : ListaFiltrada){
            System.out.println(Animal);
        }
    }

    /**
     * Cambia el precio de una mascota específica por su ID.
     *
     * @param ID ID de la mascota.
     * @param NuevoPrecio Nuevo precio a establecer.
     */
    public static void CambiarPrecio(int ID, int NuevoPrecio){
        for (Mascota m : Datos.ListadoDeMascotas){
            if (m.getID() == ID){
                m.setPrecio(NuevoPrecio);
                System.out.println("Precio de la mascota con id "+ ID + " ha sido actualizado a " + NuevoPrecio + " €");
                return;
            }
        }
        System.out.println("ID no encontrado");
    }
}