package vista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.DataBase;

public class InicioSistema extends javax.swing.JFrame {

    DataBase basedatos = new DataBase();
    Connection conexion = basedatos.getConexion();
    Principal ingreso = new Principal();
    
    public InicioSistema() {
        initComponents();
        txtNombreUsuario.requestFocus();
    }

    public void acceder(String usuario, String pass) {
        String sql = "SELECT * FROM acceso WHERE nombre = '"+usuario+"' AND password = '"+pass+"'";
        String capt = "";
        try {
        Statement st = conexion.createStatement();
        ResultSet res = st.executeQuery(sql);
        while(res.next()) {
            capt = res.getString("cargo");
        }
        
        if(capt.equals("Gerente")) {
         JOptionPane.showMessageDialog(null, "BIENVENIDO GERENTE * "+usuario+" *"
                 + "\nLO ESTÁBAMOS ESPERANDO");
         ingreso.setVisible(true);
         ingreso.ADMINISTRAR_NUEVOS.setEnabled(true); 
         ingreso.AGREGAR_EMPLEADO.setEnabled(true);
         ingreso.mnCrearUsuarios.setEnabled(true); 
         ingreso.btnNotaPedido.setEnabled(true);
         ingreso.lblTipoUsuario.setText("Acceso Protegido:  "+usuario+" "); 
         ingreso.pack();   
        }
        
        if(capt.equals("Empleado")) {
            JOptionPane.showMessageDialog(null, "BIEN VENID@ EMPLEAD@ *"+usuario+"*"
                 + "\nA TRABAJAR!");
            try {
                String checar = "SELECT id_empleado from empleado WHERE nombre = '"+usuario+"' ";
                String suCodigo = "";
                Statement sta = conexion.createStatement();
                ResultSet result = sta.executeQuery(checar);
                while(result.next()) {
                    suCodigo = result.getString("id_empleado");
                }
                JOptionPane.showMessageDialog(null, "Su código empleado es: "+suCodigo+" ");
                ingreso.lblCodigoEmpleado.setText("Su código es:    "+suCodigo+"  ");
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            ingreso.setVisible(true);
            ingreso.ADMINISTRAR_NUEVOS.setEnabled(false); 
            ingreso.AGREGAR_EMPLEADO.setEnabled(false);
            ingreso.mnCrearUsuarios.setEnabled(false); 
            ingreso.btnNotaPedido.setEnabled(false);
            ingreso.lblTipoUsuario.setText("Acceso :    "+usuario+"");
             
        }
        
        if((!capt.equals("Gerente")) && (!capt.equals("Empleado"))) {
            JOptionPane.showMessageDialog(null, "Usuario/Contraseña incorrectos");
        }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreUsuario = new org.edisoncor.gui.textField.TextField();
        txtPassword = new org.edisoncor.gui.passwordField.PasswordField();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new org.edisoncor.gui.button.ButtonIpod();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.png"))); // NOI18N
        jLabel1.setText("Contraseña");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_business_boss.png"))); // NOI18N
        jLabel2.setText("Usuario");

        txtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreUsuarioActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carta-pluma.jpg"))); // NOI18N

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/computer.jpg"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37))
                        .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String nombre = txtNombreUsuario.getText();
        String clave = new String(txtPassword.getPassword());
        if(txtNombreUsuario.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar algún nombre");
            txtNombreUsuario.requestFocus();
            return;
        }
        if(txtPassword.getPassword().length ==0 ){
            JOptionPane.showMessageDialog(null, "Debe ingresar su contraseña!");
            return;
        }
        acceder(nombre,clave);
        txtNombreUsuario.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreUsuarioActionPerformed
        txtNombreUsuario.requestFocus();
    }//GEN-LAST:event_txtNombreUsuarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Salir del sistema?","Pregunta",0);
        if(respuesta == 0) {
            System.exit(0);
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(InicioSistema.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        String nombre = txtNombreUsuario.getText();
        String clave = new String(txtPassword.getPassword());
        
        acceder(nombre,clave);
        txtNombreUsuario.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_txtPasswordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnIngresar;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.textField.TextField txtNombreUsuario;
    private org.edisoncor.gui.passwordField.PasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
