
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CAlumno extends Conexion {
    
    public boolean Agregar(Alumno al)
    {
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO alumnos (nombre, matricula, id_proyecto) VALUES (?, ?, ?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, al.getNombre());
            ps.setString(2, al.getMatricula());
            ps.setInt(3, al.getId_proyecto());
            ps.execute();
            return true;

        }catch(SQLException e){
            System.err.println(e);
            return false;
        }   finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean Modificar(Alumno al)
    {
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE alumnos SET nombre = ?, matricula = ?, id_proyecto = ? WHERE id_alumnos = ? ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, al.getNombre());
            ps.setString(2, al.getMatricula());
            ps.setInt(3, al.getId_proyecto());
            ps.setInt(4, al.getId_alumnos());
            ps.execute();
            return true;

        }catch(SQLException e){
            System.err.println(e);
            return false;
        }   finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean Eliminar(Alumno al)
    {
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM alumnos WHERE id_alumnos = ? ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, al.getId_alumnos());
            ps.execute();
            return true;

        }catch(SQLException e){
            System.err.println(e);
            return false;
        }   finally{
            try{
                con.close();
            } catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
        public boolean Buscar(Alumno al)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT a.*, p.nombre AS nombreP, p.descripcion FROM alumnos a "
                    + "LEFT JOIN proyectos p ON a.id_proyecto = p.id_proyecto"
                    + " WHERE a.matricula = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, al.getMatricula());
            rs = ps.executeQuery();
            
            if(rs.next()){
                al.setMatricula(rs.getString("matricula"));
                al.setNombre(rs.getString("nombre"));
                al.setId_proyecto(rs.getInt("id_proyecto"));
                al.setId_alumnos(rs.getInt("id_alumnos"));
                al.setNombreP(rs.getString("nombreP"));
                al.setDescripcion(rs.getString("descripcion"));
                
            return true;
            }
            return false;
            }catch(SQLException e){
                System.err.println(e);
                return false;
            }   finally{
                try{
                    con.close();
                } catch(SQLException e){
                    System.err.println(e);
                }
            }
    }
    
    
}
