package model.mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.config.Conexion;


public class mascotaDao {

    /*Atributos para realizar operaciones sobre BD */

    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r; 

    public int registrar (mascotaVo mascota) throws SQLException{
        sql="INSERT INTO mascota(nombreMascota, tipoMascota, razaMascota, pesoMascota, comportamientoMascota, idCliente) VALUES (?,?,?,?,?,?)";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, mascota.getNombreMascota());
            ps.setString(2, mascota.getTipoMascota());
            ps.setString(3, mascota.getRazaMascota());
            ps.setString(4, mascota.getPesoMascota());
            ps.setString(5, mascota.getComportamientoMascota());
            ps.setString(6, mascota.getIdCliente());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro la mascota correctamente");
        }catch(Exception e){
            System.out.println("Error en el registro" +e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }
    public List<mascotaVo> mascotaList() throws SQLException{
        List<mascotaVo> mascota = new ArrayList<>();
        sql = "SELECT * FROM mascota ";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                mascotaVo r = new mascotaVo();
                //Escribir en el setter cada valor encontrado
                r.setIdMascota(rs.getInt("idMascota"));//peticion de id
                r.setNombreMascota(rs.getString("nombreMascota"));
                r.setTipoMascota(rs.getString("tipoMascota"));
                r.setRazaMascota(rs.getString("razaMascota"));
                r.setPesoMascota(rs.getString("pesoMascota"));
                r.setComportamientoMascota(rs.getString("comportamientoMascota"));
                r.setIdCliente(rs.getString("idCliente"));
                mascota.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa mascota");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return mascota;
    }

    public List<mascotaVo> mascotaListId(String id) throws SQLException{
        List<mascotaVo> mascota = new ArrayList<>();
        sql = "SELECT * FROM mascota WHERE idCliente ="+id;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                mascotaVo r = new mascotaVo();
                //Escribir en el setter cada valor encontrado
                r.setIdMascota(rs.getInt("idMascota"));//peticion de id
                r.setNombreMascota(rs.getString("nombreMascota"));
                r.setTipoMascota(rs.getString("tipoMascota"));
                r.setRazaMascota(rs.getString("razaMascota"));
                r.setPesoMascota(rs.getString("pesoMascota"));
                r.setComportamientoMascota(rs.getString("comportamientoMascota"));
                mascota.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return mascota;
    }
    public void eliminar(int id) throws SQLException {
        sql = "DELETE FROM mascota WHERE idMascota=" + id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se elimino correctamente la mascota " );
        } catch (Exception e) {
            System.out.println("Error en la eliminacion" + e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    public List<mascotaVo> listarMascota(int id) throws SQLException{
        List<mascotaVo> mascota=new ArrayList<>();
        sql="SELECT * FROM mascota WHERE idMascota =" + id;//variable para la BD
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                mascotaVo r =new mascotaVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdMascota(rs.getInt("idMascota"));//peticion de id
                r.setNombreMascota(rs.getString("nombreMascota"));
                r.setTipoMascota(rs.getString("tipoMascota"));
                r.setRazaMascota(rs.getString("razaMascota"));
                r.setPesoMascota(rs.getString("pesoMascota"));
                r.setComportamientoMascota(rs.getString("comportamientoMascota"));
                mascota.add(r);
            }
            ps.close();
            System.out.println("Mascota especifico consultado exitosamente ");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return mascota;//retorna array con los datos de la tabla
    }

    public int actualizar(mascotaVo mascota) throws SQLException{
        sql="UPDATE mascota SET nombreMascota=?, tipoMascota=?, razaMascota=?, pesoMascota=?, comportamientoMascota=? WHERE idMascota=?";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, mascota.getNombreMascota());
            ps.setString(2, mascota.getTipoMascota());
            ps.setString(3, mascota.getRazaMascota());
            ps.setString(4, mascota.getPesoMascota());
            ps.setString(5, mascota.getComportamientoMascota());
            ps.setInt(6, mascota.getIdMascota());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se edito el Cliente correctamente");
        }catch(Exception e){
            System.out.println("Error al editar "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return r;//retornar numero de filas
    }

   
}
 