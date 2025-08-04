package Tienda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/// Definimos la clase Venta
public class Venta {
    private static int contadorID = 0;
    private static int ID;
    private LocalDate  date;
    private String id_buyer;
    private List<Integer> List_id_pet;
    private int price;

    public Venta(LocalDate  Fecha, String DNI_Comprador, List<Integer> ListaDeIDMascotasID, int Price) {
        this.ID = ++contadorID;
        this.date = Fecha;
        this.id_buyer = DNI_Comprador;
        this.List_id_pet = ListaDeIDMascotasID;
        this.price = Price;
    }
    /// GETS

    //Sirven para consultar los valores
    public int getId(){return this.ID;}

    public LocalDate getDate(){return this.date;}

    public String getId_buyer(){return this.id_buyer;}

    public List<Integer> getList_id_pet(){return this.List_id_pet;}

    public int getPrice() {
        return price;
    }

    /// SETS

    //Sirven para modificar los valores

    public void setDate(LocalDate  date) {
        this.date = date;
    }

    public void setId_buyer(String DNI_Comprador) {
        this.id_buyer = DNI_Comprador;
    }

    public void setName_pet(List<Integer> ID_Mascota) {
        this.List_id_pet = ID_Mascota;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /// Creacion de Compra
    public static Venta Compra(String DNICliente, ArrayList<Integer> ListaIDMascotas) {

        //Definimos las variables necesarias
        int Precio = 0;
        LocalDate FechaCompra = LocalDate.now();
        Cliente clienteSeleccionado = null;

        ArrayList<Mascota> mascotasValidadas = new ArrayList<>();

        //Luego comprobamos que el cliente este en la lista de clientes
        for (Cliente c : Datos.ListadoDeClientes) {
            if (c.getDNI().equalsIgnoreCase(DNICliente)) {
                clienteSeleccionado = c;
                break;
            }
        }
        //si no existe sale de la funcion
        if (clienteSeleccionado == null) {
            System.out.println("Cliente no encontrado");
            return null;
        }
        //Despues comprueba que las diferentes mascotas existan y no esten vendidas
        //Primero desmonta la lista ListaIDMascotas en IDMascota s
        for (int IDMascota : ListaIDMascotas) {
            Mascota mascotaSeleccionada = null;
            //Luego comprueba que la id de alguna de las mascotas de la lista ListadoDeMascotas corresponda con cada una de las IDMascota s y que si esta no tenga el valor vendido en true
            for (Mascota m : Datos.ListadoDeMascotas) {
                if (m.getID() == IDMascota) {
                    mascotaSeleccionada = m;
                    break;
                }
            }
            //Si no encuentra la mascota acaba la ejecucion, devuelve null y muestra el mensaje Mascota no encontrada
            if (mascotaSeleccionada == null) {
                System.out.println("Mascota no encontrada");
                return null;
            }
            //Si el valor de vendido es true acaba la ejecucion, devuelve null y muestra el mensaje La mascota ya ha sido vendida
            if (mascotaSeleccionada.isVendido()) {
                System.out.println("La mascota ya ha sido vendida");
                return null;
            }
            mascotasValidadas.add(mascotaSeleccionada);
            Precio += mascotaSeleccionada.getPrecio();
        }
        //Si llega aqui significa que todas las mascotas son validas por lo que podemos ejecutar la compra correctamente
        for (Mascota m : mascotasValidadas){
            m.setVendido(true);
        }
        //Añadimos todas las ID de las mascotas compradas a la ficha del cliente
        clienteSeleccionado.AñadirMascotasACliente(ListaIDMascotas);

        //Creamos la venta
        Venta v1 = new Venta(FechaCompra, DNICliente, ListaIDMascotas, Precio);

        System.out.println("El precio total de la compra es de " +Precio+ " €");

        // Finalmente devolvemos la venta
        return v1;
    }

    public static void MostrarVentas(ArrayList<Venta>ListaVentas){
        for (Venta v1 : ListaVentas){
            System.out.println(
                    "NºVenta: "+v1.getId() +
                    ", Fecha: "+v1.getDate() +
                    ", DNI Comprador: "+v1.id_buyer +
                    ", ID Mascotas Compradas: " + v1.getList_id_pet() +
                    ", Precio Total: "+v1.getPrice());
        }
    }
    public static void MostrarVentaConDNI(ArrayList<Venta>ListaVentas, String DNI){

        for (Venta v1 : ListaVentas){
            if (v1.id_buyer.equalsIgnoreCase(DNI)){System.out.println(
                    "NºVenta: "+v1.getId() +
                            ", Fecha: "+v1.getDate() +
                            ", DNI Comprador: "+v1.id_buyer +
                            ", ID Mascotas Compradas: " + v1.getList_id_pet() +
                            ", Precio Total: "+v1.getPrice());}
        }
    }
}