package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
LA CLASE 'Entidades' tiene las consultas y sus métodos son llamados por el
JFrame: 'Principal' ,'Categoria', EL CUAL HACEN SU USO
*/
public class Entidades {
    
    DataBase base = new DataBase();
    Connection conexion = base.getConexion();
    
    private final DefaultTableModel tablamodelo = new DefaultTableModel();
    //private final DataBase dtb = new DataBase();

    public Entidades() {
        //Constructor!
    }

    
//AGREGA UNA NUEVA CATEGORIA
    //ENVIAR A TABLA 'Categoria'
    public void agregarCategoria(String nombre) {
        try {
            PreparedStatement pst = conexion.prepareStatement(
                    "INSERT INTO categoria(nombre_categoria) "
                    + "VALUES ('"+nombre+"');");
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria Agregada");
            pst.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error"+ex.getMessage());
        }
    }
//------------++----------------++-------------------++-------------------------
    //ACTUALIZAR REGISTRO
    public void actualizarCategoria(int id, String nombre) {
        try {
            PreparedStatement pst = conexion.prepareStatement(
                    " UPDATE categoria SET nombre_categoria = ? "
                            + "WHERE id_cat = ?");
            pst.setString(1, nombre);
            pst.setInt(2, id); //IMPORTANTE!!! COLOCAR UN ENTERO Y OBTENER SU VALOR
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Actualizado");
            pst.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR!"+ex.getMessage());
        }
    }
//-----------------------------------------------------------------------------
    //BORRAR REGISTRO
    public void eliminarCategoria(int numero) {
        
        try {
            PreparedStatement pst = conexion.prepareStatement
        ("DELETE FROM categoria WHERE id_cat = ? ");
            pst.setInt(1, numero); //COLOCAR UN ENTERO
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminando...");
            pst.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     // JOptionPane.showMessageDialog(null, "LISTO...");  
     
    }
//------------------------------------------------------------------------------
    
    //AGREGAR NUEVO CLLIENTE...
    public void agregarCliente(String nombre, String apellidos,
            String sexo,String telefono, String direccion, String email, 
            String pais) {
        
        String sql = "INSERT INTO cliente(nombre,apellidos,sexo,telefono,direccion,email,"
                            + "pais) VALUES('"+nombre+"','"+apellidos+"','"+sexo+"',"
                            + " '"+telefono+"','"+direccion+"','"+email+"','"+pais+"')";
        
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado el cliente");
            pst.close();
        } catch(SQLException e ){
            JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
        }
    }
//------------------------------------------------------------------------------
    //ACTUALIZAR EL CLIENTE!
    public void actualizarCliente(int cedula, String nombre, String apellidos,
            String sexo, String telefono, String direccion, String email,
            String pais) {
            
        try {
            
            PreparedStatement pst = conexion.prepareStatement(
               "UPDATE cliente SET nombre = ?,"
                            + "apellidos  = ?,"
                            + "sexo   = ?,"
                            + "telefono  = ?,"
                            + "direccion      = ?,"
                            + "email     = ?,"
                            + "pais      = ?"
                            + "WHERE cedula    = ?");
            
            
            
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, sexo);
            pst.setString(4, telefono);
            pst.setString(5, direccion);
            pst.setString(6, email);
            pst.setString(7, pais);
            pst.setInt(8, cedula); //IMPORTANTE!!! COLOCAR UN ENTERO Y OBTENER SU VALOR
            pst.executeUpdate();
             
            JOptionPane.showMessageDialog(null, "Registro actualizado");
            pst.close();
        } catch(SQLException exceptio) {
            JOptionPane.showMessageDialog(null, "ERROR!"+exceptio.getMessage());
        }
    }
//------------------------------------------------------------------------------
    //ELIMINAR EL CLIENTE
    public void eliminarCliente(int id) {
        
        try {
            PreparedStatement pst = conexion.prepareStatement(
                    "DELETE FROM cliente  WHERE cedula = ?");
            
            pst.setInt(1, id); //COLOCAR UN ENTERO
            pst.execute();
            JOptionPane.showMessageDialog(null, "Eliminando...");
            pst.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error "+e.getMessage());
        }
    
    }
