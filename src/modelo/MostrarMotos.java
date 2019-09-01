package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarMotos {
    
    DefaultTableModel dtm = new DefaultTableModel();
    DataBase base = new DataBase();
    Connection conexion = base.getConexion();
    
    public void mostrarMotos(DefaultTableModel dtm) {
        DefaultTableModel tdm;
        //se crea una matriz con filas y columnas que necesitemos ...
        //será enviado tanto la tabla motocicleta como la lista de categorias para 
        //la tabla de motos...
        Object datos[] = new String[12];
        try {
            
            PreparedStatement pstm = conexion.prepareStatement
        ("SELECT * FROM(motocicleta JOIN categoria ON motocicleta.id_cat = categoria.id_cat)"
                + "JOIN pedidos ON pedidos.codigo_factura = motocicleta.codigo_factura");
            ResultSet reslt = pstm.executeQuery();
            
            
            int i=0;
            while(reslt.next()) {
                datos[0] = reslt.getString(1); //codigo moto
                datos[1] = reslt.getString(2); //marca
                datos[2] = reslt.getString(3); //modelo
                datos[3] = reslt.getString(4); //color
                datos[4] = reslt.getString(5); // id_cat
                datos[5] = reslt.getString(6); //codigo factua
                datos[6] = reslt.getString(7); //nombre proveedor
                
                NumberFormat formatter = new DecimalFormat("###,###,##0.00");
                datos[7] = formatter.format(reslt.getDouble(8));
                //datos[7] = reslt.getString(8); //costo unidad
                datos[8] = reslt.getString(9); //stock
                datos[9] = formatter.format(reslt.getDouble(10));
                //datos[9] = reslt.getString(10); //precio venta
                i++;
                dtm.addRow(datos);
            }
            reslt.close();
            
        }catch(SQLException e) {
            Logger.getLogger(MostrarMotos.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DATOS");
        }   
    }   
//---------------------------------------------------------------------------------------
    public DefaultComboBoxModel getListaMotociletas() {
        DefaultComboBoxModel combo = new DefaultComboBoxModel();
        
        try {
            PreparedStatement pstm = conexion.prepareStatement("SELECT * FROM motocicleta");
            ResultSet reslt = pstm.executeQuery();
            
            while(reslt.next()) {
                combo.addElement(reslt.getString("codigo_moto"));
                
            }
            reslt.close();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        
        return combo;
    }

}
