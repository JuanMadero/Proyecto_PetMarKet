package model.login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import model.config.Conexion;

public class loginDao 
{
    public String authenticateUser(loginVo loginVo)
    {
        String userName = loginVo.getNombreUsuario();
        String password = loginVo.getPasswordUsuario();
     
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;
     
        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";
        String idUsuarioDB = "";
     
        try
        {
            con = Conexion.conectar();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select idUsuario, nombreUsuario,passwordUsuario,rolUsuario from usuario");
     
            while(resultSet.next())
            {

                idUsuarioDB = resultSet.getString("idUsuario")    ;
                userNameDB = resultSet.getString("nombreUsuario");
                passwordDB = resultSet.getString("passwordUsuario");
                roleDB = resultSet.getString("rolUsuario");
     
                if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))

                return idUsuarioDB+","+userNameDB+","+roleDB;

                else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
                
                return idUsuarioDB+","+userNameDB+","+roleDB;
                else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Aux"))

                return idUsuarioDB+","+userNameDB+","+roleDB;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }   
}
