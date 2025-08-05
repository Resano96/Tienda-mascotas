package Tienda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una venta de una o varias mascotas a un cliente.
 */
public class Venta {

    /**
     * Contador estático para asignar un ID único a cada venta.
     */
    private static int contadorID = 0;

    /**
     * ID único de la venta.
     */
    private static int ID;

    /**
     * Fecha en la que se realiza la venta.
     */
    private LocalDate  date;

    /**
     * DNI del comprador.
     */
    private String id_buyer;

    /**
     * Lista de IDs de mascotas vendidas en esta venta.
     */
    private List<Integer> List_id_pet;

    /**
     * Precio total de la venta.
     */
    private int price;

    /**
     * Constructor de la clase Venta.
     *
     * @param Fecha Fecha de la venta.
     * @param DNI_Comprador DNI del cliente comprador.
     * @param ListaDeIDMascotasID Lista con los ID de las mascotas vendidas.
     * @param Price Precio total de la venta.
     */
    public Venta(LocalDate  Fecha, String DNI_Comprador, List<Integer> ListaDeIDMascotasID, int Price) {
        this.ID = ++contadorID;
        this.date = Fecha;
        this.id_buyer = DNI_Comprador;
        this.List_id_pet = ListaDeIDMascotasID;
        this.price = Price;
    }

    // GETS

    /**
     * @return ID de la venta.
     */
    public int getId(){return this.ID;}

    /**
     * @return Fecha de la venta.
     */
    public LocalDate getDate(){return this.date;}

    /**
     * @return DNI del comprador.
     */
    public String getId_buyer(){return this.id_buyer;}

    /**
     * @return Lista de ID de mascotas vendidas.
     */
    public List<Integer> getList_id_pet(){return this.List_id_pet;}

    /**
     * @return Precio total de la venta.
     */
    public int getPrice() {
        return price;
    }

    // SETS

    /**
     * Establece una nueva fecha para la venta.
     *
     * @param date Nueva fecha.
     */
    public void setDate(LocalDate  date) {
        this.date = date;
    }


    /**
     * Establece un nuevo DNI de comprador.
     *
     * @param DNI_Comprador DNI nuevo.
     */
    public void setId_buyer(String DNI_Comprador) {
        this.id_buyer = DNI_Comprador;
    }

    /**
     * Establece una nueva lista de ID de mascotas vendidas.
     *
     * @param ID_Mascota Lista de ID de mascotas.
     */
    public void setName_pet(List<Integer> ID_Mascota) {
        this.List_id_pet = ID_Mascota;
    }

    /**
     * Establece un nuevo precio para la venta.
     *
     * @param price Nuevo precio.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Método estático para realizar una compra. Comprueba validez de cliente y mascotas,
     * marca mascotas como vendidas, las asigna al cliente y crea una nueva venta.
     *
     * @param DNICliente DNI del cliente que compra.
     * @param ListaIDMascotas Lista de ID de mascotas que quiere comprar.
     * @return Objeto Venta si es válida, null en caso contrario.
     */
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

    /**
     * Muestra por consola el listado completo de ventas.
     *
     * @param ListaVentas Lista de ventas realizadas.
     */
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

    /**
     * Muestra por consola las ventas realizadas por un cliente específico (filtrando por DNI).
     *
     * @param ListaVentas Lista de todas las ventas.
     * @param DNI DNI del cliente a filtrar.
     */
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