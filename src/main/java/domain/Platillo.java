package domain;


import java.util.ArrayList;

public class Platillo {
    private int id;
    private String nombre;
    private float precio;
    private String composicion;
    private ArrayList<Ingrediente> ingredientes = null; 
    
    public void agregarIngrediente(int id, String nombre, float costo){
        
    }    
    public void eliminarIngrediente(int id){
        
    }    
    public String getComposicion() {
        return composicion;
    }
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }
    
            
    public class Ingrediente{
        private int id;
        private String nombre;
        private float costo;
        
        
    }
}
