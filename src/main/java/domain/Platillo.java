package domain;


//import java.util.ArrayList;

public class Platillo {
    private int idPlatillo;
    private int idClienteP;
    private String nombrePlatillo;
    private float costoPlatillo;
    private String composicion;
    //private ArrayList<Ingrediente> ingredientes = null; 

    public Platillo() {
    }

    public Platillo(int idPlatillo, int idClienteP, String nombrePlatillo, float costoPlatillo, String composicion) {
        this.idPlatillo = idPlatillo;
        this.idClienteP = idClienteP;
        this.nombrePlatillo = nombrePlatillo;
        this.costoPlatillo = costoPlatillo;
        this.composicion = composicion;
    }

    public Platillo(int idClienteP, String nombrePlatillo, float costoPlatillo, String composicion) {
        this.idClienteP = idClienteP;
        this.nombrePlatillo = nombrePlatillo;
        this.costoPlatillo = costoPlatillo;
        this.composicion = composicion;
    }

    public Platillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public int getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(int idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public int getIdClienteP() {
        return idClienteP;
    }

    public void setIdClienteP(int idClienteP) {
        this.idClienteP = idClienteP;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public float getCostoPlatillo() {
        return costoPlatillo;
    }

    public void setCostoPlatillo(float costoPlatillo) {
        this.costoPlatillo = costoPlatillo;
    }

    public String getComposicion() {
        return composicion;
    }

    public void setComposicion(String composicion) {
        this.composicion = composicion;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void agregarIngrediente(int id, String nombre, float costo){
        
    }    
    public void eliminarIngrediente(int id){
        
    }    
    
    
    
    
            
    public class Ingrediente{
        private int id;
        private String nombre;
        private float costo;
        
        
    }
}
