package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class MostrarCategoria {
    DataBase dtb = new DataBase();
    Connection conexion = dtb.getConexion();
    public MostrarCategoria() {
    }
    
    //este método va para la vista de agregados...
    //muestra toda la tabla de categorias
    public void mostrarCategoria(DefaultTableModel dtm) {
        String filas[] = new String[2];
        
       //Connection con = dtb.getConexion();
        try {
            Statement st = conexion.createStatement();
            ResultSet rst= st.executeQuery("SELECT*FROM categoria");
            while(rst.next()){
                filas[0]=rst.getString(1);
                filas[1]=rst.getString(2);
                dtm.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MostrarCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //-----
      public DefaultComboBoxModel getListaCategorias() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        try {
            PreparedStatement pstm = conexion.prepareStatement("SELECT * FROM categoria");
            ResultSet reslt = pstm.executeQuery();
            
            while(reslt.next()) {
                combo.addElement(reslt.getString("nombre_categoria"));
                
            }
            reslt.close();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return combo;
    }
}
