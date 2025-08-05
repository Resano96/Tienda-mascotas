package Tienda;

import java.util.ArrayList;

/**
 * Clase que representa a un cliente de la tienda.
 * Contiene información personal y las mascotas compradas.
 */
public class Cliente {
    private String nombre;
    private String dni;
    private int telefono;
    private String email;
    private final ArrayList<Integer> MascotasCompradas;

    /**
     * Constructor de Cliente.
     *
     * @param Nombre Nombre del cliente.
     * @param DNI DNI del cliente.
     * @param Telefono Teléfono del cliente.
     * @param Email Correo electrónico del cliente.
     */
    public Cliente(String Nombre, String DNI, int Telefono, String Email){
        this.nombre = Nombre;
        this.dni = DNI;
        this.telefono = Telefono;
        this.email = Email;
        this.MascotasCompradas = new ArrayList<>();
    }

    //GETS

    /**
     * Devuelve el nombre del cliente.
     * @return Nombre.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el DNI del cliente.
     * @return DNI.
     */
    public String getDNI() {
        return this.dni;
    }

    /**
     * Devuelve el teléfono del cliente.
     * @return Teléfono.
     */
    public int getTelefono() {
        return this.telefono;
    }

    /**
     * Devuelve el email del cliente.
     * @return Email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Devuelve la lista de IDs de mascotas compradas por el cliente.
     * @return Lista de IDs de mascotas.
     */
    public ArrayList<Integer> getMascotas(){
        return this.MascotasCompradas;
    }

    //SETS

    /**
     * Establece un nuevo nombre para el cliente.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece un nuevo DNI para el cliente.
     * @param dni Nuevo DNI.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Establece un nuevo teléfono para el cliente.
     * @param telefono Nuevo teléfono.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Establece un nuevo email para el cliente.
     * @param email Nuevo email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    //CREACION DE CLIENTE
    /**
     * Crea un nuevo cliente, lo muestra por consola y lo devuelve.
     *
     * @param Nombre Nombre del cliente.
     * @param DNI DNI del cliente.
     * @param Telefono Teléfono del cliente.
     * @param Email Correo electrónico del cliente.
     * @return Instancia de {@code Cliente} creada.
     */
    public static Cliente crearCliente(String Nombre, String DNI, int Telefono, String Email) {

        //Crea un cliente con todos los valores anteriores

        Cliente Cliente1 = new Cliente(Nombre,DNI,Telefono,Email);

        ///Muestra todos los valores juntos

        System.out.println("Nuevo Cliente");
        System.out.println("Nombre:" + Cliente1.getNombre());
        System.out.println("DNI: " + Cliente1.getDNI());
        System.out.println("Telefono: " + Cliente1.getTelefono());
        System.out.println("Email: "+ Cliente1.getEmail());
        return Cliente1;
    }

    /**
     * Elimina un cliente de la lista dado su DNI.
     *
     * @param ListaClientes Lista de clientes actual.
     * @param DNI DNI del cliente a eliminar.
     * @return Lista de clientes modificada.
     */
    public static ArrayList<Cliente> eliminarCliente(ArrayList<Cliente> ListaClientes, String DNI) {
        ListaClientes.removeIf(Cliente -> Cliente.getDNI().equalsIgnoreCase(DNI));
        return ListaClientes;
    }


    /**
     * Muestra por consola la lista completa de clientes con sus datos.
     *
     * @param ListaClientes Lista de clientes a mostrar.
     */
    public static void mostrarCLientes(ArrayList<Cliente> ListaClientes){
        System.out.println("Listado Completo de Clientes");
        for (Cliente Persona : ListaClientes) {
            System.out.println(
                    "Nombre: " + Persona.getNombre() +
                    " DNI: " + Persona.getDNI() +
                    " Telefono: " + Persona.getTelefono() +
                    " Email: " + Persona.getEmail() +
                    " Mascotas: " + Persona.getMascotas());
        }
    }

    /**
     * Añade una lista de IDs de mascotas al cliente.
     *
     * @param ListaIDMascotas Lista de identificadores de mascotas compradas.
     */
    public void AñadirMascotasACliente(ArrayList<Integer> ListaIDMascotas){
        this.MascotasCompradas.addAll(ListaIDMascotas);
    }


    /**
     * Cambia el teléfono de un cliente dado su DNI.
     *
     * @param DNI DNI del cliente a modificar.
     * @param NuevoTelefono Nuevo número de teléfono.
     */
    public static void CambiarTelefono(String DNI, int NuevoTelefono){
        for (Cliente c : Datos.ListadoDeClientes){
            if (c.getDNI().equalsIgnoreCase(DNI)){
                c.setTelefono(NuevoTelefono);
                return;
            }
        }
        System.out.println("DNI" + DNI+ " no corresponde a ningun cliente" );
    }

    /**
     * Cambia el email de un cliente dado su DNI.
     *
     * @param DNI DNI del cliente a modificar.
     * @param NuevoEmail Nuevo correo electrónico.
     */
    public static void CambiarEmail(String DNI, String NuevoEmail){
        for (Cliente c : Datos.ListadoDeClientes){
            if (c.getDNI().equalsIgnoreCase(DNI)){
                c.setEmail(NuevoEmail);
                return;
            }
        }
        System.out.println("DNI" + DNI+ " no corresponde a ningun cliente" );
    }

}
