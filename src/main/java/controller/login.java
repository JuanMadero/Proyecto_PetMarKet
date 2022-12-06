package controller;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import model.login.loginVo;
import model.login.loginDao;

public class login extends HttpServlet 
{
    public login(){}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
     
        loginVo loginVo = new loginVo();
     
        loginVo.setNombreUsuario(userName);
        loginVo.setPasswordUsuario(password);
     
        loginDao loginDao = new loginDao();
     
        try
        {
            String userValidate = loginDao.authenticateUser(loginVo);

            String[] datosObtenidos = userValidate.split(",");
     
            if(datosObtenidos[2].equals("Admin"))
            {
                System.out.println("Bienvenido Administrador");

     
                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("idUsuario", datosObtenidos[0]);
                session.setAttribute("userName", datosObtenidos[1]);
                session.setAttribute("role", datosObtenidos[2]);
                //session.setAttribute("Admin", userName); //setting session attribute
                //request.setAttribute("userName", userName);
     
                request.getRequestDispatcher("views/administrador/inicioadministrador.jsp").forward(request, response);
            }
            else if(datosObtenidos[2].equals("Aux"))
            {
                System.out.println("Bienvenido Auxiliar ");
     
                HttpSession session = request.getSession();
                session.setAttribute("idUsuario", datosObtenidos[0]);
                session.setAttribute("userName", datosObtenidos[1]);
                session.setAttribute("role", datosObtenidos[2]);
     
                request.getRequestDispatcher("views/auxiliar/inicioauxiliar.jsp").forward(request, response);
            }
            else if(datosObtenidos[2].equals("User"))
            {
                System.out.println("Bienvenido Administrador");
     
                HttpSession session = request.getSession(); //Creating a session
                session.setAttribute("idUsuario", datosObtenidos[0]);
                session.setAttribute("userName", datosObtenidos[1]);
                session.setAttribute("role", datosObtenidos[2]);
     
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else
            {
                System.out.println("Error message = "+userValidate);
                request.setAttribute("errMessage", userValidate);
     
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    } //End of doPost()
}
