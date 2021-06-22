package domain;

public class Pago {
    private int idPago;
    private int idCliente;
    private double montoTotal;
    private String noCuenta;
    private int cvv;
    private String fechaCad;
    private String tipo;

    public Pago(int idPago, int idCliente, double montoTotal, String noCuenta, int cvv, String fechaCad, String tipo) {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.montoTotal = montoTotal;
        this.noCuenta = noCuenta;
        this.cvv = cvv;
        this.fechaCad = fechaCad;
        this.tipo = tipo;
    }

    public Pago() {
    }

    public Pago(int idCliente, double montoTotal, String noCuenta, int cvv, String fechaCad, String tipo) {
        this.idCliente = idCliente;
        this.montoTotal = montoTotal;
        this.noCuenta = noCuenta;
        this.cvv = cvv;
        this.fechaCad = fechaCad;
        this.tipo = tipo;
    }
    

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(String fechaCad) {
        this.fechaCad = fechaCad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
