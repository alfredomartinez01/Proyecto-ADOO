package Turno;

import Restaurante.*;
import datos.ClienteDAO;
import datos.OrdenDAO;
import datos.RestauranteDAO;
import domain.Cliente;
import domain.Imagen;
import domain.Orden;
import domain.Restaurante;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MuestraTurnos extends javax.swing.JFrame {

    public static int ancho_pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int alto_pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    private static OrdenDAO ordenDao = null;
    private static ClienteDAO clienteDao = null;
    private JLabel[] principales = new JLabel[4];
    private JLabel[] secundarios = new JLabel[4];
    public final static ImageIcon admin = new Imagen("admin.png").getImageIcon();

    public MuestraTurnos() {
        initComponents();
        ajustarApariencia();
        limpiarLabels();
        muestraOrdenes();
        timer.start();
    }

    public void ajustarApariencia() {
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.decode("#ACDED5"));
        this.setTitle("Iniciar sesión");
        //this.setIconImage(new ImageIcon(getClass().getResource("/logo.jpg")).getImage());               
    }

    public void limpiarLabels() {
        principales[0] = lbl_principal1;
        principales[1] = lbl_principal2;
        principales[2] = lbl_principal3;
        principales[3] = lbl_principal4;

        secundarios[0] = lbl_principal5;
        secundarios[1] = lbl_principal6;
        secundarios[2] = lbl_principal7;
        secundarios[3] = lbl_principal8;
        for (int i = 0; i < 4; i++) {
            principales[i].setVisible(false);
            secundarios[i].setVisible(false);
        }
    }

    public void muestraOrdenes() {
        limpiarLabels();
        ordenDao = new OrdenDAO();
        clienteDao = new ClienteDAO();
        List<Orden> ordenes = ordenDao.seleccionar_por_estado("lista");
        int i = 0;
        for (Orden orden : ordenes) {
            Cliente cliente = clienteDao.seleccionar_por_orden(orden.getIdOrden());
            if (i < 4) {
                principales[i].setVisible(true);
                principales[i].setText("ID: " + orden.getIdOrden() + ", Hora: " + orden.getHora() + ", Cliente: " + cliente.getNombreCliente() + ", LISTA");
                i++;
            }
        }
        ordenDao = new OrdenDAO();
        clienteDao = new ClienteDAO();
        ordenes = ordenDao.seleccionar_por_estado("preparando");
        i = 0;
        for (Orden orden : ordenes) {

            Cliente cliente = clienteDao.seleccionar_por_orden(orden.getIdOrden());
            if (i < 4) {
                secundarios[i].setVisible(true);
                secundarios[i].setText("ID: " + orden.getIdOrden() + ", Hora: " + orden.getHora() + ", Cliente: " + cliente.getNombreCliente() + ", PREPARÁNDOSE");
                i++;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        lbl_bienvenido = new javax.swing.JLabel();
        lbl_principal1 = new javax.swing.JLabel();
        lbl_principal2 = new javax.swing.JLabel();
        lbl_principal3 = new javax.swing.JLabel();
        lbl_principal4 = new javax.swing.JLabel();
        lbl_principal5 = new javax.swing.JLabel();
        lbl_principal6 = new javax.swing.JLabel();
        lbl_principal7 = new javax.swing.JLabel();
        lbl_principal8 = new javax.swing.JLabel();

        Error.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Error.setAlwaysOnTop(true);
        Error.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Error.setResizable(false);

        message.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        message.setForeground(new java.awt.Color(255, 0, 0));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        message.setText("1");
        message.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout ErrorLayout = new javax.swing.GroupLayout(Error.getContentPane());
        Error.getContentPane().setLayout(ErrorLayout);
        ErrorLayout.setHorizontalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ErrorLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        ErrorLayout.setVerticalGroup(
            ErrorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(message)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        lbl_bienvenido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 36)); // NOI18N
        lbl_bienvenido.setForeground(new java.awt.Color(0, 153, 153));
        lbl_bienvenido.setText("ESPERA TU TURNO");

        lbl_principal1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 32)); // NOI18N
        lbl_principal1.setForeground(new java.awt.Color(0, 51, 102));
        lbl_principal1.setText("<Principal 1>");
        lbl_principal1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_principal2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 32)); // NOI18N
        lbl_principal2.setForeground(new java.awt.Color(0, 51, 102));
        lbl_principal2.setText("<Principal 2>");
        lbl_principal2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_principal3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 32)); // NOI18N
        lbl_principal3.setForeground(new java.awt.Color(0, 51, 102));
        lbl_principal3.setText("<Principal 3>");
        lbl_principal3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_principal4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_principal4.setForeground(new java.awt.Color(0, 51, 153));
        lbl_principal4.setText("<Secundario 1>");
        lbl_principal4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_principal5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_principal5.setForeground(new java.awt.Color(0, 51, 153));
        lbl_principal5.setText("<Secundario  2>");
        lbl_principal5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_principal6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_principal6.setForeground(new java.awt.Color(0, 51, 153));
        lbl_principal6.setText("<Secundario 4>");
        lbl_principal6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_principal7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbl_principal7.setForeground(new java.awt.Color(0, 51, 153));
        lbl_principal7.setText("<Secundario  3>");
        lbl_principal7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lbl_principal8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 32)); // NOI18N
        lbl_principal8.setForeground(new java.awt.Color(0, 51, 102));
        lbl_principal8.setText("<Principal 4>");
        lbl_principal8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_bienvenido)
                        .addGap(499, 499, 499))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_principal4, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_principal5, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_principal6, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_principal7, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_principal3, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_principal8, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_principal2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_principal1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(258, 258, 258))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lbl_bienvenido)
                .addGap(62, 62, 62)
                .addComponent(lbl_principal1)
                .addGap(18, 18, 18)
                .addComponent(lbl_principal2)
                .addGap(18, 18, 18)
                .addComponent(lbl_principal3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_principal8)
                .addGap(24, 24, 24)
                .addComponent(lbl_principal4)
                .addGap(32, 32, 32)
                .addComponent(lbl_principal5)
                .addGap(30, 30, 30)
                .addComponent(lbl_principal7)
                .addGap(27, 27, 27)
                .addComponent(lbl_principal6)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Timer timer = new Timer(100, new ActionListener() { // Encargado de actualizar la hora
        public void actionPerformed(ActionEvent e) {
            muestraOrdenes();
        }
    });

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuestraTurnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Error;
    private javax.swing.JLabel lbl_bienvenido;
    private javax.swing.JLabel lbl_principal1;
    private javax.swing.JLabel lbl_principal2;
    private javax.swing.JLabel lbl_principal3;
    private javax.swing.JLabel lbl_principal4;
    private javax.swing.JLabel lbl_principal5;
    private javax.swing.JLabel lbl_principal6;
    private javax.swing.JLabel lbl_principal7;
    private javax.swing.JLabel lbl_principal8;
    private javax.swing.JLabel message;
    // End of variables declaration//GEN-END:variables

}
