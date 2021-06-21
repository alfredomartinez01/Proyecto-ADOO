package Restaurante;

import static Restaurante.Login.alto_pantalla;
import static Restaurante.Login.ancho_pantalla;
import domain.Ingrediente;
import domain.Restaurante;
import domain.Menu;
import domain.Platillo;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class Modificaciones extends javax.swing.JFrame {

    private Restaurante restaurante = new Restaurante();
    private Menu menu = new Menu(restaurante);
    private Platillo plat_temp = new Platillo();
    private Ingrediente ing_temp = new Ingrediente();

    public Modificaciones(Restaurante restaurant) {
        this.restaurante = restaurant;
        menu.setIdRestaurante(restaurante.getId());
        menu.consultarIdMenu();

        initComponents();
        ajustarApariencia();
        lbl_mensaje.setText("Mostrando platillos de " + restaurante.getNombre() + ".");
        tablaPlatillos();
        popupTablaPlatillos();
        popupTablaIngredientes();

        removerActualizarItems();
    }

    public void ajustarApariencia() {
        this.setTitle("Platillos y modificaciones");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
    }

    private void tablaPlatillos() { try {
        // Muestra la tabla normal
        DefaultTableModel model = (DefaultTableModel) tablaPlatillos.getModel();
        menu.leerPlatillos();
        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        model = (DefaultTableModel) tablaPlatillos.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[5]; // Crea el objeto de celdas para agregar
        int noPlat = 0;
        for (Platillo plat : menu.getPlatillos()) {
            //tablaPlatillos.setRowHeight(noPlat, 30);
            fila[0] = plat.getIdPlatillo();
            fila[1] = plat.getNombrePlatillo();
            fila[2] = String.format("$%.2f", plat.getCostoPlatillo());
            fila[3] = plat.getComposicion();
            String ingredientes = "";
            for (Ingrediente ing : plat.getIngredientes()) {
                ingredientes += ing;
            }

            fila[4] = ingredientes;
            model.addRow(fila); // Agrega la fila al modelo de la tabla
            noPlat++;
        }
        tablaPlatillos.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
        } catch (SQLException ex) {
            Logger.getLogger(Modificaciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void tablaIngredientes() { // Muestra la tabla de ingredientes

        DefaultTableModel model = (DefaultTableModel) tablaIngredientes.getModel();
        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        model = (DefaultTableModel) tablaIngredientes.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[2]; // Crea el objeto de celdas para agregar
        for (Ingrediente ingrediente : plat_temp.getIngredientes()) {
            fila[0] = ingrediente.getNombreIngrediente();
            fila[1] = ingrediente.getCostoIngrediente();
            model.addRow(fila); // Agrega la fila al modelo de la tabla
        }
        tablaIngredientes.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 

    }

    public void popupTablaPlatillos() {
        JPopupMenu pM = new JPopupMenu(); //se crea el contenedor
        JMenuItem jmi1 = new JMenuItem("Actualizar"); //las opciones
        JMenuItem jmi2 = new JMenuItem("Eliminar");

        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtenemos el id del platillo
                Platillo plat_modificado = new Platillo();
                plat_temp = new Platillo();

                String idPlat = String.valueOf(tablaPlatillos.getValueAt(tablaPlatillos.getSelectedRow(), 0));
                int idP = Integer.valueOf(idPlat);
                if (idP != -1) { 
                    try {
                    // Busqueda por IDP, checamos que no esté vacío
                    // Buscamos los datos del platillo en la lista
                    menu.leerPlatillos();
                    for (Platillo plat : menu.getPlatillos()) {
                        if (plat.getIdPlatillo() == idP) {
                            plat_modificado = plat;
                            break;
                        }
                    }
                    mostrarActualizarItems();
                    vaciarActualizarItems();
                    plat_temp = plat_modificado;
                    llenarActualizarItems();
                    tablaIngredientes();
                    } catch (SQLException ex) {
                        Logger.getLogger(Modificaciones.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        });
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpiamoz actualizar
                removerActualizarItems();
                vaciarActualizarItems();
                plat_temp = new Platillo();
                ing_temp = new Ingrediente();
                
                // Obtenemos el id del platillo
                int idPlat = Integer.valueOf(String.valueOf(tablaPlatillos.getValueAt(tablaPlatillos.getSelectedRow(), 0)));
                // Busamos el platillo en el menu
                for (Platillo plat : menu.getPlatillos()) {
                    if (plat.getIdPlatillo() == idPlat) {
                        plat_temp = plat;
                        break;
                    }
                }
                System.out.println(idPlat);
                if (idPlat != 0) {
                    EliminarPlatillo.setVisible(true);
                    EliminarPlatillo.setSize(310, 170);
                    EliminarPlatillo.setLocation(ancho_pantalla / 2 - 160, alto_pantalla / 2 - 45);
                }
            }
        });
        pM.add(jmi1);// se agregan las opciones al contenedor
        pM.add(jmi2);

        tablaPlatillos.setComponentPopupMenu(pM);//se agrega el menú a la tabla con su respectivo evento
    }

    public void popupTablaIngredientes() {
        JPopupMenu pM = new JPopupMenu(); //se crea el contenedor
        JMenuItem jmi2 = new JMenuItem("Eliminar");
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtenemos el nombre y costo del ingrediente
                String nombre = String.valueOf(tablaIngredientes.getValueAt(tablaIngredientes.getSelectedRow(), 0));
                double costo = Double.parseDouble(String.valueOf(tablaIngredientes.getValueAt(tablaIngredientes.getSelectedRow(), 1)).replace("$", ""));
                ing_temp.setNombreIngrediente(nombre);
                ing_temp.setCostoIngrediente(costo);

                if (!nombre.equals("") && costo != 0) {
                    Eliminar.setVisible(true);
                    Eliminar.setSize(310, 170);
                    Eliminar.setLocation(ancho_pantalla / 2 - 160, alto_pantalla / 2 - 45);
                }

            }
        });
        // se agregan las opciones al contenedor
        pM.add(jmi2);

        tablaIngredientes.setComponentPopupMenu(pM);//se agrega el menú a la tabla con su respectivo evento
    }

    private void removerActualizarItems() {
        // Quitamos el label de ID y actualizamos el título
        lbl_operacion.setText("Añadir platillo");
        AnadirPlatillo.setVisible(true);

        lbl_id.setVisible(false);
        txt_id.setVisible(false);
        ActualizarPlatillo.setVisible(false);
        CancelarActualizacion.setVisible(false);
    }

    private void mostrarActualizarItems() {
        // Mostramos primero los labels
        lbl_operacion.setText("Actualizar platillo");
        ActualizarPlatillo.setVisible(true);
        CancelarActualizacion.setVisible(true);

        // Mostramos el id
        lbl_id.setVisible(true);
        txt_id.setVisible(true);
        txt_id.setEditable(false);

        // Quitamos los botones
        AnadirPlatillo.setVisible(false);
    }

    private void vaciarActualizarItems() {
        // Limpiamos los txt
        txt_id.setText("");
        txt_nombre.setText("");
        txt_precioI.setText("");
        txt_composicion.setText("");
        txt_nombreAnadirIngrediente.setText("");
        txt_precioAnadirIngrediente.setText("");

        // Quitamos el contenido de la tabla
        plat_temp = new Platillo();
        tablaIngredientes();
    }

    private void llenarActualizarItems() {
        // Llenamos los txt
        txt_id.setText("" + plat_temp.getIdPlatillo());
        txt_nombre.setText(plat_temp.getNombrePlatillo());
        txt_precioI.setText(String.format("%.2f", plat_temp.getCostoPlatillo()));
        txt_composicion.setText(plat_temp.getComposicion());
        txt_nombreAnadirIngrediente.setText("");
        txt_precioAnadirIngrediente.setText("");

        // Quitamos el contenido de la tabla
        tablaIngredientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        Eliminar = new javax.swing.JDialog();
        message1 = new javax.swing.JLabel();
        btnSi1 = new javax.swing.JButton();
        btnNo1 = new javax.swing.JButton();
        EliminarPlatillo = new javax.swing.JDialog();
        message2 = new javax.swing.JLabel();
        btnSiEliminar = new javax.swing.JButton();
        btnNo2 = new javax.swing.JButton();
        lbl_mensaje = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatillos = new javax.swing.JTable();
        lbl_operacion = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        lbl_precio = new javax.swing.JLabel();
        txt_precioI = new javax.swing.JFormattedTextField();
        lbl_nombre1 = new javax.swing.JLabel();
        txt_composicion = new javax.swing.JTextField();
        lbl_composicion = new javax.swing.JLabel();
        lbl_composicion1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        txt_precioAnadirIngrediente = new javax.swing.JFormattedTextField();
        lbl_precio1 = new javax.swing.JLabel();
        lbl_composicion3 = new javax.swing.JLabel();
        txt_nombreAnadirIngrediente = new javax.swing.JTextField();
        AnadirIngrediente = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        AnadirPlatillo = new javax.swing.JButton();
        ActualizarPlatillo = new javax.swing.JButton();
        lbl_id3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JFormattedTextField();
        lbl_id = new javax.swing.JLabel();
        CancelarActualizacion = new javax.swing.JButton();

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

        Eliminar.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        Eliminar.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                EliminarWindowClosing(evt);
            }
        });

        message1.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message1.setForeground(new java.awt.Color(255, 0, 0));
        message1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message1.setText("¿Está seguro?");

        btnSi1.setText("SÍ");
        btnSi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSi1ActionPerformed(evt);
            }
        });

        btnNo1.setText("NO");
        btnNo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EliminarLayout = new javax.swing.GroupLayout(Eliminar.getContentPane());
        Eliminar.getContentPane().setLayout(EliminarLayout);
        EliminarLayout.setHorizontalGroup(
            EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(message1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSi1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        EliminarLayout.setVerticalGroup(
            EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(message1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSi1)
                    .addComponent(btnNo1)))
        );

        EliminarPlatillo.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        EliminarPlatillo.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                EliminarPlatilloWindowClosing(evt);
            }
        });

        message2.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message2.setForeground(new java.awt.Color(255, 0, 0));
        message2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message2.setText("¿Está seguro?");

        btnSiEliminar.setText("SÍ");
        btnSiEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiEliminarActionPerformed(evt);
            }
        });

        btnNo2.setText("NO");
        btnNo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EliminarPlatilloLayout = new javax.swing.GroupLayout(EliminarPlatillo.getContentPane());
        EliminarPlatillo.getContentPane().setLayout(EliminarPlatilloLayout);
        EliminarPlatilloLayout.setHorizontalGroup(
            EliminarPlatilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPlatilloLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(EliminarPlatilloLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnSiEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        EliminarPlatilloLayout.setVerticalGroup(
            EliminarPlatilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EliminarPlatilloLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(message2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(EliminarPlatilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSiEliminar)
                    .addComponent(btnNo2)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1371, 768));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lbl_mensaje.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_mensaje.setText("Mostrando platillos de <nombre>");

        tablaPlatillos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaPlatillos.setForeground(new java.awt.Color(51, 51, 51));
        tablaPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio", "Composición", "Lista de ingredientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPlatillos.setRowHeight(22);
        tablaPlatillos.setRowMargin(2);
        jScrollPane1.setViewportView(tablaPlatillos);
        if (tablaPlatillos.getColumnModel().getColumnCount() > 0) {
            tablaPlatillos.getColumnModel().getColumn(0).setMaxWidth(100);
            tablaPlatillos.getColumnModel().getColumn(1).setMinWidth(30);
            tablaPlatillos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tablaPlatillos.getColumnModel().getColumn(1).setMaxWidth(500);
            tablaPlatillos.getColumnModel().getColumn(2).setMinWidth(25);
            tablaPlatillos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaPlatillos.getColumnModel().getColumn(2).setMaxWidth(200);
            tablaPlatillos.getColumnModel().getColumn(3).setMinWidth(25);
            tablaPlatillos.getColumnModel().getColumn(3).setPreferredWidth(300);
            tablaPlatillos.getColumnModel().getColumn(3).setMaxWidth(500);
        }

        lbl_operacion.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbl_operacion.setText("Añadir platillo");

        txt_nombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        lbl_precio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_precio.setText("Precio");

        txt_precioI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txt_precioI.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_precioI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precioIActionPerformed(evt);
            }
        });

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

        tablaIngredientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaIngredientes);

        txt_precioAnadirIngrediente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.##"))));
        txt_precioAnadirIngrediente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbl_precio1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_precio1.setText("Precio (MXN.00)");

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

        AnadirPlatillo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        AnadirPlatillo.setText("Añadir platillo");
        AnadirPlatillo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        AnadirPlatillo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AnadirPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnadirPlatilloActionPerformed(evt);
            }
        });

        ActualizarPlatillo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        ActualizarPlatillo.setText("Actualizar platillo");
        ActualizarPlatillo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        ActualizarPlatillo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ActualizarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarPlatilloActionPerformed(evt);
            }
        });

        lbl_id3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txt_id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbl_id.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_id.setText("ID");

        CancelarActualizacion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        CancelarActualizacion.setText("Cancelar");
        CancelarActualizacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        CancelarActualizacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelarActualizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActualizacionActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_operacion)
                            .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_composicion, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_composicion))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_precio)
                                    .addComponent(txt_precioI, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_composicion1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_nombre1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_id)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AnadirIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(lbl_precio1)
                                    .addComponent(txt_precioAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_composicion3)
                                    .addComponent(txt_nombreAnadirIngrediente)))
                            .addComponent(AnadirPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                        .addComponent(lbl_id3)
                        .addContainerGap(590, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ActualizarPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CancelarActualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 69, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_mensaje)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(337, 337, 337)
                        .addComponent(lbl_id3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_operacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nombre1)
                            .addComponent(lbl_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_id)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_composicion)
                            .addComponent(lbl_precio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_composicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_precioI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(lbl_composicion1)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_composicion3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombreAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(lbl_precio1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_precioAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(AnadirIngrediente))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(AnadirPlatillo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ActualizarPlatillo)
                            .addComponent(CancelarActualizacion))
                        .addGap(42, 42, 42)
                        .addComponent(Volver)))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MenuAdministrador menuAdmin = new MenuAdministrador(restaurante.getCorreo());
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
        MenuAdministrador menuAdmin = new MenuAdministrador(restaurante.getCorreo());
        menuAdmin.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void AnadirPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirPlatilloActionPerformed
        // Recogemos los datos del formulario        

        if (!(!txt_nombre.getText().equals("") && !txt_precioI.getText().equals("") && !txt_composicion.getText().equals(""))) {
            message.setText("Añadir platillo: debe llenar todos los campos");
        } else {
            // Vamos asignar sus datos
            String nombre = txt_nombre.getText();
            double precio = Double.parseDouble(txt_precioI.getText().replace(",", ""));
            String precioIng = String.format("%.2f", precio);
            precio = Double.parseDouble(precioIng);
            String composicion = txt_composicion.getText();

            plat_temp.setNombrePlatillo(nombre);
            plat_temp.setCostoPlatillo(precio);
            plat_temp.setComposicion(composicion);
            plat_temp.setIdMenu(menu.getIdMenu());

            // Intentamos hacer la transacción
            if (plat_temp.escribirPlatillo() == 0) {
                message.setText("Añadir platillo: Añadido correctamente");
                txt_nombre.setText("");
                txt_precioI.setText("");
                txt_composicion.setText("");
                plat_temp = new Platillo();
                tablaIngredientes();
                tablaPlatillos();
            } else {
                message.setText("Añadir platillo: Oh no, algo salió mal :(");
            }
        }
        Error.setVisible(true);
        Error.setSize(400, 90);
        Error.setLocation(ancho_pantalla / 2 - 200, alto_pantalla / 2 - 45);

    }//GEN-LAST:event_AnadirPlatilloActionPerformed

    private void ActualizarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarPlatilloActionPerformed
        // Recogemos los datos del formulario        

        if (!(!txt_nombre.getText().equals("") && !txt_precioI.getText().equals("") && !txt_composicion.getText().equals(""))) {
            message.setText("Actualizar platillo: debe llenar todos los campos");
        } else {
            // Vamos asignar sus datos
            String nombre = txt_nombre.getText();
            double precio = Double.parseDouble(txt_precioI.getText().replace(",", ""));
            String precioIng = String.format("%.2f", precio);
            precio = Double.parseDouble(precioIng);
            String composicion = txt_composicion.getText();

            plat_temp.setNombrePlatillo(nombre);
            plat_temp.setCostoPlatillo(precio);
            plat_temp.setComposicion(composicion);
            plat_temp.setIdMenu(menu.getIdMenu());

            // Intentamos hacer la transacción
            if (plat_temp.actualizarPlatillo() == 0) {
                message.setText("Actualizar platillo: Actualizado correctamente");
                txt_nombre.setText("");
                txt_precioI.setText("");
                txt_composicion.setText("");
                plat_temp = new Platillo();
                tablaIngredientes();
                tablaPlatillos();
            } else {
                message.setText("Actualizar platillo: Oh no, algo salió mal :(");
            }
        }
        Error.setVisible(true);
        Error.setSize(400, 90);
        Error.setLocation(ancho_pantalla / 2 - 200, alto_pantalla / 2 - 45);
        removerActualizarItems();
        vaciarActualizarItems();
        plat_temp = new Platillo();
        ing_temp = new Ingrediente();
    }//GEN-LAST:event_ActualizarPlatilloActionPerformed

    private void AnadirIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirIngredienteActionPerformed
        Ingrediente nuevo_ingrediente = new Ingrediente();
        boolean errors = false; // Control de errores
        // Recogemos la información del platillo
        if (!txt_nombreAnadirIngrediente.getText().equals("") && !txt_precioAnadirIngrediente.getText().equals("")) {
            String nombreIng = txt_nombreAnadirIngrediente.getText();
            double precioIng = Double.parseDouble(txt_precioAnadirIngrediente.getText().replace(",", ""));
            String precio = String.format("%.2f", precioIng);
            precioIng = Double.parseDouble(precio);

            nuevo_ingrediente.setNombreIngrediente(nombreIng);
            nuevo_ingrediente.setCostoIngrediente(precioIng);

        } else {
            message.setText("Añadir ingrediente: debe llenar todos los campos");
            errors = true;
        }
        if (errors) {
            Error.setVisible(true);
            Error.setSize(400, 90);
            Error.setLocation(ancho_pantalla / 2 - 200, alto_pantalla / 2 - 45);
        } else {

            plat_temp.agregarIngrediente(nuevo_ingrediente);
            tablaIngredientes();
            txt_nombreAnadirIngrediente.setText("");
            txt_precioAnadirIngrediente.setText("");
        }

    }//GEN-LAST:event_AnadirIngredienteActionPerformed

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();
    }//GEN-LAST:event_ErrorWindowClosing

    private void btnSi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSi1ActionPerformed
        // Recogemos la información del ingrediente a eliminar
        plat_temp.eliminarIngrediente(ing_temp);
        tablaIngredientes();
        ing_temp = new Ingrediente();
        Eliminar.setVisible(false);
        Eliminar.dispose();
    }//GEN-LAST:event_btnSi1ActionPerformed

    private void btnNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNo1ActionPerformed
        ing_temp = new Ingrediente();
        Eliminar.setVisible(false);
        Eliminar.dispose();
    }//GEN-LAST:event_btnNo1ActionPerformed

    private void CancelarActualizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActualizacionActionPerformed
        removerActualizarItems();
        vaciarActualizarItems();
        plat_temp = new Platillo();
        ing_temp = new Ingrediente();
    }//GEN-LAST:event_CancelarActualizacionActionPerformed

    private void txt_precioIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precioIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioIActionPerformed

    private void btnSiEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiEliminarActionPerformed
        plat_temp.eliminarPlatillo();
        plat_temp = new Platillo();
        EliminarPlatillo.setVisible(false);
        EliminarPlatillo.dispose();
        vaciarActualizarItems();
        tablaIngredientes();
        tablaPlatillos();
    }//GEN-LAST:event_btnSiEliminarActionPerformed

    private void btnNo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNo2ActionPerformed
        plat_temp = new Platillo();
        EliminarPlatillo.setVisible(false);
        EliminarPlatillo.dispose();
        vaciarActualizarItems();
        tablaIngredientes();
    }//GEN-LAST:event_btnNo2ActionPerformed

    private void EliminarWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_EliminarWindowClosing
        ing_temp = new Ingrediente();
        Eliminar.setVisible(false);
        Eliminar.dispose();
    }//GEN-LAST:event_EliminarWindowClosing

    private void EliminarPlatilloWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_EliminarPlatilloWindowClosing
        plat_temp = new Platillo();
        EliminarPlatillo.setVisible(false);
        EliminarPlatillo.dispose();
        vaciarActualizarItems();
        tablaIngredientes();
    }//GEN-LAST:event_EliminarPlatilloWindowClosing
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
    private javax.swing.JButton ActualizarPlatillo;
    private javax.swing.JButton AnadirIngrediente;
    private javax.swing.JButton AnadirPlatillo;
    private javax.swing.JButton CancelarActualizacion;
    private javax.swing.JDialog Eliminar;
    private javax.swing.JDialog EliminarPlatillo;
    private javax.swing.JDialog Error;
    private javax.swing.JButton Volver;
    private javax.swing.JButton btnNo1;
    private javax.swing.JButton btnNo2;
    private javax.swing.JButton btnSi1;
    private javax.swing.JButton btnSiEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_composicion;
    private javax.swing.JLabel lbl_composicion1;
    private javax.swing.JLabel lbl_composicion3;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_id3;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_operacion;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_precio1;
    private javax.swing.JLabel message;
    private javax.swing.JLabel message1;
    private javax.swing.JLabel message2;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTable tablaPlatillos;
    private javax.swing.JTextField txt_composicion;
    private javax.swing.JFormattedTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombreAnadirIngrediente;
    private javax.swing.JFormattedTextField txt_precioAnadirIngrediente;
    private javax.swing.JFormattedTextField txt_precioI;
    // End of variables declaration//GEN-END:variables
}
