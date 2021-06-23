package Restaurante;

import datos.RestauranteDAO;
import domain.Restaurante;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.ImageIcon;

public class Login extends javax.swing.JFrame {
    public static int ancho_pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int alto_pantalla = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public Login() {
        initComponents();        
        ajustarApariencia();
    }
    public void ajustarApariencia(){        
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.decode("#ACDED5"));
        this.setTitle("Iniciar sesión");
        this.setIconImage(new ImageIcon(getClass().getResource("/logo.jpg")).getImage());
    }
    private int comprobarCredenciales(String user, String password) {
        // Obtetiendo los datos del usuario
        Restaurante restaurante = new Restaurante();
        restaurante.setCorreo(user);
        RestauranteDAO rest_management = new RestauranteDAO();
                
        try {
            rest_management.select(restaurante);
            if(restaurante.getCorreo().equals(user)){
                if(restaurante.getContrasena().equals(password)){
                    return 0; // Usuario y contraseñas correcetas
                } else{
                    return -1; // Contraseña incorrecta 
                }
            }
            else{
                return -2; // Usuario incorrecto
            }
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
            return -3;
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Error = new javax.swing.JDialog();
        message = new javax.swing.JLabel();
        lbl_bienvenido = new javax.swing.JLabel();
        text_user = new javax.swing.JTextField();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contrasena = new javax.swing.JLabel();
        text_pass = new javax.swing.JPasswordField();
        Aceptar = new javax.swing.JButton();
        Registrarse = new javax.swing.JButton();
        lblAdminImg = new javax.swing.JLabel();

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
        lbl_bienvenido.setText("Bienvenido");

        text_user.setBackground(new java.awt.Color(204, 255, 255));
        text_user.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        text_user.setForeground(new java.awt.Color(0, 102, 153));
        text_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(172, 222, 213)));
        text_user.setNextFocusableComponent(text_pass);
        text_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_userActionPerformed(evt);
            }
        });

        lbl_usuario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(0, 153, 153));
        lbl_usuario.setText("Usuario:");

        lbl_contrasena.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbl_contrasena.setForeground(new java.awt.Color(0, 153, 153));
        lbl_contrasena.setText("Contraseña:");

        text_pass.setBackground(new java.awt.Color(204, 255, 255));
        text_pass.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        text_pass.setForeground(new java.awt.Color(0, 102, 153));
        text_pass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(172, 222, 213)));
        text_pass.setNextFocusableComponent(Aceptar);
        text_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_passActionPerformed(evt);
            }
        });

        Aceptar.setBackground(new java.awt.Color(153, 255, 255));
        Aceptar.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(0, 102, 153));
        Aceptar.setText("Ingresar");
        Aceptar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Registrarse.setBackground(new java.awt.Color(153, 255, 255));
        Registrarse.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Registrarse.setForeground(new java.awt.Color(0, 102, 153));
        Registrarse.setText("Registrarse");
        Registrarse.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Registrarse.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });

        lblAdminImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lbl_usuario))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbl_contrasena)
                            .addGap(118, 118, 118))
                        .addComponent(text_pass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(text_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Aceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Registrarse, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblAdminImg, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_bienvenido))))
                .addContainerGap(540, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(lbl_bienvenido)
                .addGap(18, 18, 18)
                .addComponent(lblAdminImg, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lbl_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbl_contrasena)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Aceptar)
                .addGap(18, 18, 18)
                .addComponent(Registrarse)
                .addGap(149, 149, 149))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_userActionPerformed

    }//GEN-LAST:event_text_userActionPerformed

    private void text_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_passActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        String user = text_user.getText();
        
        char[] pass = text_pass.getPassword();
        String password = String.valueOf(pass);
        int resComprobacion = comprobarCredenciales(user, password);
        switch (resComprobacion) {
            case 0:
                // Contraseña correcta
                MenuAdministrador menuAdmin= new MenuAdministrador(user);
                menuAdmin.setVisible(true);
                this.setVisible(false);
                this.dispose();
                break;
            case -1:
                // En caso de que sea incorrecta
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho_pantalla/2 - 160, alto_pantalla/2 - 45);
                message.setText("Contraseña incorrecta");
                break;
            case -2:
                // En caso de que no encuentre el usuario
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho_pantalla/2 - 160, alto_pantalla/2 - 45);
                message.setText("Usuario no encontrado");
                break;
            default:
                // Error en sql
                Error.setVisible(true);
                Error.setSize(310, 90);
                Error.setLocation(ancho_pantalla/2 - 160, alto_pantalla/2 - 45);
                message.setText("Oh no, algo ha salido mal ):");
                break;
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed
        DatosRegistro dataReg = new DatosRegistro();
        dataReg.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_RegistrarseActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JDialog Error;
    private javax.swing.JButton Registrarse;
    private javax.swing.JLabel lblAdminImg;
    private javax.swing.JLabel lbl_bienvenido;
    private javax.swing.JLabel lbl_contrasena;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JLabel message;
    private javax.swing.JPasswordField text_pass;
    private javax.swing.JTextField text_user;
    // End of variables declaration//GEN-END:variables

}