//------------------------------------------------------------------------------
    //REGISTRAR EMPLEADO
    public void agregarEmpleado(String nombre, String apellidos, String sexo,
            String telefono, String direccion, String email,
            double salario, int mercVendida, String fecha) {
        
        SimpleDateFormat fec = new SimpleDateFormat("aaaa/mm/dd");
        String sql = "INSERT INTO empleado(nombre,apellidos,sexo,telefono,direccion,"
                            + " email,fecha_ingreso,salario,motos_vendidas)"
                            + " VALUES('"+nombre+"','"+apellidos+"','"+sexo+"',"
                            + " '"+telefono+"','"+direccion+"','"+email+"', '"+fecha+"' ,"
                            + " "+salario+" , "+mercVendida+" );";
        try {
            PreparedStatement pst = conexion.prepareStatement(sql);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado nuevo empleado");
            pst.close();
            
        }catch(SQLException excep) {
            JOptionPane.showMessageDialog(null, "Error"+excep.getMessage());
        }   //termina catch
    } 
//termina método agregar
//--------------------------------++----------------------------------------------    
    public void actualizarEmpleado(int id_empleado, String nombre, 
            String apellidos,String sexo, String telefono, String direccion, 
            String email, double salario, int mercVendida, String fecha) {
        
        try {
            
            PreparedStatement pst = conexion.prepareStatement(
                    "UPDATE empleado SET nombre = ?,"
                            + "apellidos = ?,"
                            + "sexo = ?,"
                            + "telefono = ?,"
                            + "direccion = ?,"
                            + "email = ?,"
                            + "fecha_ingreso = ?,"
                            + "salario = ?,"
                            + "motos_vendidas = ?"
                            + "WHERE id_empleado = ?");
            pst.setString(1, nombre);
            pst.setString(2, apellidos);
            pst.setString(3, sexo);
            pst.setString(4, telefono);
            pst.setString(5, direccion);
            pst.setString(6, email);
            pst.setString(7, fecha);  
            pst.setDouble(8, salario);
            pst.setInt(9, mercVendida);
            pst.setInt(10, id_empleado);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro actualizado");
            pst.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } //termina catch
        
    } //termina metodo
    
//++-------------------++---------------------++---------------++---------------
    public void eliminarEmpleado(int id) {
        
        try {
            PreparedStatement pst = conexion.prepareStatement(""
                    + "DELETE FROM empleado WHERE id_empleado = ?");
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Eliminando...");
            pst.close();
        } catch(SQLException excep) {
            JOptionPane.showMessageDialog(null, "Error "+excep.getMessage());
        }
    }
//-------------------++--------------------++-----------------------------------
    
    
    public void agregarProveedor(String nombre, String telefono,
            String direccion, String email) {
        try {
            PreparedStatement pst = conexion.prepareStatement(
                    " INSERT INTO proveedores (nombre,telefono,direccion,"
                            + "email) VALUES('"+nombre+"','"+telefono+"',"
                            + " '"+direccion+"','"+email+"');");
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha registrado nuevo proveedor");
            pst.close();
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex.getMessage());
        }
        
    }
//---------------------++-------------------++---------------------++-----------
    public void actualizarProveedor(int codigo, String nombre, String telefono,
            String direccion, String email) {
        
        try {
            PreparedStatement  pst = conexion.prepareStatement(
                    "UPDATE proveedores SET nombre = ?,"
                            + "telefono = ?,"
                            + "direccion = ?,"
                            + "email = ?"
                            + "WHERE codigo_prov = ?");
            
            pst.setString(1, nombre);
            pst.setString(2,telefono);
            pst.setString(3, direccion);
            pst.setString(4, email);
            pst.setInt(5, codigo);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro actualizado");
            pst.close();
            
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR " +e.getMessage());
        } //termina catch
    } //termina metodo actualizar proveedor
//---------------------++--------------------++---------------------------------
    public void eliminarProveedor(int id) {
        
        try {
            PreparedStatement pst = conexion.prepareStatement(
                    "DELETE FROM proveedores WHERE codigo_prov = ?");
            pst.setInt(1, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Eliminando...");
            pst.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR" +e.getMessage());
        }
    } //termina método
    
}