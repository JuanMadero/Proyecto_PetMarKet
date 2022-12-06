package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.usuarios.usuariosDao;
import model.usuarios.usuariosVo;


public class usuarioController extends HttpServlet {

    usuariosVo u = new usuariosVo();
    usuariosDao ud = new usuariosDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String a = req.getParameter("accion");

    switch(a){
        case"ingresar":
            ingresar(req, resp);
        break;

        case"consultar":
            usuarioList(req, resp);
        break;

        case"index":
            index(req, resp);
        break;
        case"indexs":
            indexs(req, resp);
        break;
        case"eliminar":
            eliminar(req, resp);
        break;
        case "editar":
            editar(req, resp);
        break;
    }
}

private void editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idUsuario")!=null){
        u.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
    }
    try {
        List <usuariosVo> usuarioL = ud.listarUsuario(u.getIdUsuario());
        req.setAttribute("usuarioList", usuarioL);
        req.getRequestDispatcher("views/administrador/editarUsuario.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente, preparados para la edicion");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
    }

private void index(HttpServletRequest req, HttpServletResponse resp) {
    try {
        req.getRequestDispatcher("views/administrador/inicioadministrador.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
    }
}
private void indexs(HttpServletRequest req, HttpServletResponse resp) {
    try {
        req.getRequestDispatcher("views/auxiliar/inicioauxiliar.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
    }
}

private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("id") != null) {
        u.setIdUsuario(Integer.parseInt(req.getParameter("id")));
    }
    try {
        ud.eliminar(u.getIdUsuario());
        System.out.println("La Usuario se elimino correctamente");
        usuarioList(req, resp);
    } catch (Exception e) {
        System.out.println("Error al eliminar el usuario" + e.getMessage().toString());
    }
}

private void ingresar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        req.getRequestDispatcher("views/administrador/IngresarUsuario.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
    }
    }
private void usuarioList(HttpServletRequest req, HttpServletResponse resp) {
    try { 
        List<usuariosVo> usuarioL = ud.usuarioList();
        req.setAttribute("usuarioList", usuarioL);
        req.getRequestDispatcher("views/administrador/consultarUsuario.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
}

@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doPost");
        String a = req.getParameter("atcion");
        switch (a) {
            case "add":
                add(req, resp);
            break;
            case "edit":
                edit(req, resp);
            break;
    }
}


private void add(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("usuario") != null) {
        u.setUsuario(req.getParameter("usuario"));
    }
    if (req.getParameter("password") != null) {
        u.setPassword(req.getParameter("password"));
    }
    if (req.getParameter("nombre") != null) {
        u.setNombre(req.getParameter("nombre"));
    }
    if (req.getParameter("correo") != null) {
        u.setCorreo(req.getParameter("correo"));
    }
    if (req.getParameter("rol") != null) {
        u.setRol(req.getParameter("rol"));
    }
    try {
        ud.RegistrarUsuario(u);
        System.out.println("Registro insertado correctamente");
        usuarioList(req, resp);
    } catch (Exception e) {
        System.out.println("Error en la inserción del registro " + e.getMessage().toString());
    }
}
private void edit(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idUsuario")!=null){
        u.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));//Cambiar de string a int
    }
    if (req.getParameter("usuario") != null) {
        u.setUsuario(req.getParameter("usuario"));
    }
    if (req.getParameter("password") != null) {
        u.setPassword(req.getParameter("password"));
    }
    if (req.getParameter("nombre") != null) {
        u.setNombre(req.getParameter("nombre"));
    }
    if (req.getParameter("correo") != null) {
        u.setCorreo(req.getParameter("correo"));
    }
    if (req.getParameter("rol") != null) {
        u.setRol(req.getParameter("rol"));
    }
    try {
        ud.actualizar(u);
        System.out.println("Editar el registro de Cliente");
        usuarioList(req, resp);
    } catch (Exception e) {
        System.out.println("Error al editar del registro "+e.getMessage().toString());
    }
}
}