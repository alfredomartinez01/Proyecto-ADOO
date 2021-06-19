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
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Modificaciones extends javax.swing.JFrame {

    private Restaurante restaurante = new Restaurante();
    private Menu menu = new Menu(restaurante);
    private Platillo plat_temp = new Platillo();

    public Modificaciones(Restaurante restaurant) {
        this.restaurante = restaurant;
        menu.setIdRestaurante(restaurante.getId());
        menu.consultarIdMenu();

        initComponents();
        ajustarApariencia();
        lbl_mensaje.setText("Mostrando platillos de " + restaurante.getNombre() + ".");
        tablaPlatillos();
        popupTablaPlatillos();

        removeActualizarItems();
    }

    public void ajustarApariencia() {
        this.setTitle("Platillos y modificaciones");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
    }

    private void tablaPlatillos() { // Muestra la tabla normal
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

    }

    private void tablaIngredientesAnadir() { // Muestra la tabla de ingredientes

        DefaultTableModel model = (DefaultTableModel) tablaIngredientesAnadir.getModel();
        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        model = (DefaultTableModel) tablaIngredientesAnadir.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[2]; // Crea el objeto de celdas para agregar
        for (Ingrediente ingrediente : plat_temp.getIngredientes()) {
            fila[0] = ingrediente.getNombreIngrediente();
            fila[1] = ingrediente.getCostoIngrediente();
            model.addRow(fila); // Agrega la fila al modelo de la tabla
        }
        tablaIngredientesAnadir.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 

    }

    private void tablaIngredientesActualizar() { // Muestra la tabla normal
        DefaultTableModel model = (DefaultTableModel) tablaIngredientesActualizar.getModel();

        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        model = (DefaultTableModel) tablaIngredientesActualizar.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[8]; // Crea el objeto de celdas para agregar
        fila[0] = "1";
        fila[1] = "1";
        fila[2] = "1";
        fila[3] = "1";
        model.addRow(fila); // Agrega la fila al modelo de la tabla
        tablaIngredientesAnadir.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 

    }

    public void popupTablaPlatillos() {
        JPopupMenu pM = new JPopupMenu(); //se crea el contenedor
        JMenuItem jmi1 = new JMenuItem("Actualizar"); //las opciones
        JMenuItem jmi2 = new JMenuItem("Eliminar");

        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int ift = clientesT.getSelectedRow();
                String idPlat = String.valueOf(tablaPlatillos.getValueAt(tablaPlatillos.getSelectedRow(), 0));
                int idP = Integer.valueOf(idPlat);
                if (idP != -1) { // Busqueda por IDC, checamos que no esté vacío   
                    setActualizarItems();
                    System.out.println(idP);
                }
            }
        });
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Eliminar.setVisible(true);
                Eliminar.setSize(310, 170);
                Eliminar.setLocation(ancho_pantalla / 2 - 160, alto_pantalla / 2 - 45);

            }
        });
        pM.add(jmi1);// se agregan las opciones al contenedor
        pM.add(jmi2);

        tablaPlatillos.setComponentPopupMenu(pM);//se agrega el menú a la tabla con su respectivo evento
    }

    private void removeActualizarItems() {
        // Quitamos primero los labels
        lbl_anadir1.setVisible(false);
        lbl_id2.setVisible(false);
        lbl_nombre2.setVisible(false);
        lbl_precio2.setVisible(false);
        lbl_composicion2.setVisible(false);
        lbl_ingredientes2.setVisible(false);
        lbl_ingNomb2.setVisible(false);
        lbl_precio3.setVisible(false);
        lbl_id3.setVisible(false);

        // Después quitamos los text
        txt_idActualizar.setVisible(false);
        txt_nombreActualizar.setVisible(false);
        txt_precioActualizar.setVisible(false);
        txt_composicionActualizar.setVisible(false);
        txt_nombreActualizarIngrediente.setVisible(false);
        txt_precioActualizarIngrediente.setVisible(false);
        txt_idEliminarIngrediente.setVisible(false);
        
        // Quitamos los botones
        ActualizarIngrediente.setVisible(false);
        EliminarIngrediente.setVisible(false);
        Volver2.setVisible(false);
        Volver3.setVisible(false);
        
        // Quitamos la tabla
        PanelTabla.setVisible(false);
    }

    private void setActualizarItems() {
        // Quitamos primero los labels
        lbl_anadir1.setVisible(false);
        lbl_id2.setVisible(false);
        lbl_nombre2.setVisible(false);
        lbl_precio2.setVisible(false);
        lbl_composicion2.setVisible(false);
        lbl_ingredientes2.setVisible(false);
        lbl_ingNomb2.setVisible(false);
        lbl_precio3.setVisible(false);
        lbl_id3.setVisible(false);

        // Después quitamos los text
        txt_idActualizar.setVisible(false);
        txt_nombreActualizar.setVisible(false);
        txt_precioActualizar.setVisible(false);
        txt_composicionActualizar.setVisible(false);
        txt_nombreActualizarIngrediente.setVisible(false);
        txt_precioActualizarIngrediente.setVisible(false);
        txt_idEliminarIngrediente.setVisible(false);
        
        // Quitamos los botones
        ActualizarIngrediente.setVisible(false);
        EliminarIngrediente.setVisible(false);
        Volver2.setVisible(false);
        Volver3.setVisible(false);
        
        // Quitamos la tabla
        PanelTabla.setVisible(false);
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
        txt_precioAnadirIngrediente = new javax.swing.JFormattedTextField();
        lbl_precio1 = new javax.swing.JLabel();
        lbl_composicion3 = new javax.swing.JLabel();
        txt_nombreAnadirIngrediente = new javax.swing.JTextField();
        AnadirIngrediente = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        lbl_ingredientes2 = new javax.swing.JLabel();
        txt_nombreActualizarIngrediente = new javax.swing.JTextField();
        PanelTabla = new javax.swing.JScrollPane();
        tablaIngredientesActualizar = new javax.swing.JTable();
        ActualizarIngrediente = new javax.swing.JButton();
        txt_nombreActualizar = new javax.swing.JTextField();
        lbl_precio2 = new javax.swing.JLabel();
        txt_precioActualizar = new javax.swing.JFormattedTextField();
        txt_precioActualizarIngrediente = new javax.swing.JFormattedTextField();
        lbl_nombre2 = new javax.swing.JLabel();
        lbl_precio3 = new javax.swing.JLabel();
        txt_composicionActualizar = new javax.swing.JTextField();
        lbl_ingNomb2 = new javax.swing.JLabel();
        lbl_composicion2 = new javax.swing.JLabel();
        lbl_anadir1 = new javax.swing.JLabel();
        AnadirPlatillo = new javax.swing.JButton();
        Volver2 = new javax.swing.JButton();
        txt_idEliminarIngrediente = new javax.swing.JFormattedTextField();
        lbl_id3 = new javax.swing.JLabel();
        EliminarIngrediente = new javax.swing.JButton();
        txt_idActualizar = new javax.swing.JFormattedTextField();
        lbl_id2 = new javax.swing.JLabel();
        Volver3 = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1371, 768));
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
                "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
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
        jScrollPane2.setViewportView(tablaIngredientesAnadir);

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

        lbl_ingredientes2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_ingredientes2.setText("Ingredientes");

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
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PanelTabla.setViewportView(tablaIngredientesActualizar);

        ActualizarIngrediente.setText("Añadir ingrediente");

        txt_nombreActualizar.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txt_nombreActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActualizarActionPerformed(evt);
            }
        });

        lbl_precio2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_precio2.setText("Precio");

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

        lbl_ingNomb2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_ingNomb2.setText("Nombre");

        lbl_composicion2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_composicion2.setText("Composición");

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

        lbl_id3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_id3.setText("ID");

        EliminarIngrediente.setText("Eliminar ingrediente");

        txt_idActualizar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#"))));
        txt_idActualizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lbl_id2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_id2.setText("ID*");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AnadirIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(lbl_precio1)
                                    .addComponent(txt_precioAnadirIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_composicion3)
                                    .addComponent(txt_nombreAnadirIngrediente)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lbl_composicion1))
                            .addComponent(AnadirPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbl_precio2)
                                        .addGap(109, 109, 109)
                                        .addComponent(lbl_composicion2)
                                        .addGap(188, 188, 188))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(lbl_ingredientes2))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_precioActualizar)
                                                    .addComponent(txt_idActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(lbl_id2)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_nombreActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(lbl_nombre2))
                                                .addComponent(txt_composicionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_anadir1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(Volver2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Volver3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ActualizarIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                                    .addComponent(lbl_precio3)
                                                    .addComponent(txt_precioActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbl_ingNomb2)
                                                    .addComponent(txt_nombreActualizarIngrediente)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_idEliminarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(EliminarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lbl_id3))))
                                .addGap(68, 68, 68)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 101, Short.MAX_VALUE))))
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
                                .addComponent(lbl_id2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_idActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_precio2)
                            .addComponent(lbl_composicion2))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_precioActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_composicionActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_ingredientes2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_ingNomb2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_nombreActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(lbl_precio3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_precioActualizarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(ActualizarIngrediente))
                            .addComponent(PanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_id3)
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
        boolean errors = false; // Control de errores
        // Recogemos los datos del formulario        

        if (!(!txt_nombre.getText().equals("") && !txt_precio.getText().equals("") && !txt_composicion.getText().equals(""))) {
            message.setText("Añadir platillo: debe llenar todos los campos");
            errors = true;
        } else {
            // Vamos asignar sus datos
            String nombre = txt_nombre.getText();
            Double precio = Double.parseDouble(txt_precio.getText().replace(",", ""));
            String composicion = txt_composicion.getText();

            plat_temp.setNombrePlatillo(nombre);
            plat_temp.setCostoPlatillo(precio);
            plat_temp.setComposicion(composicion);
            plat_temp.setIdMenu(menu.getIdMenu());

            // Intentamos hacer la transacción
            if (plat_temp.escribirPlatillo() == 0) {
                message.setText("Añadir platillo: Añadido correctamente");
                txt_nombre.setText("");
                txt_precio.setText("");
                txt_composicion.setText("");
                plat_temp = new Platillo();
                tablaIngredientesAnadir();
                tablaPlatillos();
            } else {
                message.setText("Añadir platillo: Oh no, algo salió mal :(");
                errors = true;
            }
        }
        Error.setVisible(true);
        Error.setSize(400, 90);
        Error.setLocation(ancho_pantalla / 2 - 200, alto_pantalla / 2 - 45);

    }//GEN-LAST:event_AnadirPlatilloActionPerformed

    private void Volver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volver2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Volver2ActionPerformed

    private void Volver3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Volver3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Volver3ActionPerformed

    private void AnadirIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnadirIngredienteActionPerformed
        Ingrediente nuevo_ingrediente = new Ingrediente();
        boolean errors = false; // Control de errores
        // Recogemos la información del platillo
        if (!txt_nombreAnadirIngrediente.getText().equals("") && !txt_precioAnadirIngrediente.getText().equals("")) {
            String nombreIng = txt_nombreAnadirIngrediente.getText();
            double precioIng = Double.parseDouble(txt_precioAnadirIngrediente.getText().replace(",", ""));
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
            tablaIngredientesAnadir();
            txt_nombreAnadirIngrediente.setText("");
            txt_precioAnadirIngrediente.setText("");
        }

    }//GEN-LAST:event_AnadirIngredienteActionPerformed

    private void ErrorWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_ErrorWindowClosing
        Error.setVisible(false);
        Error.dispose();
    }//GEN-LAST:event_ErrorWindowClosing

    private void btnSi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSi1ActionPerformed
        String ideC = String.valueOf(tablaPlatillos.getValueAt(tablaPlatillos.getSelectedRow(), 0));
        if (ideC.equals("") == false) { // Busqueda por IDC, checamos que no esté vacío
            int idc = Integer.valueOf(ideC);
            if (idc != -1) {
                Eliminar.setVisible(false);
                Eliminar.dispose();
            }
        }

    }//GEN-LAST:event_btnSi1ActionPerformed

    private void btnNo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNo1ActionPerformed
        Eliminar.setVisible(false);
        Eliminar.dispose();
    }//GEN-LAST:event_btnNo1ActionPerformed
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
    private javax.swing.JDialog Eliminar;
    private javax.swing.JButton EliminarIngrediente;
    private javax.swing.JDialog Error;
    private javax.swing.JScrollPane PanelTabla;
    private javax.swing.JButton Volver;
    private javax.swing.JButton Volver2;
    private javax.swing.JButton Volver3;
    private javax.swing.JButton btnNo1;
    private javax.swing.JButton btnSi1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_anadir;
    private javax.swing.JLabel lbl_anadir1;
    private javax.swing.JLabel lbl_composicion;
    private javax.swing.JLabel lbl_composicion1;
    private javax.swing.JLabel lbl_composicion2;
    private javax.swing.JLabel lbl_composicion3;
    private javax.swing.JLabel lbl_id2;
    private javax.swing.JLabel lbl_id3;
    private javax.swing.JLabel lbl_ingNomb2;
    private javax.swing.JLabel lbl_ingredientes2;
    private javax.swing.JLabel lbl_mensaje;
    private javax.swing.JLabel lbl_nombre1;
    private javax.swing.JLabel lbl_nombre2;
    private javax.swing.JLabel lbl_precio;
    private javax.swing.JLabel lbl_precio1;
    private javax.swing.JLabel lbl_precio2;
    private javax.swing.JLabel lbl_precio3;
    private javax.swing.JLabel message;
    private javax.swing.JLabel message1;
    private javax.swing.JTable tablaIngredientesActualizar;
    private javax.swing.JTable tablaIngredientesAnadir;
    private javax.swing.JTable tablaPlatillos;
    private javax.swing.JTextField txt_composicion;
    private javax.swing.JTextField txt_composicionActualizar;
    private javax.swing.JFormattedTextField txt_idActualizar;
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
