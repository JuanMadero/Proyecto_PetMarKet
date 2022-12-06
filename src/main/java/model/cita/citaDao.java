package model.cita;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.config.Conexion;


public class citaDao {

    /*Atributos para realizar operaciones sobre BD */

    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    String sql=null;
    int r; 

    public int registrar (citaVo cita) throws SQLException{
        sql = "INSERT INTO cita (tipoServicio, idCliente, idMascota, idBloque, idUsuario) VALUES (?,?,?,?,?)" ;
        try{
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cita.getTipoServicio());
            ps.setString(2, cita.getIdCliente());
            ps.setString(3, cita.getIdMascota());
            ps.setString(4, cita.getIdBloque());
            ps.setString(5, cita.getIdUsuario());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro la cita correctamente");
        }catch(Exception e){
            System.out.println("Error en el registro" +e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }
    
    public List<citaVo> citaList() throws SQLException{
        List<citaVo> cita = new ArrayList<>();
        sql = "SELECT a.idCita, a.tipoServicio, c.nombreMascota, d.nombreCliente, d.apellidoCliente, e.diaBloque, e.horaInicioBloque, e.horaFinalizacionBloque, b.nombreUsuario FROM cita a INNER JOIN usuario b ON a.idUsuario = b.idUsuario INNER JOIN mascota c ON a.idMascota = c.idMascota INNER JOIN cliente d ON a.idCliente = d.idCliente INNER JOIN bloque e ON a.idBloque = e.idBloque";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                citaVo r = new citaVo();
                r.setIdCita(rs.getInt("idCita"));
                r.setTipoServicio(rs.getString("tipoServicio"));
                r.setNombreMascota(rs.getString("nombreMascota"));
                r.setNombreCliente(rs.getString("nombreCliente"));
                r.setApellidoCliente(rs.getString("apellidoCliente"));
                r.setDiaBloque(rs.getString("diaBloque"));
                r.setHoraInicioBloque(rs.getString("horaInicioBloque"));
                r.setHoraFinalizacionBloque(rs.getString("horaFinalizacionBloque"));
                cita.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return cita;
    }
    
    public void eliminar(int id) throws SQLException {
        sql = "DELETE FROM cita WHERE idCita=" + id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se elimino correctamente la cita " );
        } catch (Exception e) {
            System.out.println("Error en la eliminacion" + e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    public List<citaVo> listarCita(int id) throws SQLException{
        List<citaVo> cita=new ArrayList<>();
        sql="SELECT * FROM cita WHERE idCita="+id;//variable para la BD
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                citaVo r=new citaVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdCita(rs.getInt("idCita"));
                r.setTipoServicio(rs.getString("tipoServicio"));
                r.setIdMascota(rs.getString("idMascota"));
                r.setIdBloque(rs.getString("idBloque"));
                cita.add(r);
            }
            ps.close();
            System.out.println("Genero especifico consultado exitosamente ");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return cita;//retorna array con los datos de la tabla
    }
    public int actualizar(citaVo cita) throws SQLException{
        sql="UPDATE cita SET tipoServicio=?, idMascota=?, idBloque=? WHERE idCita=?";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, cita.getTipoServicio());
            ps.setString(2, cita.getIdMascota());
            ps.setString(3, cita.getIdBloque());
            ps.setInt(4, cita.getIdCita());
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
    public List<citaVo> citaListt() throws SQLException{
        List<citaVo> cita = new ArrayList<>();
        sql = "SELECT a.idCita, a.tipoServicio, c.nombreMascota, d.nombreCliente, d.apellidoCliente, e.diaBloque, e.horaInicioBloque, e.horaFinalizacionBloque, b.nombreUsuario FROM cita a INNER JOIN usuario b ON a.idUsuario = b.idUsuario INNER JOIN mascota c ON a.idMascota = c.idMascota INNER JOIN cliente d ON a.idCliente = d.idCliente INNER JOIN bloque e ON a.idBloque = e.idBloque";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                citaVo r = new citaVo();
                r.setIdCita(rs.getInt("idCita"));
                r.setTipoServicio(rs.getString("tipoServicio"));
                r.setNombreMascota(rs.getString("nombreMascota"));
                r.setNombreCliente(rs.getString("nombreCliente"));
                r.setApellidoCliente(rs.getString("apellidoCliente"));
                r.setDiaBloque(rs.getString("diaBloque"));
                r.setHoraInicioBloque(rs.getString("horaInicioBloque"));
                r.setHoraFinalizacionBloque(rs.getString("horaFinalizacionBloque"));
                cita.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        }catch(Exception e){
            System.out.println("La consulta no pudo ser ejecutada"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return cita;
    }
}
