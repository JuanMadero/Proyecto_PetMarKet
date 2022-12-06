package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bloque.bloqueDao;
import model.bloque.bloqueVo;
import model.semana.semanaDao;
import model.semana.semanaVo;


public class bloqueController extends HttpServlet {
    bloqueVo r = new bloqueVo();
    bloqueDao rd = new bloqueDao();

    semanaVo s = new semanaVo();
    semanaDao sd = new semanaDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entro al doGet");
        String a = req.getParameter("accion");

        switch (a) {
            case "ingresar":
                ingresar(req, resp);
                break;
            case "consultar":
                bloqueList(req, resp);
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
        if (req.getParameter("idSemana") != null) {
            r.setIdSemana(req.getParameter("idSemana"));
        }
        if (req.getParameter("diaBloque") != null) {
            r.setDiaBloque(req.getParameter("diaBloque"));
        }
        if (req.getParameter("horaInicioBloque") != null) {
            r.setHoraInicioBloque(req.getParameter("horaInicioBloque"));
        }
        if (req.getParameter("horaFinalizacionBloque") != null) {
            r.setHoraFinalizacionBloque(req.getParameter("horaFinalizacionBloque"));
        }
        if (req.getParameter("estadoBloque") != null) {
            r.setEstadoBloque(req.getParameter("estadoBloque"));
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");
            bloqueList(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro " + e.getMessage().toString());
        }
    }

    private void bloqueList(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("idSemana")!= null){
            r.setIdSemana(req.getParameter("idSemana"));
        }

        try {
            List<bloqueVo> bloquel = rd.bloqueList(r.getIdSemana());
            req.setAttribute("bloqueList", bloquel);

            List<semanaVo> semanal = sd.semanaListId(r.getIdSemana());
            req.setAttribute("semanaListId", semanal);

            req.getRequestDispatcher("views/cita/consultarSemana.jsp").forward(req, resp);
            System.out.println("Datos listados correctamente, preparados para la edicion");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

}
