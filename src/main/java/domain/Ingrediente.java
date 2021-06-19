
package domain;

/**
 *
 * @author chris
 */
public class Ingrediente {
    private int idIngrediente;
    private String nombreIngrediente;
    private float costoIngrediente;

    public Ingrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Ingrediente(String nombreIngrediente, float costoIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
        this.costoIngrediente = costoIngrediente;
    }

    public Ingrediente(int idIngrediente, String nombreIngrediente, float costoIngrediente) {
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

    public float getCostoIngrediente() {
        return costoIngrediente;
    }

    public void setCostoIngrediente(float costoIngrediente) {
        this.costoIngrediente = costoIngrediente;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "idIngrediente=" + idIngrediente + ", nombreIngrediente=" + nombreIngrediente + ", costoIngrediente=" + costoIngrediente + '}';
    }
    
        
}
