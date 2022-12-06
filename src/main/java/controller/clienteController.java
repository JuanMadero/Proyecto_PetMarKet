package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cliente.clienteDao;
import model.cliente.clienteVo;

import model.mascota.mascotaDao;
import model.mascota.mascotaVo;

import model.bloque.bloqueDao;
import model.bloque.bloqueVo;

public class clienteController extends HttpServlet {

    clienteVo r = new clienteVo();
    clienteDao rd = new clienteDao();
    
    bloqueVo f = new bloqueVo();
    bloqueDao fd = new bloqueDao();

    mascotaVo s = new mascotaVo();
    mascotaDao sd = new mascotaDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String a = req.getParameter("action");
        switch(a)
        {
            case"index":
            index(req, resp);
            break;

            case"ingresar":
            ingresar(req,resp);
            break;

            case"consultar":
            clienteList(req, resp);
            break;

            case"consultara":
            clienteLista(req, resp);
            break;

            case"eliminar":
            eliminar(req, resp);
            break;

            case "editar":
            editar(req, resp);
            break;
            
        }
   }
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doPost");
        String a = req.getParameter("accion");
        switch (a) {
            case "add":
                add(req, resp);
            break;
            case "edit":
                edit(req,resp);
            break;
    }
}

private void index(HttpServletRequest req, HttpServletResponse resp) {
    try {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
        System.out.println("El formulario ha sido abierto");
    } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
    }
}

    private void ingresar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idCliente")!= null){
            s.setIdCliente(req.getParameter("idCliente"));
            //r.setIdCliente(Integer.parseInt(req.getParameter("idCliente")));
        }
        try { 
            
            List<mascotaVo> mascotaL = sd.mascotaListId(s.getIdCliente());
            req.setAttribute("mascotaList", mascotaL);
            List<bloqueVo> bloqueL = fd.bloqueListDis();
            req.setAttribute("bloqueListDis", bloqueL);
            List<clienteVo> clientel = rd.clienteListId(s.getIdCliente());
            req.setAttribute("clienteListId", clientel); 
            req.getRequestDispatcher("views/cita/ingresarCita.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente todo okeyy");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    
    private void add(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("nombreCliente")!= null){
            r.setNombreCliente(req.getParameter("nombreCliente"));
        }
        if(req.getParameter("apellidoCliente")!= null){
            r.setApellidoCliente(req.getParameter("apellidoCliente"));
        }
        if (req.getParameter("tipoIdentificacion")!=null){
            r.setTipoIdentificacion(req.getParameter("tipoIdentificacion"));
        }
        if (req.getParameter("identificacionCliente")!= null){
            r.setIdentificacionCliente(req.getParameter("identificacionCliente"));
        }
        if (req.getParameter("direccionCliente")!= null){
            r.setDireccionCliente(req.getParameter("direccionCliente"));
        }
        if (req.getParameter("correoCliente")!= null){
            r.setCorreoCliente(req.getParameter("correoCliente"));
        }
        if (req.getParameter("telefonoCliente")!= null){
            r.setTelefonoCliente(req.getParameter("telefonoCliente"));
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            clienteList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    } 

    private void clienteList(HttpServletRequest req, HttpServletResponse resp) {
        try { 
            List<clienteVo> clienteL = rd.clienteList();
            req.setAttribute("clienteList", clienteL);
            req.getRequestDispatcher("views/cita/cliente.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void clienteLista(HttpServletRequest req, HttpServletResponse resp) {
        try { 
            List<clienteVo> clienteL = rd.clienteList();
            req.setAttribute("clienteList", clienteL);
            req.getRequestDispatcher("views/administrador/cliente.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") != null) {
            r.setIdCliente(Integer.parseInt(req.getParameter("id")));
        }
        try {
            rd.eliminar(r.getIdCliente());
            System.out.println("El cliente se elimino correctamente");
            clienteList(req, resp);
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente" + e.getMessage().toString());
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCliente")!=null){
            r.setIdCliente(Integer.parseInt(req.getParameter("idCliente")));
        }
        try {
            List <clienteVo> clienteL = rd.listarCliente(r.getIdCliente());
            req.setAttribute("clienteList", clienteL);
            req.getRequestDispatcher("views/cita/editarCliente.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente, preparados para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCliente")!=null){
            r.setIdCliente(Integer.parseInt(req.getParameter("idCliente")));//Cambiar de string a int
        }
        if (req.getParameter("nombreCliente")!= null){
            r.setNombreCliente(req.getParameter("nombreCliente"));
        }
        if(req.getParameter("apellidoCliente")!= null){
            r.setApellidoCliente(req.getParameter("apellidoCliente"));
        }
        if (req.getParameter("tipoIdentificacion")!=null){
            r.setTipoIdentificacion(req.getParameter("tipoIdentificacion"));
        }
        if (req.getParameter("identificacionCliente")!= null){
            r.setIdentificacionCliente(req.getParameter("identificacionCliente"));
        }
        if (req.getParameter("direccionCliente")!= null){
            r.setDireccionCliente(req.getParameter("direccionCliente"));
        }
        if (req.getParameter("correoCliente")!= null){
            r.setCorreoCliente(req.getParameter("correoCliente"));
        }
        if (req.getParameter("telefonoCliente")!= null){
            r.setTelefonoCliente(req.getParameter("telefonoCliente"));
        }
        try {
            rd.actualizar(r);
            System.out.println("Editar el registro de Cliente");
            clienteList(req, resp);
        } catch (Exception e) {
            System.out.println("Error al editar del registro "+e.getMessage().toString());
        }
    }
}
