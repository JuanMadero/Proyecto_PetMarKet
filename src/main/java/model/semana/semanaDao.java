package model.semana;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.config.Conexion;


public class semanaDao {

    /*Atributos para realizar operaciones sobre BD */

    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r; 

    public int registrar (semanaVo semana) throws SQLException{
        sql="INSERT INTO semana(nombreSemana, fechaInicio, fechaFinalizacion, estadoSemana) VALUES (?,?,?,?)";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, semana.getNombreSemana());
            ps.setString(2, semana.getFechaInicio());
            ps.setString(3, semana.getFechaFinalizacion());
            ps.setString(4, semana.getEstadoSemana());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro la semana correctamente");
        }catch(Exception e){
            System.out.println("Error en el registro" +e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }
    public List<semanaVo> semanaList() throws SQLException{
        List<semanaVo> semana = new ArrayList<>();
        sql = "SELECT * FROM semana";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                semanaVo r = new semanaVo();
                //Escribir en el setter cada valor encontrado
                r.setIdSemana(rs.getInt("idSemana"));//peticion de id
                r.setNombreSemana(rs.getString("nombreSemana"));
                r.setFechaInicio(rs.getString("fechaInicio"));
                r.setFechaFinalizacion(rs.getString("fechaFinalizacion"));
                r.setEstadoSemana(rs.getString("estadoSemana"));
                semana.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return semana;
    }

    public List<semanaVo> semanaListId(String id) throws SQLException{
        List<semanaVo> semana = new ArrayList<>();
        sql = "SELECT * FROM semana WHERE idSemana ="+id;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                semanaVo r = new semanaVo();
                //Escribir en el setter cada valor encontrado
                r.setIdSemana(rs.getInt("idSemana"));//peticion de id
                r.setNombreSemana(rs.getString("nombreSemana"));
                r.setFechaInicio(rs.getString("fechaInicio"));
                r.setFechaFinalizacion(rs.getString("fechaFinalizacion"));
                r.setEstadoSemana(rs.getString("estadoSemana"));
                semana.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return semana;
    }
}