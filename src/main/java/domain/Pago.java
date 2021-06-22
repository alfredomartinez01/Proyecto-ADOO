package domain;

public class Pago {
    private int idPago;
    private int idCliente;
    private double montoTotal;
    private int noCuenta;
    private int cvv;
    private String fechaCad;
    private int tipo;

    public Pago(int idPago, int idCliente, double montoTotal, int noCuenta, int cvv, String fechaCad, int tipo) {
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

    public Pago(int idCliente, double montoTotal, int noCuenta, int cvv, String fechaCad, int tipo) {
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

    public int getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(int noCuenta) {
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}
