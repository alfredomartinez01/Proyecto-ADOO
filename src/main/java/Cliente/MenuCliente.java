package Cliente;
import static Cliente.Bienvenida.alto_pantalla;
import static Cliente.Bienvenida.ancho_pantalla;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class MenuCliente extends javax.swing.JFrame {

    
    public MenuCliente() {
        initComponents();
        ajustarApariencia();
        pnlPlatillos.setVisible(false);
        pnlMenuCliente.setVisible(false);
    }

    public void ajustarApariencia() {
        getContentPane().setBackground(Color.WHITE);
        this.setTitle("Autorder");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.decode("#3B3455"));
        pnlRestaurantes.setBackground(Color.decode("#3B3455"));
        pnlPlatillos.setBackground(Color.decode("#A4A3A6"));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRestaurantes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRes1 = new javax.swing.JButton();
        pnlPlatillos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnPlatillo1 = new javax.swing.JButton();
        pnlMenuCliente = new javax.swing.JPanel();
        pnlDescripcion = new javax.swing.JPanel();
        btnAgregarP = new javax.swing.JButton();
        lblNombreP = new javax.swing.JLabel();
        lblImagenP = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        pnlOrden = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrden = new javax.swing.JTable();
        btnContinuar = new javax.swing.JButton();
        btnBorrarRow = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlRestaurantes.setBackground(Color.decode("#3B3455")
        );

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Restaurantes");

        btnRes1.setBackground(new java.awt.Color(255, 255, 255));
        btnRes1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRes1.setForeground(new java.awt.Color(59, 52, 85));
        btnRes1.setText("Res1");
        btnRes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRes1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRestaurantesLayout = new javax.swing.GroupLayout(pnlRestaurantes);
        pnlRestaurantes.setLayout(pnlRestaurantesLayout);
        pnlRestaurantesLayout.setHorizontalGroup(
            pnlRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                .addGroup(pnlRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3))
                    .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnRes1)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnlRestaurantesLayout.setVerticalGroup(
            pnlRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addComponent(btnRes1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPlatillos.setBackground(Color.decode("#A4A3A6")
        );

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menú");

        btnPlatillo1.setBackground(new java.awt.Color(255, 255, 255));
        btnPlatillo1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPlatillo1.setForeground(new java.awt.Color(59, 52, 85));
        btnPlatillo1.setText("Platillo1");
        btnPlatillo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatillo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPlatillosLayout = new javax.swing.GroupLayout(pnlPlatillos);
        pnlPlatillos.setLayout(pnlPlatillosLayout);
        pnlPlatillosLayout.setHorizontalGroup(
            pnlPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlatillosLayout.createSequentialGroup()
                .addGroup(pnlPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlatillosLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel2))
                    .addGroup(pnlPlatillosLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnPlatillo1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlPlatillosLayout.setVerticalGroup(
            pnlPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlatillosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(btnPlatillo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarP.setBackground(new java.awt.Color(153, 255, 255));
        btnAgregarP.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAgregarP.setForeground(new java.awt.Color(59, 52, 85));
        btnAgregarP.setText("Agregar");

        lblNombreP.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblNombreP.setText("<Nombre Platillo>");

        lblDescripcion.setText("<Descripción de platillo>");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Tu orden");

        tblOrden.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tblOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrden);

        btnContinuar.setBackground(new java.awt.Color(153, 255, 255));
        btnContinuar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(59, 52, 85));
        btnContinuar.setText("Siguiente");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnBorrarRow.setBackground(new java.awt.Color(153, 255, 255));
        btnBorrarRow.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnBorrarRow.setForeground(new java.awt.Color(59, 52, 85));
        btnBorrarRow.setText("Borrar");

        btnLimpiar.setBackground(new java.awt.Color(153, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(59, 52, 85));
        btnLimpiar.setText("Limpiar");

        javax.swing.GroupLayout pnlOrdenLayout = new javax.swing.GroupLayout(pnlOrden);
        pnlOrden.setLayout(pnlOrdenLayout);
        pnlOrdenLayout.setHorizontalGroup(
            pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenLayout.createSequentialGroup()
                .addGroup(pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOrdenLayout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addComponent(jLabel1))
                    .addGroup(pnlOrdenLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlOrdenLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnBorrarRow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimpiar)
                                .addGap(201, 201, 201)
                                .addComponent(btnContinuar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlOrdenLayout.setVerticalGroup(
            pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(btnBorrarRow)
                    .addComponent(btnLimpiar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlDescripcionLayout = new javax.swing.GroupLayout(pnlDescripcion);
        pnlDescripcion.setLayout(pnlDescripcionLayout);
        pnlDescripcionLayout.setHorizontalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDescripcionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripcionLayout.createSequentialGroup()
                        .addComponent(lblNombreP)
                        .addGap(331, 331, 331))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripcionLayout.createSequentialGroup()
                        .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAgregarP)
                            .addGroup(pnlDescripcionLayout.createSequentialGroup()
                                .addComponent(lblImagenP, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addComponent(pnlOrden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pnlDescripcionLayout.setVerticalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNombreP)
                .addGap(30, 30, 30)
                .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImagenP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarP)
                .addGap(18, 18, 18)
                .addComponent(pnlOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMenuClienteLayout = new javax.swing.GroupLayout(pnlMenuCliente);
        pnlMenuCliente.setLayout(pnlMenuClienteLayout);
        pnlMenuClienteLayout.setHorizontalGroup(
            pnlMenuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuClienteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlMenuClienteLayout.setVerticalGroup(
            pnlMenuClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuClienteLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlPlatillos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlMenuCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlPlatillos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMenuCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRestaurantes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnRes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRes1ActionPerformed
        pnlPlatillos.setVisible(true);
    }//GEN-LAST:event_btnRes1ActionPerformed

    private void btnPlatillo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatillo1ActionPerformed
        pnlMenuCliente.setVisible(true);
    }//GEN-LAST:event_btnPlatillo1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnBorrarRow;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnPlatillo1;
    private javax.swing.JButton btnRes1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblImagenP;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JPanel pnlDescripcion;
    private javax.swing.JPanel pnlMenuCliente;
    private javax.swing.JPanel pnlOrden;
    private javax.swing.JPanel pnlPlatillos;
    private javax.swing.JPanel pnlRestaurantes;
    private javax.swing.JTable tblOrden;
    // End of variables declaration//GEN-END:variables
}
