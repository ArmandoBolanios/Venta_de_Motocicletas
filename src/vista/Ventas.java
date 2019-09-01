package vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.DataBase;
import modelo.EspecialFacturaMoto;
import modelo.EspecialVentas;
import modelo.Modelo;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public final class Ventas extends javax.swing.JFrame {

    DataBase basedatos = new DataBase();
    Connection conexion = basedatos.getConexion();
    DefaultTableModel tablemodel;
    private Modelo model = new Modelo();
    private Motocicleta stock = new Motocicleta();
    private EspecialVentas ev = new EspecialVentas();
    int contador = 0;
    String relleno[];
    int fila = -1;
    
    public Ventas() {
        super("NUEVA VENTA");
        initComponents();
        modeloTabla();
        fechaActual();
        bloquearVenta();
        generarNumeroFactura();
        
        try {
            Statement sta  = conexion.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM motocicleta");
            while(rs.next()) {
                this.cmbListaMotocicletas.addItem(rs.getString("codigo_moto"));
            }
            contador++;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        try {
            Statement sta  = conexion.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM empleado");
            while(rs.next()) {
                this.cmbListaEmpleados.addItem(rs.getString("id_empleado"));
            }
            contador++;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        try {
            Statement sta  = conexion.createStatement();
            ResultSet rs = sta.executeQuery("SELECT * FROM cliente");
            while(rs.next()) {
                this.cmbListaClientes.addItem(rs.getString("cedula"));
            }
            contador++;
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    
//---------------------------------------------------------------------------------------
    public void modeloTabla() {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Cantidad");
        tablemodel.addColumn("Descripción");
        tablemodel.addColumn("Precio Unitario");
        tablemodel.addColumn("Total");
        tablaVentas.setModel(tablemodel);
    }

    public void bloquearVenta() {
        txtFechaVenta.setEnabled(false);
        cmbListaEmpleados.setEnabled(false);
        txtNombreEmpleado.setEnabled(false);
        cmbListaMotocicletas.setEnabled(false);
        txtMarcaMotocicleta.setEnabled(false);
        txtCantidadVenta.setEnabled(false);
        txtTotalMotocicleta.setEnabled(false);
        cmbListaClientes.setEnabled(false);
        txtNombreCliente.setEnabled(false);
        txtTotalGeneral.setEnabled(false);
        txtRecibiMoneda.setEnabled(false);
        txtResultadoCambio.setEnabled(false);
        btnRemoverProducto.setEnabled(false); 
        btnActualizarProducto.setEnabled(false);
        btnFacturar.setEnabled(false); 
        btnCancelarVenta.setEnabled(false);
        btnAgregarALista.setEnabled(false);
    }
    
    public void desbloquearVenta() {
        txtFechaVenta.setEnabled(true);
        cmbListaEmpleados.setEnabled(true);
        txtNombreEmpleado.setEnabled(true);
        cmbListaMotocicletas.setEnabled(true);
        txtMarcaMotocicleta.setEnabled(true);
        txtCantidadVenta.setEnabled(true);
        txtTotalMotocicleta.setEnabled(true);
        cmbListaClientes.setEnabled(true);
        txtNombreCliente.setEnabled(true);
        txtTotalGeneral.setEnabled(true);
        txtRecibiMoneda.setEnabled(true);
        txtResultadoCambio.setEnabled(true);
        btnCancelarVenta.setEnabled(true);
        
    }
//---------------------------------------------------------------------------------------
    public void nuevaVenta() {
        txtNombreEmpleado.setText("");
        txtMarcaMotocicleta.setText("");
        txtCantidadVenta.setText("");
        txtTotalMotocicleta.setText("");
        txtNombreCliente.setText("");
        txtTotalGeneral.setText("");
        txtRecibiMoneda.setText("");
        txtResultadoCambio.setText("");
        txtPrecioUnitario.setText("");
    }
    public void  fechaActual(){
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
        txtFechaVenta.setText(sdf.format(fecha));
    }
//---------------------------------------------------------------------------------------    
    public void generarTotalVentaxMotos(){
        String conversion;
        
        double totalGral = 0;
        double cantidadVT = Float.parseFloat(txtCantidadVenta.getText());
        double precioUN = Float.parseFloat(txtPrecioUnitario.getText());
        double precioProducto = cantidadVT * precioUN;
        
        totalGral = precioProducto;
        
        NumberFormat deci = new DecimalFormat("#0.00");
        conversion = (String)deci.format(totalGral);
        
        txtTotalMotocicleta.setText(conversion);
    }
    
    public void sumarPrecios() {
        //cuenta las filas de una tabla
        int filasumar = tablemodel.getRowCount();
        double sumadora = 0;
        String conversion;
         
        for(int i=0; i<filasumar; i++) {
            //ir sumando en la posicion fila:0-n && columna 3
            sumadora += Double.parseDouble((String)tablemodel.getValueAt(i, 3));
        }   //fin de ciclo
        
        NumberFormat deci = new DecimalFormat("#0.00");
        conversion = (String)deci.format(sumadora);
        //colocar el total en el txt !
        txtTotalGeneral.setText(conversion + " ");
    } //finde método
    
    public void restarPrecios() {
        int filarestar = tablemodel.getRowCount();
        double  sumadora = 0;
        double restadora = 0;
        double resultado = 0;
        String conversion;
         
        for(int i=0; i<filarestar; i++) {
            //obtiene el valor que se esta sumando entre la fila:0-n && columna 3
            sumadora += Double.parseDouble((String)tablemodel.getValueAt(i, 3));
            //una vez obtenido el valor se resta:
            //obteniendo la misma posicion que la suma; aquí abajo
            restadora = Double.parseDouble((String)tablemodel.getValueAt(i, 3)) 
                    -   Double.parseDouble((String)tablemodel.getValueAt(i, 3));
            //éste es el principio de Armand
            resultado = sumadora - restadora;
        }
        
        NumberFormat decimales = new DecimalFormat("#0.00");
        conversion = (String)decimales.format(resultado);
        //el total se mostrará en el txtgeneral
        txtTotalGeneral.setText(conversion);
        
    }
    
    public void removerProducto() {
        //obtiene la seleccion de filas de una tabla
        int datos = tablaVentas.getSelectedRow();
        if(datos>=0) {
            //si cumple la condicion, remueve todos los datos contenidos en una sola fila ----
            tablemodel.removeRow(datos);
        }
        else {
            JOptionPane.showMessageDialog(this, "No seleccionó datos");
        }
    }
    
    public void borrarDatos() {
        //hace conteo de filas en una tabla
        int cantidad = tablaVentas.getRowCount();
        
        //contando desde la tabla y restando 1 unidad
        //cuando el contador es>=0 a su vez se le irán restando
        for(int wer= cantidad-1; wer>=0; wer--)
            tablemodel.removeRow(wer); 
    }
    
    public void generarCambioMoneda() {
        String conversion;
        
        double recibe        = Float.parseFloat(txtRecibiMoneda.getText());
        double totalGeneral  = Float.parseFloat(txtTotalGeneral.getText());
        
        if(totalGeneral>recibe) {
            JOptionPane.showMessageDialog(this, "Dinero Insuficiente!");
        } else {
        
        double totalCambio   = recibe - totalGeneral;
        
        NumberFormat deci = new DecimalFormat("#0.00");
        conversion = (String)deci.format(totalCambio);
        
        txtResultadoCambio.setText(conversion + " ");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbListaMotocicletas = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbListaClientes = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbListaEmpleados = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTotalMotocicleta = new org.edisoncor.gui.textField.TextField();
        txtCantidadVenta = new org.edisoncor.gui.textField.TextField();
        txtPrecioUnitario = new org.edisoncor.gui.textField.TextField();
        txtMarcaMotocicleta = new org.edisoncor.gui.textField.TextField();
        txtNombreCliente = new org.edisoncor.gui.textField.TextField();
        txtNombreEmpleado = new org.edisoncor.gui.textField.TextField();
        txtFechaVenta = new org.edisoncor.gui.textField.TextField();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();
        btnNuevaVenta = new org.edisoncor.gui.button.ButtonIpod();
        jLabel3 = new javax.swing.JLabel();
        btnAgregarALista = new org.edisoncor.gui.button.ButtonAero();
        txtNumeroFactura = new org.edisoncor.gui.textField.TextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        btnRemoverProducto = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtTotalGeneral = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtRecibiMoneda = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtResultadoCambio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnActualizarProducto = new javax.swing.JButton();
        panel1 = new org.edisoncor.gui.panel.Panel();
        btnFacturar = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 255, 204));
        jLabel1.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel1.setText("VENTAS DE MOTOCICLETAS");

        jLabel2.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel2.setText("Fecha de Venta");

        jLabel4.setText("Código Motocicleta");

        cmbListaMotocicletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaMotocicletasActionPerformed(evt);
            }
        });

        jLabel5.setText("Marca Motocicleta");

        jLabel7.setText("Precio Unitario");

        jLabel8.setText("Cantidad Venta");

        jLabel10.setText("Código Cliente");

        cmbListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaClientesActionPerformed(evt);
            }
        });

        jLabel11.setText("Nombre Cliente");

        jLabel16.setText("Código Empleado");

        cmbListaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListaEmpleadosActionPerformed(evt);
            }
        });

        jLabel17.setText("Nombre Empleado");

        jLabel6.setText("Total");

        txtTotalMotocicleta.setEditable(false);
        txtTotalMotocicleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalMotocicletaActionPerformed(evt);
            }
        });

        txtCantidadVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadVentaActionPerformed(evt);
            }
        });

        txtPrecioUnitario.setEditable(false);

        txtMarcaMotocicleta.setEditable(false);

        txtNombreCliente.setEditable(false);

        txtNombreEmpleado.setEditable(false);

        txtFechaVenta.setEditable(false);
        txtFechaVenta.setForeground(new java.awt.Color(0, 102, 255));

        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/error.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnNuevaVenta.setForeground(new java.awt.Color(145, 80, 37));
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Pluma y tintaja.jpg"))); // NOI18N
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        jLabel3.setText("$:");

        btnAgregarALista.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarALista.setForeground(new java.awt.Color(153, 0, 153));
        btnAgregarALista.setText("Agregar a la Lista");
        btnAgregarALista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAListaActionPerformed(evt);
            }
        });

        txtNumeroFactura.setEditable(false);

        jLabel9.setText("Número Factura");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbListaMotocicletas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbListaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8))
                                        .addGap(22, 22, 22))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMarcaMotocicleta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotalMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 102, Short.MAX_VALUE))
                                    .addComponent(btnAgregarALista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(43, 43, 43)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(30, 30, 30)
                                .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 31, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cmbListaEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cmbListaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbListaMotocicletas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtMarcaMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTotalMotocicleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addComponent(btnAgregarALista, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
        );

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaVentas);

        btnRemoverProducto.setText("Remover Producto");
        btnRemoverProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverProductoActionPerformed(evt);
            }
        });

        jLabel13.setText("$:");

        txtTotalGeneral.setEditable(false);
        txtTotalGeneral.setBackground(new java.awt.Color(0, 0, 0));
        txtTotalGeneral.setForeground(new java.awt.Color(68, 196, 228));
        txtTotalGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalGeneralActionPerformed(evt);
            }
        });
        txtTotalGeneral.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalGeneralKeyTyped(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/coins.png"))); // NOI18N
        jLabel14.setText("Importe");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtRecibiMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecibiMonedaActionPerformed(evt);
            }
        });
        txtRecibiMoneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRecibiMonedaKeyTyped(evt);
            }
        });

        jLabel15.setText("$:");

        txtResultadoCambio.setEditable(false);
        txtResultadoCambio.setBackground(new java.awt.Color(0, 0, 0));
        txtResultadoCambio.setForeground(new java.awt.Color(0, 255, 255));
        txtResultadoCambio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtResultadoCambioKeyTyped(evt);
            }
        });

        jLabel12.setText("Total");

        jLabel18.setText("Su Cambio");

        btnActualizarProducto.setText("Actualizar Producto");
        btnActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProductoActionPerformed(evt);
            }
        });

        btnFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/doc_pdf.png"))); // NOI18N
        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });

        btnCancelarVenta.setText("Cancelar Venta");
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFacturar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarVenta)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(btnFacturar)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(btnCancelarVenta)
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemoverProducto)
                        .addGap(99, 99, 99)
                        .addComponent(btnActualizarProducto)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtResultadoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(77, 77, 77)
                        .addComponent(txtRecibiMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemoverProducto)
                        .addComponent(jLabel13)
                        .addComponent(txtTotalGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnActualizarProducto))
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtRecibiMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(txtResultadoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void rellenarTablaVentas() {
     relleno =new String[4];
     relleno[0] = txtCantidadVenta.getText();
     relleno[1] = txtMarcaMotocicleta.getText();
     relleno[2] = txtPrecioUnitario.getText();
     relleno[3] = txtTotalMotocicleta.getText();
     tablemodel.addRow(relleno);
     tablaVentas.setModel(tablemodel);
     
 }

 public int getCedulaCliente() {
     int cedulaCliente   = Integer.parseInt(cmbListaClientes.getSelectedItem().toString());
     ev.setCedulaCliente(cedulaCliente);
     int suCedula = ev.getCedulaCliente();
     return suCedula;
 }
 
 public int getIdEmpleado() {
     int idEmpleado      = Integer.parseInt(cmbListaEmpleados.getSelectedItem().toString());
     ev.setIdEmpleado(idEmpleado);
     int suIdEmpleado = ev.getIdEmpleado();
     return suIdEmpleado;
 }
 
 public int getCodigoMotocicleta() {
     int codigoMoto  = Integer.parseInt(cmbListaMotocicletas.getSelectedItem().toString());
     ev.setCodigoMoto(codigoMoto);
     int suCodigoMoto = ev.getCodigoMoto();
     return suCodigoMoto;
 }
 
 public String getMarcaMotocicleta() {
     String marcaMoto   = txtMarcaMotocicleta.getText();
     ev.setMarcaMoto(marcaMoto);
     String suMarca = ev.getMarcaMoto();
     return suMarca;
 }
 
 public int getCantidadMotocicleta() {
     //--->es para tener la venta que se esta yendo
        int cantidadVenta = tablemodel.getRowCount();
        int ventasRegistradas = 0;
        //se posiciona solo en la columna 0 y fila 0-n
        //irá sumando de acuerdo a la cantidad de motos que se estén registrando
        for(int i=0; i<cantidadVenta; i++) {
            ventasRegistradas += Integer.parseInt(tablemodel.getValueAt(i, 0).toString());
        }
        return ventasRegistradas;
 }
 
 public double getPrecioMotocicleta() {
     double precioMoto    = Double.parseDouble(txtPrecioUnitario.getText());
     ev.setPrecioVenta(precioMoto);
     double suPrecioVenta = ev.getPrecioVenta();
     return suPrecioVenta;
 }
 
 public double getPrecioTotal() {
     double precioGral   = Double.parseDouble(txtTotalGeneral.getText());
     ev.setPrecioGral(precioGral);
     double suPrecioGral = ev.getPrecioGral();
     return suPrecioGral;
 }
 
 public String getFechaVenta() {
     String fecha = txtFechaVenta.getText();
     ev.setFecha(fecha);
     String suFecha = ev.getFecha();
     return suFecha;
 }
 
 public JTextField getOperacion() {
     return txtCantidadVenta;
 }
 
 public void verCantidadEmpleado() {
     //<--empieza contador para ver que cantidad de motocicletas ha vendido el empleado
        int filaempleado = tablemodel.getRowCount();
        int sumadora = 0; 
        try {//--->
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery("SELECT motos_vendidas FROM empleado WHERE id_empleado = "+getIdEmpleado()+"");
            while(rs.next()) {
                //se posiciona desde el gestor en la columna de motos_vendidas
                //en este caso el empleado tiene tal cantidad de U.Vendidas
                sumadora = rs.getInt(1);
            }
        }catch(SQLException ex) {JOptionPane.showMessageDialog(null, ex.getMessage());}
        //<---
        
        try {//--->
            for(int i=0; i<filaempleado; i++) {
            //empieza la suma posicionandose en la fila 0-n && columna 0
            //ésta cantidad  se le irán sumando al empleado
            sumadora += Integer.parseInt(tablemodel.getValueAt(i, 0).toString());
            }
        
        String updateEmpleado = "UPDATE empleado SET motos_vendidas =  "+sumadora+" WHERE id_empleado = "+getIdEmpleado()+"";
        PreparedStatement pst = conexion.prepareStatement(updateEmpleado);
        pst.executeUpdate();
        }catch(SQLException err){JOptionPane.showMessageDialog(null, err.getMessage());}
        //<---aqui termina del chequeo del empleado con su cantidad de motos vendidas
 }
 
 public void actualizarParaMotocicletas() {
     //esto es para actualizar el stock de la motocicleta!
     int id          = 0;
     int cantidad    = 0; 
     
     try {
         
         Statement st = conexion.createStatement();
         ResultSet rs = st.executeQuery("SELECT codigo_moto, stock  FROM motocicleta WHERE codigo_moto = "+getCodigoMotocicleta()+" ");
         while(rs.next()){
             id = rs.getInt(1);
             cantidad = rs.getInt(2);
         }
     } catch (SQLException ex) {
         Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
     }

     try {
         
         int restar      = Integer.parseInt(txtCantidadVenta.getText());
         int actual      = cantidad - restar;
         if(actual==5) {JOptionPane.showMessageDialog(null, "Se esta quedando sin motocicletas!"
                 + "\nLe sugiero comprar más motos");
         }
         
         //se hace la actualizacion de motos porque se han vendido
         
         String sqlUpdateMoto  = "UPDATE motocicleta SET stock = "+actual+" WHERE codigo_moto = " + id;
         PreparedStatement pst = conexion.prepareStatement(sqlUpdateMoto);
         pst.executeUpdate();
     }catch(SQLException err) {JOptionPane.showMessageDialog(null, err.getMessage());}
     //aqui termina el chequeo del stock
     
 }
 
 public void getIReport(){
     DecimalFormat formateador = new DecimalFormat("###,###,##0.00");
     //-->>Empeiza el reporte
        List lista = new ArrayList();
        for(int j=0; j<tablaVentas.getRowCount(); j++) {//inicia for
            //-->instanciamos la clase
            double ecio = Double.valueOf(tablaVentas.getValueAt(j, 2).toString());
            double total = Double.valueOf(tablaVentas.getValueAt(j, 3).toString());
            
            String obtenerpre = formateador.format(ecio);
            String obtotal = formateador.format(total); 
            
            EspecialFacturaMoto listaventas = new EspecialFacturaMoto(
                    tablaVentas.getValueAt(j, 0).toString(),
                    tablaVentas.getValueAt(j, 1).toString(),
                    
                    obtenerpre,
                    obtotal);
            lista.add(listaventas);
        } //termina for
   
        try{
            JasperReport Reporte = (JasperReport) JRLoader.loadObject("Factura.jasper");
            Map parametro = new HashMap();
            
           
            double mostrarmoneda = Double.parseDouble(txtRecibiMoneda.getText());
            //double moneda = mostrarmoneda;
            double mostrarcambio = Double.parseDouble(txtResultadoCambio.getText());
            //double cambio = mostrarcambio;
            double mostrartotal =  Double.parseDouble(txtTotalGeneral.getText());
            //double total = mostrartotal;
            /*
            /*
            double amount = 2192.015;
  NumberFormat formatter = new DecimalFormat("#0.00");
  System.out.println("El valor decimal es:"+formatter.format(amount));
            */
            
            //FORMATEO
            String paramMoneda = (formateador.format(mostrarmoneda));
            String paramCambio = formateador.format(mostrarcambio);
            String paramTotal = formateador.format(mostrartotal);
            
            parametro.put("importe", paramMoneda);
            parametro.put("cambio", paramCambio);
            parametro.put("total", paramTotal);
            
            //parametro.put("importe", this.txtRecibiMoneda.getText());
            //parametro.put("cambio", this.txtResultadoCambio.getText());
            //parametro.put("total", this.txtTotalGeneral.getText());
            parametro.put("numeroFactura", this.txtNumeroFactura.getText());
            JasperPrint print = JasperFillManager.fillReport(Reporte, parametro, new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(print,false);
            
        } catch (JRException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        //---<termina factura
 }
 
 public void generarNumeroFactura() {
     int contarFilas = 0;
     int ultimoId = 0;
     try {
         Statement st = conexion.createStatement();
         ResultSet reslt = st.executeQuery("SELECT COUNT(*) FROM venta");
         while(reslt.next()) {
             contarFilas = reslt.getInt(1);
         }
         if(contarFilas == 0) {
             txtNumeroFactura.setText("1");
         }
         else {
             ResultSet res = st.executeQuery(
                     "SELECT codigo_venta FROM venta ORDER BY codigo_venta DESC LIMIT 1");
             while(res.next()) {
                 ultimoId = res.getInt(1);
             }
             int idActual = ultimoId + 1;
             txtNumeroFactura.setText(Integer.toString(idActual));
         } 
     }catch(SQLException err){JOptionPane.showMessageDialog(null, err.getMessage());}
 }
    private void cmbListaMotocicletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaMotocicletasActionPerformed
        // TODO add your handling code here:
        try {
            String sql = " SELECT * FROM motocicleta where codigo_moto = '"+this.cmbListaMotocicletas.getSelectedItem()+"' ";
            txtCantidadVenta.setText("");
            txtTotalMotocicleta.setText(""); 
            if(this.contador>0) {
            Statement state = conexion.createStatement();
            ResultSet result = state.executeQuery(sql);
            result.next();
            this.txtMarcaMotocicleta.setText(String.valueOf(result.getString("marca")));
            this.txtPrecioUnitario.setText(String.valueOf(result.getFloat("pv_unidad")));
            }
            
            }catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_cmbListaMotocicletasActionPerformed

    private void cmbListaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaEmpleadosActionPerformed
        // TODO add your handling code here:
        try {
            String sql = " SELECT * FROM empleado where id_empleado = '"+this.cmbListaEmpleados.getSelectedItem()+"' ";
            if(this.contador>0) {
            Statement state = conexion.createStatement();
            ResultSet result = state.executeQuery(sql);
            result.next();
            this.txtNombreEmpleado.setText(String.valueOf(result.getString("nombre") + " "  + result.getString("apellidos")));
            }
            cmbListaEmpleados.setEnabled(false); 
            }catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_cmbListaEmpleadosActionPerformed

    private void cmbListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListaClientesActionPerformed
        // TODO add your handling code here:
        try {
            String sql = " SELECT * FROM cliente where cedula = '"+this.cmbListaClientes.getSelectedItem()+"' ";
            if(this.contador>0) {
            Statement state = conexion.createStatement();
            ResultSet result = state.executeQuery(sql);
            result.next();
            this.txtNombreCliente.setText(String.valueOf(result.getString("nombre") + " "  + result.getString("apellidos")));
            }
            cmbListaClientes.setEnabled(false); 
            }catch(SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_cmbListaClientesActionPerformed

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        if(txtNombreEmpleado.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Hace falta el nombre del Empleado");
            this.txtNombreEmpleado.requestFocus();
            return;
        } 
        if(txtNombreCliente.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta el nombre del Cliente");
            this.txtNombreCliente.requestFocus();
            return;
        }
        if(txtMarcaMotocicleta.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta la marca de la motocicleta");
            this.txtMarcaMotocicleta.requestFocus();
            return;
        }
        if(txtCantidadVenta.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Escriba la cantidad a vender");
            txtCantidadVenta.requestFocus();
            return;
        }
        
        if(txtRecibiMoneda.getText().length()==0) {
            JOptionPane.showMessageDialog(rootPane, "Hace falta su importe");
            this.txtRecibiMoneda.requestFocus();
            return;
        }
        
        model.generarVenta(getCedulaCliente(), getIdEmpleado(), getCodigoMotocicleta(),
                getCantidadMotocicleta(), getPrecioMotocicleta(), getPrecioTotal(), getFechaVenta(),
                txtCantidadVenta, getMarcaMotocicleta());
        
        verCantidadEmpleado();
        getIReport();
        nuevaVenta();
        generarNumeroFactura();
        bloquearVenta();
        borrarDatos();
        btnSalir.setEnabled(true);
        btnNuevaVenta.setEnabled(true); 
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        // TODO add your handling code here:
        this.cmbListaEmpleados.setEnabled(true);
        this.cmbListaClientes.setEnabled(true);
        btnAgregarALista.setEnabled(false);
        btnFacturar.setEnabled(false);
        borrarDatos();
        nuevaVenta();
    }//GEN-LAST:event_btnCancelarVentaActionPerformed

    private void txtTotalGeneralKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalGeneralKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(txtTotalGeneral.getText().length()>=20) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtTotalGeneralKeyTyped

    private void txtRecibiMonedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibiMonedaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(txtRecibiMoneda.getText().length()>=20) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtRecibiMonedaKeyTyped

    private void txtResultadoCambioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtResultadoCambioKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(txtResultadoCambio.getText().length()>=20) evt.consume();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtResultadoCambioKeyTyped

    private void btnRemoverProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverProductoActionPerformed
        removerProducto();
        restarPrecios();
    }//GEN-LAST:event_btnRemoverProductoActionPerformed

    private void txtTotalGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalGeneralActionPerformed
      
    }//GEN-LAST:event_txtTotalGeneralActionPerformed

    private void txtRecibiMonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecibiMonedaActionPerformed
        btnFacturar.setEnabled(true);
        generarCambioMoneda();
    }//GEN-LAST:event_txtRecibiMonedaActionPerformed

    private void btnActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProductoActionPerformed
        if(fila>-1) {
            
            
            String cantidad = txtCantidadVenta.getText();
            String importe  = txtTotalMotocicleta.getText();
            
            tablaVentas.setValueAt(cantidad, fila, 0);
            tablaVentas.setValueAt(importe, fila, 3);
          
            sumarPrecios();
            
        }
    }//GEN-LAST:event_btnActualizarProductoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        nuevaVenta();
        borrarDatos();
        bloquearVenta();
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        nuevaVenta();
        desbloquearVenta();
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void txtCantidadVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadVentaActionPerformed
        btnAgregarALista.setEnabled(true);
        int motos = Integer.parseInt(stock.txtStockMotocicleta.getText());
        int  stockMotocicleta = motos;
