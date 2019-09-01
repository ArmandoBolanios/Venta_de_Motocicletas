package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarVenta {
    
    DataBase base = new DataBase();
    Connection conexion = base.getConexion();
    
    public void mostrarVenta(DefaultTableModel tablemodel) {
        Object filas[] = new Object[6];
        
        try {
            
            Statement st = conexion.createStatement();
            ResultSet rst= st.executeQuery("SELECT codigo_venta, cantidad_venta,precio_venta,"
                    + "valor_total, fecha_venta FROM venta");
            while(rst.next()) {
                filas[0] = rst.getInt(1);
                filas[1] = rst.getInt(2);
                filas[2] = rst.getFloat(3);
                filas[3] = rst.getFloat(4);
                filas[4] = rst.getString(5);
                tablemodel.addRow(filas); 
            }
        }catch(SQLException ex){JOptionPane.showMessageDialog(null, ex.getMessage());}
    }
}
