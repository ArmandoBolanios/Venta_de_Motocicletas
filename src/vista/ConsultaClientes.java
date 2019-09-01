package vista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.DataBase;

public class ConsultaClientes extends javax.swing.JFrame {
    DataBase basedatos = new DataBase();
    Connection conexion = basedatos.getConexion();
    public ConsultaClientes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        panel1 = new org.edisoncor.gui.panel.Panel();
        btnBuscar = new org.edisoncor.gui.button.ButtonTask();
        rdbGenero = new javax.swing.JRadioButton();
        rdbCodigoCliente = new javax.swing.JRadioButton();
        rdbTodos = new javax.swing.JRadioButton();
        cmbGenero = new org.edisoncor.gui.comboBox.ComboBoxRound();
        txtCodigoCliente = new org.edisoncor.gui.textField.TextField();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaConsultaClientes = new javax.swing.JTable();
        labelHeader2 = new org.edisoncor.gui.label.LabelHeader();
        txtCantidadRegistros = new org.edisoncor.gui.textField.TextField();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setForeground(new java.awt.Color(154, 64, 64));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbGenero);
        rdbGenero.setText("Mostrar Clientes por Género");
        rdbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbGeneroActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbCodigoCliente);
        rdbCodigoCliente.setText("Buscar Clientes por Código");
        rdbCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbCodigoClienteActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdbTodos);
        rdbTodos.setText("Mostrar Todos los Clientes");
        rdbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbTodosActionPerformed(evt);
            }
        });

        cmbGenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "M", "F" }));

        labelHeader1.setText("CONSULTA DE CLIENTES");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(rdbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rdbCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(rdbTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 93, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbGenero)
                            .addComponent(cmbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbCodigoCliente)
                    .addComponent(txtCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbTodos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        tablaConsultaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaConsultaClientes);

        labelHeader2.setBackground(new java.awt.Color(204, 204, 255));
        labelHeader2.setText("Total de Registros");

        txtCantidadRegistros.setBackground(new java.awt.Color(107, 207, 74));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(txtCantidadRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarTablaClientes() {
        DefaultTableModel modelo= new DefaultTableModel();
        String []Titulos = {"CÉDULA","NOMBRES","APELLIDOS","SEXO","TELEFONO","DIRECCIÓN","EMAIL","PAÍS"};
        modelo.setColumnIdentifiers(Titulos);
         tablaConsultaClientes.setModel(modelo);
        try {
            
            String ConsultaSQL="SELECT * FROM cliente";
        
            String []registros= new String[9];
           
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(ConsultaSQL);
            while(rs.next())
            {
                registros[0]=rs.getString("cedula");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellidos");  
                registros[3]=rs.getString("sexo");
                registros[4]=rs.getString("telefono");
                registros[5]=rs.getString("direccion");
                registros[6]=rs.getString("email");
                registros[7]=rs.getString("pais");
                modelo.addRow(registros);
                                
            }
            tablaConsultaClientes.setModel(modelo);
            txtCantidadRegistros.setText(""+tablaConsultaClientes.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String sexo= cmbGenero.getSelectedItem().toString();
        String dni = txtCodigoCliente.getText();
   
   if(rdbGenero.isSelected()==true) {
       
       DefaultTableModel modelo= new DefaultTableModel();
       String []Titulos = {"CÉDULA","NOMBRES","APELLIDOS","SEXO","TELEFONO","DIRECCIÓN","EMAIL","PAÍS"};
       modelo.setColumnIdentifiers(Titulos);
       tablaConsultaClientes.setModel(modelo);
       try {
            
            String consulta = "SELECT * FROM cliente WHERE sexo = '"+sexo+"'";
        
            String []registros= new String[9];
           
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next())
            {
                registros[0]=rs.getString("cedula");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellidos");  
                registros[3]=rs.getString("sexo");
                registros[4]=rs.getString("telefono");
                registros[5]=rs.getString("direccion");
                registros[6]=rs.getString("email");
                registros[7]=rs.getString("pais");
                modelo.addRow(registros);
                                
            }
            tablaConsultaClientes.setModel(modelo);
            txtCantidadRegistros.setText(""+tablaConsultaClientes.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   
   if(rdbCodigoCliente.isSelected()==true) {
       DefaultTableModel modelo= new DefaultTableModel();
       String []Titulos = {"CÉDULA","NOMBRES","APELLIDOS","SEXO","TELEFONO","DIRECCIÓN","EMAIL","PAÍS"};
       modelo.setColumnIdentifiers(Titulos);
       tablaConsultaClientes.setModel(modelo);
       try {
            
            String ConsultaSQL="SELECT * FROM cliente WHERE cedula = '"+dni+"'";
        
            String []registros= new String[9];
           
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(ConsultaSQL);
            while(rs.next())
            {
                registros[0]=rs.getString("cedula");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellidos");  
                registros[3]=rs.getString("sexo");
                registros[4]=rs.getString("telefono");
                registros[5]=rs.getString("direccion");
                registros[6]=rs.getString("email");
                registros[7]=rs.getString("pais");
                modelo.addRow(registros);
                                
            }
            tablaConsultaClientes.setModel(modelo);
            txtCantidadRegistros.setText(""+tablaConsultaClientes.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   if(rdbTodos.isSelected()==true) {
       cargarTablaClientes();
   }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void rdbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbGeneroActionPerformed
        if(rdbGenero.isSelected()==true) {
        cmbGenero.setSelectedItem(0);
        cmbGenero.setEnabled(true);
        txtCodigoCliente.setEnabled(false);
        txtCodigoCliente.setText("");
        }
    }//GEN-LAST:event_rdbGeneroActionPerformed

    private void rdbCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbCodigoClienteActionPerformed
        if(rdbCodigoCliente.isSelected()==true) {
        cmbGenero.setSelectedIndex(0);
        cmbGenero.setEnabled(false);
        txtCodigoCliente.setEnabled(true);
        txtCodigoCliente.requestFocus();
        }
    }//GEN-LAST:event_rdbCodigoClienteActionPerformed

    private void rdbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTodosActionPerformed
        cargarTablaClientes();
        txtCodigoCliente.setText("");
        txtCodigoCliente.setEnabled(false);
    }//GEN-LAST:event_rdbTodosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        TodasConsultas todas = new TodasConsultas();
        todas.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonTask btnBuscar;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private org.edisoncor.gui.comboBox.ComboBoxRound cmbGenero;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private org.edisoncor.gui.label.LabelHeader labelHeader2;
    private org.edisoncor.gui.panel.Panel panel1;
    private javax.swing.JRadioButton rdbCodigoCliente;
    private javax.swing.JRadioButton rdbGenero;
    private javax.swing.JRadioButton rdbTodos;
    private javax.swing.JTable tablaConsultaClientes;
    private org.edisoncor.gui.textField.TextField txtCantidadRegistros;
    private org.edisoncor.gui.textField.TextField txtCodigoCliente;
    // End of variables declaration//GEN-END:variables
}
