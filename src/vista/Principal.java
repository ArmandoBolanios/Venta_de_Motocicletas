package vista;
import javax.swing.table.DefaultTableModel;
import modelo.*;

public class Principal extends javax.swing.JFrame {
/*
    ESTE JFrame solo hace visible la ventana principal, pero tambien 
    MANDA A LLAMARa los demás JFrame con sus datos ya registrados, en 
    caso de no haber registros pues los visualiza vacías
    */
    //private final DataBase base = new DataBase();
    
    DefaultTableModel tablemodel;
    
    public Principal() {
        super("ELABORÓ ING. ARMANDO BOLAÑOS DIRCIO V.1.0");
        initComponents();
    }
    public final void mostrardatosMotos() {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Código Motocicleta");
        tablemodel.addColumn("Marca");
        tablemodel.addColumn("Modelo");
        tablemodel.addColumn("Color");
        tablemodel.addColumn("Código Categoria");
        tablemodel.addColumn("Código Factura");
        tablemodel.addColumn("*Nombre Proveedor*");
        tablemodel.addColumn("Costo Unidad Motocicleta");
        tablemodel.addColumn("Stock");
        tablemodel.addColumn("Venta Unidad Motocicleta");
        frmoto.tablaMotocicletas.setModel(tablemodel);
        MostrarMotos motis = new MostrarMotos();
        motis.mostrarMotos(tablemodel);
    }

//-----------------------------------------------------------------------------
    public void mostrardatosEmpleado() {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Código Empleado");
        tablemodel.addColumn("Nombre");
        tablemodel.addColumn("Apellidos");
        tablemodel.addColumn("Sexo");
        tablemodel.addColumn("Teléfono");
        tablemodel.addColumn("Dirección");
        tablemodel.addColumn("E-mail");
        tablemodel.addColumn("Fecha Ingreso");
        tablemodel.addColumn("Salario");
        tablemodel.addColumn("Motos Vendidas");
        frmempleados.tablaEmpleado.setModel(tablemodel);
        MostrarEmpleado re = new MostrarEmpleado();
        re.mostrarEmpleado(tablemodel);
    }
    
    public void mostrarPedidos() {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Código Factura");
        tablemodel.addColumn("Fecha de Pedido");
        tablemodel.addColumn("Código Proveedor");
        tablemodel.addColumn("Nombre Proveedor");
        tablemodel.addColumn("Costo por Unidad");
        tablemodel.addColumn("Cantidad");
        tablemodel.addColumn("Compra Total");
        tablemodel.addColumn("¿Registrado?");
        frmpedidos.tablaPedidos.setModel(tablemodel);
        MostrarPedidos compras = new MostrarPedidos();
        compras.mostrarCompras(tablemodel); 
    }
//----------------------------------------------------------------------------- 
    //estas son instancias de las clases ..
    MostrarCategoria cat        = new MostrarCategoria();
    MostrarCliente   cliente    = new MostrarCliente();
    MostrarMotos motos          = new MostrarMotos();
    Motocicleta frmoto          = new Motocicleta();
    MostrarEmpleado empleado    = new MostrarEmpleado();
    MostrarPedidos listacompra  = new MostrarPedidos();
    MostrarProveedor listaprov  = new MostrarProveedor();
//--instancias de los JFrames
    NotaPedidos frmpedidos      = new NotaPedidos();
    Categoria frmCategorias     = new Categoria();
    Proveedor frmproveedores    = new Proveedor();
    Cliente frmclientes         = new Cliente();      
    Empleado frmempleados       = new Empleado();
    TodasConsultas frmConsultas = new TodasConsultas();
    Ventas    frmVentas         = new Ventas();
    CorteCaja corte             = new CorteCaja();
    AdministracionUsuarios usuarios = new AdministracionUsuarios();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        panel1 = new org.edisoncor.gui.panel.Panel();
        lblTipoUsuario = new javax.swing.JLabel();
        clockFace1 = new org.edisoncor.gui.varios.ClockFace();
        btnNotaPedido = new org.edisoncor.gui.button.ButtonTask();
        btnNuevaVenta = new org.edisoncor.gui.button.ButtonTask();
        btnComprarMoto = new org.edisoncor.gui.button.ButtonTask();
        btnConsultas = new org.edisoncor.gui.button.ButtonTask();
        lblCodigoEmpleado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        ADMINISTRAR_NUEVOS = new javax.swing.JMenu();
        AGREGAR_CATEGORIA = new javax.swing.JMenuItem();
        AGREGAR_PROVEEDOR = new javax.swing.JMenuItem();
        AGREGAR_CLIENTE = new javax.swing.JMenuItem();
        AGREGAR_EMPLEADO = new javax.swing.JMenuItem();
        MENU = new javax.swing.JMenu();
        mnCorteCaja = new javax.swing.JMenuItem();
        mnConsultas = new javax.swing.JMenuItem();
        mnCrearUsuarios = new javax.swing.JMenuItem();
        SALIR = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTipoUsuario.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        lblTipoUsuario.setForeground(new java.awt.Color(255, 255, 255));

