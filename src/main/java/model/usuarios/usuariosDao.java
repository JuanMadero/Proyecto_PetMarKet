package model.usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.config.Conexion;


public class usuariosDao extends Conexion  {

    
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r; 
    
   
    public Boolean RegistrarUsuario(usuariosVo user) {

        sql = "INSERT INTO usuario (usuario, passwordUsuario, nombreUsuario, correo, rolUsuario) values (?,?,?,?,?)";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNombre());
            ps.setString(4, user.getCorreo());
            ps.setString(5, user.getRol());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el usuario correctamente");
            return true;
        } catch (Exception e) {
            System.out.println("Error en el registro" +e.getMessage().toString());
            return false;
        }

        
    }

    /**
     * @return
     * @throws SQLException
     */
    public List<usuariosVo> usuarioList() throws SQLException {
        List<usuariosVo> usuarios = new ArrayList<>();
        sql = "SELECT * FROM usuario";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                usuariosVo r = new usuariosVo();
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setUsuario(rs.getString("usuario"));
                r.setPassword(rs.getString("passwordUsuario"));
                r.setNombre(rs.getString("nombreUsuario"));
                r.setCorreo(rs.getString("correo"));
                r.setRol(rs.getString("rolUsuario"));
                usuarios.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosajijiji");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada" + e.getMessage().toString());
        } finally {
            con.close();
        }
        return usuarios;
    }

    public void eliminar(int id) throws SQLException {
        sql = "DELETE FROM usuario WHERE idUsuario=" + id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se elimino correctamente el usuario" );
        } catch (Exception e) {
            System.out.println("Error en la eliminacion" + e.getMessage().toString());
        } finally {
            con.close();
        }
    }
    public List<usuariosVo> listarUsuario(int id) throws SQLException{
        List<usuariosVo> usuario=new ArrayList<>();
        sql="SELECT * FROM usuario WHERE idUsuario =" + id;//variable para la BD
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                usuariosVo r =new usuariosVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdUsuario(rs.getInt("idUsuario"));//peticion de id
                r.setUsuario(rs.getString("usuario"));
                r.setPassword(rs.getString("passwordUsuario"));
                r.setNombre(rs.getString("nombreUsuario"));
                r.setCorreo(rs.getString("correo"));
                r.setRol(rs.getString("rolUsuario"));
                usuario.add(r);
            }
            ps.close();
            System.out.println("Mascota especifico consultado exitosamente ");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return usuario;//retorna array con los datos de la tabla
    }
    public int actualizar(usuariosVo usuario) throws SQLException{
        sql="UPDATE usuario SET usuario=?, passwordUsuario=?, nombreUsuario=?, correo=?, rolUsuario=? WHERE idUsuario=?";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getRol());
            ps.setInt(6, usuario.getIdUsuario());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito el usuario correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;//retornar numero de filas
    }
}
