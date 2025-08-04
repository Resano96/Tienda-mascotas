package Tienda;

import java.util.ArrayList;


public class Mascota {
    private static int contadorID = 0;
    private int ID;
    private String especie;
    private String raza;
    private String color;
    private int edad;
    private int precio;
    private boolean vendido;

/// Constructor, getters y setters

    public Mascota(String Especie, String Raza, String Color, int Edad, int Precio) {
        this.ID = ++contadorID;
        this.especie = Especie;
        this.raza = Raza;
        this.color = Color;
        this.edad = Edad;
        this.precio = Precio;
        this.vendido = false;
    }

    /// GETS

    // Sirven para consultar los valores
    public int getID() {
        return this.ID;
    }

    public String getEspecie() {
        return this.especie;
    }

    public String getRaza() {
        return this.raza;
    }

    public String getColor() {
        return this.color;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getPrecio() {
        return this.precio;
    }

    public boolean isVendido() {
        return vendido;
    }

    /// SETS

    // Sirven para modificar los valores

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPrecio(int precio){
        this.precio = precio;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    @Override
    /// Modificamos toString() para que nos de los valores que queremos
    public String toString() {
        return "ID: " + ID + ", Especie: " + especie + ", Raza: " + raza + ", Color: " + color + ", Edad: " + edad + " años, Precio: " + precio + "€" + ", Vendido: " + vendido;
    }

    ///  CREACION DE MASCOTA

    /// Crea una mascota con los valores dados entre parentesis, El id se genera solo y por defecto, al crear una mascota tiene el booleano de vendido en false. Devuelve la mascota
    public static Mascota crearMascota(String Especie, String Raza, String Color, int Edad, int Precio){


        Mascota mascota1 = new Mascota(Especie, Raza, Color, Edad, Precio);

        // Muestra todos los valores en una frase

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
    ///  Eliminar 1 mascota por su id (valor unico autoincremntal) de la lista de animales dada en los parametros. Devuelve la lista modificada
    public static ArrayList<Mascota> EliminarMascota(ArrayList<Mascota> ListaAnimales, int ID ) {
    ListaAnimales.removeIf(mascota -> mascota.getID() == ID);
        return ListaAnimales;
    }

    /// MOSTRAR EL CATALOGO
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