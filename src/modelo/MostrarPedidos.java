package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarPedidos {
    
    DataBase base = new DataBase();
    Connection conexion = base.getConexion();
    
    public void mostrarCompras(DefaultTableModel dtm) {
        Object datos[] = new Object[9];
        
        try { 
           String sql      = "SELECT * FROM pedidos";
           Statement st    = conexion.createStatement();
           ResultSet reslt = st.executeQuery(sql);
           
           int iterador = 0;
           while(reslt.next()) {
               datos[0] = reslt.getInt(1);
               datos[1] = reslt.getString(2);
               datos[2] = reslt.getInt(3);
               datos[3] = reslt.getString(4);
               datos[4] = reslt.getDouble(5);
               datos[5] = reslt.getInt(6);
               
               NumberFormat formatter = new DecimalFormat("###,###,##0.00");
               datos[6] = formatter.format(reslt.getDouble(7));
               //datos[6] = reslt.getDouble(7);
               datos[7] = reslt.getString(8);
               iterador++;
               dtm.addRow(datos);
           }
        }catch(SQLException ex) {
            Logger.getLogger(MostrarPedidos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
//----------------------------------------------------------------------------------------------------------
    public DefaultComboBoxModel getListaCompras() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        try {
            PreparedStatement pstm = conexion.prepareStatement(
                    "SELECT * FROM pedidos WHERE registrado = 'No'");
            ResultSet reslt = pstm.executeQuery();
            
            while(reslt.next()) {
                combo.addElement(reslt.getString("codigo_factura"));
                
            }
            reslt.close();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return combo;
    }
    
}
