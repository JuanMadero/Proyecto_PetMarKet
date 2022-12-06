package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cita.citaDao;
import model.cita.citaVo;

public class citaController extends HttpServlet {

    citaVo r = new citaVo();
    citaDao rd = new citaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String a = req.getParameter("accion");
        switch (a) {
            case "consultar":
                citaList(req, resp);
                break;
            case "eliminar":
                eliminar(req, resp);
                break;
            case "editar":
                editar(req, resp);
                break;
            case "consultarr":
            citaListt(req, resp);
                break;
            case "consultara":
                citaLista(req, resp);
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

    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if (req.getParameter("tipoServicio") != null) {
            r.setTipoServicio(req.getParameter("tipoServicio"));
        }
        if (req.getParameter("idMascota") != null) {
            r.setIdMascota(req.getParameter("idMascota"));
        }
        if (req.getParameter("idBloque") != null) {
            r.setIdBloque(req.getParameter("idBloque"));
        }
        if (req.getParameter("idRecepcionista") != null) {
            r.setIdUsuario(req.getParameter("idRecepcionista"));
        }
        if (req.getParameter("idCliente") != null) {
            r.setIdCliente(req.getParameter("idCliente"));
        }
        try {
            rd.registrar(r);
            System.out.println("Registro de cita insertado correctamente");
            citaList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    }

    private void citaList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<citaVo> citaL = rd.citaList();
            req.setAttribute("citaList", citaL);
            req.getRequestDispatcher("views/cita/consultarCita.jsp").forward(req, resp);
            System.out.println("Datos listados bloques correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void citaListt(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<citaVo> citaL = rd.citaListt();
            req.setAttribute("citaList", citaL);
            req.getRequestDispatcher("views/auxiliar/consultarCita.jsp").forward(req, resp);
            System.out.println("Datos listados bloques correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void citaLista(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<citaVo> citaL = rd.citaList();
            req.setAttribute("citaList", citaL);
            req.getRequestDispatcher("views/administrador/consultarCita.jsp").forward(req, resp);
            System.out.println("Datos listados bloques correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("id") != null) {
            r.setIdCita(Integer.parseInt(req.getParameter("id")));
        }
        try {
            rd.eliminar(r.getIdCita());
            System.out.println("La cita se elimino correctamente");
            citaList(req, resp);
        } catch (Exception e) {
            System.out.println("Error al eliminar el cliente" + e.getMessage().toString());
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idCita") != null) {
            r.setIdCita(Integer.parseInt(req.getParameter("idCita")));
        }
        try {
            List<citaVo> citaL = rd.listarCita(r.getIdCita());
            req.setAttribute("citaList", citaL);
            req.getRequestDispatcher("views/cita/editarCita.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente, preparados para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idCita") != null) {
            r.setIdCita(Integer.parseInt(req.getParameter("idCita")));// Cambiar de string a int
        }
        if (req.getParameter("tipoServicio") != null) {
            r.setTipoServicio(req.getParameter("tipoServicio"));
        }
        if (req.getParameter("idMascota") != null) {
            r.setIdMascota(req.getParameter("idMascota"));
        }
        if (req.getParameter("idBloque") != null) {
            r.setIdBloque(req.getParameter("idBloque"));
        }
        try {
            rd.actualizar(r);
            System.out.println("Editar el registro de Cliente");
            citaList(req, resp);
        } catch (Exception e) {
            System.out.println("Error al editar del registro " + e.getMessage().toString());
        }
    }
}
