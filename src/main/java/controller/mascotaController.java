package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.mascota.mascotaDao;
import model.mascota.mascotaVo;

import model.cliente.clienteDao;
import model.cliente.clienteVo;


public class mascotaController extends HttpServlet {

    mascotaVo r = new mascotaVo();
    mascotaDao rd = new mascotaDao();

    clienteVo c = new clienteVo();
    clienteDao cd = new clienteDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String a = req.getParameter("accion");

        switch(a){
            case"consultar":
                mascotaList(req, resp);
            break;

            case"consultara":
                mascotaLista(req, resp);
            break;

            case"eliminar":
                eliminar(req, resp);
            break;

            case"editar":
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
                edit(req, resp);
                break;

    }
}

    private void add(HttpServletRequest req, HttpServletResponse resp){
        if (req.getParameter("nombreMascota")!= null){
            r.setNombreMascota(req.getParameter("nombreMascota"));
        }
        if(req.getParameter("tipoMascota")!= null){
            r.setTipoMascota(req.getParameter("tipoMascota"));
        }
        if (req.getParameter("razaMascota")!=null){
            r.setRazaMascota(req.getParameter("razaMascota"));
        }
        if (req.getParameter("pesoMascota")!= null){
            r.setPesoMascota(req.getParameter("pesoMascota"));
        }
        if (req.getParameter("comportamientoMascota")!= null){
            r.setComportamientoMascota(req.getParameter("comportamientoMascota"));
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            mascotaList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    } 

    private void mascotaList(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idCliente")!= null){
            r.setIdCliente(req.getParameter("idCliente"));
        }
        try { 
            
            List<mascotaVo> mascotaL = rd.mascotaListId(r.getIdCliente());
            req.setAttribute("mascotaList", mascotaL);

            List<clienteVo> clientel = cd.clienteListId(r.getIdCliente());
            req.setAttribute("clienteListId", clientel); 

            req.getRequestDispatcher("views/cita/consultarCliente.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void mascotaLista(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idCliente")!= null){
            r.setIdCliente(req.getParameter("idCliente"));
        }
        try { 
            
            List<mascotaVo> mascotaL = rd.mascotaListId(r.getIdCliente());
            req.setAttribute("mascotaList", mascotaL);

            List<clienteVo> clientel = cd.clienteListId(r.getIdCliente());
            req.setAttribute("clienteListId", clientel); 

            req.getRequestDispatcher("views/administrador/consultarCliente.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") != null) {
            r.setIdMascota(Integer.parseInt(req.getParameter("id")));
        }
        try {
            rd.eliminar(r.getIdMascota());
            System.out.println("La mascota se elimino correctamente");
            mascotaList(req, resp);
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente" + e.getMessage().toString());
        }
    }
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idMascota")!=null){
            r.setIdMascota(Integer.parseInt(req.getParameter("idMascota")));
        }
        try {
            List <mascotaVo> mascotaL = rd.listarMascota(r.getIdMascota());
            req.setAttribute("mascotaList", mascotaL);
            req.getRequestDispatcher("views/cita/editarMascota.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente, preparados para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }
    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idMascota")!=null){
            r.setIdMascota(Integer.parseInt(req.getParameter("idMascota")));//Cambiar de string a int
        }
        if (req.getParameter("nombreMascota")!= null){
            r.setNombreMascota(req.getParameter("nombreMascota"));
        }
        if(req.getParameter("tipoMascota")!= null){
            r.setTipoMascota(req.getParameter("tipoMascota"));
        }
        if (req.getParameter("razaMascota")!=null){
            r.setRazaMascota(req.getParameter("razaMascota"));
        }
        if (req.getParameter("pesoMascota")!= null){
            r.setPesoMascota(req.getParameter("pesoMascota"));
        }
        if (req.getParameter("comportamientoMascota")!= null){
            r.setComportamientoMascota(req.getParameter("comportamientoMascota"));
        }
        try {
            rd.actualizar(r);
            System.out.println("Editar el registro de Cliente");
            mascotaList(req, resp);
        } catch (Exception e) {
            System.out.println("Error al editar del registro "+e.getMessage().toString());
        }
    }
}
