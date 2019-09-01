package vista;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Entidades;
import modelo.MostrarCliente;
import modelo.Persona;
import modelo.ReporteCliente;

public final class Cliente extends javax.swing.JFrame {
    private final Entidades modelo = new Entidades();
    private DefaultTableModel tablemodel;
    private int fila = -1;
    Persona especial = new Persona();
    ReporteCliente iCliente = new ReporteCliente();
        
    
    public Cliente() {
        super("ADMINISTRACIÓN DE CLIENTES");
        initComponents();
        mostrarDatosCliente();
        bloquearCliente();
        nuevoCliente();
    }

    public void mostrarDatosCliente() {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Cédula");
        tablemodel.addColumn("Nombre");
        tablemodel.addColumn("Apellidos");
        tablemodel.addColumn("Sexo");
        tablemodel.addColumn("Teléfono");
        tablemodel.addColumn("Dirección");
        tablemodel.addColumn("E-mail");
        tablemodel.addColumn("País");
        tablaCliente.setModel(tablemodel);
        
        MostrarCliente cliente = new MostrarCliente();
        cliente.mostrarTablaCliente(tablemodel);
    }
   
    public void bloquearCliente() {
        txtNombreCliente.setEnabled(false);
        txtApellidos.setEnabled(false);
        cmbListaSexos.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtMail.setEnabled(false);
        txtPais.setEnabled(false);
        btnActualizarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
        btnRegistrarCliente.setEnabled(false);
    }
    
    public void desbloquearCliente() {
        txtNombreCliente.setEnabled(true);
        txtApellidos.setEnabled(true);
        cmbListaSexos.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtMail.setEnabled(true);
        txtPais.setEnabled(true);
        btnRegistrarCliente.setEnabled(true);
    }
    
