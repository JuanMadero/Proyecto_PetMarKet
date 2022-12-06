package model.cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.config.Conexion;

public class clienteDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int r;

    public int registrar(clienteVo cliente) throws SQLException {
        sql = "INSERT INTO cliente (nombreCliente, apellidoCliente, tipoIdentificacion, identificacionCliente, direccionCliente, correoCliente, telefonoCliente) values (?,?,?,?,?,?,?)";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombreCliente());
            ps.setString(2, cliente.getApellidoCliente());
            ps.setString(3, cliente.getTipoIdentificacion());
            ps.setString(4, cliente.getIdentificacionCliente());
            ps.setString(5, cliente.getDireccionCliente());
            ps.setString(6, cliente.getCorreoCliente());
            ps.setString(7, cliente.getTelefonoCliente());
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se registro el cliente correctamente");
        } catch (Exception e) {
            System.out.println("Error en el registro" + e.getMessage().toString());
        } finally {
            con.close();
        }
        return r;

    }

    public List<clienteVo> clienteList() throws SQLException {
        List<clienteVo> cliente = new ArrayList<>();
        sql = "SELECT * FROM cliente";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                clienteVo r = new clienteVo();
                r.setIdCliente(rs.getInt("idCliente"));
                r.setNombreCliente(rs.getString("nombreCliente"));
                r.setApellidoCliente(rs.getString("apellidoCliente"));
                r.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                r.setIdentificacionCliente(rs.getString("identificacionCliente"));
                r.setDireccionCliente(rs.getString("direccionCliente"));
                r.setCorreoCliente(rs.getString("correoCliente"));
                r.setTelefonoCliente(rs.getString("telefonoCliente"));
                cliente.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosajijiji");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada" + e.getMessage().toString());
        } finally {
            con.close();
        }
        return cliente;
    }

     public void eliminar(int id) throws SQLException {
        sql = "DELETE FROM cliente WHERE idCliente=" + id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
            System.out.println("Se elimino correctamente el cliente" );
        } catch (Exception e) {
            System.out.println("Error en la eliminacion" + e.getMessage().toString());
        } finally {
            con.close();
        }
    }

    public List<clienteVo> clienteListId(String id) throws SQLException {
        List<clienteVo> cliente = new ArrayList<>();
        sql = "SELECT * FROM cliente WHERE idCliente ="+id;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                clienteVo r = new clienteVo();
                // Escribir en el setter cada valor encontrado
                r.setIdCliente(rs.getInt("idCliente"));
                r.setNombreCliente(rs.getString("nombreCliente"));
                r.setApellidoCliente(rs.getString("apellidoCliente"));
                r.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                r.setIdentificacionCliente(rs.getString("identificacionCliente"));
                r.setDireccionCliente(rs.getString("direccionCliente"));
                r.setCorreoCliente(rs.getString("correoCliente"));
                r.setTelefonoCliente(rs.getString("telefonoCliente"));
                cliente.add(r);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada" + e.getMessage().toString());
        } finally {
            con.close();
        }
        return cliente;
    }

    public List<clienteVo> listarCliente(int id) throws SQLException{
        List<clienteVo> cliente=new ArrayList<>();
        sql="SELECT * FROM cliente WHERE idCliente="+id;//variable para la BD
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                clienteVo r=new clienteVo();
                //Escribir  en el setter cada valor encontrado
                r.setIdCliente(rs.getInt("idCliente"));
                r.setNombreCliente(rs.getString("nombreCliente"));
                r.setApellidoCliente(rs.getString("apellidoCliente"));
                r.setTipoIdentificacion(rs.getString("tipoIdentificacion"));
                r.setIdentificacionCliente(rs.getString("identificacionCliente"));
                r.setDireccionCliente(rs.getString("direccionCliente"));
                r.setCorreoCliente(rs.getString("correoCliente"));
                r.setTelefonoCliente(rs.getString("telefonoCliente"));
                cliente.add(r);
            }
            ps.close();
            System.out.println("Genero especifico consultado exitosamente ");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
        }
        finally{
            con.close();
        }
        return cliente;//retorna array con los datos de la tabla
    }
    public int actualizar(clienteVo cliente) throws SQLException{
        sql="UPDATE cliente SET nombreCliente=?, apellidoCliente=?, tipoIdentificacion=?, identificacionCliente=?, direccionCliente=?, correoCliente=?, telefonoCliente=? WHERE idCliente=?";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.setString(1, cliente.getNombreCliente());
            ps.setString(2, cliente.getApellidoCliente());
            ps.setString(3, cliente.getTipoIdentificacion());
            ps.setString(4, cliente.getIdentificacionCliente());
            ps.setString(5, cliente.getDireccionCliente());
            ps.setString(6, cliente.getCorreoCliente());
            ps.setString(7, cliente.getTelefonoCliente());
            ps.setInt(8, cliente.getIdCliente());
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
