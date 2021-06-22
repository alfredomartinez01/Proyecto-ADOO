package domain;


import java.util.ArrayList;

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

    public Orden( int idOrden, int idClienteO, String fecha, String hora,String estado) {
        this.estado = estado;
        this.idOrden = idOrden;
        this.idClienteO = idClienteO;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Orden(int idOrden, int idClienteO) {
        this.idOrden = idOrden;
        this.idClienteO = idClienteO;
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
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    //-------------------------------------------

    @Override
    public String toString() {
        return "Orden{" + "estado=" + estado + ", idOrden=" + idOrden + ", idClienteO=" + idClienteO + ", fecha=" + fecha + ", hora=" + hora + '}';
    }

   
}