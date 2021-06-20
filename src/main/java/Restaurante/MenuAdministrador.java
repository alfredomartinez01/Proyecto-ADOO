package Restaurante;

import static Restaurante.DatosRegistro.diasSemana;
import static Restaurante.Login.alto_pantalla;
import static Restaurante.Login.ancho_pantalla;
import datos.Conexion;
import datos.MenuDAO;
import datos.RestauranteDAO;
import domain.Restaurante;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;

public class MenuAdministrador extends javax.swing.JFrame {

    private Restaurante restaurante = new Restaurante();

    public MenuAdministrador(String user) {
        initComponents();
        ajustarApariencia();
        consultarRestaurante(user);
        asignarDatos();
        System.out.println(restaurante.getNombre());
        lbl_bienvenido.setText("Bienvenido " + restaurante.getCorreo() + ", administrando " + restaurante.getNombre() + ".");
    }

    public void ajustarApariencia() {
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

    public void asignarDatos() {
        txt_nombre.setText("" + restaurante.getNombre());
        txt_telefono.setText("" + restaurante.getTelefono());
        txt_correo.setText("" + restaurante.getCorreo());
        txt_local.setText("" + restaurante.getLocal());

        boolean[] diasRest = restaurante.getDias(); // dias que sí abre en booleano
        String[][] horariosRest = restaurante.getHorarios(); // horarios de apertura y cierre
        if (diasRest[0]) { // Si abren los lunes 
            txt_Hlunes.setText(horariosRest[0][0].substring(0, 5) + horariosRest[0][1].substring(0, 5));
            chck_lunes.setSelected(true);
        } else {
            txt_Hlunes.setText("");
        }
        if (diasRest[1]) { // Si abren los martes
            txt_Hmartes.setText(horariosRest[1][0].substring(0, 5) + horariosRest[1][1].substring(0, 5));
            chck_martes.setSelected(true);
        } else {
            txt_Hmartes.setText("");
        }
        if (diasRest[2]) { // Si abren los miércoles
            txt_Hmiercoles.setText(horariosRest[2][0].substring(0, 5) + horariosRest[2][1].substring(0, 5));
            chck_miercoles.setSelected(true);
        } else {
            txt_Hmiercoles.setText("");
        }
        if (diasRest[3]) { // Si abren los jueves
            txt_Hjueves.setText(horariosRest[3][0].substring(0, 5) + horariosRest[3][1].substring(0, 5));
            chck_jueves.setSelected(true);
        } else {
            txt_Hjueves.setText("");
        }
        if (diasRest[4]) { // Si abren los viernes
            txt_Hviernes.setText(horariosRest[4][0].substring(0, 5) + horariosRest[4][1].substring(0, 5));
            chck_viernes.setSelected(true);
        } else {
            txt_Hviernes.setText("");
        }
        if (diasRest[5]) { // Si abren los sabado
            txt_Hsabado.setText(horariosRest[5][0].substring(0, 5) + horariosRest[5][1].substring(0, 5));
            chck_sabado.setSelected(true);
        } else {
            txt_Hsabado.setText("");
        }
        if (diasRest[6]) { // Si abren los domingo
            txt_Hdomingo.setText(horariosRest[6][0].substring(0, 5) + horariosRest[6][1].substring(0, 5));
            chck_domingo.setSelected(true);
        } else {
            txt_Hdomingo.setText("");
        }

        txt_nombre.setEditable(false);
        txt_telefono.setEditable(false);
        txt_correo.setEditable(false);
        txt_local.setEditable(false);

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

    public void consultarRestaurante(String user) {
        /* Se manda llamar el método para obtener los datos de la base de datos sobre el restaurante*/
        restaurante = new Restaurante();
        restaurante.setCorreo(user);
        RestauranteDAO rest_management = new RestauranteDAO();

        try {
            rest_management.select(restaurante);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        /* Ahora obtenemos los horarios */
        try {
            rest_management.select_horario(restaurante);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        lbl_bienvenido = new javax.swing.JLabel();
        chck_domingo = new javax.swing.JCheckBox();
        txt_Hdomingo = new javax.swing.JFormattedTextField();
        txt_telefono = new javax.swing.JFormattedTextField();
        lbl_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        lbl_correo1 = new javax.swing.JLabel();
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
        txt_lastPass = new javax.swing.JPasswordField();
        lbl_instrucciones1 = new javax.swing.JLabel();
        HistorialPedidos = new javax.swing.JButton();
        ActualizarMenu = new javax.swing.JButton();
        lbl_instrucciones2 = new javax.swing.JLabel();
        ActualizarContrasena = new javax.swing.JButton();
        ActualizarContrasena1 = new javax.swing.JButton();
        txt_local = new javax.swing.JFormattedTextField();

        Error.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Error.setAlwaysOnTop(true);
        Error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Error.setResizable(false);
        Error.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                ErrorWindowClosing(evt);
            }
        });

        message.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addContainerGap())
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
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

        lbl_correo2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_correo2.setText("Horario");

        chck_lunes.setText("Lunes");
        chck_lunes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chck_lunesActionPerformed(evt);
            }
        });

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

        txt_lastPass.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_lastPass.setName("Contra"); // NOI18N
        txt_lastPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lastPassActionPerformed(evt);
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

        txt_local.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_local.setToolTipText("");
        txt_local.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_local.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_local.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_localActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbl_bienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(lbl_correo1)))
                                            .addComponent(txt_local, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txt_lastPass, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                            .addComponent(txt_lastPass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_local, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lbl_instrucciones1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HistorialPedidos)
                    .addComponent(ActualizarMenu))
                .addContainerGap(89, Short.MAX_VALUE))
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
        // Obtenemos los datos del formulario
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // formateamos la fecha para que se ingrese en número  

        String dato_nombre = "";
        long dato_telefono = 0;
        String dato_correo = "";
        int dato_local = 0;
        boolean[] diasAbiertos = {false, false, false, false, false, false, false};
        String horarios[][] = {{"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}, {"", ""}};
        String dato_pass = "";

        boolean errors = false; // Identifica si hubo algún error en la lectura de datos, si lo hubo, se vuelve true

        try { // Nombre
            dato_nombre = txt_nombre.getText();
            dato_nombre = dato_nombre.toUpperCase(); // Mayúsculas todas para no tener problemas con mayúsculas/minúsculas
            if (txt_nombre.getText().equals("")) { // Comprueba que la casilla del nombre no esté vacío
                message.setText("Falta nombre o está mal");
                errors = true;
            }
        } catch (Exception e) {
            System.out.println(e);
            message.setText("Falta nombre o está mal");
            errors = true;
        }

        try { // Telefono
            dato_telefono = Long.valueOf(txt_telefono.getText());
            if (txt_telefono.getText().equals("")) { // Comprueba que la casilla del teléfono no esté vacío
                message.setText("Falta telefono o está mal");
                errors = true;
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            errors = true;
            message.setText("Falta telefono o está mal");
        }

        try { // Correo
            dato_correo = txt_correo.getText();
            // Patrón para validar el email
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(dato_correo);

            if (!mather.find()) { //En caso de que no cumpla las condiciones para el correo
                message.setText("Falta correo o está mal");
                errors = true;
            }
        } catch (Exception e) {
            System.out.println(e);
            errors = true;
            message.setText("Falta correo o está mal");
        }

        try { // Local
            if (txt_local.getText().equals("")) { // Comprueba que la casilla del local no esté vacío
                message.setText("Falta local o está mal");
                errors = true;
            } else {
                dato_local = Integer.parseInt(txt_local.getText());
            }
        } catch (Exception e) {
            System.out.println(e);
            message.setText("Falta local o está mal");
            errors = true;
        }

        // Obtiene todos los dias con sus horarios
        String hora_ap = "";
        String hora_cie = "";
        if (chck_lunes.isSelected()) {
            try {
                hora_ap = txt_Hlunes.getText(0, 5);
                hora_cie = txt_Hlunes.getText(8, 5);
                // Formateamos la hora para evitar errores
                hora_ap = sdf.format(sdf.parse(hora_ap));
                hora_cie = sdf.format(sdf.parse(hora_cie));

                horarios[0][0] = hora_ap;
                horarios[0][1] = hora_cie;
                diasAbiertos[0] = true;
            } catch (BadLocationException | ParseException ex) {
                System.out.println(ex);
                message.setText("Falta horario de lunes o está mal");
                errors = true;
            }
        }
        if (chck_martes.isSelected()) {
            try {
                hora_ap = txt_Hmartes.getText(0, 5);
                hora_cie = txt_Hmartes.getText(8, 5);
                // Formateamos la hora para evitar errores
                hora_ap = sdf.format(sdf.parse(hora_ap));
                hora_cie = sdf.format(sdf.parse(hora_cie));

                horarios[1][0] = hora_ap;
                horarios[1][1] = hora_cie;
                diasAbiertos[1] = true;
            } catch (BadLocationException | ParseException ex) {
                System.out.println(ex);
                message.setText("Falta horario de martes o está mal");
                errors = true;
            }
        }
        if (chck_miercoles.isSelected()) {
            try {
                hora_ap = txt_Hmiercoles.getText(0, 5);
                hora_cie = txt_Hmiercoles.getText(8, 5);
                // Formateamos la hora para evitar errores
                hora_ap = sdf.format(sdf.parse(hora_ap));
                hora_cie = sdf.format(sdf.parse(hora_cie));

                horarios[2][0] = hora_ap;
                horarios[2][1] = hora_cie;
                diasAbiertos[2] = true;
            } catch (BadLocationException | ParseException ex) {
                System.out.println(ex);
                message.setText("Falta horario de miércoles o está mal");
                errors = true;
            }
        }
        if (chck_jueves.isSelected()) {
            try {
                hora_ap = txt_Hjueves.getText(0, 5);
                hora_cie = txt_Hjueves.getText(8, 5);
                // Formateamos la hora para evitar errores
                hora_ap = sdf.format(sdf.parse(hora_ap));
                hora_cie = sdf.format(sdf.parse(hora_cie));

                horarios[3][0] = hora_ap;
                horarios[3][1] = hora_cie;
                diasAbiertos[3] = true;
            } catch (BadLocationException | ParseException ex) {
                System.out.println(ex);
                message.setText("Falta horario de jueves o está mal");
                errors = true;
            }
        }
        if (chck_viernes.isSelected()) {
            try {
                hora_ap = txt_Hviernes.getText(0, 5);
                hora_cie = txt_Hviernes.getText(8, 5);
                // Formateamos la hora para evitar errores
                hora_ap = sdf.format(sdf.parse(hora_ap));
                hora_cie = sdf.format(sdf.parse(hora_cie));

                horarios[4][0] = hora_ap;
                horarios[4][1] = hora_cie;
                diasAbiertos[4] = true;
            } catch (BadLocationException | ParseException ex) {
                System.out.println(ex);
                message.setText("Falta horario de viernes o está mal");
                errors = true;
            }
        }
        if (chck_sabado.isSelected()) {
            try {
                hora_ap = txt_Hsabado.getText(0, 5);
                hora_cie = txt_Hsabado.getText(8, 5);
                // Formateamos la hora para evitar errores
                hora_ap = sdf.format(sdf.parse(hora_ap));
                hora_cie = sdf.format(sdf.parse(hora_cie));

                horarios[5][0] = hora_ap;
                horarios[5][1] = hora_cie;
                diasAbiertos[5] = true;
            } catch (BadLocationException | ParseException ex) {
                System.out.println(ex);
                message.setText("Falta horario de sabado o está mal");
                errors = true;
            }
        }
        if (chck_domingo.isSelected()) {
            try {
                hora_ap = txt_Hdomingo.getText(0, 5);
                hora_cie = txt_Hdomingo.getText(8, 5);
                // Formateamos la hora para evitar errores
                hora_ap = sdf.format(sdf.parse(hora_ap));
                hora_cie = sdf.format(sdf.parse(hora_cie));

                horarios[6][0] = hora_ap;
                horarios[6][1] = hora_cie;
                diasAbiertos[6] = true;
            } catch (BadLocationException | ParseException ex) {
                System.out.println(ex);
                message.setText("Falta horario de domingo o está mal");
                errors = true;
            }
        }

        if (errors) { // Si hay algún error, mostrará la ventana con el error antes asignado
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho_pantalla / 2 - 160, alto_pantalla / 2 - 45);
        } else { // Intentará crear y bajar a la base de datos el restaurante
            Restaurante nuevo_restaurante = new Restaurante(dato_nombre, dato_local, dato_telefono, dato_correo, restaurante.getContrasena(), diasAbiertos, horarios); //             Creamos el objeto restaurante
            Connection conexion = null; // Creamos la conexión 

            try {
                conexion = Conexion.getConnection(); // Establecemos la conexión
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
                }
                nuevo_restaurante.setId(restaurante.getId());
                RestauranteDAO res_management = new RestauranteDAO(conexion); // Creamos el objeto para hacer los cambios en la base a través de la conexión
                res_management.actualizar(nuevo_restaurante); // Intentamos hacer la transacción para insertar al restaurante
                res_management.select(nuevo_restaurante); // Buscamos los datos faltantes (id) que se acaba de insertar

                /* Asignamos los horarios en las tablas */
                boolean[] diasRest = nuevo_restaurante.getDias();
                String[][] horariosRest = nuevo_restaurante.getHorarios();

                for (int i = 0; i < 7; i++) {
                    if (diasRest[i]) { // Si está seleccionado su checkbox
                        if (res_management.select_horario(restaurante.getId()).getDias()[i]) { // Si el día se encuentra registrado en la base de datos
                            res_management.actualizar_horario(diasSemana[i], nuevo_restaurante.getId(), horariosRest[i][0], horariosRest[i][1]);
                        } else { // Entonces lo insterta
                            res_management.insertar_horario(diasSemana[i], nuevo_restaurante.getId(), horariosRest[i][0], horariosRest[i][1]);
                        }

                    } else { // Si no está seleccionado su checkbox
                        if (res_management.select_horario(restaurante.getId()).getDias()[i]) { // Si el día se encuentra registrado en la base de datos
                            res_management.eliminar_horario(diasSemana[i], nuevo_restaurante.getId());
                        }
                    }
                }
                conexion.commit(); // Intentamos hacer el commit de todos los queries 
                System.out.println("Se ha hecho commit de la transaccion");

                // Volvemos a cargar la información                
                consultarRestaurante(nuevo_restaurante.getCorreo());
                asignarDatos();
                System.out.println(nuevo_restaurante.getNombre());
                lbl_bienvenido.setText("Bienvenido " + nuevo_restaurante.getCorreo() + ", administrando " + nuevo_restaurante.getNombre() + ".");
                chck_editable.setSelected(false);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                message.setText("No se actualizó cliente correctamente");
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho_pantalla / 2 - 160, alto_pantalla / 2 - 45);

                System.out.println("Entramos al rollback");
                try {
                    conexion.rollback(); // Si hubo algún error
                } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
                }
            }
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void txt_lastPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastPassActionPerformed

    private void chck_editableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chck_editableActionPerformed
        if (chck_editable.isSelected()) {
            txt_nombre.setEditable(true);
            txt_telefono.setEditable(true);
            txt_correo.setEditable(true);
            txt_local.setEditable(true);

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
        } else {
            asignarDatos();
        }


    }//GEN-LAST:event_chck_editableActionPerformed

    private void HistorialPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistorialPedidosActionPerformed
        DespliegueHistorial historial = new DespliegueHistorial(restaurante);
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
        // Obtenemos las contraseñas
        char[] lastPass = txt_lastPass.getPassword();
        String lastPassword = String.valueOf(lastPass);
        
        char[] pass = txt_pass.getPassword();
        String password = String.valueOf(pass);
        
        char[] passConfirm = txt_passConfirm.getPassword();
        String passwordConfirm = String.valueOf(passConfirm);
        boolean errors = false;

        if (!password.equals("")&& !lastPassword.equals("")) { // Checa que no esté vacío            
            if (password.equals(passwordConfirm)) { // Comprueba que sean iguales
                if (lastPassword.equals(restaurante.getContrasena())) { // Checa que sea la contraseña correcta
                    // Creamos la conexión a la base y el restaurante con los datos a 
                    Restaurante nuevo_restaurante = new Restaurante(restaurante.getNombre(), restaurante.getLocal(), restaurante.getTelefono(), restaurante.getCorreo(), password, restaurante.getDias(), restaurante.getHorarios());
                    Connection conexion = null; // Creamos la conexión 
                    try {
                        conexion = Conexion.getConnection(); // Establecemos la conexión
                        if (conexion.getAutoCommit()) {
                            conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
                        }
                        nuevo_restaurante.setId(restaurante.getId());
                        RestauranteDAO res_management = new RestauranteDAO(conexion); // Creamos el objeto para hacer los cambios en la base a través de la conexión
                        res_management.actualizar(nuevo_restaurante); // Intentamos hacer la transacción para insertar al restaurante

                        conexion.commit(); // Intentamos hacer el commit de todos los queries 
                        System.out.println("Se ha hecho commit de la transaccion");

                        // Volvemos a cargar la información                
                        consultarRestaurante(nuevo_restaurante.getCorreo());

                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                        message.setText("No se actualizó contraseña correctamente");

                        System.out.println("Entramos al rollback");
                        try {
                            conexion.rollback(); // Si hubo algún error
                        } catch (SQLException ex1) {
                            ex1.printStackTrace(System.out);
                        }
                    }
                } else {
                    message.setText("La contraseña es incorrecta");
                    errors = true;
                }

            } else {
                message.setText("Las contraseñas deben ser iguales");
                errors = true;
            }
        } else {
            message.setText("Falta contraseña, no debe ser nula");
            errors = true;
        }
        if (errors) {
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho_pantalla / 2 - 160, alto_pantalla / 2 - 45);
        } else{
            message.setText("Contraseña actualizada correctamente");
            Error.setVisible(true);
            Error.setSize(310, 90);
            Error.setLocation(ancho_pantalla / 2 - 160, alto_pantalla / 2 - 45);
            txt_lastPass.setText("");
            txt_pass.setText("");
            txt_passConfirm.setText("");
        }
    }//GEN-LAST:event_ActualizarContrasenaActionPerformed

    private void ActualizarContrasena1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarContrasena1ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ActualizarContrasena1ActionPerformed

    private void txt_localActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_localActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_localActionPerformed

    private void chck_lunesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chck_lunesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chck_lunesActionPerformed

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();
    }//GEN-LAST:event_ErrorWindowClosing

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador("aa@aa.aaa").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton ActualizarContrasena;
    private javax.swing.JButton ActualizarContrasena1;
    private javax.swing.JButton ActualizarMenu;
    private javax.swing.JDialog Error;
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
    private javax.swing.JLabel message;
    private javax.swing.JFormattedTextField txt_Hdomingo;
    private javax.swing.JFormattedTextField txt_Hjueves;
    private javax.swing.JFormattedTextField txt_Hlunes;
    private javax.swing.JFormattedTextField txt_Hmartes;
    private javax.swing.JFormattedTextField txt_Hmiercoles;
    private javax.swing.JFormattedTextField txt_Hsabado;
    private javax.swing.JFormattedTextField txt_Hviernes;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JPasswordField txt_lastPass;
    private javax.swing.JFormattedTextField txt_local;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JPasswordField txt_passConfirm;
    private javax.swing.JFormattedTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
