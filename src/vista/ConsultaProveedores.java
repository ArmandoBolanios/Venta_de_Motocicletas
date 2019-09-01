package vista;

public class ConsultaProveedores extends javax.swing.JFrame {

    public ConsultaProveedores() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelImageReflect1 = new org.edisoncor.gui.panel.PanelImageReflect();
        labelRect1 = new org.edisoncor.gui.label.LabelRect();
        rdbCodigo = new javax.swing.JRadioButton();
        rdbRazonSocial = new javax.swing.JRadioButton();
        buttonIpod1 = new org.edisoncor.gui.button.ButtonIpod();
        txtCodigo = new org.edisoncor.gui.textField.TextField();
        btnBuscar = new org.edisoncor.gui.button.ButtonTask();
        cmbCorreos = new org.edisoncor.gui.comboBox.ComboBoxRect();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        txtCantidadRegistros = new org.edisoncor.gui.textField.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImageReflect1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botones.jpg"))); // NOI18N

        labelRect1.setText("CONSULTA DE PROVEEDORES");
        panelImageReflect1.add(labelRect1);
        labelRect1.setBounds(450, 20, 210, 17);

        buttonGroup1.add(rdbCodigo);
        rdbCodigo.setText("Buscar por Código");
        rdbCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/key.png"))); // NOI18N
        panelImageReflect1.add(rdbCodigo);
        rdbCodigo.setBounds(50, 170, 200, 25);

        buttonGroup1.add(rdbRazonSocial);
        rdbRazonSocial.setText("Buscar por Correo Electrónico");
        rdbRazonSocial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        panelImageReflect1.add(rdbRazonSocial);
        rdbRazonSocial.setBounds(50, 220, 200, 25);

        buttonIpod1.setText("Salir");
        buttonIpod1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIpod1ActionPerformed(evt);
            }
        });
        panelImageReflect1.add(buttonIpod1);
        buttonIpod1.setBounds(600, 40, 73, 76);
        panelImageReflect1.add(txtCodigo);
        txtCodigo.setBounds(320, 170, 130, 21);

        btnBuscar.setText("Buscar");
        panelImageReflect1.add(btnBuscar);
        btnBuscar.setBounds(462, 184, 210, 60);

        cmbCorreos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "@hotmail.com", "@gmail.com", "@yahoo.com" }));
        panelImageReflect1.add(cmbCorreos);
        cmbCorreos.setBounds(320, 220, 130, 20);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        labelHeader1.setText("Registros Encontrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImageReflect1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(txtCantidadRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImageReflect1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidadRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIpod1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIpod1ActionPerformed
        TodasConsultas todas = new TodasConsultas();
        todas.setVisible(true);
        dispose();
    }//GEN-LAST:event_buttonIpod1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonTask btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.edisoncor.gui.button.ButtonIpod buttonIpod1;
    private org.edisoncor.gui.comboBox.ComboBoxRect cmbCorreos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.edisoncor.gui.label.LabelHeader labelHeader1;
    private org.edisoncor.gui.label.LabelRect labelRect1;
    private org.edisoncor.gui.panel.PanelImageReflect panelImageReflect1;
    private javax.swing.JRadioButton rdbCodigo;
    private javax.swing.JRadioButton rdbRazonSocial;
    private org.edisoncor.gui.textField.TextField txtCantidadRegistros;
    private org.edisoncor.gui.textField.TextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