    private void nuevoCliente() {
        txtCodigoCliente.setText("");
        txtNombreCliente.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtMail.setText("");
        txtPais.setText("");
    }
    public String getNombreCliente() {
        String nombreCliente = txtNombreCliente.getText();
        especial.setNombre(nombreCliente);
        String suNombre = especial.getNombre();
        return suNombre;
    }
    public String getApellidosCliente() {
        String apellidos = txtApellidos.getText();
        especial.setApellidos(apellidos);
        String suApellido = especial.getApellidos();
        return suApellido;
    }
    public String getGeneroCliente() {
        String sexos[] = new String[3];
        boolean verifica;
        verifica = cmbListaSexos.getSelectedIndex()==0;
        sexos[0] = (String)cmbListaSexos.getSelectedItem();
        cmbListaSexos.setSelectedItem(0);
        especial.setSexo(sexos[0]);
        String susexo = especial.getSexo();
        return susexo;
    }
    public String getTelefonoCliente() {
        String phone = txtTelefono.getText();
        especial.setTelefono(phone);
        String suPhone = especial.getTelefono();
        return suPhone;
    }
    public String getDireccionCliente() {
        String direccion = txtDireccion.getText();
        especial.setDireccion(direccion);
        String suDireccion = especial.getDireccion();
        return suDireccion;
    }
    public String getEmailCliente() {
        String email = txtMail.getText();
        especial.setEmail(email);
        String suEmail = especial.getEmail();
        return suEmail;
    }
    public String getPaisCliente() {
        String pais = txtPais.getText();
        return pais;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbListaSexos = new javax.swing.JComboBox();
        btnSalir = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        btnRegistrarCliente = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnpdf = new javax.swing.JMenuItem();
        mnword = new javax.swing.JMenuItem();
        mnexcel = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel1.setText("Registro de Nuevo Cliente");

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel2.setText("Código Cliente");

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel4.setText("Apellidos");

        jLabel6.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel6.setText("Teléfono");

        jLabel7.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel7.setText("Dirección");

        jLabel8.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel8.setText("e-mail");

        jLabel9.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel9.setText("País");

        txtCodigoCliente.setEditable(false);
        txtCodigoCliente.setBackground(new java.awt.Color(199, 199, 226));
        txtCodigoCliente.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        txtNombreCliente.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtNombreCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteKeyTyped(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        txtTelefono.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        txtDireccion.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        txtMail.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        txtPais.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtPais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaisKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel10.setText("Sexo");

        cmbListaSexos.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        cmbListaSexos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar:", "M", "F" }));

        btnSalir.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevoCliente.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(312, 312, 312)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel9)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel10))))
                                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(cmbListaSexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir)
                    .addComponent(jLabel1))
                .addGap(9, 9, 9)
                .addComponent(btnNuevoCliente)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(cmbListaSexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        tablaCliente.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCliente);

        btnRegistrarCliente.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnRegistrarCliente.setText("Registrar");
        btnRegistrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClienteActionPerformed(evt);
            }
        });

        btnActualizarCliente.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnActualizarCliente.setText("Actualizar");
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jMenu1.setText("Reporte");

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

        mnexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/page_white_excel.png"))); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnRegistrarCliente)
                        .addGap(95, 95, 95)
                        .addComponent(btnActualizarCliente)
                        .addGap(107, 107, 107)
                        .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCliente)
                    .addComponent(btnActualizarCliente)
                    .addComponent(btnEliminarCliente)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClienteActionPerformed
        
        if(txtNombreCliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar nombre del cliente");
            txtNombreCliente.requestFocus();
            return;
        }
        if(txtApellidos.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar apellidos del cliente");
            txtApellidos.requestFocus();
            return;
        }
        if(txtTelefono.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar teléfono del cliente");
            txtTelefono.requestFocus();
            return;
        }
        if(txtDireccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar dirección del cliente");
            txtDireccion.requestFocus();
            return;
        }
        if(txtMail.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar e-mail del cliente");
            txtMail.requestFocus();
            return;
        }
        if(txtPais.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar nacionalidad del cliente");
            txtPais.requestFocus();
            return;
        }
        modelo.agregarCliente(getNombreCliente(), getApellidosCliente(), getGeneroCliente(), getTelefonoCliente(),
                getDireccionCliente(), getEmailCliente(), getPaisCliente());
        mostrarDatosCliente();
        nuevoCliente();
        bloquearCliente();
    }//GEN-LAST:event_btnRegistrarClienteActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        if(fila>-1) { //inicia if
        
        int codigo = Integer.valueOf(tablaCliente.getValueAt(fila, 0).toString());
        modelo.actualizarCliente(codigo, getNombreCliente(), getApellidosCliente(),getGeneroCliente(),
                getTelefonoCliente(), getDireccionCliente(), getEmailCliente(), getPaisCliente());
        mostrarDatosCliente();
        nuevoCliente();
        bloquearCliente();
        } //termina if
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        //ELIMINAR EL CLIENTE  QUE YA NO COMPRA
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar Cliente?","Pregunta",0);
        if(respuesta==0) { //inicio if respuesta
        if(fila>-1) { //inicia if 
            int codigo = Integer.valueOf(tablaCliente.getValueAt(fila, 0).toString());
            modelo.eliminarCliente(codigo);
            mostrarDatosCliente();
            nuevoCliente();
            bloquearCliente();
            fila = -1;
        } //termina if
        } //termina if respuesta
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        desbloquearCliente();
        nuevoCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        mostrarDatosCliente();
        nuevoCliente();
    }//GEN-LAST:event_formWindowOpened

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        // escucha al dar clic sobre la tabla
        desbloquearCliente();
        btnRegistrarCliente.setEnabled(false); 
        btnActualizarCliente.setEnabled(true);
        btnEliminarCliente.setEnabled(true);
        fila = tablaCliente.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            txtCodigoCliente.setText(String.valueOf(tablaCliente.getValueAt(fila, 0)));
            txtNombreCliente.setText(String.valueOf(tablaCliente.getValueAt(fila, 1)));
            txtApellidos.setText(String.valueOf(tablaCliente.getValueAt(fila, 2)));
            txtTelefono.setText(String.valueOf(tablaCliente.getValueAt(fila, 4)));
            txtDireccion.setText(String.valueOf(tablaCliente.getValueAt(fila, 5)));
            txtMail.setText(String.valueOf(tablaCliente.getValueAt(fila, 6)));
            txtPais.setText(String.valueOf(tablaCliente.getValueAt(fila, 7)));
        }
    }//GEN-LAST:event_tablaClienteMouseClicked

    private void txtNombreClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)){
                evt.consume();
        }
    }//GEN-LAST:event_txtNombreClienteKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char car = evt.getKeyChar();
        if(txtTelefono.getText().length()>=12) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtPaisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaisKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
            }
    }//GEN-LAST:event_txtPaisKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        nuevoCliente();
        bloquearCliente();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        nuevoCliente();
        bloquearCliente();
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void mnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnpdfActionPerformed
        iCliente.formatoPDF();
    }//GEN-LAST:event_mnpdfActionPerformed

    private void mnwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnwordActionPerformed
        iCliente.formatoWord();
    }//GEN-LAST:event_mnwordActionPerformed

    private void mnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnexcelActionPerformed
        iCliente.formatoExcel();
    }//GEN-LAST:event_mnexcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCliente;
    public javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnRegistrarCliente;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox cmbListaSexos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem mnexcel;
    private javax.swing.JMenuItem mnpdf;
    private javax.swing.JMenuItem mnword;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JTextField txtApellidos;
    public javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
