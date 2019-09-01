package modelo;
import java.sql.*;

public class DataBase {
    //mis datos para la conexion
    private String db = "abd";
    //mi usuario ...
    private String user = "postgres";
    //mi contraseña
    private String password = "***************";
    
    //cadena para la conexion
    private String url = "jdbc:postgresql://localhost/" + db;
    
    /*
    esta es mi variable para que pueda trabajar con la conexion
    */
    Connection conn = null;
    
    //utilizo constructor
    public DataBase()  {
        //this.url = "jdbc:postgresql://localhost/" + this.db;
        try {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(url, user, password);
        //Statement stm = conn.createStatement();
        
        if(conn != null) {
            System.out.println("["+this.db+"] conectado!");   
        }
        
    } catch( SQLException | ClassNotFoundException e ){
            System.err.println(e.getMessage());
        }
    }
    
    public Connection getConexion() {
        return conn;
    }
    
    public void cerrar() {
        try {
            System.out.println("B.D.["+this.db+"] cerrado");
            conn.close();
        }catch(SQLException e) {
            System.out.println("Error al cerrar conexion!");
        }
    }
}

