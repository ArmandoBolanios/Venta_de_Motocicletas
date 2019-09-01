package vista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DataBase;

public class ConsultaCategorias extends javax.swing.JFrame {

    DefaultTableModel tablemodel;
    DataBase basedatos = new DataBase();
    Connection conexion = basedatos.getConexion();
    public ConsultaCategorias() {
        initComponents();
    }

    public void buscarCategoria(int ide) {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Id_Categoria*");
        tablemodel.addColumn("Nombre Categoria");
        tablaCategorias.setModel(tablemodel);
        
        String buscar = "";
        if(ide != 0){
            JOptionPane.showMessageDialog(this, "Buscando...");
            buscar = "SELECT * FROM categoria WHERE id_cat =  "+ide+" ";
        }
        
        Object datos[] = new Object[2];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(buscar);
            
            boolean encuentra = false;
            while(rs.next()){
                datos[0]=rs.getInt(1);
                datos[1]=rs.getString(2);
                encuentra = true;
                tablemodel.addRow(datos);
            }
            
            if(encuentra==false) { 
                JOptionPane.showMessageDialog(this, "No existe el registro: "+ ""+txtCodigoCategoria.getText()+"" );
            }
            tablaCategorias.setModel(tablemodel);
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        labelRect1 = new org.edisoncor.gui.label.LabelRect();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        txtCodigoCategoria = new org.edisoncor.gui.textField.TextField();
        btnBuscar = new org.edisoncor.gui.button.ButtonTask();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelRect1.setText("CONSULTA DE CATEGORIAS");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        labelHeader1.setText("Buscar por Código");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(labelRect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRect1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaCategorias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        int codigo = Integer.parseInt(txtCodigoCategoria.getText());
        buscarCategoria(codigo);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        TodasConsultas todas = new TodasConsultas();
        todas.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonTask btnBuscar;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private org.edisoncor.gui.label.LabelRect labelRect1;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JTable tablaCategorias;
    private org.edisoncor.gui.textField.TextField txtCodigoCategoria;
    // End of variables declaration//GEN-END:variables
}
