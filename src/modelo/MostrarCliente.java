package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarCliente {
    DataBase dtb = new DataBase();
    Connection conexion = dtb.getConexion();
    
    public void mostrarTablaCliente(DefaultTableModel dtm) {
        Object filas[] = new Object[9];
        
        //Connection con = dtb.getConexion();
        try {
            Statement st = conexion.createStatement();
            ResultSet rst= st.executeQuery("SELECT * FROM cliente");
            while(rst.next()){
                filas[0]=rst.getInt(1);
                filas[1]=rst.getString(2);
                filas[2]=rst.getString(3);
                filas[3]=rst.getString(4);
                filas[4]=rst.getString(5);
                filas[5]=rst.getString(6);
                filas[6]=rst.getString(7);
                filas[7]=rst.getString(8);
                dtm.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MostrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DATOS");
        }     
    }
//---------------------------------------------------------------------------------------------------------    
    public DefaultComboBoxModel getListaClientes() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        try {
            PreparedStatement pstm = conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet reslt = pstm.executeQuery();
            
            while(reslt.next()) {
                combo.addElement(reslt.getString("cedula"));
                
            }
            reslt.close();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return combo;
    }
}
