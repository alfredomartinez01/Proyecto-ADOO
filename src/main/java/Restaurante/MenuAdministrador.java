package Restaurante;

import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;

public class MenuAdministrador extends javax.swing.JFrame {
    private Restaurante restaurante = new Restaurante();
    
    public MenuAdministrador(String user) {
        initComponents();
        ajustarApariencia();      
        lbl_bienvenido.setText("Bienvenido " + user + ", administrando " + restaurante.getNombre()+ ".");
        asignarDatos();
    }
    public void ajustarApariencia(){
        getContentPane().setBackground(Color.WHITE);        
        this.setTitle("Administración");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        chck_lunes.setBackground(Color.WHITE);
        chck_martes.setBackground(Color.WHITE);
        chck_miercoles.setBackground(Color.WHITE);
        chck_jueves.setBackground(Color.WHITE);
        chck_viernes.setBackground(Color.WHITE);
        chck_sabado.setBackground(Color.WHITE);
        chck_domingo.setBackground(Color.WHITE); 
        chck_editable.setBackground(Color.WHITE);
        
        Actualizar.setSelected(false);
    }
    
    public void asignarDatos(){
        txt_nombre.setText(""+restaurante.getNombre());
        txt_telefono.setText(""+restaurante.getTelefono());
        txt_correo.setText(""+restaurante.getCorreo());
        txt_direccion.setText(""+restaurante.getDireccion());
        /* Seccion de asignación de horario*/
        
        
        txt_nombre.setEditable(false);
        txt_telefono.setEditable(false);
        txt_correo.setEditable(false);
        txt_direccion.setEditable(false);
        
        chck_lunes.setEnabled(false);
        chck_martes.setEnabled(false);
        chck_miercoles.setEnabled(false);
        chck_jueves.setEnabled(false);
        chck_viernes.setEnabled(false);
        chck_sabado.setEnabled(false);
        chck_domingo.setEnabled(false);
        txt_Hlunes.setEditable(false);
        txt_Hmartes.setEditable(false);
        txt_Hmiercoles.setEditable(false);
        txt_Hjueves.setEditable(false);
        txt_Hviernes.setEditable(false);
        txt_Hsabado.setEditable(false);
        txt_Hdomingo.setEditable(false);
        
        Actualizar.setEnabled(false);
        
    }
    
    public void consultarRestaurante(String user){
        /* Se manda llamar el método para obtener los datos de la base de datos sobre el restaurante*/
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_bienvenido = new javax.swing.JLabel();
        chck_domingo = new javax.swing.JCheckBox();
        txt_Hdomingo = new javax.swing.JFormattedTextField();
        txt_telefono = new javax.swing.JFormattedTextField();
        lbl_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        lbl_correo1 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_correo2 = new javax.swing.JLabel();
        chck_lunes = new javax.swing.JCheckBox();
        txt_Hlunes = new javax.swing.JFormattedTextField();
        lbl_correo4 = new javax.swing.JLabel();
        chck_miercoles = new javax.swing.JCheckBox();
        txt_Hmartes = new javax.swing.JFormattedTextField();
        txt_Hmiercoles = new javax.swing.JFormattedTextField();
        lbl_nombre = new javax.swing.JLabel();
        chck_martes = new javax.swing.JCheckBox();
        txt_nombre = new javax.swing.JTextField();
        chck_jueves = new javax.swing.JCheckBox();
        lbl_contrasena = new javax.swing.JLabel();
        txt_Hjueves = new javax.swing.JFormattedTextField();
        txt_pass = new javax.swing.JPasswordField();
        chck_viernes = new javax.swing.JCheckBox();
        txt_Hviernes = new javax.swing.JFormattedTextField();
        lbl_instrucciones = new javax.swing.JLabel();
        chck_sabado = new javax.swing.JCheckBox();
        lbl_rpcontrasena = new javax.swing.JLabel();
        txt_Hsabado = new javax.swing.JFormattedTextField();
        txt_passConfirm = new javax.swing.JPasswordField();
        lbl_telefono = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        chck_editable = new javax.swing.JCheckBox();
        lbl_contrasena1 = new javax.swing.JLabel();
        txt_passAnterior = new javax.swing.JPasswordField();
        lbl_instrucciones1 = new javax.swing.JLabel();
        HistorialPedidos = new javax.swing.JButton();
        ActualizarMenu = new javax.swing.JButton();
        lbl_instrucciones2 = new javax.swing.JLabel();
        ActualizarContrasena = new javax.swing.JButton();
        ActualizarContrasena1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_bienvenido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_bienvenido.setText("Bienvenido <usuario>, administrando <nombre restaurante>.");

        chck_domingo.setText("Domingo");

        try {
            txt_Hdomingo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## - ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txt_telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_telefono.setToolTipText("");
        txt_telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_telefono.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        lbl_correo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_correo.setText("Correo");

        txt_correo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });

