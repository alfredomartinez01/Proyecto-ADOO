package Restaurante;

import domain.Restaurante;
import domain.Menu;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.table.DefaultTableModel;

public class Modificaciones extends javax.swing.JFrame {
    private Restaurante restaurante = new Restaurante();
    private Menu menu = new Menu(restaurante);
    
    public Modificaciones(Restaurante restaurant) {
        this.restaurante = restaurant;
                initComponents();        
        ajustarApariencia();
        lbl_mensaje.setText("Mostrando platillos de "+restaurante.getNombre() + ".");
        tablaPlatillos();
        tablaIngredientesAnadir();
        tablaIngredientesActualizar();
    }
    public void ajustarApariencia(){        
        this.setTitle("Platillos y modificaciones");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
    }
    
    private void tablaPlatillos(){ // Muestra la tabla normal
        DefaultTableModel model=(DefaultTableModel) tablaPlatillos.getModel();
        
        // Borra la tabla anterior
        int index = 0;
        while(index < model.getRowCount()){
                model.removeRow(index); 
        }
        model=(DefaultTableModel) tablaPlatillos.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[8]; // Crea el objeto de celdas para agregar
                    fila[0] = "1";
                    fila[1] = "1";
                    fila[2] = "1";
                    fila[3] = "1";
                    model.addRow(fila); // Agrega la fila al modelo de la tabla
                    tablaPlatillos.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
                
    }
    private void tablaIngredientesAnadir(){ // Muestra la tabla normal
        DefaultTableModel model=(DefaultTableModel) tablaIngredientesAnadir.getModel();
        
        // Borra la tabla anterior
        int index = 0;
        while(index < model.getRowCount()){
                model.removeRow(index); 
        }
        model=(DefaultTableModel) tablaIngredientesAnadir.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[8]; // Crea el objeto de celdas para agregar
                    fila[0] = "1";
                    fila[1] = "1";
                    fila[2] = "1";
                    fila[3] = "1";
                    model.addRow(fila); // Agrega la fila al modelo de la tabla
                    tablaIngredientesAnadir.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
                
    }
    private void tablaIngredientesActualizar(){ // Muestra la tabla normal
        DefaultTableModel model=(DefaultTableModel) tablaIngredientesActualizar.getModel();
        
        // Borra la tabla anterior
        int index = 0;
        while(index < model.getRowCount()){
                model.removeRow(index); 
        }
        model=(DefaultTableModel) tablaIngredientesActualizar.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[8]; // Crea el objeto de celdas para agregar
                    fila[0] = "1";
                    fila[1] = "1";
                    fila[2] = "1";
                    fila[3] = "1";
                    model.addRow(fila); // Agrega la fila al modelo de la tabla
                    tablaIngredientesActualizar.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
                
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_mensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatillos = new javax.swing.JTable();
        lbl_anadir = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_precio = new javax.swing.JLabel();
        txt_precio = new javax.swing.JFormattedTextField();
        lbl_nombre1 = new javax.swing.JLabel();
        txt_composicion = new javax.swing.JTextField();
        lbl_composicion = new javax.swing.JLabel();
        lbl_composicion1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngredientesAnadir = new javax.swing.JTable();
        lbl_composicion2 = new javax.swing.JLabel();
        txt_idAnadirIngrediente = new javax.swing.JFormattedTextField();
        txt_precioAnadirIngrediente = new javax.swing.JFormattedTextField();
        lbl_precio1 = new javax.swing.JLabel();
        lbl_composicion3 = new javax.swing.JLabel();
        txt_nombreAnadirIngrediente = new javax.swing.JTextField();
        AnadirIngrediente = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        lbl_composicion4 = new javax.swing.JLabel();
        txt_nombreActualizarIngrediente = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaIngredientesActualizar = new javax.swing.JTable();
        ActualizarIngrediente = new javax.swing.JButton();
        lbl_composicion5 = new javax.swing.JLabel();
        txt_nombreActualizar = new javax.swing.JTextField();
        lbl_precio2 = new javax.swing.JLabel();
        txt_idActualizarIngrediente = new javax.swing.JFormattedTextField();
        txt_precioActualizar = new javax.swing.JFormattedTextField();
        txt_precioActualizarIngrediente = new javax.swing.JFormattedTextField();
        lbl_nombre2 = new javax.swing.JLabel();
        lbl_precio3 = new javax.swing.JLabel();
        txt_composicionActualizar = new javax.swing.JTextField();
        lbl_composicion6 = new javax.swing.JLabel();
        lbl_composicion7 = new javax.swing.JLabel();
        lbl_anadir1 = new javax.swing.JLabel();
        AnadirPlatillo = new javax.swing.JButton();
        Volver2 = new javax.swing.JButton();
        txt_idEliminarIngrediente = new javax.swing.JFormattedTextField();
        lbl_composicion8 = new javax.swing.JLabel();
        EliminarIngrediente = new javax.swing.JButton();
        txt_idActualizar = new javax.swing.JFormattedTextField();
        lbl_composicion9 = new javax.swing.JLabel();
        Volver3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1371, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_mensaje.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_mensaje.setText("Mostrando ingredientes");

        tablaPlatillos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Composición", "Lista de ingredientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
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

        lbl_anadir.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_anadir.setText("Añadir platillo");

        txt_nombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        lbl_precio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_precio.setText("Precio");

        txt_precio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txt_precio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lbl_nombre1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_nombre1.setText("Nombre");

        txt_composicion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_composicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_composicionActionPerformed(evt);
            }
        });

        lbl_composicion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_composicion.setText("Composición");

        lbl_composicion1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_composicion1.setText("Ingredientes");

        tablaIngredientesAnadir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaIngredientesAnadir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaIngredientesAnadir);

        lbl_composicion2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_composicion2.setText("ID");

        txt_idAnadirIngrediente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_idAnadirIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_precioAnadirIngrediente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txt_precioAnadirIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbl_precio1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_precio1.setText("Precio");

        lbl_composicion3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_composicion3.setText("Nombre");

        txt_nombreAnadirIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nombreAnadirIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreAnadirIngredienteActionPerformed(evt);
            }
        });

        AnadirIngrediente.setText("Añadir ingrediente");
        AnadirIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadirIngredienteActionPerformed(evt);
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

        lbl_composicion4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_composicion4.setText("Ingredientes");

        txt_nombreActualizarIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txt_nombreActualizarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActualizarIngredienteActionPerformed(evt);
            }
        });

        tablaIngredientesActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaIngredientesActualizar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaIngredientesActualizar);

        ActualizarIngrediente.setText("Añadir ingrediente");

        lbl_composicion5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_composicion5.setText("ID");

        txt_nombreActualizar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_nombreActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActualizarActionPerformed(evt);
            }
        });

        lbl_precio2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_precio2.setText("Precio");

        txt_idActualizarIngrediente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_idActualizarIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_precioActualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txt_precioActualizar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        txt_precioActualizarIngrediente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txt_precioActualizarIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbl_nombre2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_nombre2.setText("Nombre");

        lbl_precio3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_precio3.setText("Precio");

        txt_composicionActualizar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_composicionActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_composicionActualizarActionPerformed(evt);
            }
        });

        lbl_composicion6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_composicion6.setText("Nombre");

        lbl_composicion7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_composicion7.setText("Composición");

        lbl_anadir1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_anadir1.setText("Actualizar platillo");

        AnadirPlatillo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        AnadirPlatillo.setText("Añadir platillo");
        AnadirPlatillo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        AnadirPlatillo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnadirPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadirPlatilloActionPerformed(evt);
            }
        });

        Volver2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Volver2.setText("Actualizar platillo");
        Volver2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Volver2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Volver2ActionPerformed(evt);
            }
        });

        txt_idEliminarIngrediente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_idEliminarIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbl_composicion8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_composicion8.setText("ID");

        EliminarIngrediente.setText("Eliminar ingrediente");

        txt_idActualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_idActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbl_composicion9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_composicion9.setText("ID*");

        Volver3.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        Volver3.setText("Eliminar platillo");
        Volver3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Volver3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Volver3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Volver3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(965, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_anadir)
                            .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(lbl_nombre1)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(lbl_precio))))
                            .addComponent(txt_composicion, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lbl_composicion))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_idAnadirIngrediente)
                                            .addComponent(lbl_composicion2)
                                            .addComponent(lbl_precio1)
                                            .addComponent(txt_precioAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_composicion3)
                                            .addComponent(txt_nombreAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbl_composicion1))
                            .addComponent(AnadirPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_precio2)
                                        .addGap(109, 109, 109)
                                        .addComponent(lbl_composicion7)
                                        .addGap(188, 188, 188))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(lbl_composicion4))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_precioActualizar)
                                                    .addComponent(txt_idActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(lbl_composicion9)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_nombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(lbl_nombre2))
                                                .addComponent(txt_composicionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(lbl_anadir1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Volver3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_idActualizarIngrediente)
                                                    .addComponent(lbl_composicion5)
                                                    .addComponent(lbl_precio3)
                                                    .addComponent(txt_precioActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_composicion6)
                                                    .addComponent(txt_nombreActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_idEliminarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(EliminarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_composicion8))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lbl_mensaje)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbl_anadir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_nombre1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_precio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_composicion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_composicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(lbl_composicion1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_composicion2)
                                    .addComponent(lbl_composicion3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txt_idAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_precio1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_nombreAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addComponent(txt_precioAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(AnadirIngrediente))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(AnadirPlatillo)
                        .addGap(69, 69, 69)
                        .addComponent(Volver)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_anadir1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_nombre2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_composicion9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_precio2)
                            .addComponent(lbl_composicion7))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_precioActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_composicionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_composicion4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_composicion5)
                                    .addComponent(lbl_composicion6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txt_idActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_precio3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_nombreActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addComponent(txt_precioActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(ActualizarIngrediente))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_composicion8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_idEliminarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EliminarIngrediente))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Volver2)
                            .addComponent(Volver3))
                        .addGap(109, 109, 109))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MenuAdministrador menuAdmin= new MenuAdministrador(restaurante.getCorreo());
        menuAdmin.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed

    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_composicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_composicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_composicionActionPerformed

    private void txt_nombreAnadirIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreAnadirIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreAnadirIngredienteActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        MenuAdministrador menuAdmin= new MenuAdministrador(restaurante.getCorreo());
        menuAdmin.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void txt_nombreActualizarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActualizarIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActualizarIngredienteActionPerformed

    private void txt_nombreActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActualizarActionPerformed

    private void txt_composicionActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_composicionActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_composicionActualizarActionPerformed

    private void AnadirPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirPlatilloActionPerformed
        
    }//GEN-LAST:event_AnadirPlatilloActionPerformed

    private void Volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volver2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Volver2ActionPerformed

    private void Volver3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volver3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Volver3ActionPerformed

    private void AnadirIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirIngredienteActionPerformed
        // Recogemos la información del platillo
        
        
    }//GEN-LAST:event_AnadirIngredienteActionPerformed
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
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificaciones(new Restaurante()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarIngrediente;
    private javax.swing.JButton AnadirIngrediente;
    private javax.swing.JButton AnadirPlatillo;
    private javax.swing.JButton EliminarIngrediente;
    private javax.swing.JButton Volver;
    private javax.swing.JButton Volver2;
    private javax.swing.JButton Volver3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_anadir;
    private javax.swing.JLabel lbl_anadir1;
    private javax.swing.JLabel lbl_composicion;
    private javax.swing.JLabel lbl_composicion1;
    private javax.swing.JLabel lbl_composicion2;
    private javax.swing.JLabel lbl_composicion3;
    private javax.swing.JLabel lbl_composicion4;
    private javax.swing.JLabel lbl_composicion5;
    private javax.swing.JLabel lbl_composicion6;
    private javax.swing.JLabel lbl_composicion7;
    private javax.swing.JLabel lbl_composicion8;
    private javax.swing.JLabel lbl_composicion9;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_precio1;
    private javax.swing.JLabel lbl_precio2;
    private javax.swing.JLabel lbl_precio3;
    private javax.swing.JTable tablaIngredientesActualizar;
    private javax.swing.JTable tablaIngredientesAnadir;
    private javax.swing.JTable tablaPlatillos;
    private javax.swing.JTextField txt_composicion;
    private javax.swing.JTextField txt_composicionActualizar;
    private javax.swing.JFormattedTextField txt_idActualizar;
    private javax.swing.JFormattedTextField txt_idActualizarIngrediente;
    private javax.swing.JFormattedTextField txt_idAnadirIngrediente;
    private javax.swing.JFormattedTextField txt_idEliminarIngrediente;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreActualizar;
    private javax.swing.JTextField txt_nombreActualizarIngrediente;
    private javax.swing.JTextField txt_nombreAnadirIngrediente;
    private javax.swing.JFormattedTextField txt_precio;
    private javax.swing.JFormattedTextField txt_precioActualizar;
    private javax.swing.JFormattedTextField txt_precioActualizarIngrediente;
    private javax.swing.JFormattedTextField txt_precioAnadirIngrediente;
    // End of variables declaration//GEN-END:variables
}
