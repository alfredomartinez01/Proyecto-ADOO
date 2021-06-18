package domain;


import java.util.ArrayList;

public class Menu {
    private String nombre;
    private int idRestaurante;
    private ArrayList<Platillo> platillos = null; // Lista de platillos de cada menu
    
    public Menu(){
        
    }
    
    public Menu(Restaurante restaurante){
        this.nombre = restaurante.getNombre();
    }    
    
    public void agregarPlatillo(){
        
    }
    public void eliminarPlatillo(){
        
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
    public void setPlatillos(ArrayList<Platillo> platillos) {
        this.platillos = platillos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }
    
    
}
