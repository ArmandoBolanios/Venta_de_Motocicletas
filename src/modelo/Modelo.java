package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Modelo {
    
    DataBase base = new DataBase();
    Connection conexion = base.getConexion();
    
    public void realizarPedido(String fecha, int idProveedor,String nombreProveedor, double costoUnidad,
            int cantidadUnidades, double compraTotal) {
        
        String sql = " INSERT INTO pedidos(fecha_compra, codigo_prov, nombre_prov, costo_unidad, cantidad_unidades,"
                + "compra_total, registrado)"
                
                + "VALUES('"+fecha+"', "+idProveedor+",'"+nombreProveedor+"', "+costoUnidad+","
                + " "+cantidadUnidades+", "+compraTotal+", 'No');";
        try {
            
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Nota Registrada");
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }
//------------------------------------------------------------------------------------------------------------------ 
    public void actualizarPedido(int codigoFactura, String fecha, double costoUnidad,int cantidadUnidades, double compraTotal) {
        String sql = "UPDATE pedidos SET fecha_compra      = ?, "
                + "                  costo_unidad           = ?,"
                + "                  cantidad_unidades      = ?,"
                + "                  compra_total           = ? "
                + "                 WHERE codigo_factura    = ? "
                + "                 AND registrado          = 'No'";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, fecha);
            pst.setDouble(2, costoUnidad);
            pst.setInt(3, cantidadUnidades);
            pst.setDouble(4, compraTotal);
            pst.setInt(5, codigoFactura);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, " Datos Actualizados");
            pst.close();
        }catch(SQLException err) {JOptionPane.showMessageDialog(null, err.getMessage());}
    }
    
    public void eliminarPedido(int codigoFactura) {
        String sentencia = "DELETE FROM pedidos WHERE codigo_factura = ?";
        try {
            PreparedStatement pstm = conexion.prepareStatement(sentencia);
            pstm.setInt(1, codigoFactura);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Eliminando ...");
            pstm.close();
        }catch(SQLException err) {JOptionPane.showMessageDialog(null, err.getMessage());}
    }
//------------------------------------------------------------------------------------------------------------------    
    public void agregarCompraMoto(String marca, String modelo, String color, int idCategoria, int codFactura,
            String nombreProv, double costoMoto, int stock, double preciovt) {
        
             try {
                 
                 String sql = "INSERT INTO motocicleta(marca,modelo,color,id_cat,codigo_factura,nombre_proveedor, costo_unidad,stock,pv_unidad)"
                         + "VALUES('"+marca+"' , '"+modelo+"' , '"+color+"', "+idCategoria+", "+codFactura+", '"+nombreProv+"', "+costoMoto+","
                         + " "+stock+", "+preciovt+")";
                 
            PreparedStatement p = conexion.prepareStatement(sql);
            p.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compra Registrada");
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }

//-------------------------------------------------------------------------------------------------- 
    public void actualizarDatosMoto(int codigo,String marca, String modelo, String color, int idCategoria) {
        
        /*
        int codigo,String marca, String modelo, String color, int idCategoria, int codFactura,
            String nombreProv, double costoMoto, int stock, double preciovt
        */
        String sql = "UPDATE motocicleta SET marca  = ?,    "
                + "modelo                           = ?,    "
                + "color                            = ?,    "
                + "id_cat                           = ?    "
                
                + "WHERE codigo_moto                = ?     ";
        
        try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1,     marca);
        ps.setString(2, modelo);
        ps.setString(3, color);
        ps.setDouble(4, idCategoria);
        
        ps.setInt(5, codigo);
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, " Datos Actualizados");
        ps.close();
    } catch(SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }
//--------------------------------------------------------------------------------------------------    
   public void actualizarStockMotocicleta(int codigoMoto,String marca, String modelo, String color, int idCategoria, int codFactura,
            String nombreProv, double costoMoto, int stock, double preciovt) {
        
        int id = 0;
        String sql = "UPDATE motocicleta set marca = ?,"
                + "modelo = ?,"
                + "color = ?,"
                + "id_cat = ?,"
                + "codigo_factura = ?,"
                + "nombre_proveedor = ?,"
                + "costo_unidad = ?,"
                + "stock = ?,"
                + "pv_unidad = ?"
                + "WHERE codigo_moto = ?";
        
        try {
            Statement st = conexion.createStatement();
            ResultSet res = st.executeQuery("SELECT stock FROM motocicleta where codigo_moto = "  + codigoMoto);
            while(res.next()) {
                id = res.getInt(1);
            }
        }catch(SQLException err) {JOptionPane.showMessageDialog(null, err.getMessage());}
        
        try {
            int stockActual = id + stock;
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.setString(1, marca);
            pstm.setString(2, modelo);
            pstm.setString(3, color);
            pstm.setInt(4, idCategoria);
            pstm.setInt(5, codFactura);
            pstm.setString(6, nombreProv);
            pstm.setDouble(7, costoMoto);
            pstm.setInt(8, stockActual);
            pstm.setDouble(9, preciovt);
            pstm.setInt(10, codigoMoto);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha actualizado el Stock!");
            pstm.close();
        }catch(SQLException ex) {JOptionPane.showMessageDialog(null, ex.getMessage());}
        
        try {
            String actualiza = "UPDATE pedidos SET registrado = 'Si' WHERE codigo_factura = "+idCategoria+" ";
            PreparedStatement pst = conexion.prepareStatement(actualiza);
            pst.executeUpdate();
        }catch(SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
//--------------------------------------------------------------------------------------------------    
    public void eliminarCompraMoto(int id) {
        
        String sql = "DELETE FROM motocicleta where codigo_moto = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Eliminando ...");
            ps.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------------       
    public void generarVenta(int cedula, int idEmpleado, int codigoMoto,
            int cantidadVenta, double precioVenta, double valorTotal, 
            String fechaVenta, JTextField operacion, String marcaMoto) {
        
//insercion de la nueva venta
        try {
            //
            String sql = "INSERT INTO venta(cedula,id_empleado,codigo_moto,cantidad_venta,precio_venta, valor_total,fecha_venta, marca_moto)"
                    + "VALUES("+cedula+", "+idEmpleado+", "+codigoMoto+", "+cantidadVenta+", "+precioVenta+", "+valorTotal+","
                    + " '"+fechaVenta+"' , '"+marcaMoto+"' )";
            
            PreparedStatement pstm = conexion.prepareStatement(sql);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venta Registrada");
            
        } catch(SQLException e){JOptionPane.showMessageDialog(null, e.getMessage());}

        
    } //fin del metodo generarVenta
//--------------------------------------------------------------------------------------------------------------------------------
    
}