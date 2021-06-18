package domain;

public class Restaurante extends Usuario{
    private int id;
    private String nombre;
    private int local;
    private long telefono;
    private String correo;
    private String contrasena;
    private boolean[] dias = {false, false, false, false, false, false, false};
    private String horarios[][] = {{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""}};
    
    public Restaurante(){
        
    }
    public Restaurante(String nombre, int local, long telefono, String correo, String contrasena, boolean[] dias, String[][] horarios){
        this.nombre = nombre;
        this.local = local;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.dias = dias;
        this.horarios = horarios;
    }
    public void crearMenu(){
        
    }
    public void eliminar(){
        
    }
    public void editarMenu(){
        
    }

    public void setId(int id) {
        this.id = id;
    }   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setDias(boolean[] dias) {
        this.dias = dias;
    }

    public void setHorarios(String[][] horarios) {
        this.horarios = horarios;
    }
 
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getLocal() {
        return local;
    }
    public long getTelefono() {
        return telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public boolean[] getDias() {
        return dias;
    }
    public String[][] getHorarios() {
        return horarios;
    }    
    private class Empleado{
        private int idEmpleado;        
        private String contrasenaEmpleado;
    }
}
