package Cliente;

import static Cliente.Bienvenida.alto_pantalla;
import static Cliente.Bienvenida.ancho_pantalla;
import datos.ClienteDAO;
import datos.Conexion;
import datos.OrdenDAO;
import datos.PagoDAO;
import datos.PlatilloDAO;
import datos.IngredienteDAO;
import domain.Cliente;
import domain.Ingrediente;
import domain.Menu;
import domain.Orden;
import domain.Orden;
import domain.Pago;
import domain.Platillo;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormaPago extends javax.swing.JFrame {

    private Cliente cli = new Cliente();
    private int idCli;
    private Orden orden_temp = null;
    private Menu menu_temp = new Menu();
    private int idOrden;
    private Pago pago = new Pago();
    private Double montoTotal;
    private PagoDAO pagoD = new PagoDAO();

    public FormaPago() {
        initComponents();
        ajustarApariencia();
        pnlGracias.setVisible(false);
        pnlTarjeta.setVisible(false);
        pnlMetodoPago.setVisible(false);

    }

    public FormaPago(Orden orden, Menu menu) {
        initComponents();
        ajustarApariencia();
        orden_temp = orden;
        menu_temp = menu;
        pnlGracias.setVisible(false);
        pnlTarjeta.setVisible(false);
        pnlMetodoPago.setVisible(false);
        montoTotal = montoAPagar();
        lblMonto.setText(String.valueOf(montoTotal));
    }

    public void ajustarApariencia() {
        this.setTitle("Forma de Pago");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.decode("#ACDED5"));
        //this.setIconImage(new ImageIcon(getClass().getResource("/logo.jpg")).getImage());
        pnlTarjeta.setBackground(Color.decode("#A4A3A6"));
        pnlGracias.setBackground(Color.decode("#A4A3A6"));
    }

    public void transaccionPago(int tipo) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection(); // Establecemos la conexión
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
            }

            // Creamos el cliente y lo insertamos
            cli.setNombreCliente(txtNombre.getText());
            ClienteDAO cli_management = new ClienteDAO(conexion);
            cli_management.insertar(cli);

            // Obtenemos el id del cliente insertado
            idCli = cli_management.lastIDCliente();
            cli.setIdCliente(idCli);

            obtenerDatosOrden(); // Obtenemos los datos complementarios de la orden

            // Insertamos la orden en la base de datos
           
            orden_temp.setEstado("realizada");
            OrdenDAO od_management = new OrdenDAO(conexion);
            od_management.insertar(orden_temp);
            idOrden = od_management.lastIDOrden();
            orden_temp.setIdOrden(idOrden);

            // Insertamos ahora los datos de pago dependiendo del tipo
            pago.setIdCliente(idCli);
            pago.setMontoTotal(montoTotal);
            
            if (tipo == 0) { // efectivo (para evitar problemas en la base)
                pago.setNoCuenta("-");
                pago.setCvv(0);
                pago.setFechaCad("01/01");
                pago.setTipo("efectivo");
            } else { // tarjeta
                // Ya insertamos sus datos
                pago.setTipo("tarjeta");
            }
            PagoDAO pago_management = new PagoDAO(conexion);
            pago_management.insertar(pago);

            // Ahora insertamos los platillos
            for (Platillo plat : orden_temp.getPlatillos()) {
                // Ponemos los datos a los platillos
                plat.setTipo(1);

                // Escribimos los platillos
                PlatilloDAO plat_management = new PlatilloDAO(conexion);
                plat_management.insertar(plat);
                int idPlatillo = plat_management.lastIDPlatillo();
                plat.setIdPlatillo(idPlatillo);

                IngredienteDAO ing_management = new IngredienteDAO(conexion);
                for (Ingrediente ing : plat.getIngredientes()) {
                    // Obteniendo el id del ingrediente y platillo
                    ing_management.seleccionar_por_data(ing);
                    ing_management.insertar_en_agrega(plat.getIdPlatillo(), ing.getIdIngrediente());
                }
                
                // Escribimos el platillo en contiene junto con el id de la orden
                plat_management.insertar_en_contiene(idPlatillo, orden_temp.getIdOrden());                
            }

            conexion.commit(); // Todo bien toco correcto

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback(); // Si hubo algún error
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }

    public void obtenerDatosOrden() {
        Date dNow = new Date();
        SimpleDateFormat ftDia = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ftHora = new SimpleDateFormat("hh:mm:ss");
        String dia = ftDia.format(dNow);
        String hora = ftHora.format(dNow);
        orden_temp.setIdClienteO(idCli);
        orden_temp.setFecha(dia);
        orden_temp.setHora(hora);
    }

    public Double montoAPagar() {
        Double monto = 0.0;
        for (Platillo plat : orden_temp.getPlatillos()) {
            monto += plat.getCostoPlatillo();
        }
        return monto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnContinuar = new javax.swing.JButton();
        pnlMetodoPago = new javax.swing.JPanel();
        btnEfectivo = new javax.swing.JButton();
        btnTarjeta = new javax.swing.JButton();
        pnlGracias = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnlTarjeta = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNoCuenta = new javax.swing.JTextField();
        txtCvv = new javax.swing.JTextField();
        txtFCaducidad = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        lblMonto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Monto a pagar:");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Escribe tu nombre, por favor:");

        txtNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnEfectivo.setText("Efectivo");
        btnEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfectivoActionPerformed(evt);
            }
        });

        btnTarjeta.setText("Tarjeta");
        btnTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Gracias por tu compra!");

        javax.swing.GroupLayout pnlGraciasLayout = new javax.swing.GroupLayout(pnlGracias);
        pnlGracias.setLayout(pnlGraciasLayout);
        pnlGraciasLayout.setHorizontalGroup(
            pnlGraciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGraciasLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlGraciasLayout.setVerticalGroup(
            pnlGraciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGraciasLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jLabel4.setText("Numero de Cuenta:");

        jLabel6.setText("cvv:");

        jLabel7.setText("Fecha de Caducidad:");

        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTarjetaLayout = new javax.swing.GroupLayout(pnlTarjeta);
        pnlTarjeta.setLayout(pnlTarjetaLayout);
        pnlTarjetaLayout.setHorizontalGroup(
            pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjetaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFinalizar)
                    .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlTarjetaLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTarjetaLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTarjetaLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(45, 45, 45)
                            .addComponent(txtNoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTarjetaLayout.setVerticalGroup(
            pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTarjetaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(33, 33, 33)
                .addGroup(pnlTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtFCaducidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlMetodoPagoLayout = new javax.swing.GroupLayout(pnlMetodoPago);
        pnlMetodoPago.setLayout(pnlMetodoPagoLayout);
        pnlMetodoPagoLayout.setHorizontalGroup(
            pnlMetodoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMetodoPagoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlMetodoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMetodoPagoLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(btnEfectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTarjeta)
                        .addGap(117, 117, 117))
                    .addGroup(pnlMetodoPagoLayout.createSequentialGroup()
                        .addComponent(pnlGracias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(pnlTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlMetodoPagoLayout.setVerticalGroup(
            pnlMetodoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMetodoPagoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnlMetodoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEfectivo)
                    .addComponent(btnTarjeta))
                .addGroup(pnlMetodoPagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMetodoPagoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(pnlTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMetodoPagoLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(pnlGracias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        lblMonto.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(btnContinuar))
                            .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(pnlMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(563, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnContinuar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        pnlGracias.setVisible(true);
        pnlTarjeta.setVisible(false);
        pago.setNoCuenta(txtNoCuenta.getText());
        pago.setCvv(Integer.parseInt(txtCvv.getText()));
        try {
            /*
            SimpleDateFormat ftFecha = new SimpleDateFormat ("yyyy-MM-dd");
            String fecha = ftFecha.format(txtFCaducidad.getText());*/
            pago.setFechaCad(txtFCaducidad.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Escribe la fecha en el formato: yyyy-MM-dd");
        }
        transaccionPago(1);
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEfectivoActionPerformed
        transaccionPago(0); // Implica que pagará en efectivo
        pnlGracias.setVisible(true);
        pnlTarjeta.setVisible(false);
    }//GEN-LAST:event_btnEfectivoActionPerformed

    private void btnTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaActionPerformed
        pnlGracias.setVisible(false);
        pnlTarjeta.setVisible(true);
    }//GEN-LAST:event_btnTarjetaActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        pnlMetodoPago.setVisible(true);
    }//GEN-LAST:event_btnContinuarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormaPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnEfectivo;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JPanel pnlGracias;
    private javax.swing.JPanel pnlMetodoPago;
    private javax.swing.JPanel pnlTarjeta;
    private javax.swing.JTextField txtCvv;
    private javax.swing.JTextField txtFCaducidad;
    private javax.swing.JTextField txtNoCuenta;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
