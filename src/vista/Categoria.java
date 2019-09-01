package vista;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.DataBase;
import modelo.Entidades;
import modelo.MostrarCategoria;

public final class Categoria extends javax.swing.JFrame {  
    private final Entidades modelo  = new Entidades();
    private DefaultTableModel tablemodel;
    DataBase  basedatos = new DataBase();
    Connection conexion = basedatos.getConexion();
    int fila = -1;
    
    public Categoria() {
        super("ADMINISTRACIÓN DE CATEGORIAS");
        initComponents();
        bloquearCategoria();
    }
    
//------------------------------------------------------------------------------
    public void mostrarDatosCategoria() {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Código Categoria");
        tablemodel.addColumn("Nombre Categoria");
        
        MostrarCategoria vercategoria     = new MostrarCategoria();
        tablaCategorias.setModel(tablemodel);
        vercategoria.mostrarCategoria(tablemodel);                
    }

    public void buscarCategoria(int ide) {
        tablemodel = new DefaultTableModel();
        tablemodel.addColumn("Id_Categoria");
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
                JOptionPane.showMessageDialog(this, "No existe el registro: "+ ""+txtBuscar.getText()+"" );
            }
            tablaCategorias.setModel(tablemodel);
        } catch (SQLException ex) {
            Logger.getLogger(Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void bloquearCategoria() {
        txtNombreCategoria.setEnabled(false);
        btnAgregarCategoria.setEnabled(false);
        btnActualizarCategoria.setEnabled(false);
        btnEliminarCategoria.setEnabled(false);
        txtBuscar.setEnabled(false);
        btnBuscarCategoria.setEnabled(false);
        btnMostrarTablaCategoria.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
    
    public void desbloquearCategoria() {
        txtNombreCategoria.setEnabled(true);
        btnAgregarCategoria.setEnabled(true);
        
        btnMostrarTablaCategoria.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    private void nuevaCategoria() {
        txtCodigo.setText("");
        txtNombreCategoria.setText("");
        txtBuscar.setText(""); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAgregarCategoria = new javax.swing.JButton();
        btnActualizarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();
        btnNuevaCategoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscarCategoria = new javax.swing.JButton();
        btnMostrarTablaCategoria = new javax.swing.JButton();
        btnSalirCategoria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCategorias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        mnSalir = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel3.setText("Nombre Categoria");

        jLabel4.setText("Código Categoria");

        txtNombreCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        txtNombreCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCategoriaKeyTyped(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        btnCancelar.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(btnCancelar)
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAgregarCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnAgregarCategoria.setText("Agregar");
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        btnActualizarCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnActualizarCategoria.setText("Actualizar");
        btnActualizarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCategoriaActionPerformed(evt);
            }
        });

        btnEliminarCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnEliminarCategoria.setText("Eliminar");
        btnEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCategoriaActionPerformed(evt);
            }
        });

        btnNuevaCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnNuevaCategoria.setText("Nuevo");
        btnNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCategoriaActionPerformed(evt);
            }
        });

        jLabel2.setText(">>");

        txtBuscar.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N

        btnBuscarCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnBuscarCategoria.setText("Buscar");
        btnBuscarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCategoriaActionPerformed(evt);
            }
        });

        btnMostrarTablaCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnMostrarTablaCategoria.setText("Mostrar Tabla");
        btnMostrarTablaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTablaCategoriaActionPerformed(evt);
            }
        });

        btnSalirCategoria.setFont(new java.awt.Font("Lao UI", 0, 12)); // NOI18N
        btnSalirCategoria.setText("Salir");
        btnSalirCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirCategoriaActionPerformed(evt);
            }
        });

        tablaCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCategoriasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCategorias);

        jLabel1.setText("Registro de nueva categoria");

        jMenu2.setText("Salir");

        mnSalir.setText("Ok");
        mnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSalirActionPerformed(evt);
            }
        });
        jMenu2.add(mnSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarTablaCategoria)
                            .addComponent(btnEliminarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(169, 169, 169))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalirCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaCategoria)
                    .addComponent(btnSalirCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarCategoria)
                    .addComponent(btnActualizarCategoria)
                    .addComponent(btnEliminarCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscarCategoria)
                    .addComponent(btnMostrarTablaCategoria)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        if(txtNombreCategoria.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar el nombre");
        txtNombreCategoria.requestFocus();
        return;
        }
        
        modelo.agregarCategoria(txtNombreCategoria.getText() );
        mostrarDatosCategoria();
        nuevaCategoria();
        
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        
        int respuesta;
        respuesta=JOptionPane.showConfirmDialog(null, "¿Eliminar Categoria?","Pregunta",0);
        
        if(respuesta==0) {
        if(fila>-1) {
            //TIENE QUE LEER LA POSICION COMO UN ENTERO NO COMO 'STRING' DESPUES LO CONVIERTE!
            int numero = Integer.valueOf(tablaCategorias.getValueAt(fila, 0).toString());
            modelo.eliminarCategoria(numero);
            mostrarDatosCategoria();
            fila=-1;
        }
        }
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void btnActualizarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCategoriaActionPerformed
        
        if(fila>-1) {
            int numero = Integer.valueOf(tablaCategorias.getValueAt(fila, 0).toString());
            String nombre = txtNombreCategoria.getText();
            modelo.actualizarCategoria(numero, nombre);
            mostrarDatosCategoria();
        } //finde if
    }//GEN-LAST:event_btnActualizarCategoriaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        mostrarDatosCategoria();
        nuevaCategoria();
    }//GEN-LAST:event_formWindowOpened

    private void btnNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaActionPerformed
        // TODO add your handling code here:
        desbloquearCategoria();
        nuevaCategoria();
    }//GEN-LAST:event_btnNuevaCategoriaActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void btnBuscarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCategoriaActionPerformed
        int codigo = Integer.parseInt(txtBuscar.getText());
        buscarCategoria(codigo);
    }//GEN-LAST:event_btnBuscarCategoriaActionPerformed

    private void btnMostrarTablaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTablaCategoriaActionPerformed
        mostrarDatosCategoria();
    }//GEN-LAST:event_btnMostrarTablaCategoriaActionPerformed

    private void btnSalirCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirCategoriaActionPerformed
        // TODO add your handling code here:
        nuevaCategoria();
        bloquearCategoria();
        dispose();
    }//GEN-LAST:event_btnSalirCategoriaActionPerformed

    private void txtNombreCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCategoriaKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCategoriaKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        nuevaCategoria();
        btnActualizarCategoria.setEnabled(false);
        btnEliminarCategoria.setEnabled(false);
        txtBuscar.setEnabled(false);
        btnBuscarCategoria.setEnabled(false);
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tablaCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriasMouseClicked
        // TODO add your handling code here:
        desbloquearCategoria();
        btnAgregarCategoria.setEnabled(false); 
        btnActualizarCategoria.setEnabled(true);
        btnEliminarCategoria.setEnabled(true);
        txtBuscar.setEnabled(true);
        btnBuscarCategoria.setEnabled(true);
        fila = tablaCategorias.rowAtPoint(evt.getPoint());
        if(fila>-1) {
            txtCodigo.setText(String.valueOf(tablaCategorias.getValueAt(fila, 0)));
            txtNombreCategoria.setText(String.valueOf(tablaCategorias.getValueAt(fila, 1)));
        }
    }//GEN-LAST:event_tablaCategoriasMouseClicked

    private void mnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSalirActionPerformed
        nuevaCategoria();
        bloquearCategoria();
        dispose();
    }//GEN-LAST:event_mnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarCategoria;
    public javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnBuscarCategoria;
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnMostrarTablaCategoria;
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.JButton btnSalirCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnSalir;
    public javax.swing.JTable tablaCategorias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables

    
}
