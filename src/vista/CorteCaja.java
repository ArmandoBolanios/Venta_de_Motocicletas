package vista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DataBase;
import modelo.EspecialCorteCaja;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class CorteCaja extends javax.swing.JFrame {

    DefaultTableModel table;// = new DefaultTableModel();
    DataBase basedatos = new DataBase();
    Connection conexion = basedatos.getConexion();
    public CorteCaja() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCorteCaja = new javax.swing.JTable();
        labelHeader2 = new org.edisoncor.gui.label.LabelHeader();
        txtTotal = new org.edisoncor.gui.textField.TextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panel1 = new org.edisoncor.gui.panel.Panel();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        txtFecha1 = new com.toedter.calendar.JDateChooser();
        txtFecha2 = new com.toedter.calendar.JDateChooser();
        btnBuscarVentas = new org.edisoncor.gui.button.ButtonTask();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnGenrarReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaCorteCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCorteCaja);

        labelHeader2.setText("Total   $:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        jLabel3.setText("Del");

        jLabel4.setFont(new java.awt.Font("Lao UI", 0, 14)); // NOI18N
        jLabel4.setText("Al");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        labelHeader1.setText("CORTE  DECAJA");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        btnBuscarVentas.setText("Consultar");
        btnBuscarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarVentasActionPerformed(evt);
            }
        });

        jMenu1.setText("Reportes");

        mnGenrarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blueprint.png"))); // NOI18N
        mnGenrarReporte.setText("Generar");
        mnGenrarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGenrarReporteActionPerformed(evt);
            }
        });
        jMenu1.add(mnGenrarReporte);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addGap(51, 51, 51)
                .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(47, 47, 47)
                .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void buscarVentas(String fecha1, String fecha2) {
        table = new DefaultTableModel();
        table.addColumn("CÓDIGO");
        table.addColumn("CEDULA CLIENTE");
        table.addColumn("CÓDIGO EMPLEADO");
        table.addColumn("CÓDIGO MOTO");
        table.addColumn("CANTIDAD VENTA");
        table.addColumn("PRECIO VENTA");
        table.addColumn("TOTAL");
        table.addColumn("FECHA");
        
        String buscar = "SELECT * FROM venta WHERE (fecha_venta>= '"+fecha1+"' AND fecha_venta<= '"+fecha2+"')";
        Object datos[] = new Object[9];
        try {
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery(buscar);
            while(res.next()) {
            datos[0] = res.getString(1);
            datos[1] = res.getString(2);
            datos[2] = res.getString(3);
            datos[3] = res.getString(4);
            datos[4] = res.getString(5);
            
            NumberFormat formatter = new DecimalFormat("#0.00");
            datos[5] = formatter.format(res.getDouble(6));
            //datos[5] = res.getString(6);
            //datos[6] = res.getString(7);
            datos[6] = formatter.format(res.getDouble(7));
            datos[7] = res.getString(8);
            table.addRow(datos); 
        }
            tablaCorteCaja.setModel(table); 
        }catch(SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void sumarTotal() {
        int filas = table.getRowCount();
        double total = 0;
        for(int i=0; i<filas; i++) {
            total += Double.parseDouble(table.getValueAt(i, 6).toString());
            
            NumberFormat deci = new DecimalFormat("###,###,##0.00");
            String conversion = (String)deci.format(total);
            txtTotal.setText(conversion);
        }
    }
    
    public void getIReport() {
        List lista = new ArrayList();
        for(int i=0; i<tablaCorteCaja.getRowCount(); i++) {
            EspecialCorteCaja corte = new EspecialCorteCaja(
            tablaCorteCaja.getValueAt(i, 0).toString(),
            tablaCorteCaja.getValueAt(i, 1).toString(),
            tablaCorteCaja.getValueAt(i, 2).toString(),
            tablaCorteCaja.getValueAt(i, 3).toString(),
            tablaCorteCaja.getValueAt(i, 4).toString(),
            tablaCorteCaja.getValueAt(i, 5).toString(),
            tablaCorteCaja.getValueAt(i, 6).toString(),
            tablaCorteCaja.getValueAt(i, 7).toString());
            lista.add(corte);
        }
        try{
            JasperReport Reporte = (JasperReport) JRLoader.loadObject("iCorte.jasper");
            Map parametro = new HashMap();
            parametro.put("tot", this.txtTotal.getText());
            JasperPrint print = JasperFillManager.fillReport(Reporte, parametro, new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(print,false);
            
        } catch (JRException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void borrarDatos() {
        int cantidad = tablaCorteCaja.getRowCount();
        if(table.getRowCount()>-1) {
        for(int wer= cantidad-1; wer>=0; wer--)
            table.removeRow(wer);
        }
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        //borrarDatos();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarVentasActionPerformed
        SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/dd");
        String fecha1 = formato.format(txtFecha1.getDate());
        String fecha2 = formato.format(txtFecha2.getDate());
        
        buscarVentas(fecha1,fecha2);
        sumarTotal();
    }//GEN-LAST:event_btnBuscarVentasActionPerformed

    private void mnGenrarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGenrarReporteActionPerformed
        getIReport();
    }//GEN-LAST:event_mnGenrarReporteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonTask btnBuscarVentas;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private org.edisoncor.gui.label.LabelHeader labelHeader2;
    private javax.swing.JMenuItem mnGenrarReporte;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablaCorteCaja;
    private com.toedter.calendar.JDateChooser txtFecha1;
    private com.toedter.calendar.JDateChooser txtFecha2;
    private org.edisoncor.gui.textField.TextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
