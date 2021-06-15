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
   private Date fechaHora;
   private ArrayList<Platillo> platillos = null; // Lista de platillos de cada menu
   private String estado;
   
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
