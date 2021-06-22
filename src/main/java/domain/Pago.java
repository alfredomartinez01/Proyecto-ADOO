/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author chris
 */
public class Pago {
    private int idPago;
    private int idClienteP;
    private double montoTotal;
    private int noCuenta;
    private int cvv;
    private String fechaCad;
    private String tipo;

    public Pago() {
    }

    public Pago(int idPago, int idClienteP, double montoTotal, int noCuenta, int cvv, String fechaCad, String tipo) {
        this.idPago = idPago;
        this.idClienteP = idClienteP;
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

    public int getIdClienteP() {
        return idClienteP;
    }

    public void setIdClienteP(int idClienteP) {
        this.idClienteP = idClienteP;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pago(int idPago, int idClienteP, double montoTotal, String tipo) {
        this.idPago = idPago;
        this.idClienteP = idClienteP;
        this.montoTotal = montoTotal;
        this.tipo = tipo;
    }

    public Pago(int idClienteP, double montoTotal, int noCuenta, int cvv, String fechaCad, String tipo) {
        this.idClienteP = idClienteP;
        this.montoTotal = montoTotal;
        this.noCuenta = noCuenta;
        this.cvv = cvv;
        this.fechaCad = fechaCad;
        this.tipo = tipo;
    }

    public Pago(int idPago) {
        this.idPago = idPago;
    }

    public Pago(double montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    
    
}
