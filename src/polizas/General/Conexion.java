package polizas.General;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection cnx;
    public PreparedStatement ps;
    public ResultSet rs;
    
    public void conectar() throws SQLException{
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root","");
        } catch (SQLException ex){
            System.out.println("Erro: " + ex.getMessage());
        }
        
    }
}