//        int codigoMoto = Integer.parseInt(stock.txtCodigoMoto.getText());
        
        try {   //se hace una consulta para saber que cantidad hay en la tabla motocicletas
            //se puede saber solo seleccionando el codigo de la Motocicleta
            String sql = "SELECT stock FROM motocicleta WHERE codigo_moto = "+cmbListaMotocicletas.getSelectedItem()+" ";
            Statement state = conexion.createStatement();
            ResultSet result = state.executeQuery(sql);
            
            //se pide la cantidad a vender 
            int pideCantidad = Integer.parseInt(txtCantidadVenta.getText());
            
            while(result.next()) {
                //se hace una consulta pidiendo el stock de acuerdo con el codigo-Motocicleta
                stockMotocicleta = result.getInt(1);
                
                if(stockMotocicleta>=pideCantidad){
                    generarTotalVentaxMotos();
                } //termina condicón de if
                else {JOptionPane.showMessageDialog(null, "Es demasiado \nNo hay suficientes motocicletas");}
            } // termina ciclo while que contiene el result.next()
            
        }catch(SQLException ex){JOptionPane.showMessageDialog(null, ex.getMessage());} 
    }//GEN-LAST:event_txtCantidadVentaActionPerformed

    private void tablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaVentasMouseClicked
        fila = tablaVentas.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            txtCantidadVenta.setText(String.valueOf(tablaVentas.getValueAt(fila, 0)));
        }
        
    }//GEN-LAST:event_tablaVentasMouseClicked

    private void txtTotalMotocicletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalMotocicletaActionPerformed
        rellenarTablaVentas();
        sumarPrecios();
    }//GEN-LAST:event_txtTotalMotocicletaActionPerformed

    private void btnAgregarAListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAListaActionPerformed
        btnRemoverProducto.setEnabled(true);
        btnActualizarProducto.setEnabled(true);
        btnSalir.setEnabled(false);
        btnNuevaVenta.setEnabled(false);
        btnCancelarVenta.setEnabled(false); 
        rellenarTablaVentas();
        sumarPrecios();
        actualizarParaMotocicletas();
    }//GEN-LAST:event_btnAgregarAListaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarProducto;
    private org.edisoncor.gui.button.ButtonAero btnAgregarALista;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnFacturar;
    private org.edisoncor.gui.button.ButtonIpod btnNuevaVenta;
    public javax.swing.JButton btnRemoverProducto;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    public javax.swing.JComboBox cmbListaClientes;
    public javax.swing.JComboBox cmbListaEmpleados;
    public javax.swing.JComboBox cmbListaMotocicletas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablaVentas;
    public org.edisoncor.gui.textField.TextField txtCantidadVenta;
    private org.edisoncor.gui.textField.TextField txtFechaVenta;
    private org.edisoncor.gui.textField.TextField txtMarcaMotocicleta;
    private org.edisoncor.gui.textField.TextField txtNombreCliente;
    private org.edisoncor.gui.textField.TextField txtNombreEmpleado;
    private org.edisoncor.gui.textField.TextField txtNumeroFactura;
    public org.edisoncor.gui.textField.TextField txtPrecioUnitario;
    private javax.swing.JTextField txtRecibiMoneda;
    private javax.swing.JTextField txtResultadoCambio;
    public javax.swing.JTextField txtTotalGeneral;
    public org.edisoncor.gui.textField.TextField txtTotalMotocicleta;
    // End of variables declaration//GEN-END:variables
}
