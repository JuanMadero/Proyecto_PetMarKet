package model.bloque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.config.Conexion;


public class bloqueDao {

    /*Atributos para realizar operaciones sobre BD */

    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r; 

    public int registrar (bloqueVo bloque) throws SQLException{
        sql="INSERT INTO bloque(diaBloque, horaInicioBloque, horaFinalizacionBloque, estadoBloque, idSemana) VALUES (?,?,?,?,?)";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, bloque.getDiaBloque());
            ps.setString(2, bloque.getHoraInicioBloque());
            ps.setString(3, bloque.getHoraFinalizacionBloque());
            ps.setString(4, bloque.getEstadoBloque());
            ps.setString(5, bloque.getIdSemana());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el bloque correctamente");
        }catch(Exception e){
            System.out.println("Error en el registro" +e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }
    public List<bloqueVo> bloqueList(String id) throws SQLException{
        List<bloqueVo> bloque = new ArrayList<>();
        sql = "SELECT * FROM bloque WHERE idSemana ="+id;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                bloqueVo r = new bloqueVo();
                //Escribir en el setter cada valor encontrado
                r.setIdBloque(rs.getInt("idBloque"));
                r.setDiaBloque(rs.getString("diaBloque"));
                r.setHoraInicioBloque(rs.getString("horaInicioBloque"));
                r.setHoraFinalizacionBloque(rs.getString("horaFinalizacionBloque"));
                r.setEstadoBloque(rs.getString("estadoBloque"));
                r.setIdSemana(rs.getString("idSemana"));
                bloque.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return bloque;
    }

    public List<bloqueVo> bloqueListDis() throws SQLException{
        List<bloqueVo> bloque = new ArrayList<>();
        sql = "SELECT idBloque, diaBloque, TIME_FORMAT(horaInicioBloque, '%r') as horaInicioBloque, DATE_FORMAT(horaFinalizacionBloque, '%r') as horaFinalizacionBloque, estadoBloque, idSemana FROM bloque WHERE estadoBloque ='Disponible'";
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                bloqueVo r = new bloqueVo();
                //Escribir en el setter cada valor encontrado
                r.setIdBloque(rs.getInt("idBloque"));
                r.setDiaBloque(rs.getString("diaBloque"));
                r.setHoraInicioBloque(rs.getString("horaInicioBloque"));
                r.setHoraFinalizacionBloque(rs.getString("horaFinalizacionBloque"));
                r.setEstadoBloque(rs.getString("estadoBloque"));
                r.setIdSemana(rs.getString("idSemana"));
                bloque.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return bloque;
    }
    
    public List<bloqueVo> listInfo(String id) throws SQLException{
        List<bloqueVo> bloque = new ArrayList<>();
        sql = "SELECT * FROM bloque WHERE idSemana ="+id;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                bloqueVo r = new bloqueVo();
                //Escribir en el setter cada valor encontrado
                r.setIdBloque(rs.getInt("idBloque"));
                r.setDiaBloque(rs.getString("diaBloque"));
                r.setHoraInicioBloque(rs.getString("horaInicioBloque"));
                r.setHoraFinalizacionBloque(rs.getString("horaFinalizacionBloque"));
                r.setEstadoBloque(rs.getString("estadoBloque"));
                r.setIdSemana(rs.getString("idSemana"));
                bloque.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return bloque;
    }

}