package vista;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Entidades;
import modelo.Persona;
import modelo.MostrarEmpleado;
import modelo.ReporteEmpleado;


public final class Empleado extends javax.swing.JFrame {

    private final Entidades model = new Entidades();
    private DefaultTableModel dtm;
    private final Persona people = new Persona();
    private int fila = -1;
    ReporteEmpleado iEmple = new ReporteEmpleado();
    
    
    public Empleado() {
        super("ADMINISTRACIÓN DE EMPLEADOS");
        initComponents();
        mostrarDatosEmpleado();
        bloquearEmpleado();
        nuevoEmpleado();
    }
    
    public void mostrarDatosEmpleado() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Código Empleado");
        dtm.addColumn("Nombre");
        dtm.addColumn("Apellidos");
        dtm.addColumn("Sexo");
        dtm.addColumn("Teléfono");
        dtm.addColumn("Dirección");
        dtm.addColumn("E-mail");
        dtm.addColumn("Fecha Ingreso");
        dtm.addColumn("Salario");
        dtm.addColumn("Motos Vendidas");
        tablaEmpleado.setModel(dtm);
        
        MostrarEmpleado re = new MostrarEmpleado();
        re.mostrarEmpleado(dtm);
    }
    
    private void bloquearEmpleado() {
        txtNombreEmpleado.setEnabled(false); 
        txtApellidos.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtMail.setEnabled(false);
        txtFechaIngreso.setEnabled(false); 
        txtSalario.setEnabled(false);
        txtUnidadesVendidas.setEnabled(false);
        cmbListaSexos.setEnabled(false);
        btnActualizarEmpleado.setEnabled(false);
        btnEliminarEmpleado.setEnabled(false);
        
    }
    
    private void desbloquearEmpleado() {
        txtNombreEmpleado.setEnabled(true); 
        txtApellidos.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtMail.setEnabled(true);
        txtFechaIngreso.setEnabled(true); 
        txtSalario.setEnabled(true);
        txtUnidadesVendidas.setEnabled(true);
        cmbListaSexos.setEnabled(true); 
    }
    
    private void nuevoEmpleado() {
        txtCodigoEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtApellidos.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtMail.setText("");
        txtFechaIngreso.setText("");
        txtSalario.setText("");
        txtUnidadesVendidas.setText("");
    }
    
    public String getFecha() {
         String fecha = txtFechaIngreso.getText();
         return fecha;
    }
   
    public String  getNombre(){
        String nombre = txtNombreEmpleado.getText();
        people.setNombre(nombre);
        String sunombre = people.getNombre();
        return sunombre;
    }
        //----------------------------------------
    public String getApellidos() {
        String apellidos = txtApellidos.getText();
        people.setApellidos(apellidos);
        String suapellido = people.getApellidos();
        return suapellido;
    }
        //---------------------------------------
    public String getPhone() {
        String telefono = txtTelefono.getText();
        people.setTelefono(telefono);
        String sutelefono = people.getTelefono();
        return sutelefono;
    }
        //---------------------------------------
    public String getSexos() {
        String sexos[] = new String[3];
        boolean verifica;
        verifica = cmbListaSexos.getSelectedIndex()==0;
        sexos[0] = (String)cmbListaSexos.getSelectedItem();
        cmbListaSexos.setSelectedItem(0);
        people.setSexo(sexos[0]);
        String susexo = people.getSexo();
        return susexo;
    }
    
    public String getDireccion() {
        String direccion = txtDireccion.getText();
        people.setDireccion(direccion);
        String sudireccion = people.getDireccion();
    
    return sudireccion;
    }
        //----------------------------------------
    public String getEmail() {
        String email = txtMail.getText();
        people.setEmail(email);
        String suemail = people.getEmail();
    return suemail;
    }
        //---------------------------------------------}
    public double getSalario() {
        double salarioEmpleado;
        
        double salario = Double.parseDouble(txtSalario.getText());
        NumberFormat deci = new DecimalFormat("#0.00");
        salarioEmpleado = Double.parseDouble(deci.format(salario));
        
        return salarioEmpleado;
        }
    
    public int getMotosVendidas() {
        int cantidadmoto = Integer.parseInt(txtUnidadesVendidas.getText());
        return cantidadmoto;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoEmpleado = new javax.swing.JTextField();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbListaSexos = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtUnidadesVendidas = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JFormattedTextField();
        txtSalario = new javax.swing.JTextField();
        btnSalirEmpleado = new javax.swing.JButton();
        btnNuevoEmpleado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleado = new javax.swing.JTable();
        btnRegistrarEmpleado = new javax.swing.JButton();
        btnActualizarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnCancelarEmpleado = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel1.setText("Registro de nuevo empleado");

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel2.setText("Código empleado");

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
        jLabel9.setText("Fecha Ingreso");

        txtCodigoEmpleado.setEditable(false);
        txtCodigoEmpleado.setBackground(new java.awt.Color(233, 231, 231));
        txtCodigoEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        txtNombreEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtNombreEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreEmpleadoKeyTyped(evt);
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

        jLabel10.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel10.setText("Sexo");

        cmbListaSexos.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        cmbListaSexos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar:", "M", "F" }));

        jLabel5.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel5.setText("Salario");

        jLabel11.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel11.setText("Unidades vendidas");

        txtUnidadesVendidas.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtUnidadesVendidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnidadesVendidasKeyTyped(evt);
            }
        });

        jLabel12.setText("AAAA/MM/DD");

        try {
            txtFechaIngreso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIngresoActionPerformed(evt);
            }
        });

        txtSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalarioKeyTyped(evt);
            }
        });

        btnSalirEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnSalirEmpleado.setText("Salir");
        btnSalirEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirEmpleadoActionPerformed(evt);
            }
        });

        btnNuevoEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnNuevoEmpleado.setText("Nuevo");
        btnNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpleadoActionPerformed(evt);
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirEmpleado)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel9))
                                        .addGap(43, 43, 43)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                                .addComponent(txtNombreEmpleado)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel8)))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbListaSexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUnidadesVendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSalirEmpleado))
                .addGap(16, 16, 16)
                .addComponent(btnNuevoEmpleado)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbListaSexos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidadesVendidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, Short.MAX_VALUE))
        );

        tablaEmpleado.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tablaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaEmpleado.setGridColor(new java.awt.Color(102, 102, 255));
        tablaEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEmpleado);

        btnRegistrarEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnRegistrarEmpleado.setText("Registrar");
        btnRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpleadoActionPerformed(evt);
            }
        });

        btnActualizarEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnActualizarEmpleado.setText("Actualizar");
        btnActualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });

        btnCancelarEmpleado.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        btnCancelarEmpleado.setText("Cancelar");
        btnCancelarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarEmpleadoActionPerformed(evt);
            }
        });

        jMenu1.setText("Reportes");

        mnpdf.setText("PDF");
        mnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnpdfActionPerformed(evt);
            }
        });
        jMenu1.add(mnpdf);

        mnword.setText("WORD");
        mnword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnwordActionPerformed(evt);
            }
        });
        jMenu1.add(mnword);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnRegistrarEmpleado)
                        .addGap(170, 170, 170)
                        .addComponent(btnActualizarEmpleado)
                        .addGap(253, 253, 253)
                        .addComponent(btnEliminarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarEmpleado)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarEmpleado)
                    .addComponent(btnActualizarEmpleado)
                    .addComponent(btnEliminarEmpleado)
                    .addComponent(btnCancelarEmpleado))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoActionPerformed
        if(txtNombreEmpleado.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el nombre del empleado");
            txtNombreEmpleado.requestFocus();
            return;
        }
        if(txtApellidos.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta los apellidos del empleado");
            txtApellidos.requestFocus();
            return;
        }
        if(txtTelefono.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el número de teléfono");
            txtTelefono.requestFocus();
            return;
        }
        if(txtDireccion.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta la dirección del\nempleado");
            txtDireccion.requestFocus();
            return;
        }
        if(txtMail.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el \ne-mail del empleado");
            txtMail.requestFocus();
            return;
        }
        if(txtFechaIngreso.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta la fecha de ingreso");
            txtFechaIngreso.requestFocus();
            return;
        }
        if(txtSalario.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el salario \ndel empleado");
            txtSalario.requestFocus();
            return;
        }
        if(txtUnidadesVendidas.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Las unidades vendidas tienen que"
                    + "\nser 0");
            return;
        }
        model.agregarEmpleado(getNombre(), getApellidos(), getSexos(), getPhone(), getDireccion(), 
                getEmail(), getSalario(), getMotosVendidas(), getFecha());
        
        mostrarDatosEmpleado();
        nuevoEmpleado();
    }//GEN-LAST:event_btnRegistrarEmpleadoActionPerformed

    private void btnActualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEmpleadoActionPerformed
        //
        int id = Integer.valueOf(tablaEmpleado.getValueAt(fila, 0).toString());
            
        model.actualizarEmpleado(id, getNombre(), getApellidos(), getSexos(), getPhone(), 
                getDireccion(), getEmail(), getSalario(), getMotosVendidas(), getFecha());
        
        mostrarDatosEmpleado();
        nuevoEmpleado();
    }//GEN-LAST:event_btnActualizarEmpleadoActionPerformed

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        // 
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar Empleado?","Pregunta",0);
        if(respuesta==0) {
            if(fila>-1) {
                int id_empleado = Integer.valueOf(tablaEmpleado.getValueAt(fila, 0).toString());
                model.eliminarEmpleado(id_empleado);
                mostrarDatosEmpleado();
                nuevoEmpleado();
                fila = -1;
            }
        }
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
        //
        desbloquearEmpleado();
        nuevoEmpleado();
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    private void tablaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadoMouseClicked
        // TODO add your handling code here:
        desbloquearEmpleado(); 
        txtUnidadesVendidas.setEnabled(false);
        btnRegistrarEmpleado.setEnabled(false);
        btnActualizarEmpleado.setEnabled(true);
        btnEliminarEmpleado.setEnabled(true);
        fila = tablaEmpleado.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            txtCodigoEmpleado.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 0)));
            txtNombreEmpleado.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 1)));
            txtApellidos.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 2)));
            txtTelefono.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 4)));
            txtDireccion.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 5)));
            txtMail.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 6)));
            txtFechaIngreso.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 7)));
            txtSalario.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 8)));        
            txtUnidadesVendidas.setText(String.valueOf(tablaEmpleado.getValueAt(fila, 9)));    
        }
    }//GEN-LAST:event_tablaEmpleadoMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        mostrarDatosEmpleado();
        nuevoEmpleado();
    }//GEN-LAST:event_formWindowOpened

    private void txtNombreEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEmpleadoKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
            }
    }//GEN-LAST:event_txtNombreEmpleadoKeyTyped

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

    private void txtSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSalarioKeyTyped

    private void txtUnidadesVendidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadesVendidasKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(txtUnidadesVendidas.getText().length()>=9) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtUnidadesVendidasKeyTyped

    private void btnSalirEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirEmpleadoActionPerformed
        // TODO add your handling code here:
        nuevoEmpleado();
        bloquearEmpleado();
        dispose();
    }//GEN-LAST:event_btnSalirEmpleadoActionPerformed

    private void btnCancelarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarEmpleadoActionPerformed
        nuevoEmpleado();
    }//GEN-LAST:event_btnCancelarEmpleadoActionPerformed

    private void txtFechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIngresoActionPerformed

    private void mnwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnwordActionPerformed
        iEmple.formatoWORD();
    }//GEN-LAST:event_mnwordActionPerformed

    private void mnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnpdfActionPerformed
        iEmple.formatoPDF();
    }//GEN-LAST:event_mnpdfActionPerformed

    private void mnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnexcelActionPerformed
        iEmple.formatoEXCEL();
    }//GEN-LAST:event_mnexcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarEmpleado;
    private javax.swing.JButton btnCancelarEmpleado;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnRegistrarEmpleado;
    private javax.swing.JButton btnSalirEmpleado;
    private javax.swing.JComboBox cmbListaSexos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnexcel;
    private javax.swing.JMenuItem mnpdf;
    private javax.swing.JMenuItem mnword;
    public javax.swing.JTable tablaEmpleado;
    public javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCodigoEmpleado;
    public javax.swing.JTextField txtDireccion;
    public javax.swing.JFormattedTextField txtFechaIngreso;
    public javax.swing.JTextField txtMail;
    public javax.swing.JTextField txtNombreEmpleado;
    public javax.swing.JTextField txtSalario;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUnidadesVendidas;
    // End of variables declaration//GEN-END:variables
}
