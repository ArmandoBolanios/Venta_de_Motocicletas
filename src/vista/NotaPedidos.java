package vista;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DataBase;
import modelo.*;
import java.util.Date; 

public final class NotaPedidos extends javax.swing.JFrame {
    
    DataBase basedatos = new DataBase();
    Connection conexion = basedatos.getConexion();
    DefaultTableModel tablemodel; 
    private Modelo modelo = new Modelo();
    private EspecialCompras especialCompras = new EspecialCompras();
    
    int contador = 0;
    int fila = -1;
    ReportePedidos iPedidos = new ReportePedidos();
    
    
    public NotaPedidos() {
        super("NUEVO PEDIDO");
        initComponents();
        nuevoPedido();
        fechaActual();
        bloquearPedidos();
        mostrarPedidos();
        try {
            Statement sta  = conexion.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM proveedores");
            while(rs.next()) {
                this.cmbListaProveedores.addItem(rs.getString("codigo_prov"));
            }
            contador ++;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
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
        tablaPedidos.setModel(tablemodel);
        
        MostrarPedidos compras = new MostrarPedidos();
        compras.mostrarCompras(tablemodel); 
    }
    
    public void nuevoPedido() {
        txtNombreProveedor.setText("");
        txtCostoUnidad.setText("");
        txtCantidadUnidades.setText("");
        txtTotalCompra.setText("");
    }
    
    public void bloquearPedidos() {
        txtFechaPedido.setEnabled(false);
        txtCantidadUnidades.setEnabled(false);
        txtTotalCompra.setEnabled(false);
        txtNombreProveedor.setEnabled(false);
        btnRegistrarPedido.setEnabled(false);
        btnCancelarPedido.setEnabled(false);
        txtCostoUnidad.setEnabled(false);
        cmbListaProveedores.setEnabled(false);
        btnEditarPedido.setEnabled(false);
        btnEliminarPedido.setEnabled(false);
    }
    
    public void desbloquearPedidos() {
        txtCantidadUnidades.setEnabled(true);
        txtTotalCompra.setEnabled(true);
        btnRegistrarPedido.setEnabled(true);
        btnCancelarPedido.setEnabled(true);
        txtCostoUnidad.setEnabled(true);
        cmbListaProveedores.setEnabled(true);
        
    }
    
    public void fechaActual() {
        Date fecha = new Date();
        SimpleDateFormat objeto = new SimpleDateFormat("YYYY-MM-dd");
        txtFechaPedido.setText(objeto.format(fecha)); 
    }
    public String getFechaPedido() {
        String fecha = txtFechaPedido.getText();
        especialCompras.setFechaCompra(fecha); 
        String suFecha = especialCompras.getFechaCompra();
        return suFecha;
    }
    
    
    public int getIdProveedor() {
        int id = Integer.parseInt(cmbListaProveedores.getSelectedItem().toString());
        
        especialCompras.setCodigoProveedor(id); 
        int codigoProveedor = especialCompras.getCodigoProveedor();
        
        return codigoProveedor;
    }
    
    public String getNombreProveedor() {
        String nombre = txtNombreProveedor.getText();
        especialCompras.setNombreProveedor(nombre);
        String colocarNombre = especialCompras.getNombreProveedor();
        return colocarNombre;
    }
    
    public int getCantidadUnidades() {
        int cantidadUnidades = Integer.parseInt(txtCantidadUnidades.getText());
        especialCompras.setUnidades(cantidadUnidades);
        int cantidadCompra = especialCompras.getUnidades();
        
        return cantidadCompra;
    }
    
    
    public double getTotalCompra() {
        double tc;
        double total = Double.parseDouble(txtTotalCompra.getText());
        
        especialCompras.setTotal(total);
        double totalCompra = especialCompras.getTotal();
        
        NumberFormat deci   = new DecimalFormat("#0.00");
        tc                  = Double.parseDouble(deci.format(total));
        return tc;
    }
    
    public void generarTotalCompraMotos(){
        String conversion;
        double totalGral = 0;
        double costo = Double.parseDouble(txtCostoUnidad.getText());
        int cantidad = Integer.parseInt(txtCantidadUnidades.getText());
        
        double compraProducto = costo * cantidad;
        
        totalGral = compraProducto;
        
        NumberFormat deci = new DecimalFormat("#0.00");
        conversion = (String)deci.format(totalGral);
        txtTotalCompra.setText(conversion);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodigoFactura = new javax.swing.JTextField();
        txtCantidadUnidades = new javax.swing.JTextField();
        txtTotalCompra = new javax.swing.JFormattedTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        btnRegistrarPedido = new javax.swing.JButton();
        btnCancelarPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnNuevoPedido = new javax.swing.JButton();
        cmbListaProveedores = new javax.swing.JComboBox();
        txtFechaPedido = new javax.swing.JFormattedTextField();
        btnSalirPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCostoUnidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnEditarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnpdf = new javax.swing.JMenuItem();
        mnword = new javax.swing.JMenuItem();
        mnexcel = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel1.setText("Código Factura");

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel3.setText("Fecha Pedido");

        jLabel4.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel4.setText("Código Proveedor");

        jLabel5.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel5.setText("Cantidad Unidades");

        jLabel6.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel6.setText("Total Compra");

        txtCodigoFactura.setEditable(false);

        txtCantidadUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadUnidadesActionPerformed(evt);
            }
        });

        txtTotalCompra.setText(" ");

        txtNombreProveedor.setBackground(new java.awt.Color(0, 0, 0));
        txtNombreProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNombreProveedor.setForeground(new java.awt.Color(51, 255, 255));
        txtNombreProveedor.setText(" ");
        txtNombreProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProveedorKeyTyped(evt);
            }
        });

        btnRegistrarPedido.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnRegistrarPedido.setText("Registrar Nota");
        btnRegistrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPedidoActionPerformed(evt);
            }
        });

        btnCancelarPedido.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnCancelarPedido.setText("Cancelar Nota");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPedidos);

        jLabel7.setText("Registro de nuevo pedido");

        btnNuevoPedido.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnNuevoPedido.setText("Nueva Nota");
        btnNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPedidoActionPerformed(evt);
            }
        });

        cmbListaProveedores.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        cmbListaProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaProveedoresActionPerformed(evt);
            }
        });

        txtFechaPedido.setBackground(new java.awt.Color(0, 0, 0));
        txtFechaPedido.setForeground(new java.awt.Color(51, 255, 204));
        txtFechaPedido.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N

        btnSalirPedido.setText("Salir");
        btnSalirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPedidoActionPerformed(evt);
            }
        });

        jLabel2.setText("Costo por Unidad");

        jLabel8.setText("Pedidos Motocicleta");

        jLabel9.setText("$:");

        jLabel10.setText("$:");

        btnEditarPedido.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnEditarPedido.setText("Actualizar Pedido");
        btnEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnEliminarPedido.setText("Eliminar Pedido");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtCostoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirPedido))
                    .addComponent(btnNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnRegistrarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(btnEditarPedido)
                                        .addGap(214, 214, 214)
                                        .addComponent(btnEliminarPedido))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCantidadUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbListaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(53, 53, 53)
                                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevoPedido)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigoFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbListaProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalirPedido)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txtCostoUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidadUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarPedido)
                    .addComponent(btnEditarPedido)
                    .addComponent(btnCancelarPedido)
                    .addComponent(btnEliminarPedido))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar Nota-Pedido?","Pregunta",0);
        if(respuesta==0) {
            if(fila>-1) {
                int codigoFactura = Integer.valueOf(tablaPedidos.getValueAt(fila, 0).toString());
                modelo.eliminarPedido(codigoFactura);
                mostrarPedidos();
                nuevoPedido();
                fila = -1;
            }
        }
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPedidoActionPerformed
        String registro = String.valueOf(tablaPedidos.getValueAt(fila, 7));

        if(fila>-1 && registro.equals("No")) {
            int codigo = Integer.valueOf(tablaPedidos.getValueAt(fila, 0).toString());
            double costoMoto = Double.parseDouble(txtCostoUnidad.getText());
            modelo.actualizarPedido(codigo, getFechaPedido(),costoMoto, getCantidadUnidades(), getTotalCompra());
            mostrarPedidos();
            nuevoPedido();
            bloquearPedidos();
        }
        else {
            JOptionPane.showMessageDialog(this, "La factura ya está registrada en  motocicletas"
                + "\n Seleccione  la factura que aun no se ha registrado");
        }
    }//GEN-LAST:event_btnEditarPedidoActionPerformed

    private void btnSalirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPedidoActionPerformed
        // TODO add your handling code here:
        nuevoPedido();
        bloquearPedidos();
        dispose();
    }//GEN-LAST:event_btnSalirPedidoActionPerformed

    private void cmbListaProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaProveedoresActionPerformed
        try {

            String sql = " SELECT * FROM proveedores where codigo_prov = '"+this.cmbListaProveedores.getSelectedItem()+"' ";
            if(this.contador>0) {
                Statement state = conexion.createStatement();
                ResultSet result = state.executeQuery(sql);
                result.next();
                this.txtNombreProveedor.setText(String.valueOf(result.getString("nombre")));

            }

        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_cmbListaProveedoresActionPerformed

    private void btnNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoActionPerformed
        // TODO add your handling code here:
        nuevoPedido();
        desbloquearPedidos();
    }//GEN-LAST:event_btnNuevoPedidoActionPerformed

    private void tablaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPedidosMouseClicked

        fila = tablaPedidos.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            desbloquearPedidos();
            this.txtFechaPedido.setEnabled(false);
            this.cmbListaProveedores.setEnabled(false);
            this.txtNombreProveedor.setEnabled(false);
            btnRegistrarPedido.setEnabled(false); 
            btnEditarPedido.setEnabled(true);
            btnEliminarPedido.setEnabled(true);
            txtCodigoFactura.setText(String.valueOf(tablaPedidos.getValueAt(fila, 0)));
            txtNombreProveedor.setText(String.valueOf(tablaPedidos.getValueAt(fila, 3)));
            txtCostoUnidad.setText(String.valueOf(tablaPedidos.getValueAt(fila, 4)));
            txtCantidadUnidades.setText(String.valueOf(tablaPedidos.getValueAt(fila, 5)));
            txtTotalCompra.setText(String.valueOf(tablaPedidos.getValueAt(fila, 6)));

        }
    }//GEN-LAST:event_tablaPedidosMouseClicked

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        // TODO add your handling code here:
        nuevoPedido();
        btnEditarPedido.setEnabled(false);
        btnEliminarPedido.setEnabled(false); 
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    private void btnRegistrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPedidoActionPerformed
        if(txtNombreProveedor.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el nombre del proveedor");
            txtNombreProveedor.requestFocus();
            return;
        }
        if(txtCostoUnidad.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane,  "Escriba el costo de la motocicleta");
            txtCostoUnidad.requestFocus();
            return;
        }
        if(txtCantidadUnidades.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Escriba la cantidad de motocicletas"
                    + "\na pedir");
            txtCantidadUnidades.requestFocus();
            return;
        }
        if(txtTotalCompra.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Pulse 'Enter' en [Cantidad Unidades]"
                    + "para obtener el total");
            txtTotalCompra.requestFocus();
            return;
        }
        
        double costoMoto = Double.parseDouble(txtCostoUnidad.getText());
        modelo.realizarPedido(getFechaPedido() , getIdProveedor(), getNombreProveedor(), costoMoto, getCantidadUnidades(),
        getTotalCompra());
        mostrarPedidos();
        nuevoPedido();
        bloquearPedidos();

    }//GEN-LAST:event_btnRegistrarPedidoActionPerformed

    private void txtNombreProveedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProveedorKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreProveedorKeyTyped

    private void txtCantidadUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadUnidadesActionPerformed
        generarTotalCompraMotos();
    }//GEN-LAST:event_txtCantidadUnidadesActionPerformed

    private void mnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnpdfActionPerformed
        iPedidos.formatoPDF();
    }//GEN-LAST:event_mnpdfActionPerformed

    private void mnwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnwordActionPerformed
        iPedidos.formatoWORD();
    }//GEN-LAST:event_mnwordActionPerformed

    private void mnexcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnexcelActionPerformed
        iPedidos.formatoEXCEL();
    }//GEN-LAST:event_mnexcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JButton btnEditarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnNuevoPedido;
    private javax.swing.JButton btnRegistrarPedido;
    public javax.swing.JButton btnSalirPedido;
    public javax.swing.JComboBox cmbListaProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    public javax.swing.JTable tablaPedidos;
    public javax.swing.JTextField txtCantidadUnidades;
    public javax.swing.JTextField txtCodigoFactura;
    private javax.swing.JTextField txtCostoUnidad;
    public javax.swing.JFormattedTextField txtFechaPedido;
    public javax.swing.JTextField txtNombreProveedor;
    public javax.swing.JFormattedTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
