package Restaurante;

import static Restaurante.Login.*;
import datos.ClienteDAO;
import datos.OrdenDAO;
import datos.PagoDAO;
import domain.Cliente;
import domain.Menu;
import domain.Orden;
import domain.Pago;
import domain.Restaurante;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class DespliegueHistorial extends javax.swing.JFrame {

    private Restaurante restaurante = new Restaurante();
    private OrdenDAO ordenDao = new OrdenDAO();
    private PagoDAO pagoDao = new PagoDAO();
    private ClienteDAO clienteDao = new ClienteDAO();
    public int noOrden;
    private Menu menu = new Menu(restaurante);

    public DespliegueHistorial(Restaurante restaurant) {
        this.restaurante = restaurant;
        initComponents();
        ajustarApariencia();
        timer.start();
        table_timer.start();
    }

    public void ajustarApariencia() {
        this.setTitle("Historial de pedidos");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.decode("#ACDED5"));
    }

    private void tablaPedidos() { // Muestra la tabla normal
        menu.setIdRestaurante(restaurante.getId());
        menu.consultarIdMenu();

        DefaultTableModel model = (DefaultTableModel) tablaPedidos.getModel();
        List<Orden> ordenes = ordenDao.seleccionar_por_menu(menu.getIdMenu());

        List<Pago> pagos = pagoDao.seleccionar();

        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        model = (DefaultTableModel) tablaPedidos.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[6]; // Crea el objeto de celdas para agregar

        for (Orden orden : ordenes) {
            Cliente cliente = clienteDao.seleccionar_por_orden(orden.getIdOrden());
            Pago pago = pagoDao.seleccionar_por_cliente(cliente.getIdCliente());
            fila[0] = orden.getIdOrden();
            fila[1] = orden.getFecha();
            fila[2] = pago.getTipo();
            fila[3] = pago.getMontoTotal();
            fila[4] = orden.getEstado();
            fila[5] = cliente.getNombreCliente();
            model.addRow(fila);

        }

        tablaPedidos.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_mensaje = new javax.swing.JLabel();
        fecha_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        lbl_detalles = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_orden = new javax.swing.JFormattedTextField();
        Actualizar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_mensaje.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_mensaje.setForeground(new java.awt.Color(0, 153, 153));
        lbl_mensaje.setText("Mostrando historial de pedidos");

        fecha_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha_label.setForeground(new java.awt.Color(0, 153, 153));
        fecha_label.setText("Fecha");

        tablaPedidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Orden", "Fecha", "Tipo de pago", "Monto total", "Estado", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPedidos);

        lbl_detalles.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_detalles.setForeground(new java.awt.Color(0, 153, 153));
        lbl_detalles.setText("Ver detalles de orden");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("No. Orden");

        txt_orden.setBackground(new java.awt.Color(204, 255, 255));
        txt_orden.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(172, 222, 213)));
        txt_orden.setForeground(new java.awt.Color(0, 102, 153));
        txt_orden.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));

        Actualizar.setBackground(new java.awt.Color(153, 255, 255));
        Actualizar.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        Actualizar.setForeground(new java.awt.Color(0, 102, 153));
        Actualizar.setText("Consultar");
        Actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Volver.setBackground(new java.awt.Color(153, 255, 255));
        Volver.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        Volver.setForeground(new java.awt.Color(0, 102, 153));
        Volver.setText("Volver atr??s");
        Volver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Actualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_detalles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Volver, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_orden, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbl_mensaje)
                .addGap(18, 18, 18)
                .addComponent(fecha_label)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lbl_detalles)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_orden, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(Actualizar)
                .addGap(27, 27, 27)
                .addComponent(Volver)
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        timer.stop();
        table_timer.stop();
        MenuAdministrador menuAdmin = new MenuAdministrador(restaurante.getCorreo());
        menuAdmin.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        timer.stop();
        table_timer.stop();
        DetallesPedido detalles = new DetallesPedido(restaurante, txt_orden.getText());
        detalles.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ActualizarActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        timer.stop();
        table_timer.stop();
        MenuAdministrador menuAdmin = new MenuAdministrador(restaurante.getCorreo());
        menuAdmin.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void txt_ordenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ordenActionPerformed
        // TODO add your handling code here:
        List<Orden> ordenes = ordenDao.seleccionar();

        System.out.println("valor historial" + txt_orden.getText());
        for (Orden orden : ordenes) {
            if (orden.getIdCliente() == noOrden) {
                noOrden = orden.getIdCliente();
            }
        }

    }//GEN-LAST:event_txt_ordenActionPerformed

    Timer timer = new Timer(100, new ActionListener() { // Encargado de actualizar la hora
        public void actionPerformed(ActionEvent e) {
            fecha_label.setText("Fecha: " + new Date());
        }
    });

    Timer table_timer = new Timer(100, new ActionListener() { // Encargado de mostrar la tabla normal
        public void actionPerformed(ActionEvent e) {
            tablaPedidos();
        }
    });

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DespliegueHistorial(new Restaurante()).setVisible(true);
            }
        });
    }
    private javax.swing.JLabel message;
    private javax.swing.JDialog Error;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_detalles;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JFormattedTextField txt_orden;
    // End of variables declaration//GEN-END:variables
}