        lbl_correo1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_correo1.setText("Dirección");

        txt_direccion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });

        lbl_correo2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_correo2.setText("Horario");

        chck_lunes.setText("Lunes");

        try {
            txt_Hlunes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## - ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_Hlunes.setAutoscrolls(false);
        txt_Hlunes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txt_HlunesPropertyChange(evt);
            }
        });

        lbl_correo4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lbl_correo4.setText("Apertura - Cierre");

        chck_miercoles.setText("Miércoles");

        try {
            txt_Hmartes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## - ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txt_Hmiercoles.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## - ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_nombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_nombre.setText("Nombre");

        chck_martes.setText("Martes");

        txt_nombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        chck_jueves.setText("Jueves");

        lbl_contrasena.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_contrasena.setText("Nueva contraseña:");

        try {
            txt_Hjueves.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## - ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txt_pass.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_pass.setName("Contra"); // NOI18N
        txt_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passActionPerformed(evt);
            }
        });

        chck_viernes.setText("Viernes");

        try {
            txt_Hviernes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## - ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbl_instrucciones.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_instrucciones.setText("Datos de restaurante");

        chck_sabado.setText("Sábado");

        lbl_rpcontrasena.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_rpcontrasena.setText("Repita su contraseña:");

        try {
            txt_Hsabado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:## - ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txt_passConfirm.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_passConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passConfirmActionPerformed(evt);
            }
        });

        lbl_telefono.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_telefono.setText("Teléfono");

        Actualizar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Actualizar.setText("Actualizar datos");
        Actualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        chck_editable.setText("Editar datos");
        chck_editable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chck_editableActionPerformed(evt);
            }
        });

        lbl_contrasena1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_contrasena1.setText("Contraseña anterior");

        txt_passAnterior.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_passAnterior.setName("Contra"); // NOI18N
        txt_passAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passAnteriorActionPerformed(evt);
            }
        });

        lbl_instrucciones1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_instrucciones1.setText("Menu y pedidos");

        HistorialPedidos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        HistorialPedidos.setText("Ver historial de pedidos");
        HistorialPedidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        HistorialPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HistorialPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistorialPedidosActionPerformed(evt);
            }
        });

        ActualizarMenu.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ActualizarMenu.setText("Actualizar menú");
        ActualizarMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        ActualizarMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ActualizarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarMenuActionPerformed(evt);
            }
        });

        lbl_instrucciones2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_instrucciones2.setText("Acceso y sesión");

        ActualizarContrasena.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ActualizarContrasena.setText("Actualizar contraseña");
        ActualizarContrasena.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        ActualizarContrasena.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ActualizarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarContrasenaActionPerformed(evt);
            }
        });

        ActualizarContrasena1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ActualizarContrasena1.setText("Salir");
        ActualizarContrasena1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        ActualizarContrasena1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ActualizarContrasena1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarContrasena1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_correo2)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(98, 98, 98)
                                                            .addComponent(lbl_correo4))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(chck_martes)
                                                                .addComponent(chck_lunes)
                                                                .addComponent(chck_miercoles))
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(txt_Hmiercoles, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txt_Hmartes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txt_Hlunes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGap(62, 62, 62)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(chck_viernes, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(chck_sabado, javax.swing.GroupLayout.Alignment.TRAILING))
                                                        .addComponent(chck_jueves))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txt_Hviernes, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txt_Hsabado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(txt_Hjueves, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(83, 83, 83)
                                                            .addComponent(chck_domingo)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(txt_Hdomingo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(lbl_instrucciones)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(chck_editable))
                                                .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_direccion, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(36, 36, 36))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                            .addComponent(lbl_telefono)
                                                            .addGap(217, 217, 217)))
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl_correo)
                                                        .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(lbl_correo1, javax.swing.GroupLayout.Alignment.LEADING)))
                                        .addGap(18, 18, 18)))
                                .addComponent(lbl_instrucciones1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(HistorialPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ActualizarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lbl_nombre)))
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_instrucciones2)
                            .addComponent(lbl_contrasena)
                            .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_rpcontrasena)
                            .addComponent(txt_passConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_contrasena1)
                            .addComponent(ActualizarContrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ActualizarContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_passAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_bienvenido)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_instrucciones2)
                        .addGap(31, 31, 31)
                        .addComponent(lbl_contrasena)
                        .addGap(11, 11, 11)
                        .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_rpcontrasena))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_instrucciones)
                            .addComponent(chck_editable))
                        .addGap(30, 30, 30)
                        .addComponent(lbl_nombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_telefono)
                            .addComponent(lbl_correo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_passConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_correo1)
                            .addComponent(lbl_contrasena1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_passAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_correo2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chck_lunes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(chck_martes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(chck_miercoles))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(chck_jueves)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(chck_viernes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(chck_sabado))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(ActualizarContrasena)
                                        .addComponent(lbl_correo4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_Hlunes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_Hmartes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_Hmiercoles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_Hviernes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ActualizarContrasena1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Hsabado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_Hjueves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(chck_domingo)
                                        .addComponent(txt_Hdomingo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(18, 18, 18)
                .addComponent(Actualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_instrucciones1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HistorialPedidos)
                    .addComponent(ActualizarMenu))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_HlunesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txt_HlunesPropertyChange

    }//GEN-LAST:event_txt_HlunesPropertyChange

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed

    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passActionPerformed

    private void txt_passConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passConfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passConfirmActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
       
    }//GEN-LAST:event_ActualizarActionPerformed

    private void txt_passAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passAnteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passAnteriorActionPerformed

    private void chck_editableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chck_editableActionPerformed
        if(chck_editable.isSelected()){
            txt_nombre.setEditable(true);
            txt_telefono.setEditable(true);
            txt_correo.setEditable(true);
            txt_direccion.setEditable(true);

            chck_lunes.setEnabled(true);
            chck_martes.setEnabled(true);
            chck_miercoles.setEnabled(true);
            chck_jueves.setEnabled(true);
            chck_viernes.setEnabled(true);
            chck_sabado.setEnabled(true);
            chck_domingo.setEnabled(true);
            txt_Hlunes.setEditable(true);
            txt_Hmartes.setEditable(true);
            txt_Hmiercoles.setEditable(true);
            txt_Hjueves.setEditable(true);
            txt_Hviernes.setEditable(true);
            txt_Hsabado.setEditable(true);
            txt_Hdomingo.setEditable(true);
            
            Actualizar.setEnabled(true);
        }
        else{
            asignarDatos();
        }
        
        
    }//GEN-LAST:event_chck_editableActionPerformed

    private void HistorialPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialPedidosActionPerformed
        DespliegueHistorial historial= new DespliegueHistorial(restaurante);
        historial.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_HistorialPedidosActionPerformed

    private void ActualizarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarMenuActionPerformed
        Modificaciones modificaciones = new Modificaciones(this.restaurante);
        modificaciones.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ActualizarMenuActionPerformed

    private void ActualizarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualizarContrasenaActionPerformed

    private void ActualizarContrasena1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarContrasena1ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ActualizarContrasena1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador("prueba").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton ActualizarContrasena;
    private javax.swing.JButton ActualizarContrasena1;
    private javax.swing.JButton ActualizarMenu;
    private javax.swing.JButton HistorialPedidos;
    private javax.swing.JCheckBox chck_domingo;
    private javax.swing.JCheckBox chck_editable;
    private javax.swing.JCheckBox chck_jueves;
    private javax.swing.JCheckBox chck_lunes;
    private javax.swing.JCheckBox chck_martes;
    private javax.swing.JCheckBox chck_miercoles;
    private javax.swing.JCheckBox chck_sabado;
    private javax.swing.JCheckBox chck_viernes;
    private javax.swing.JLabel lbl_bienvenido;
    private javax.swing.JLabel lbl_contrasena;
    private javax.swing.JLabel lbl_contrasena1;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_correo1;
    private javax.swing.JLabel lbl_correo2;
    private javax.swing.JLabel lbl_correo4;
    private javax.swing.JLabel lbl_instrucciones;
    private javax.swing.JLabel lbl_instrucciones1;
    private javax.swing.JLabel lbl_instrucciones2;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_rpcontrasena;
    private javax.swing.JLabel lbl_telefono;
    private javax.swing.JFormattedTextField txt_Hdomingo;
    private javax.swing.JFormattedTextField txt_Hjueves;
    private javax.swing.JFormattedTextField txt_Hlunes;
    private javax.swing.JFormattedTextField txt_Hmartes;
    private javax.swing.JFormattedTextField txt_Hmiercoles;
    private javax.swing.JFormattedTextField txt_Hsabado;
    private javax.swing.JFormattedTextField txt_Hviernes;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JPasswordField txt_passAnterior;
    private javax.swing.JPasswordField txt_passConfirm;
    private javax.swing.JFormattedTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
