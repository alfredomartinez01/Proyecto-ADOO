package Restaurante;

import datos.OrdenDAO;
import datos.PagoDAO;
import datos.PlatilloDAO;
import domain.Orden;
import domain.Platillo;
import domain.Restaurante;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import Restaurante.DespliegueHistorial;

public class DetallesPedido extends javax.swing.JFrame {
    
    private Restaurante restaurante = new Restaurante();
    private OrdenDAO ordenDao = new OrdenDAO();
    private PlatilloDAO platilloDao = new PlatilloDAO();
    public String no_ord;
    
    
    public DetallesPedido(Restaurante restaurant, String no_orden) {
        this.restaurante = restaurant;
        this.no_ord = no_orden;   
        initComponents();
        ajustarApariencia();  
        tablaPlatillos();
        lbl_mensaje.setText("Mostrando detalles de la orden " + no_orden + ".");
        timer.start();    
    }    
    
    
    public void ajustarApariencia(){      
        this.setTitle("Detalles de orden");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
    }
    public void asignarDatos(){
        /* Asignamos los platillos y toda la información de la orden*/  
        tablaPlatillos();       
    }
    
    private void tablaPlatillos(){ // Muestra la tabla normal
        DefaultTableModel model = (DefaultTableModel) tablaPlatillos.getModel();
        List<Orden> contiene = ordenDao.seleccionar_contiene();
        List<Platillo> platillos = platilloDao.seleccionar();
        
        int o = 0;
        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        model = (DefaultTableModel) tablaPlatillos.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[4]; // Crea el objeto de celdas para agregar
        
        
        System.out.println(this.no_ord);
        
        for (Orden orden : contiene){
            if(orden.getIdOrden()== 12){
                for (Platillo platillo : platillos){
                    o = platillo.getIdPlatillo();
                }
            }
        }
            
            for (Platillo platillo1 : platillos) {
                
                if (platillo1.getIdPlatillo() == o) {
                    fila[0] = platillo1.getIdPlatillo();
                    fila[1] = platillo1.getNombrePlatillo();
                    fila[2] = platillo1.getCostoPlatillo();
                    fila[3] = platillo1.getComposicion();
                   
                    model.addRow(fila);
                }
                
            }
        

        tablaPlatillos.setModel(model); 
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_mensaje = new javax.swing.JLabel();
        lbl_instrucciones2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatillos = new javax.swing.JTable();
        lbl_instrucciones3 = new javax.swing.JLabel();
        fecha_label = new javax.swing.JLabel();
        fecha_label1 = new javax.swing.JLabel();
        lbl_instrucciones4 = new javax.swing.JLabel();
        Estados = new javax.swing.JComboBox<>();
        Volver = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_mensaje.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_mensaje.setText("Mostrando detalles de la orden <n_orden>.");

        lbl_instrucciones2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_instrucciones2.setText("Estado");

        tablaPlatillos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Composición"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPlatillos);
        if (tablaPlatillos.getColumnModel().getColumnCount() > 0) {
            tablaPlatillos.getColumnModel().getColumn(0).setMaxWidth(100);
            tablaPlatillos.getColumnModel().getColumn(1).setMinWidth(30);
            tablaPlatillos.getColumnModel().getColumn(1).setPreferredWidth(300);
            tablaPlatillos.getColumnModel().getColumn(1).setMaxWidth(500);
            tablaPlatillos.getColumnModel().getColumn(2).setMinWidth(25);
            tablaPlatillos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaPlatillos.getColumnModel().getColumn(2).setMaxWidth(100);
            tablaPlatillos.getColumnModel().getColumn(3).setMinWidth(25);
            tablaPlatillos.getColumnModel().getColumn(3).setPreferredWidth(300);
            tablaPlatillos.getColumnModel().getColumn(3).setMaxWidth(500);
        }

        lbl_instrucciones3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_instrucciones3.setText("Platillos");

        fecha_label.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha_label.setText("Fecha");

        fecha_label1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fecha_label1.setText("Fecha");

        lbl_instrucciones4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_instrucciones4.setText("Fecha de orden");

        Estados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Estados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Orden realizada", "Orden recibida", "Preparando orden", "Orden lista parar recoger" }));
        Estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadosActionPerformed(evt);
            }
        });

        Volver.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Volver.setText("Volver atrás");
        Volver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Volver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        Actualizar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Actualizar.setText("Actualizar estado");
        Actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_instrucciones4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_instrucciones3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fecha_label, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_mensaje)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fecha_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_instrucciones2)
                    .addComponent(Estados, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lbl_mensaje)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(fecha_label)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_instrucciones3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(lbl_instrucciones4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fecha_label1)
                .addGap(18, 18, 18)
                .addComponent(lbl_instrucciones2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Estados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Volver)
                    .addComponent(Actualizar))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        DespliegueHistorial historial= new DespliegueHistorial(restaurante);
        historial.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        DespliegueHistorial historial= new DespliegueHistorial(restaurante);
        historial.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    
    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        String estado = (String) Estados.getSelectedItem();
        String update_estado;
        OrdenDAO ordenDao = new OrdenDAO();
        System.out.println("valor   "+Integer.valueOf(no_ord));
        int  x = Integer.parseInt(no_ord);
        if("Orden realizada".equals(estado)){
        Orden ordenModificar = new Orden(x,"REALIZADA");
        ordenDao.actualizar(ordenModificar);
        }else if("Orden recibida".equals(estado)){
        Orden ordenModificar = new Orden(x,"RECIBIDA");
        ordenDao.actualizar(ordenModificar); 
        }else if("Preparando orden".equals(estado)){
        Orden ordenModificar = new Orden(x,"PREPARANDO");
        ordenDao.actualizar(ordenModificar); 
        }else if("Orden lista parar recoger".equals(estado)){
        Orden ordenModificar = new Orden(x,"LISTA");
        ordenDao.actualizar(ordenModificar); 
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void EstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadosActionPerformed
        //////////
    }//GEN-LAST:event_EstadosActionPerformed
    Timer timer = new Timer (1000, new ActionListener (){ // Encargado de actualizar la hora
            public void actionPerformed(ActionEvent e) {
               fecha_label.setText("Fecha: " + new Date());
            }           
    });
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetallesPedido(new Restaurante(), "1").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JComboBox<String> Estados;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel fecha_label1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_instrucciones2;
    private javax.swing.JLabel lbl_instrucciones3;
    private javax.swing.JLabel lbl_instrucciones4;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JTable tablaPlatillos;
    // End of variables declaration//GEN-END:variables
}
