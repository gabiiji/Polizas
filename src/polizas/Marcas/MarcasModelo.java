
package polizas.Marcas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import polizas.General.DAO;
import polizas.General.Conexion;

public class MarcasModelo extends Conexion implements DAO{
  
    MarcasModelo(){
        super();
    }
    
    
    @Override
    public List read(){
        List<Marca> lista = new ArrayList<>();
        try{
            this.conectar();
            ps = cnx.prepareStatement("SELECT * FROM marcas");
            rs = ps.executeQuery();
            lista.clear();
            while (rs.next()){
                lista.add(new Marca(rs.getInt("IdMarca"), rs.getString("nombreMarca")));
            }
        }catch (SQLException ex){
            System.out.println("Error: " + ex.getMessage());
        }finally{
            try{
                cnx.close();
            }catch (SQLException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return lista;
    }
    @Override
    public int create(Object obj){
        try{
            this.conectar();
            Marca marca = (Marca) obj;
            ps = cnx.prepareStatement("Insert into marcas(nombreMarca) values (?)");
            ps.setString(1, marca.getNombre());
            return ps.executeUpdate();
        } catch (SQLException ex ){
            System.out.println("Error: " + ex.getMessage());
        }finally{
            try{
                cnx.close();
            }catch (SQLException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
        return 1;
    }
    
   
@Override
public int update(Object obj) {
    
        try {
            this.conectar();
            Marca marca = (Marca) obj;
            ps = cnx.prepareStatement("UPDATE marcas SET nombreMarca = ? WHERE IdMarca = ?");
            ps.setString(1, marca.getNombre());
            ps.setInt(2, marca.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (cnx != null) cnx.close();
            } catch (SQLException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    return 0;
}

    
    
@Override
public int delete(Object obj) {
       try {
            this.conectar();
            Marca marca = (Marca) obj;
            ps = cnx.prepareStatement("DELETE FROM marcas WHERE IdMarca = ?");
            ps.setInt(1, marca.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (cnx != null) cnx.close();
            }catch (SQLException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
    
    return 0;
}}