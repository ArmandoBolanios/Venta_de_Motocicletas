package vista;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CrearUsuarios;

public final class AdministracionUsuarios extends javax.swing.JFrame {

    private final CrearUsuarios usuario = new CrearUsuarios();
    private DefaultTableModel tablemodel;
    private int fila = -1;
    
    public AdministracionUsuarios() {
        super("ADMINISTRACIÓN DE USUARIOS");
        initComponents();
        mostrarDatosUser();
    }

    public void mostrarDatosUser() {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Cédula");
        tablemodel.addColumn("Nombre");
        tablemodel.addColumn("Contraseña");
        tablemodel.addColumn("Tipo usuario");
        tablaUsuarios.setModel(tablemodel);
        
        CrearUsuarios nuevousuario = new CrearUsuarios();
        nuevousuario.mostrarUsers(tablemodel);
    }
    
    public void nuevoUsuario(){
        txtNombreUsuario.setText("");
        txtTipoUsuario.setText("");
        txtContraseña.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtTipoUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnEliminarUsuario = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnNuevoUsuario = new javax.swing.JMenuItem();
        mnModificar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre Usuario");

        jLabel2.setText("Contraseña");

        jLabel3.setText("Tipo usuario");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setText("Nuevos Usuarios");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jMenu1.setText("Menú");

        mnNuevoUsuario.setText("Nuevo");
        mnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNuevoUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(mnNuevoUsuario);

        mnModificar.setText("Modificar");
        mnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnModificarActionPerformed(evt);
            }
        });
        jMenu1.add(mnModificar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnAgregar)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnEliminarUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminarUsuario)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String nombre = this.txtNombreUsuario.getText();
        String contraseña = this.txtContraseña.getText();
        String tipo = this.txtTipoUsuario.getText();
        
        usuario.crearUser(nombre, contraseña, tipo);
        mostrarDatosUser();
        nuevoUsuario();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar Usuario?","Pregunta",0);
        if(respuesta==0) {
            if(fila>-1) {
                int codigo = Integer.valueOf(tablaUsuarios.getValueAt(fila, 0).toString());
                usuario.eliminarUser(codigo); 
                mostrarDatosUser();
            }
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        nuevoUsuario();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUsuariosMouseClicked

        btnAgregar.setEnabled(false);
        
        fila = tablaUsuarios.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            txtNombreUsuario.setText(String.valueOf(tablaUsuarios.getValueAt(fila, 1)));
            txtContraseña.setText(String.valueOf(tablaUsuarios.getValueAt(fila, 2)));
            txtTipoUsuario.setText(String.valueOf(tablaUsuarios.getValueAt(fila, 3)));
        }
        
    }//GEN-LAST:event_tablaUsuariosMouseClicked

    private void mnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNuevoUsuarioActionPerformed
        btnAgregar.setEnabled(true);
        btnEliminarUsuario.setEnabled(false);
        nuevoUsuario();
    }//GEN-LAST:event_mnNuevoUsuarioActionPerformed

    private void mnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnModificarActionPerformed
        if(fila>-1) {
            int num = Integer.valueOf(tablaUsuarios.getValueAt(fila, 0).toString());
            String nombre = this.txtNombreUsuario.getText();
            String contraseña = this.txtContraseña.getText();
 
            usuario.modificarUser(num, nombre, contraseña);
            mostrarDatosUser();
        }
    }//GEN-LAST:event_mnModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminarUsuario;
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnModificar;
    private javax.swing.JMenuItem mnNuevoUsuario;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
