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

public class MostrarEmpleado {

    DataBase dtb = new DataBase();
    Connection conexion = dtb.getConexion();
    
    public void mostrarEmpleado(DefaultTableModel dtm) {
        Object filas[] = new Object[11];
        
        //Connection con = dtb.getConexion();
        try {
            Statement st = conexion.createStatement();
            ResultSet rst= st.executeQuery("SELECT * FROM empleado");
            while(rst.next()){
                filas[0]=rst.getInt(1);
                filas[1]=rst.getString(2);
                filas[2]=rst.getString(3);
                filas[3]=rst.getString(4);
                filas[4]=rst.getString(5);
                filas[5]=rst.getString(6);
                filas[6]=rst.getString(7);
                filas[7]=rst.getString(8);
                filas[8]=rst.getFloat(9);
                filas[9]=rst.getInt(10);
                
                dtm.addRow(filas);
            }
        } catch(SQLException e) {
            Logger.getLogger(MostrarEmpleado.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DATOS");
        }
    }
//------------------------------------------------------------------------------------------
    public DefaultComboBoxModel getListaEmpleados() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        try {
            PreparedStatement pstm = conexion.prepareStatement("SELECT * FROM empleado");
            ResultSet reslt = pstm.executeQuery();
            
            while(reslt.next()) {
                combo.addElement(reslt.getString("id_empleado"));
                
            }
            reslt.close();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return combo;
    }
}
