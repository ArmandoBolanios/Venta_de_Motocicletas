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

public class MostrarProveedor {
    
    DataBase dtb = new DataBase();
    Connection conexion = dtb.getConexion();
    
    public void mostrarProveedor(DefaultTableModel dtm) {
        Object titulos[] = new Object[6];
        //Connection con = dtb.getConexion();
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rslt = st.executeQuery(" SELECT * FROM proveedores");
            while(rslt.next()) {
                titulos[0] = rslt.getInt(1);
                titulos[1] = rslt.getString(2);
                titulos[2] = rslt.getString(3);
                titulos[3] = rslt.getString(4);
                titulos[4] = rslt.getString(5);
                
                dtm.addRow(titulos);
            }
        } catch(SQLException ex) {
            Logger.getLogger(MostrarProveedor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DATOS");
        }
    }
    
    public DefaultComboBoxModel getListaProveedores() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        try {
            PreparedStatement pstm = conexion.prepareStatement(
                    "SELECT * FROM proveedores");
            ResultSet reslt = pstm.executeQuery();
            
            while(reslt.next()) {
                combo.addElement(reslt.getString("codigo_prov"));
                
            }
            reslt.close();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return combo;
    }
}
