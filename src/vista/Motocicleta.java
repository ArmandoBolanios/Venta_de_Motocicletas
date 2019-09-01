package vista;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public final class Motocicleta extends javax.swing.JFrame {
    private DefaultTableModel dtm;
    private final Modelo model                  = new Modelo();
    private final EspecialCategoria especial   = new EspecialCategoria();
    private DataBase basedatos                  = new DataBase();
    Connection conexion = basedatos.getConexion();
    
    int contador = 0;
    int fila = -1;
    
    public Motocicleta() {
        super("COMPRA DE MOTOCICLETAS");
        initComponents();
        mostrarDatosMotos();
        bloquearMoto();
        nuevaMoto();
        
        try {
            Statement sta  = conexion.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM categoria");
            while(rs.next()) {
                this.cmbListaCategoriasMoto.addItem(rs.getString("nombre_categoria"));
            }
            contador++;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        
        try {
            Statement stm = conexion.createStatement();
            ResultSet rslt = stm.executeQuery("SELECT * FROM pedidos WHERE registrado = 'No'");
            while(rslt.next()) {
                this.cmbListaPedidos.addItem(rslt.getInt("codigo_factura")); 
            }
            contador++;
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public final void mostrarDatosMotos() {
        dtm = new DefaultTableModel();
        dtm.addColumn("Código Motocicleta");
        dtm.addColumn("Marca");
        dtm.addColumn("Modelo");
        dtm.addColumn("Color");
        dtm.addColumn("Código Categoria");
        dtm.addColumn("Código Factura");
        dtm.addColumn("*Nombre Proveedor*");
        dtm.addColumn("Costo Unidad Motocicleta");
        dtm.addColumn("Stock");
        dtm.addColumn("Venta Unidad Motocicleta");
        tablaMotocicletas.setModel(dtm);
        MostrarMotos motis = new MostrarMotos();
        motis.mostrarMotos(dtm);
    }
    
    public void bloquearMoto() {
       txtMarcaMotocicleta.setEnabled(false);
       txtModeloMotocicleta.setEnabled(false);
       txtColorMotocicleta.setEnabled(false);
       cmbListaCategoriasMoto.setEnabled(false);
       cmbListaPedidos.setEnabled(false);
       txtNombreProveedor.setEnabled(false);
       txtCostoMoto.setEnabled(false);
       txtPrecioVentaMoto.setEnabled(false);
       txtGanancia.setEnabled(false); 
       btnRegistrarCompra.setEnabled(false);
       btnActualizarDatosMoto.setEnabled(false);
       btnCancelarMoto.setEnabled(false);
       btnEliminarMoto.setEnabled(false);
       
    }
    
    public void desbloquearMoto() {
       txtMarcaMotocicleta.setEnabled(true);
       txtModeloMotocicleta.setEnabled(true);
       txtColorMotocicleta.setEnabled(true);
       cmbListaCategoriasMoto.setEnabled(true);
       cmbListaPedidos.setEnabled(true);
       txtNombreProveedor.setEnabled(true);
       txtCostoMoto.setEnabled(true);
       txtPrecioVentaMoto.setEnabled(true);
       btnRegistrarCompra.setEnabled(true);
       btnCancelarMoto.setEnabled(true);
       
       
    }
    
    private void nuevaMoto() {
        txtMarcaMotocicleta.setText("");
        txtModeloMotocicleta.setText("");
        txtColorMotocicleta.setText("");
        txtCodigoCategoria.setText("");
        txtNombreProveedor.setText("");
        txtCostoMoto.setText("");
        txtStockMotocicleta.setText("");
        txtPrecioVentaMoto.setText("");
        txtGanancia.setText("");
    }

    public String getMarca() {
        String marca = txtMarcaMotocicleta.getText();
        especial.setMarca(marca);
        String suMarca = especial.getMarca();
        return suMarca;
    }
    
    public String getModelo() {
        String modelo = txtModeloMotocicleta.getText();
        especial.setModelo(modelo);
        String suModelo = especial.getModelo();
        return suModelo;
    }
    
    public String getColor() {
        String color =  txtColorMotocicleta.getText();
        especial.setColor(color);
        String suColor =  especial.getColor();
        return suColor;
    }
    
    public double getPrecioVenta(){
        double preciomoto;
        double ganancia = 0;
        
        double costoMoto = Double.parseDouble(txtCostoMoto.getText());
        //double precio = Double.parseDouble(txtPrecioVentaMoto.getText());
        double ganar = Double.parseDouble(txtGanancia.getText());

        ganancia = costoMoto + ((costoMoto*ganar)/100);
        
        especial.setPreciovt(ganancia);
        double venta = especial.getPreciovt();
        
        NumberFormat deci = new DecimalFormat("#0.00");
        preciomoto = Double.parseDouble(deci.format(venta));
        
        return preciomoto;
        
    }
    
    public int getCodigoCategoria() {
        int clasificacion = Integer.parseInt(txtCodigoCategoria.getText());
        
        especial.setCategoria(clasificacion); 
        int codigoCategoria = especial.getCategoria();
        
        return codigoCategoria;
    }
    
    public int getCodigoPedido() {
        int codigoFactura = Integer.parseInt(cmbListaPedidos.getSelectedItem().toString());
        return codigoFactura;
    }
    
    public String getNombreProveedor() {
        String nombre = txtNombreProveedor.getText();
        return nombre;
    }
    
    public double getCostoMoto() {
        double costo = Double.parseDouble(txtCostoMoto.getText());
        return costo;
    }
    
    public int getStock() {
        int stock = Integer.parseInt(txtStockMotocicleta.getText());
        especial.setStock(stock);
        int suStock =  especial.getStock();
        return suStock;
    }
    
    public void actualizarPedidos() {
     try {
            PreparedStatement st = conexion.prepareStatement(
                    "UPDATE pedidos SET registrado = 'Si' WHERE codigo_factura = "+cmbListaPedidos.getSelectedItem().toString());
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Motocicleta.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void obtenerReporteMillar() {
        List lista = new ArrayList();
        for(int i=0; i<tablaMotocicletas.getRowCount(); i++) {
            //Instancias la clase millares
            MillaresMotos listmotos = new MillaresMotos(
            tablaMotocicletas.getValueAt(i, 0).toString(),
            tablaMotocicletas.getValueAt(i, 1).toString(),
            tablaMotocicletas.getValueAt(i, 2).toString(),
            tablaMotocicletas.getValueAt(i, 3).toString(),
            tablaMotocicletas.getValueAt(i, 4).toString(),
            tablaMotocicletas.getValueAt(i, 5).toString(),
            tablaMotocicletas.getValueAt(i, 6).toString(),
            tablaMotocicletas.getValueAt(i, 7).toString(),
            tablaMotocicletas.getValueAt(i, 8).toString(),
            tablaMotocicletas.getValueAt(i, 9).toString());
            lista.add(listmotos);
        }
        try {
            JasperReport Reporte = (JasperReport) JRLoader.loadObject("ReporteMillar.jasper");
            JasperPrint print = JasperFillManager.fillReport(Reporte, null, new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(print,false);
        } catch (JRException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//---------------------------------------------------------------------------------------------------------------------------- 
//----------------------------------------------------------------------------------------------------------------------------    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMotocicletas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbListaCategoriasMoto = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoMoto = new javax.swing.JFormattedTextField();
        txtMarcaMotocicleta = new javax.swing.JFormattedTextField();
        txtModeloMotocicleta = new javax.swing.JFormattedTextField();
        txtColorMotocicleta = new javax.swing.JFormattedTextField();
        txtPrecioVentaMoto = new javax.swing.JFormattedTextField();
        txtStockMotocicleta = new javax.swing.JFormattedTextField();
        txtCodigoCategoria = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cmbListaPedidos = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCostoMoto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnNuevaMoto = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtGanancia = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        btnRegistrarCompra = new javax.swing.JButton();
        btnActualizarDatosMoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEliminarMoto = new javax.swing.JButton();
        btnCancelarMoto = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        mnStock = new javax.swing.JMenuItem();
        mnGenerarReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 176));
        jPanel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        tablaMotocicletas.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N
        tablaMotocicletas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMotocicletas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMotocicletasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMotocicletas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setText("Código moto");

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel3.setText("Marca");

        jLabel4.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel4.setText("Modelo");

        jLabel5.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel5.setText("Color");

        jLabel6.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel6.setText("Precio para Venta");

        jLabel7.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel7.setText("Stock");

        cmbListaCategoriasMoto.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        cmbListaCategoriasMoto.setToolTipText("");
        cmbListaCategoriasMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaCategoriasMotoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel8.setText("Nombre Categoria");

        txtCodigoMoto.setEditable(false);
        txtCodigoMoto.setBackground(new java.awt.Color(0, 0, 0));
        txtCodigoMoto.setForeground(new java.awt.Color(0, 255, 255));
        txtCodigoMoto.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N

        txtMarcaMotocicleta.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtMarcaMotocicleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaMotocicletaKeyTyped(evt);
            }
        });

        txtModeloMotocicleta.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        txtColorMotocicleta.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtColorMotocicleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorMotocicletaKeyTyped(evt);
            }
        });

        txtPrecioVentaMoto.setEditable(false);
        txtPrecioVentaMoto.setBackground(new java.awt.Color(0, 0, 0));
        txtPrecioVentaMoto.setForeground(new java.awt.Color(0, 255, 255));
        txtPrecioVentaMoto.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N

        txtStockMotocicleta.setEditable(false);
        txtStockMotocicleta.setBackground(new java.awt.Color(0, 0, 0));
        txtStockMotocicleta.setForeground(new java.awt.Color(0, 255, 204));
        txtStockMotocicleta.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N
        txtStockMotocicleta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockMotocicletaKeyTyped(evt);
            }
        });

        txtCodigoCategoria.setEditable(false);
        txtCodigoCategoria.setBackground(new java.awt.Color(0, 0, 0));
        txtCodigoCategoria.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N
        txtCodigoCategoria.setForeground(new java.awt.Color(51, 255, 204));

        jLabel9.setText("Código Nota");

        cmbListaPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaPedidosActionPerformed(evt);
            }
        });

        jLabel10.setText("Nombre Proveedor");

        jLabel11.setText("Código Categoria");

        jLabel12.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        jLabel12.setText("Datos del pedido");

        jLabel13.setText("Costo de Motocicleta");

        txtCostoMoto.setEditable(false);
        txtCostoMoto.setBackground(new java.awt.Color(0, 0, 0));
        txtCostoMoto.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N
        txtCostoMoto.setForeground(new java.awt.Color(0, 255, 255));

        jLabel14.setText("$:");

        btnNuevaMoto.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        btnNuevaMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnNuevaMoto.setText("Nueva Compra");
        btnNuevaMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaMotoActionPerformed(evt);
            }
        });

        jLabel15.setText("Anote su ganancia");

        txtGanancia.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtGanancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGananciaActionPerformed(evt);
            }
        });
        txtGanancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGananciaKeyTyped(evt);
            }
        });

        jLabel16.setText("%");

        txtNombreProveedor.setEditable(false);
        txtNombreProveedor.setBackground(new java.awt.Color(0, 0, 0));
        txtNombreProveedor.setFont(new java.awt.Font("Lao UI", 1, 12)); // NOI18N
        txtNombreProveedor.setForeground(new java.awt.Color(0, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel15))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCodigoMoto, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                        .addComponent(cmbListaPedidos, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMarcaMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtPrecioVentaMoto))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtModeloMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel14)))
                                    .addComponent(jLabel13))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(txtColorMotocicleta))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(txtCostoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStockMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbListaCategoriasMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnNuevaMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnNuevaMoto)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtMarcaMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtModeloMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtColorMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbListaCategoriasMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecioVentaMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel15)
                            .addComponent(txtGanancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbListaPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(txtCostoMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(txtStockMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))))
        );

        btnRegistrarCompra.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnRegistrarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attach.png"))); // NOI18N
        btnRegistrarCompra.setText("Registrar Compra");
        btnRegistrarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCompraActionPerformed(evt);
            }
        });

        btnActualizarDatosMoto.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        btnActualizarDatosMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        btnActualizarDatosMoto.setText("Actualizar Datos");
        btnActualizarDatosMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatosMotoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        jLabel1.setText("Compra de Motocicleta");

        btnEliminarMoto.setFont(new java.awt.Font("Lao UI", 0, 11)); // NOI18N
        btnEliminarMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_registro.png"))); // NOI18N
        btnEliminarMoto.setText("Eliminar");
        btnEliminarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMotoActionPerformed(evt);
            }
        });

        btnCancelarMoto.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnCancelarMoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        btnCancelarMoto.setText("Cancelar");
        btnCancelarMoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarMotoActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/no.png"))); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jMenu.setText("Menú");

        mnStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        mnStock.setText("Actualizar Compra(Stock)");
        mnStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnStockActionPerformed(evt);
            }
        });
        jMenu.add(mnStock);

        mnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blueprint.png"))); // NOI18N
        mnGenerarReporte.setText("Generar Reporte");
        mnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGenerarReporteActionPerformed(evt);
            }
        });
        jMenu.add(mnGenerarReporte);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(220, 220, 220)
                                .addComponent(btnActualizarDatosMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(156, 156, 156)
                                .addComponent(btnEliminarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancelarMoto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarCompra)
                    .addComponent(btnActualizarDatosMoto)
                    .addComponent(btnEliminarMoto)
                    .addComponent(btnCancelarMoto))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbListaCategoriasMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaCategoriasMotoActionPerformed

        try {
            String sql = " SELECT * FROM categoria where nombre_categoria = '"+this.cmbListaCategoriasMoto.getSelectedItem()+"' ";
            if(this.contador>0) {
            Statement state = conexion.createStatement();
            ResultSet result = state.executeQuery(sql);
            result.next();
            this.txtCodigoCategoria.setText(String.valueOf(result.getInt("id_cat")));
            }
            }catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_cmbListaCategoriasMotoActionPerformed

    private void btnRegistrarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCompraActionPerformed

        if(txtMarcaMotocicleta.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta la marca de la motocicleta");
            txtMarcaMotocicleta.requestFocus();
            return;
        }
        if(txtModeloMotocicleta.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el modelo de la motocicleta");
            txtModeloMotocicleta.requestFocus();
            return;
        }
        if(txtColorMotocicleta.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el color de la motocicleta");
            txtColorMotocicleta.requestFocus();
            return;
        }
        if(txtCodigoCategoria.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el código de categoria");
            txtCodigoCategoria.requestFocus();
            return;
        }
        if(txtNombreProveedor.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Hace falta el nombre del proveedor");
            txtNombreProveedor.requestFocus();
            return;
        }
        if(txtGanancia.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Anote su ganancia");
            txtGanancia.requestFocus();
            return;
        }
        
        model.agregarCompraMoto(getMarca(), getModelo(), getColor(), getCodigoCategoria(), getCodigoPedido(), 
                getNombreProveedor(), getCostoMoto(), getStock(), getPrecioVenta());
        
        actualizarPedidos();
        int itemCount = cmbListaPedidos.getItemCount();
        int i = 0;
        cmbListaPedidos.removeItemAt(i);
        
        nuevaMoto();
        mostrarDatosMotos();
    }//GEN-LAST:event_btnRegistrarCompraActionPerformed

    private void tablaMotocicletasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMotocicletasMouseClicked
        desbloquearMoto();
        nuevaMoto();
        
        fila = tablaMotocicletas.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            btnRegistrarCompra.setEnabled(false);
            txtGanancia.setEnabled(false);
            btnActualizarDatosMoto.setEnabled(true);
            btnEliminarMoto.setEnabled(true);
            txtCodigoMoto.setText(String.valueOf(tablaMotocicletas.getValueAt(fila, 0)));
            txtMarcaMotocicleta.setText(String.valueOf(tablaMotocicletas.getValueAt(fila, 1)));
            txtModeloMotocicleta.setText(String.valueOf(tablaMotocicletas.getValueAt(fila, 2)));
            txtColorMotocicleta.setText(String.valueOf(tablaMotocicletas.getValueAt(fila, 3)));
            txtCodigoCategoria.setText(String.valueOf(tablaMotocicletas.getValueAt(fila, 4)));
            
        }
         
    }//GEN-LAST:event_tablaMotocicletasMouseClicked

    private void btnActualizarDatosMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatosMotoActionPerformed
        
        int fil = 0;    
        if(fila>-1) {
            int codec = Integer.valueOf(tablaMotocicletas.getValueAt(fila, 0).toString());
            model.actualizarDatosMoto(codec, getMarca(), getModelo(), getColor(), getCodigoCategoria());
            mostrarDatosMotos();
            nuevaMoto();
        } //fin de if
    }//GEN-LAST:event_btnActualizarDatosMotoActionPerformed

    private void btnEliminarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMotoActionPerformed
        // TODO add your handling code here:
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar Motocicleta?","Pregunta",0);
        if(respuesta==0) {
        if(fila>-1) {
            int codigo = Integer.valueOf(tablaMotocicletas.getValueAt(fila, 0).toString());
            model.eliminarCompraMoto(codigo);
            mostrarDatosMotos();
            nuevaMoto();
            fila = -1;
        }
        }
    }//GEN-LAST:event_btnEliminarMotoActionPerformed

    private void btnNuevaMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaMotoActionPerformed
        desbloquearMoto();
        nuevaMoto();
    }//GEN-LAST:event_btnNuevaMotoActionPerformed

    private void btnCancelarMotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarMotoActionPerformed
        nuevaMoto();
        btnActualizarDatosMoto.setEnabled(false);
        btnEliminarMoto.setEnabled(false);
    }//GEN-LAST:event_btnCancelarMotoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        nuevaMoto();
        bloquearMoto();
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtMarcaMotocicletaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaMotocicletaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
            }
    }//GEN-LAST:event_txtMarcaMotocicletaKeyTyped

    private void txtColorMotocicletaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorMotocicletaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
            }
    }//GEN-LAST:event_txtColorMotocicletaKeyTyped

    private void txtStockMotocicletaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockMotocicletaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(txtStockMotocicleta.getText().length()>=20) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtStockMotocicletaKeyTyped

    private void cmbListaPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaPedidosActionPerformed
        try {
            String sql = "SELECT * FROM pedidos  WHERE codigo_factura = '"+this.cmbListaPedidos.getSelectedItem()+"'";
            
            if(contador>0) {
                Statement state = conexion.createStatement();
                ResultSet result = state.executeQuery(sql);
                result.next();
                txtGanancia.setEnabled(true);
                this.txtNombreProveedor.setText(String.valueOf(result.getString("nombre_prov")));
                this.txtCostoMoto.setText(String.valueOf(result.getDouble("costo_unidad"))); 
                this.txtStockMotocicleta.setText(String.valueOf(result.getInt("cantidad_unidades")));
            }
        } catch(SQLException e) {JOptionPane.showMessageDialog(this, e);}
        
    }//GEN-LAST:event_cmbListaPedidosActionPerformed

    private void txtGananciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGananciaActionPerformed
        
        this.txtPrecioVentaMoto.setText(String.valueOf(getPrecioVenta()));
        
    }//GEN-LAST:event_txtGananciaActionPerformed

    private void txtGananciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyTyped
        char car = evt.getKeyChar();
        if(txtGanancia.getText().length()>=5) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtGananciaKeyTyped

    private void mnStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnStockActionPerformed
    //Actualiza el Stock! -->
        if(txtGanancia.getText().length()==0) {
            JOptionPane.showMessageDialog(null, "Anote su ganancia");
            txtGanancia.requestFocus();
            return;
        }
        String nombreTabla  = String.valueOf(tablaMotocicletas.getValueAt(fila, 6));
        String nombreProv   = txtNombreProveedor.getText();
        
        if(nombreTabla.equals(nombreProv)) {
            JOptionPane.showMessageDialog(null, "Aztualizando stok...");
            
            int fil = 0;
            if(fila>-1) {
                int codecMoto = Integer.valueOf(tablaMotocicletas.getValueAt(fila, 0).toString());
                
                model.actualizarStockMotocicleta(codecMoto, getMarca(), getModelo(), getColor(), 
                getCodigoCategoria(), getCodigoPedido(), getNombreProveedor(), getCostoMoto(), 
                getStock(), getPrecioVenta());
                
                try {
            PreparedStatement st = conexion.prepareStatement(
                    "UPDATE pedidos SET registrado = 'Si' WHERE codigo_factura = "+cmbListaPedidos.getSelectedItem().toString());
            st.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Motocicleta.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                int itemCount = cmbListaPedidos.getItemCount();
                int i = 0;
                cmbListaPedidos.removeItemAt(i);
                
                mostrarDatosMotos();
                nuevaMoto();
            
        } //fin de if
                
        }
        else {
            JOptionPane.showMessageDialog(null, "Realizando Nuevo Registro");
            model.agregarCompraMoto(getMarca(), getModelo(), getColor(), getCodigoCategoria(), getCodigoPedido(), 
                getNombreProveedor(), getCostoMoto(), getStock(), getPrecioVenta());
            
            actualizarPedidos();
            int itemCount = cmbListaPedidos.getItemCount();
            int i = 0;
            cmbListaPedidos.removeItemAt(i);
        
            nuevaMoto();
            mostrarDatosMotos();
            }
    }//GEN-LAST:event_mnStockActionPerformed

    private void mnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGenerarReporteActionPerformed
        obtenerReporteMillar();
        
    }//GEN-LAST:event_mnGenerarReporteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarDatosMoto;
    public javax.swing.JButton btnCancelarMoto;
    private javax.swing.JButton btnEliminarMoto;
    private javax.swing.JButton btnNuevaMoto;
    public javax.swing.JButton btnRegistrarCompra;
    private javax.swing.JButton btnSalir;
    public javax.swing.JComboBox cmbListaCategoriasMoto;
    public javax.swing.JComboBox cmbListaPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnGenerarReporte;
    public javax.swing.JMenuItem mnStock;
    public javax.swing.JTable tablaMotocicletas;
    public javax.swing.JTextField txtCodigoCategoria;
    public javax.swing.JFormattedTextField txtCodigoMoto;
    public javax.swing.JFormattedTextField txtColorMotocicleta;
    public javax.swing.JTextField txtCostoMoto;
    public javax.swing.JTextField txtGanancia;
    public javax.swing.JFormattedTextField txtMarcaMotocicleta;
    public javax.swing.JFormattedTextField txtModeloMotocicleta;
    public javax.swing.JTextField txtNombreProveedor;
    public javax.swing.JFormattedTextField txtPrecioVentaMoto;
    public javax.swing.JFormattedTextField txtStockMotocicleta;
    // End of variables declaration//GEN-END:variables
}
