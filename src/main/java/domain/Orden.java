package domain;

import java.util.ArrayList;
import java.util.Date;
enum ESTADOS{
    REALIZADA,
    RECIBIDA,
    LISTA,
    RECOGIDA,
}
public class Orden {
   private int numero;
   
   private ArrayList<Platillo> platillos = null; // Lista de platillos de cada menu
   private String estado;
   
   private int idOrden;
   private int idClienteO;
   private String fecha;
   private String hora;
   private int fecha1;
   private long hora1;

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
    
    

    

    
   
   
   public void Orden(){
       
   }
   public void agregarPlatillo(){
       
   }
   public void eliminarPlatillo(){
       
   }
   public void pagarOrden(){
       
   }
   public String verificarEstado(){
       return estado;
   }
}
