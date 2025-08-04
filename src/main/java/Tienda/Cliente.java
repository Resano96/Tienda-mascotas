package Tienda;

import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String dni;
    private int telefono;
    private String email;
    private final ArrayList<Integer> MascotasCompradas;
// Constructor, getters y setters

    public Cliente(String Nombre, String DNI, int Telefono, String Email){
        this.nombre = Nombre;
        this.dni = DNI;
        this.telefono = Telefono;
        this.email = Email;
        this.MascotasCompradas = new ArrayList<>();
    }
    /// GETS
    public String getNombre() {
        return this.nombre;
    }

    public String getDNI() {
        return this.dni;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<Integer> getMascotas(){
        return this.MascotasCompradas;
    }
    /// SETS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    ///  CREACION DE CLIENTE
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

    /// ELIMINAR 1 CLIENTE
    public static ArrayList<Cliente> eliminarCliente(ArrayList<Cliente> ListaClientes, String DNI) {
        ListaClientes.removeIf(Cliente -> Cliente.getDNI().equalsIgnoreCase(DNI));
        return ListaClientes;
    }


    /// Mostrar CLientes
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

    /// Añadir Mascotas, recibe como parametros el cliente y las mascotas que ha comprado
    public void AñadirMascotasACliente(ArrayList<Integer> ListaIDMascotas){
        this.MascotasCompradas.addAll(ListaIDMascotas);
    }
    

    public static void CambiarTelefono(String DNI, int NuevoTelefono){
        for (Cliente c : Datos.ListadoDeClientes){
            if (c.getDNI().equalsIgnoreCase(DNI)){
                c.setTelefono(NuevoTelefono);
                return;
            }
        }
        System.out.println("DNI" + DNI+ " no corresponde a ningun cliente" );
    }
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
