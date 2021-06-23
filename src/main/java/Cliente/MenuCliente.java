package Cliente;

import static Cliente.Bienvenida.alto_pantalla;
import static Cliente.Bienvenida.ancho_pantalla;
import static Restaurante.Login.alto_pantalla;
import static Restaurante.Login.ancho_pantalla;
import datos.Conexion;
import datos.IngredienteDAO;
import datos.RestauranteDAO;
import domain.Ingrediente;
import domain.Menu;
import domain.Orden;
import domain.Platillo;
import domain.Restaurante;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class MenuCliente extends javax.swing.JFrame {

    private ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();
    private Restaurante rest_temp = new Restaurante();
    private Menu menu_temp = new Menu();
    private Platillo plat_temp = new Platillo();
    private Orden orden_temp = new Orden();
    private ArrayList<Ingrediente> ing_disp = new ArrayList<Ingrediente>();
    private ArrayList<Ingrediente> ing_agregados = new ArrayList<Ingrediente>();
    private JButton[] btns_rest = new JButton[5];
    private JButton[] btns_plat = new JButton[5];

    public MenuCliente() {
        initComponents();
        ajustarApariencia();

        consultarRestaurantes();
        removerElementos(); // removidos todos            
        agregarBotones();
        popupTablaIngredientesDisp();
        popupTablaIngredientesAgregados();
        popupTablaPlatillos();
    }
    
    public MenuCliente(Orden order, Menu menu) {
        initComponents();
        ajustarApariencia();

        consultarRestaurantes();
        removerElementos(); // removidos todos            
        agregarBotones();
        pnlMenu.setVisible(true);
        pnlPlatillo.setVisible(true);
        pnlDescripcion.setVisible(false);
        orden_temp = order;
        menu_temp = menu;
        llenarTablaPlatillos();
        popupTablaIngredientesDisp();
        popupTablaIngredientesAgregados();
        popupTablaPlatillos();
    }

    public void ajustarApariencia() {
        this.setTitle("Autorder");
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.decode("#ACDED5"));
        //this.setIconImage(new ImageIcon(getClass().getResource("/logo.jpg")).getImage());
        pnlRestaurantes.setBackground(Color.decode("#3B3455"));
        pnlMenu.setBackground(Color.decode("#A4A3A6"));
    }

    public void removerElementos() {
        pnlMenu.setVisible(false);
        pnlPlatillo.setVisible(false);
        btnRes1.setVisible(false);
        btnRes2.setVisible(false);
        btnRes2.setVisible(false);
        btnRes3.setVisible(false);
        btnRes4.setVisible(false);
        btnRes5.setVisible(false);

        btnPlatillo1.setVisible(false);
        btnPlatillo2.setVisible(false);
        btnPlatillo3.setVisible(false);
        btnPlatillo4.setVisible(false);
        btnPlatillo5.setVisible(false);

        btns_rest[0] = btnRes1;
        btns_rest[1] = btnRes2;
        btns_rest[2] = btnRes3;
        btns_rest[3] = btnRes4;
        btns_rest[4] = btnRes5;

        btns_plat[0] = btnPlatillo1;
        btns_plat[1] = btnPlatillo2;
        btns_plat[2] = btnPlatillo3;
        btns_plat[3] = btnPlatillo4;
        btns_plat[4] = btnPlatillo5;

    }

    public void removerPlatillos() {
        btnPlatillo1.setVisible(false);
        btnPlatillo2.setVisible(false);
        btnPlatillo3.setVisible(false);
        btnPlatillo4.setVisible(false);
        btnPlatillo5.setVisible(false);
    }

    public void consultarRestaurantes() {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection(); // Establecemos la conexión
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false); // Quitamos el autocommit para la transacción
            }
            RestauranteDAO rest_management = new RestauranteDAO(conexion);
            restaurantes = rest_management.select_all(); // Todos los restaurantes en buffer

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

    public void agregarBotones() {
        int index = 0;
        for (Restaurante res : restaurantes) {
            btns_rest[index].setSize(200, 50);
            btns_rest[index].setText(res.getNombre());
            btns_rest[index].setVisible(true);
            index++;
        }

    }

    public void llenarTablaDisponibles() {
        IngredienteDAO ing_management = new IngredienteDAO();        
        try{
            ing_disp = ing_management.seleccionar_por_idPlatillo(plat_temp.getIdPlatillo());
        } catch(SQLException ex){
            ex.printStackTrace(System.out);
        }              
        
        DefaultTableModel model = (DefaultTableModel) tablaIngredientesDisp.getModel();
        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        
        model = (DefaultTableModel) tablaIngredientesDisp.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[2]; // Crea el objeto de celdas para agregar
        
        for (Ingrediente ingrediente : ing_disp) {
            fila[0] = ingrediente.getNombreIngrediente();
            fila[1] = ingrediente.getCostoIngrediente();
            model.addRow(fila); // Agrega la fila al modelo de la tabla
        }
        tablaIngredientesDisp.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
    }
    
    public void llenarTablaAgregados() {
        DefaultTableModel model = (DefaultTableModel) tablaIngredientesAgregados.getModel();
        // Borra la tabla anterior
        int index = 0;
        while (index < model.getRowCount()) {
            model.removeRow(index);
        }
        
        model = (DefaultTableModel) tablaIngredientesAgregados.getModel(); // Crea el modelo de la tabla a partir del actual
        Object[] fila = new Object[2]; // Crea el objeto de celdas para agregar
        
        for (Ingrediente ingrediente : ing_agregados) {
            fila[0] = ingrediente.getNombreIngrediente();
            fila[1] = ingrediente.getCostoIngrediente();
            model.addRow(fila); // Agrega la fila al modelo de la tabla
        }
        tablaIngredientesAgregados.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
    }
    public void llenarTablaPlatillos() {           
        // Muestra la tabla normal
            DefaultTableModel model = (DefaultTableModel) tablaPlatillos.getModel();
            // Borra la tabla anterior
            int index = 0;
            while (index < model.getRowCount()) {
                model.removeRow(index);
            }
            model = (DefaultTableModel) tablaPlatillos.getModel(); // Crea el modelo de la tabla a partir del actual
            Object[] fila = new Object[5]; // Crea el objeto de celdas para agregar
            int noPlat = 0;
            for (Platillo plat : orden_temp.getPlatillos()) {
                //tablaPlatillos.setRowHeight(noPlat, 30);
                plat.setIdMenu(menu_temp.getIdMenu());
                fila[0] = plat.getNombrePlatillo();
                fila[1] = plat.getComposicion();
                fila[2] = plat.getCostoPlatillo();
                String ingredientes = "";
                for (Ingrediente ing : plat.getIngredientes()) {
                    ingredientes += ing;
                }
                fila[3] = ingredientes;
                model.addRow(fila); // Agrega la fila al modelo de la tabla
                noPlat++;
            }
            tablaPlatillos.setModel(model); // Reasigna el modelo pero ahora con los nuevos datos 
    }
    
    public void popupTablaIngredientesDisp() {
        JPopupMenu pM = new JPopupMenu(); //se crea el contenedor
        JMenuItem op_agrega = new JMenuItem("Agregar a orden"); //las opciones

        op_agrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ing_agregados.add( ing_disp.get(tablaIngredientesDisp.getSelectedRow()) );
                llenarTablaAgregados();
            }
        });
        pM.add(op_agrega);// se agregan las opciones al contenedor

        tablaIngredientesDisp.setComponentPopupMenu(pM);//se agrega el menú a la tabla con su respectivo evento
    }
    public void popupTablaIngredientesAgregados() {
        JPopupMenu pM = new JPopupMenu(); //se crea el contenedor
        JMenuItem op_elimina = new JMenuItem("Eliminar");
        
        op_elimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ing_agregados.remove( ing_agregados.get(tablaIngredientesAgregados.getSelectedRow()) );
                llenarTablaAgregados();
            }
        });
        // se agregan las opciones al contenedor
        pM.add(op_elimina);

        tablaIngredientesAgregados.setComponentPopupMenu(pM);//se agrega el menú a la tabla con su respectivo evento
    }
    
    public void popupTablaPlatillos() {
        JPopupMenu pM = new JPopupMenu(); //se crea el contenedor
        JMenuItem op_elimina = new JMenuItem("Eliminar");
        
        op_elimina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               orden_temp.getPlatillos().remove(orden_temp.getPlatillos().get(tablaPlatillos.getSelectedRow()));
                llenarTablaPlatillos();
            }
        });
        // se agregan las opciones al contenedor
        pM.add(op_elimina);

        tablaPlatillos.setComponentPopupMenu(pM);//se agrega el menú a la tabla con su respectivo evento
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRestaurantes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRes1 = new javax.swing.JButton();
        btnRes2 = new javax.swing.JButton();
        btnRes3 = new javax.swing.JButton();
        btnRes4 = new javax.swing.JButton();
        btnRes5 = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnPlatillo2 = new javax.swing.JButton();
        btnPlatillo1 = new javax.swing.JButton();
        btnPlatillo3 = new javax.swing.JButton();
        btnPlatillo4 = new javax.swing.JButton();
        btnPlatillo5 = new javax.swing.JButton();
        pnlPlatillo = new javax.swing.JPanel();
        pnlDescripcion = new javax.swing.JPanel();
        btnAgregarP = new javax.swing.JButton();
        lblNombreP = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIngredientesAgregados = new javax.swing.JTable();
        lbl_ingAgregados = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaIngredientesDisp = new javax.swing.JTable();
        lbl_ingDisponibles = new javax.swing.JLabel();
        pnlOrden = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPlatillos = new javax.swing.JTable();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        btnRes2.setBackground(new java.awt.Color(255, 255, 255));
        btnRes2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRes2.setForeground(new java.awt.Color(59, 52, 85));
        btnRes2.setText("Res2");
        btnRes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRes2ActionPerformed(evt);
            }
        });

        btnRes3.setBackground(new java.awt.Color(255, 255, 255));
        btnRes3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRes3.setForeground(new java.awt.Color(59, 52, 85));
        btnRes3.setText("Res3");
        btnRes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRes3ActionPerformed(evt);
            }
        });

        btnRes4.setBackground(new java.awt.Color(255, 255, 255));
        btnRes4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRes4.setForeground(new java.awt.Color(59, 52, 85));
        btnRes4.setText("Res4");
        btnRes4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRes4ActionPerformed(evt);
            }
        });

        btnRes5.setBackground(new java.awt.Color(255, 255, 255));
        btnRes5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnRes5.setForeground(new java.awt.Color(59, 52, 85));
        btnRes5.setText("Res5");
        btnRes5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRes5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRestaurantesLayout = new javax.swing.GroupLayout(pnlRestaurantes);
        pnlRestaurantes.setLayout(pnlRestaurantesLayout);
        pnlRestaurantesLayout.setHorizontalGroup(
            pnlRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                .addGroup(pnlRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(pnlRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRes2)
                            .addComponent(btnRes1)
                            .addComponent(btnRes3)
                            .addComponent(btnRes4)
                            .addComponent(btnRes5)))
                    .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlRestaurantesLayout.setVerticalGroup(
            pnlRestaurantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRestaurantesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(btnRes1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRes2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRes3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRes4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRes5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.setBackground(Color.decode("#A4A3A6")
        );

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Menú");

        btnPlatillo2.setBackground(new java.awt.Color(255, 255, 255));
        btnPlatillo2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPlatillo2.setForeground(new java.awt.Color(59, 52, 85));
        btnPlatillo2.setText("Platillo2");
        btnPlatillo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatillo2ActionPerformed(evt);
            }
        });

        btnPlatillo1.setBackground(new java.awt.Color(255, 255, 255));
        btnPlatillo1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPlatillo1.setForeground(new java.awt.Color(59, 52, 85));
        btnPlatillo1.setText("Platillo1");
        btnPlatillo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatillo1ActionPerformed(evt);
            }
        });

        btnPlatillo3.setBackground(new java.awt.Color(255, 255, 255));
        btnPlatillo3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPlatillo3.setForeground(new java.awt.Color(59, 52, 85));
        btnPlatillo3.setText("Platillo3");
        btnPlatillo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatillo3ActionPerformed(evt);
            }
        });

        btnPlatillo4.setBackground(new java.awt.Color(255, 255, 255));
        btnPlatillo4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPlatillo4.setForeground(new java.awt.Color(59, 52, 85));
        btnPlatillo4.setText("Platillo4");
        btnPlatillo4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatillo4ActionPerformed(evt);
            }
        });

        btnPlatillo5.setBackground(new java.awt.Color(255, 255, 255));
        btnPlatillo5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        btnPlatillo5.setForeground(new java.awt.Color(59, 52, 85));
        btnPlatillo5.setText("Platillo5");
        btnPlatillo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlatillo5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlatillo5)
                    .addComponent(btnPlatillo3)
                    .addComponent(btnPlatillo4)
                    .addComponent(btnPlatillo1)
                    .addComponent(btnPlatillo2)
                    .addComponent(jLabel2))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnPlatillo1)
                .addGap(18, 18, 18)
                .addComponent(btnPlatillo2)
                .addGap(18, 18, 18)
                .addComponent(btnPlatillo3)
                .addGap(18, 18, 18)
                .addComponent(btnPlatillo4)
                .addGap(18, 18, 18)
                .addComponent(btnPlatillo5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarP.setBackground(new java.awt.Color(153, 255, 255));
        btnAgregarP.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnAgregarP.setForeground(new java.awt.Color(59, 52, 85));
        btnAgregarP.setText("Agregar");
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });

        lblNombreP.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblNombreP.setText("<Nombre Platillo>");

        lblDescripcion.setText("<Descripción de platillo>");

        tablaIngredientesAgregados.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaIngredientesAgregados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaIngredientesAgregados);

        lbl_ingAgregados.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_ingAgregados.setText("Ingredientes agregados");

        tablaIngredientesDisp.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tablaIngredientesDisp.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaIngredientesDisp);

        lbl_ingDisponibles.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbl_ingDisponibles.setText("Ingredientes disponibles");

        javax.swing.GroupLayout pnlDescripcionLayout = new javax.swing.GroupLayout(pnlDescripcion);
        pnlDescripcion.setLayout(pnlDescripcionLayout);
        pnlDescripcionLayout.setHorizontalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripcionLayout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addComponent(lblNombreP)
                .addGap(331, 331, 331))
            .addGroup(pnlDescripcionLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDescripcionLayout.createSequentialGroup()
                        .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripcionLayout.createSequentialGroup()
                        .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlDescripcionLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAgregarP))
                            .addGroup(pnlDescripcionLayout.createSequentialGroup()
                                .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_ingDisponibles)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_ingAgregados)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50))))
        );
        pnlDescripcionLayout.setVerticalGroup(
            pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDescripcionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ingAgregados)
                    .addComponent(lbl_ingDisponibles))
                .addGap(18, 18, 18)
                .addGroup(pnlDescripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarP)
                .addGap(434, 434, 434))
        );

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Tu orden");

        tablaPlatillos.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        tablaPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Composicion", "Precio", "Ingredientes"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tablaPlatillos.getColumnModel().getColumn(2).setMaxWidth(60);
            tablaPlatillos.getColumnModel().getColumn(3).setMinWidth(200);
        }

        btnContinuar.setBackground(new java.awt.Color(153, 255, 255));
        btnContinuar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(59, 52, 85));
        btnContinuar.setText("Siguiente");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOrdenLayout = new javax.swing.GroupLayout(pnlOrden);
        pnlOrden.setLayout(pnlOrdenLayout);
        pnlOrdenLayout.setHorizontalGroup(
            pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenLayout.createSequentialGroup()
                .addGroup(pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnContinuar)
                    .addGroup(pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlOrdenLayout.createSequentialGroup()
                            .addGap(334, 334, 334)
                            .addComponent(jLabel1))
                        .addGroup(pnlOrdenLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlOrdenLayout.setVerticalGroup(
            pnlOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnContinuar)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPlatilloLayout = new javax.swing.GroupLayout(pnlPlatillo);
        pnlPlatillo.setLayout(pnlPlatilloLayout);
        pnlPlatilloLayout.setHorizontalGroup(
            pnlPlatilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlatilloLayout.createSequentialGroup()
                .addGroup(pnlPlatilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPlatilloLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(pnlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPlatilloLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlPlatilloLayout.setVerticalGroup(
            pnlPlatilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPlatilloLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRestaurantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(pnlPlatillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPlatillo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRestaurantes, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        this.setVisible(false);
        ConfirmarOrden confirm = new ConfirmarOrden(orden_temp, menu_temp);
        confirm.setVisible(true);
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnRes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRes1ActionPerformed
        removerPlatillos();
        asignarRestaurante(0);
        mostrarPlatillos();
    }//GEN-LAST:event_btnRes1ActionPerformed
    public void asignarRestaurante(int nBoton) {
        rest_temp = restaurantes.get(nBoton);
        menu_temp = new Menu(rest_temp);
        menu_temp.consultarIdMenu(); // Aquí ya tenemos el menu con el nombre de restuarante, idRestaurante e idMenu
        try {
            menu_temp.leerPlatillos(); // Ya tenemos lista la lista de plat_temp
        } catch (SQLException ex) {
            Logger.getLogger(MenuCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void mostrarPlatillos() {
        pnlMenu.setVisible(true);
        int index = 0;
        for (Platillo plat : menu_temp.getPlatillos()) {
            btns_plat[index].setSize(200, 50);
            btns_plat[index].setText(plat.getNombrePlatillo());
            btns_plat[index].setVisible(true);
            index++;
        }
    }

    private void btnPlatillo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatillo2ActionPerformed
        activarPaneles();
        asignarDataPlatillo(1);
    }//GEN-LAST:event_btnPlatillo2ActionPerformed

    private void btnRes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRes2ActionPerformed
        removerPlatillos();
        asignarRestaurante(1);
        mostrarPlatillos();
    }//GEN-LAST:event_btnRes2ActionPerformed

    private void btnRes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRes3ActionPerformed
        removerPlatillos();
        asignarRestaurante(2);
        mostrarPlatillos();
    }//GEN-LAST:event_btnRes3ActionPerformed

    private void btnRes4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRes4ActionPerformed
        removerPlatillos();
        asignarRestaurante(3);
        mostrarPlatillos();
    }//GEN-LAST:event_btnRes4ActionPerformed

    private void btnRes5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRes5ActionPerformed
        removerPlatillos();
        asignarRestaurante(5);
        mostrarPlatillos();
    }//GEN-LAST:event_btnRes5ActionPerformed

    private void btnPlatillo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatillo1ActionPerformed
        activarPaneles();
        asignarDataPlatillo(0);
    }//GEN-LAST:event_btnPlatillo1ActionPerformed

    public void asignarDataPlatillo(int nBoton) {
        plat_temp = menu_temp.getPlatillos().get(nBoton); // Ya tenemos el plat_temp es específico
        lblNombreP.setText(plat_temp.getNombrePlatillo());
        lblDescripcion.setText("Costo: $" + plat_temp.getCostoPlatillo() + " Composición: " + plat_temp.getComposicion());
        llenarTablaDisponibles();
    }
    
    public void activarPaneles(){
        pnlPlatillo.setVisible(true);
        pnlDescripcion.setVisible(true);
    }

    private void btnPlatillo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatillo3ActionPerformed
        activarPaneles();
        asignarDataPlatillo(2);
    }//GEN-LAST:event_btnPlatillo3ActionPerformed

    private void btnPlatillo4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatillo4ActionPerformed
        activarPaneles();
        asignarDataPlatillo(3);
    }//GEN-LAST:event_btnPlatillo4ActionPerformed

    private void btnPlatillo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlatillo5ActionPerformed
        activarPaneles();
        asignarDataPlatillo(4);
    }//GEN-LAST:event_btnPlatillo5ActionPerformed

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
        Platillo platillo = new Platillo();
        platillo.copiar(plat_temp);
        platillo.setIngredientes(ing_agregados);
        int idMenu = menu_temp.getIdMenu();
        platillo.setIdMenu(idMenu);
        
        double precio = platillo.getCostoPlatillo();
        for(Ingrediente ing: platillo.getIngredientes()){
            precio += ing.getCostoIngrediente();
        }
        platillo.setCostoPlatillo(precio);
        orden_temp.agregarPlatillo(platillo);
        llenarTablaPlatillos();
    }//GEN-LAST:event_btnAgregarPActionPerformed

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
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnPlatillo1;
    private javax.swing.JButton btnPlatillo2;
    private javax.swing.JButton btnPlatillo3;
    private javax.swing.JButton btnPlatillo4;
    private javax.swing.JButton btnPlatillo5;
    private javax.swing.JButton btnRes1;
    private javax.swing.JButton btnRes2;
    private javax.swing.JButton btnRes3;
    private javax.swing.JButton btnRes4;
    private javax.swing.JButton btnRes5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombreP;
    private javax.swing.JLabel lbl_ingAgregados;
    private javax.swing.JLabel lbl_ingDisponibles;
    private javax.swing.JPanel pnlDescripcion;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlOrden;
    private javax.swing.JPanel pnlPlatillo;
    private javax.swing.JPanel pnlRestaurantes;
    private javax.swing.JTable tablaIngredientesAgregados;
    private javax.swing.JTable tablaIngredientesDisp;
    private javax.swing.JTable tablaPlatillos;
    // End of variables declaration//GEN-END:variables
}
