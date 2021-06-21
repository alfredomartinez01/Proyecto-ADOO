package domain;

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
}
