
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level; 
import java.util.logging.Logger;

public class Conexion {
    
    private final String base = "dual";
    private final String URL = "jdbc:mysql://localhost:3306/Dual";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection con = null;
    
    public Connection getConnection()
    {       
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.URL,this.USERNAME,this.PASSWORD);
            
        } catch(SQLException e)
        {
            System.err.println(e);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null, ex);
        }
        return con;
    }
}
