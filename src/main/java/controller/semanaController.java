package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.semana.semanaDao;
import model.semana.semanaVo;

public class semanaController extends HttpServlet {
    semanaVo r = new semanaVo();
    semanaDao rd = new semanaDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String a = req.getParameter("accion");

        switch (a) {
            case "ingresar":
                ingresar(req, resp);
                break;
            case "consultar":
                semanaList(req, resp);
                break;
        }
    }

    private void ingresar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("views/cita/gestionCita.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        } catch (Exception e) {
            System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
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

        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("nombreSemana") != null) {
            r.setNombreSemana(req.getParameter("nombreSemana"));
        }
        if (req.getParameter("fechaInicio") != null) {
            r.setFechaInicio(req.getParameter("fechaInicio"));
        }
        if (req.getParameter("fechaFinalizacion") != null) {
            r.setFechaFinalizacion(req.getParameter("fechaFinalizacion"));
        }
        if (req.getParameter("estadoSemana") != null) {
            r.setEstadoSemana(req.getParameter("estadoSemana"));
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            semanaList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    }

    private void semanaList(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<semanaVo> semanaL = rd.semanaList();
            req.setAttribute("semanaList", semanaL);
            req.getRequestDispatcher("views/cita/Semana.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
        }
    }

}
