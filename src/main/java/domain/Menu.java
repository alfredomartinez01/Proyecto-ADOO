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
        this.idRestaurante = restaurante.getId();
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
    public int leerPlatillos(){ // Lee los platillos del restaurante de la base de datos
        
        return 0;
    }
    public int escribirPlatillos(){ // Escribe los platillos del restaurante sobre la base de datos
        
        return 0;
    }
    public int agregarPlatillo(Platillo plat){ // Agrega un platillo a la lista en el menu
        
        return 0;
    }
    public int removerPlatillo(Platillo plat){ // Remueve un platillo de la lista en el menú
        
        return 0;
    }
    public ArrayList<Platillo> getPlatillos() {
        return platillos;
    }
    
    
}
