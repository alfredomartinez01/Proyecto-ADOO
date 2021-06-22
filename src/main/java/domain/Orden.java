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
   
   private ArrayList<Platillo> platillos = new ArrayList<Platillo>(); // Lista de platillos de cada menu
   private String estado = "";   
   private int idOrden;
   private int idClienteO;
   private String fecha;
   private String hora;
   private int idPlatillo;
   

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
    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }

    public Orden( int idOrden, int idClienteO, String fecha, String hora,String estado) {
        this.estado = estado;
        this.idOrden = idOrden;
        this.idClienteO = idClienteO;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getIdPlatillo() {
        return idPlatillo;
    }

    /*public Orden(int idOrden, int idClienteO) {
    this.idOrden = idOrden;
    this.idClienteO = idClienteO;
    }*/
    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public Orden(int idOrden, int idPlatillo) {
        this.idOrden = idOrden;
        this.idPlatillo = idPlatillo;
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

    public void setIdClienteO(int idClienteO) {
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
    //-------------------------------------------

    @Override
    public String toString() {
        return "Orden{" + "numero=" + numero + ", platillos=" + platillos + ", estado=" + estado + ", idOrden=" + idOrden + ", idClienteO=" + idClienteO + ", fecha=" + fecha + ", hora=" + hora + ", idPlatillo=" + idPlatillo + '}';
    }

    

   
}