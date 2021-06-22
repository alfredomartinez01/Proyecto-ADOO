package domain;

import datos.Conexion;
import datos.IngredienteDAO;
import datos.OrdenDAO;
import datos.PlatilloDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
enum ESTADOS{
    REALIZADA, // Cuando el cliente la hace
    RECIBIDA, // Cuando el restaurante la recibe
    LISTA, // Cuando está terminada de preparar
    RECOGIDA, // Cuando fue recogida
}
public class Orden {
   private int numero;
   
   private ArrayList<Platillo> platillos = new ArrayList<Platillo>(); // Lista de platillos de cada menu
   private String estado;
   
   private int idOrden;
   private int idClienteO;
   private String fecha;
   private String hora;

    public Orden() {
    }

    public Orden(int idClienteO, String fecha, String hora) {
        this.idClienteO = idClienteO;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Orden(int idOrden, int idClienteO, String fecha, String hora) {
        this.idOrden = idOrden;
        this.idClienteO = idClienteO;
        this.fecha = fecha;
        this.hora = hora;
    }    

    public Orden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idClienteO;
    }

    public void setIdCliente(int idClienteO) {
        this.idClienteO = idClienteO;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    //-------------------------------------------

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(ArrayList<Platillo> platillos) {
        this.platillos = platillos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdClienteO() {
        return idClienteO;
    }

    public void setIdClienteO(int idClienteO) {
        this.idClienteO = idClienteO;
    }
    
    /*public int escribirOrden() {
        Connection conexion = null; // Creamos la conexión

        try {
            conexion = Conexion.getConnection(); // Establecemos la conexión
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
            }
            OrdenDAO ord_management = new OrdenDAO(conexion);
            ord_management.insertar(this);

            PlatilloDAO plat_management = new PlatilloDAO(conexion);
            for (Platillo plat : this.platillos) { 
                //plat_management.insertar(plat);
                // Obteniendo el id del ingrediente y platillo
                //ord_management.seleccionar_data(this);
                //plat_management.seleccionar_por_data(plat);
                plat_management.insertar_en_contiene(plat.getIdPlatillo(), this.idOrden);
            }

            conexion.commit(); // Intentamos hacer el commit de todos los queries 
            System.out.println("Se ha hecho commit de la transaccion");

            return 0;

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback(); // Si hubo algún error
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }

            return -1;
        }
    }*/


    

    
   
   
   public void Orden(){
       
   }
   public void agregarPlatillo(Platillo plat){
       this.platillos.add(plat);
   }
   public void eliminarPlatillo(){
       
   }
   public void pagarOrden(){
       
   }
   public String verificarEstado(){
       return estado;
   }
   
   
   @Override
    public String toString() {
        return "Orden{" + "idOrden=" + idOrden + ", idCliente=" + idClienteO + ", fecha:" + fecha + ",Hora:" + hora + '}';
    }
}