        btnNotaPedido.setForeground(new java.awt.Color(204, 204, 204));
        btnNotaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delivery.png"))); // NOI18N
        btnNotaPedido.setText("NOTA PEDIDO");
        btnNotaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaPedidoActionPerformed(evt);
            }
        });

        btnNuevaVenta.setForeground(new java.awt.Color(204, 204, 204));
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard_text.png"))); // NOI18N
        btnNuevaVenta.setText("NUEVA VENTA");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        btnComprarMoto.setForeground(new java.awt.Color(204, 204, 204));
        btnComprarMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/page_white_paste.png"))); // NOI18N
        btnComprarMoto.setText("COMPRAR MOTO");
        btnComprarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarMotoActionPerformed(evt);
            }
        });

        btnConsultas.setForeground(new java.awt.Color(204, 204, 204));
        btnConsultas.setText("CONSULTAS");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        lblCodigoEmpleado.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        lblCodigoEmpleado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNotaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnComprarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 161, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCodigoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clockFace1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNotaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComprarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(lblCodigoEmpleado)
                .addGap(18, 18, 18)
                .addComponent(lblTipoUsuario)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 161;
        gridBagConstraints.ipady = 91;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panel1, gridBagConstraints);

        ADMINISTRAR_NUEVOS.setText("ADMINISTRAR");

        AGREGAR_CATEGORIA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clipboard_text.png"))); // NOI18N
        AGREGAR_CATEGORIA.setText("CATEGORÍA");
        AGREGAR_CATEGORIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_CATEGORIAActionPerformed(evt);
            }
        });
        ADMINISTRAR_NUEVOS.add(AGREGAR_CATEGORIA);

        AGREGAR_PROVEEDOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_thief_baldie.png"))); // NOI18N
        AGREGAR_PROVEEDOR.setText("PROVEEDOR");
        AGREGAR_PROVEEDOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_PROVEEDORActionPerformed(evt);
            }
        });
        ADMINISTRAR_NUEVOS.add(AGREGAR_PROVEEDOR);

        AGREGAR_CLIENTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_business_boss.png"))); // NOI18N
        AGREGAR_CLIENTE.setText("CLIENTE");
        AGREGAR_CLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_CLIENTEActionPerformed(evt);
            }
        });
        ADMINISTRAR_NUEVOS.add(AGREGAR_CLIENTE);

        AGREGAR_EMPLEADO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        AGREGAR_EMPLEADO.setText("EMPLEADO");
        AGREGAR_EMPLEADO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AGREGAR_EMPLEADOActionPerformed(evt);
            }
        });
        ADMINISTRAR_NUEVOS.add(AGREGAR_EMPLEADO);

        jMenuBar1.add(ADMINISTRAR_NUEVOS);

        MENU.setText("MENÚ");

        mnCorteCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/page_white_paste.png"))); // NOI18N
        mnCorteCaja.setText("Realizar Corte de Caja");
        mnCorteCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCorteCajaActionPerformed(evt);
            }
        });
        MENU.add(mnCorteCaja);

        mnConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/magnify.png"))); // NOI18N
        mnConsultas.setText("Consultas");
        mnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnConsultasActionPerformed(evt);
            }
        });
        MENU.add(mnConsultas);

        mnCrearUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.png"))); // NOI18N
        mnCrearUsuarios.setText("Crear Usuarios");
        mnCrearUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCrearUsuariosActionPerformed(evt);
            }
        });
        MENU.add(mnCrearUsuarios);

        SALIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/no.png"))); // NOI18N
        SALIR.setText("Salir");
        SALIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SALIRActionPerformed(evt);
            }
        });
        MENU.add(SALIR);

        jMenuBar1.add(MENU);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AGREGAR_CATEGORIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_CATEGORIAActionPerformed
        // VER TABLA CATEGORIA:
        frmCategorias.setVisible(true);
    }//GEN-LAST:event_AGREGAR_CATEGORIAActionPerformed

    private void AGREGAR_PROVEEDORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_PROVEEDORActionPerformed
        // VER: PROVEEDOR
        frmproveedores.setVisible(true);
        
    }//GEN-LAST:event_AGREGAR_PROVEEDORActionPerformed

    private void AGREGAR_CLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_CLIENTEActionPerformed
        // TODO add your handling code here:
        frmclientes.setVisible(true);
    }//GEN-LAST:event_AGREGAR_CLIENTEActionPerformed

    private void AGREGAR_EMPLEADOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AGREGAR_EMPLEADOActionPerformed
        // TODO add your handling code here:
       frmempleados.setVisible(true);
       mostrardatosEmpleado();
    }//GEN-LAST:event_AGREGAR_EMPLEADOActionPerformed

    private void SALIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SALIRActionPerformed
        // TODO add your handling code here:
       // base.cerrar();
        dispose();
    }//GEN-LAST:event_SALIRActionPerformed

    private void mnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnConsultasActionPerformed
        frmConsultas.setVisible(true);
    }//GEN-LAST:event_mnConsultasActionPerformed

    private void mnCorteCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCorteCajaActionPerformed
        corte.setVisible(true); 
    }//GEN-LAST:event_mnCorteCajaActionPerformed

    private void btnNotaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaPedidoActionPerformed
        //VER NUEVA COMPRA:
        frmpedidos .setVisible(true);
        frmpedidos.cmbListaProveedores.setModel(listaprov.getListaProveedores());
        mostrarPedidos();
    }//GEN-LAST:event_btnNotaPedidoActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        // VER NUEVA VENTA:
        frmVentas.setVisible(true);
        frmVentas.cmbListaEmpleados.setModel(empleado.getListaEmpleados());
        frmVentas.cmbListaMotocicletas.setModel(motos.getListaMotociletas());
        frmVentas.cmbListaClientes.setModel(cliente.getListaClientes());
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnComprarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarMotoActionPerformed
        int contador = 0;
        frmoto.setVisible(true);
        mostrardatosMotos();
        
        //voy a mandar a llamar la 'clase' Modelo donde obtendré los productos[motocicletas]...
        //esta instancia me permite actualizar todas las categorias que existen      
        frmoto.cmbListaCategoriasMoto.setModel(cat.getListaCategorias());
        frmoto.cmbListaPedidos.setModel(listacompra.getListaCompras());
    }//GEN-LAST:event_btnComprarMotoActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        // TODO add your handling code here:
        frmConsultas.setVisible(true);
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void mnCrearUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCrearUsuariosActionPerformed
        usuarios.setVisible(true); 
    }//GEN-LAST:event_mnCrearUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu ADMINISTRAR_NUEVOS;
    public javax.swing.JMenuItem AGREGAR_CATEGORIA;
    public javax.swing.JMenuItem AGREGAR_CLIENTE;
    public javax.swing.JMenuItem AGREGAR_EMPLEADO;
    public javax.swing.JMenuItem AGREGAR_PROVEEDOR;
    private javax.swing.JMenu MENU;
    private javax.swing.JMenuItem SALIR;
    public org.edisoncor.gui.button.ButtonTask btnComprarMoto;
    public org.edisoncor.gui.button.ButtonTask btnConsultas;
    public org.edisoncor.gui.button.ButtonTask btnNotaPedido;
    public org.edisoncor.gui.button.ButtonTask btnNuevaVenta;
    private org.edisoncor.gui.varios.ClockFace clockFace1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JLabel lblCodigoEmpleado;
    public javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JMenuItem mnConsultas;
    private javax.swing.JMenuItem mnCorteCaja;
    public javax.swing.JMenuItem mnCrearUsuarios;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables

}
