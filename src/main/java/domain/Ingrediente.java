
package domain;

/**
 *
 * @author chris
 */
public class Ingrediente {
    private int idIngrediente;
    private String nombreIngrediente;
    private double costoIngrediente;
    
    public Ingrediente() {
    }
    public Ingrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Ingrediente(String nombreIngrediente, double costoIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
        this.costoIngrediente = costoIngrediente;
    }

    public Ingrediente(int idIngrediente, String nombreIngrediente, double costoIngrediente) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.costoIngrediente = costoIngrediente;
    }

    

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public double getCostoIngrediente() {
        return costoIngrediente;
    }

    public void setCostoIngrediente(double costoIngrediente) {
        this.costoIngrediente = costoIngrediente;
    }

    @Override
    public String toString() {
        return "{ID: " + idIngrediente + ", nombre: " + nombreIngrediente + ", costo: $" + String.format("%.2f", costoIngrediente) +"} ";
    }
    
        
}
