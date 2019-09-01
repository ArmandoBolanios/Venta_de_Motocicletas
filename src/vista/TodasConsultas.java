package vista;

public class TodasConsultas extends javax.swing.JFrame {

    
    public TodasConsultas() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new org.edisoncor.gui.panel.Panel();
        btnSalir = new org.edisoncor.gui.button.ButtonIpod();
        btnCategorias = new org.edisoncor.gui.button.ButtonIpod();
        btnProveedores = new org.edisoncor.gui.button.ButtonIpod();
        btnEmpleados = new org.edisoncor.gui.button.ButtonIpod();
        btnPedidos = new org.edisoncor.gui.button.ButtonIpod();
        btnClientes = new org.edisoncor.gui.button.ButtonIpod();
        btnVentas = new org.edisoncor.gui.button.ButtonIpod();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        btnSalir.setForeground(new java.awt.Color(204, 0, 51));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnCategorias.setForeground(new java.awt.Color(255, 102, 0));
        btnCategorias.setText("CATEGORIAS");
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });

        btnProveedores.setForeground(new java.awt.Color(255, 102, 0));
        btnProveedores.setText("PROVEEDORES");
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnEmpleados.setForeground(new java.awt.Color(255, 102, 0));
        btnEmpleados.setText("EMPLEADOS");

        btnPedidos.setForeground(new java.awt.Color(255, 102, 0));
        btnPedidos.setText("PEDIDOS");

        btnClientes.setForeground(new java.awt.Color(255, 102, 0));
        btnClientes.setText("CLIENTES");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnVentas.setForeground(new java.awt.Color(255, 102, 0));
        btnVentas.setText("VENTAS");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Gisha", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(144, 222, 248));
        jLabel1.setText("CONSULTAS");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(114, 114, 114)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(53, 53, 53)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
        );

        getContentPane().add(panel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        ConsultaProveedores prov = new ConsultaProveedores();
        prov.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        ConsultaClientes cliente = new ConsultaClientes();
        cliente.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        ConsultaCategorias categorias = new ConsultaCategorias();
        categorias.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        CorteCaja corte = new CorteCaja();
        corte.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod btnCategorias;
    private org.edisoncor.gui.button.ButtonIpod btnClientes;
    private org.edisoncor.gui.button.ButtonIpod btnEmpleados;
    private org.edisoncor.gui.button.ButtonIpod btnPedidos;
    private org.edisoncor.gui.button.ButtonIpod btnProveedores;
    private org.edisoncor.gui.button.ButtonIpod btnSalir;
    private org.edisoncor.gui.button.ButtonIpod btnVentas;
    private javax.swing.JLabel jLabel1;
    private org.edisoncor.gui.panel.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
