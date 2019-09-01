package vista;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Entidades;
import modelo.EspecialProveedor;
import modelo.MostrarProveedor;
import modelo.ReporteProveedores;


public final class Proveedor extends javax.swing.JFrame {
    private DefaultTableModel dtm;
    private final Entidades model = new Entidades();
    int fila = -1;
    EspecialProveedor especial = new EspecialProveedor();
    ReporteProveedores iProveedor = new ReporteProveedores();
    
    
    public Proveedor() {
        super("ADMINISTRACIÓN DE PROVEEDORES");
        initComponents();
        mostrarDatosProveedor();
        bloquearProveedor();
        nuevoProveedor();
        
    }

    public void mostrarDatosProveedor() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Código Proveedor");
        dtm.addColumn("Nombre");
        dtm.addColumn("Tetéfono");
        dtm.addColumn("Dirección");
        dtm.addColumn("e-Mail");
        tablaProveedores.setModel(dtm);
        
        MostrarProveedor mprov = new MostrarProveedor();
        mprov.mostrarProveedor(dtm);
    }
    
    public void bloquearProveedor() {
        txtNombreProveedor.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtEmail.setEnabled(false);
        btnAgregarProveedor.setEnabled(false);
        btnActualizarProveedor.setEnabled(false);
        btnEliminarProveedor.setEnabled(false);
        btnCancelarProveedor.setEnabled(false);
    }
    
    public void desbloquearProveedor() {
        txtNombreProveedor.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtEmail.setEnabled(true);
        btnAgregarProveedor.setEnabled(true);
        
        btnCancelarProveedor.setEnabled(true);
    }
    
    public void nuevoProveedor() {
        txtCodigoProveedor.setText("");
        txtNombreProveedor.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        
    }
    
    public String getNombreProveedor() {
        String nombre = txtNombreProveedor.getText();
        especial.setNombre(nombre);
        String suNombre = especial.getNombre();
        return suNombre;
    }
    public String getTelefono() {
        String phone = txtTelefono.getText();
        especial.setPhone(phone);
        String suPhone = especial.getPhone();
        return suPhone;
    }
    public String getDireccion() {
        String direccion = txtDireccion.getText();
        especial.setDireccion(direccion);
        String suDireccion = especial.getDireccion();
        return suDireccion;
    }
    public String getEmail() {
        String email = txtEmail.getText();
        especial.setEmail(email);
        String suEmail = especial.getEmail();
        return suEmail;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoProveedor = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        btnNuevoProveedor = new javax.swing.JButton();
        btnAgregarProveedor = new javax.swing.JButton();
        btnActualizarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedores = new javax.swing.JTable();
        btnCancelarProveedor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnpdf = new javax.swing.JMenuItem();
        mnword = new javax.swing.JMenuItem();
        mnexcel = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(191, 246, 191));

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel1.setText("Registro de nuevo proveedor");

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel2.setText("Código proveedor");

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel3.setText("Nombre o razón social");

        jLabel4.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel4.setText("Teléfono");

        jLabel5.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel5.setText("Dirección");

        txtCodigoProveedor.setEditable(false);
        txtCodigoProveedor.setBackground(new java.awt.Color(204, 204, 255));
        txtCodigoProveedor.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtCodigoProveedor.setForeground(new java.awt.Color(0, 153, 255));
        txtCodigoProveedor.setText("  ");
        txtCodigoProveedor.setCaretColor(new java.awt.Color(0, 204, 204));

        txtDireccion.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel6.setText("e-mail");

        txtEmail.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        txtNombreProveedor.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevoProveedor.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnNuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        btnNuevoProveedor.setText("Nuevo");
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(318, 318, 318)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalir)))
                .addGap(25, 25, 25)
                .addComponent(btnNuevoProveedor)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        btnAgregarProveedor.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnAgregarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnAgregarProveedor.setText("Agregar");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        btnActualizarProveedor.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnActualizarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnActualizarProveedor.setText("Actualizar");
        btnActualizarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        tablaProveedores.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        tablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProveedores);

        btnCancelarProveedor.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnCancelarProveedor.setText("Cancelar");
        btnCancelarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarProveedorActionPerformed(evt);
            }
        });

        jMenu1.setText("Reportes");

        mnpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/doc_pdf.png"))); // NOI18N
        mnpdf.setText("PDF");
        mnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnpdfActionPerformed(evt);
            }
        });
        jMenu1.add(mnpdf);

        mnword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/page_white_word.png"))); // NOI18N
        mnword.setText("WORD");
        mnword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnwordActionPerformed(evt);
            }
        });
        jMenu1.add(mnword);

        mnexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/doc_excel_csv.png"))); // NOI18N
        mnexcel.setText("EXCEL");
        mnexcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnexcelActionPerformed(evt);
            }
        });
        jMenu1.add(mnexcel);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarProveedor)
                        .addGap(183, 183, 183)
                        .addComponent(btnActualizarProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarProveedor)
                        .addGap(185, 185, 185)
                        .addComponent(btnCancelarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProveedor)
                    .addComponent(btnActualizarProveedor)
                    .addComponent(btnEliminarProveedor)
                    .addComponent(btnCancelarProveedor))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
               
        if(txtNombreProveedor.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar nombre del proveedor");
            txtNombreProveedor.requestFocus();
            return;
        }
        if(txtTelefono.getText().length() == 0) {
          JOptionPane.showMessageDialog(rootPane, "Debe ingresar número de teléfono");
          txtTelefono.requestFocus();
          return;
        }
        if(txtDireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar dirección del proveedor");
            txtDireccion.requestFocus();
            return;
        }
        if(txtEmail.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar e-mail");
            txtEmail.requestFocus();
            return;
        }
        
        model.agregarProveedor(getNombreProveedor(), getTelefono(), getDireccion(), getEmail());
        mostrarDatosProveedor();
        nuevoProveedor();       
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void btnActualizarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProveedorActionPerformed
        // TODO add your handling code here:
        desbloquearProveedor();
        
        int id = Integer.valueOf(tablaProveedores.getValueAt(fila, 0).toString());
        //mandar a llamar para actualizar
        model.actualizarProveedor(id, getNombreProveedor(), getTelefono(), getDireccion(),
                getEmail());
        mostrarDatosProveedor();
        nuevoProveedor();
    }//GEN-LAST:event_btnActualizarProveedorActionPerformed

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        // TODO add your handling code here:
        desbloquearProveedor();
        nuevoProveedor();
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        // TODO add your handling code here:
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar Proveedor?","Pregunta",0);
        if(respuesta==0) {
            if(fila>-1) {
                int idProveedor = Integer.valueOf(tablaProveedores.getValueAt(fila, 0).toString());
                model.eliminarProveedor(idProveedor);
                
                mostrarDatosProveedor();
                nuevoProveedor();
                fila = -1;
            } 
        }
        
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void tablaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProveedoresMouseClicked
        desbloquearProveedor();
        btnAgregarProveedor.setEnabled(false); 
        btnActualizarProveedor.setEnabled(true);
        btnEliminarProveedor.setEnabled(true);
        fila = tablaProveedores.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            txtCodigoProveedor.setText(String.valueOf(tablaProveedores.getValueAt(fila, 0)));
            txtNombreProveedor.setText(String.valueOf(tablaProveedores.getValueAt(fila, 1)));
            txtTelefono.setText(String.valueOf(tablaProveedores.getValueAt(fila, 2)));
            txtDireccion.setText(String.valueOf(tablaProveedores.getValueAt(fila, 3)));
            txtEmail.setText(String.valueOf(tablaProveedores.getValueAt(fila, 4)));
            
        }
    }//GEN-LAST:event_tablaProveedoresMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // 
        mostrarDatosProveedor();
        nuevoProveedor();
    }//GEN-LAST:event_formWindowOpened

    private void btnCancelarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarProveedorActionPerformed
        nuevoProveedor();
        btnActualizarProveedor.setEnabled(false);
        btnEliminarProveedor.setEnabled(false);
    }//GEN-LAST:event_btnCancelarProveedorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        nuevoProveedor();
        bloquearProveedor();
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
            }
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(txtTelefono.getText().length()>=12) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
            }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void mnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnpdfActionPerformed
        iProveedor.formatoPDF();
    }//GEN-LAST:event_mnpdfActionPerformed

    private void mnwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnwordActionPerformed
        iProveedor.formatoWORD();
    }//GEN-LAST:event_mnwordActionPerformed

    private void mnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnexcelActionPerformed
        iProveedor.formatoEXCEL();
    }//GEN-LAST:event_mnexcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarProveedor;
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnCancelarProveedor;
    public javax.swing.JButton btnEliminarProveedor;
    public javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnexcel;
    private javax.swing.JMenuItem mnpdf;
    private javax.swing.JMenuItem mnword;
    public javax.swing.JTable tablaProveedores;
    public javax.swing.JTextField txtCodigoProveedor;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
