package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CrearUsuarios {
    DataBase base = new DataBase();
    Connection conexion = base.getConexion();
    
    public void mostrarUsers(DefaultTableModel tablemodel) {
        
        
        Object filas[] = new Object[4];
        
        try {
            Statement st = conexion.createStatement();
            ResultSet rst= st.executeQuery("SELECT * FROM acceso");
            while(rst.next()){
                filas[0]=rst.getInt(1);
                filas[1]=rst.getString(2);
                filas[2]=rst.getString(3);
                filas[3]=rst.getString(4);
                tablemodel.addRow(filas);
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public DefaultComboBoxModel getListaUsuarios() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        try {
            PreparedStatement pstm = conexion.prepareStatement("SELECT * FROM acceso");
            ResultSet reslt = pstm.executeQuery();
            
            while(reslt.next()) {
                combo.addElement(reslt.getString("cargo"));   
            }
            reslt.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return combo;
    }

    public void crearUser(String nombre, String contraseña, String tipo) {
        String sql = "INSERT INTO acceso(nombre,password,cargo)"
                + "VALUES('"+nombre+"','"+contraseña+"','"+tipo+"')";
        
        try {    
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Agregado");
            pst.close();
        }catch(SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
    
    public void modificarUser(int id, String nombre, String contraseña) {
        String sql = "UPDATE acceso SET nombre = ?,"
                + "                   password = ?"
                + "   WHERE           id  = ?";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, nombre);
            pst.setString(2, contraseña);
            pst.setInt(3, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro actualizado");
            pst.close();
        }catch(SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void eliminarUser(int id) {
        try {
            PreparedStatement pst = conexion.prepareStatement
        ("DELETE FROM acceso WHERE id = ?");
            pst.setInt(1, id); 
            pst.execute();
            JOptionPane.showMessageDialog(null, "Eliminando...");
            pst.close();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    }
}
