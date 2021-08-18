package histopatologialab.reporte;

import histopatologialab.core.RequestAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static histopatologialab.core.Daos.reporteDao;
import static histopatologialab.core.ServletHelper.checkSession;
import static histopatologialab.core.ServletHelper.getRequestAction;

@WebServlet(name = "ReporteServlet")
public class ReporteServlet extends HttpServlet {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        checkSession(request, response);

        RequestAction action = getRequestAction(request);
        String tipo = request.getParameter("tipo");

        if (action == RequestAction.DESCARGAR_INFORME) {
            returnCSV(request, response, tipo);
        } else {
            getDefaultPage(request, response);
        }
    }

    private void getDefaultPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher despachador = request.getRequestDispatcher("reporte/reporte.jsp");
        despachador.forward(request, response);
    }

    public void returnCSV(HttpServletRequest request, HttpServletResponse response, String tipo) throws IOException {
        String fromString = request.getParameter("from");
        String toString = request.getParameter("to");
        LocalDate from = LocalDate.parse(fromString, formatter);
        LocalDate to = LocalDate.parse(toString, formatter);

        String filename = tipo + "-" + LocalDate.now();
        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename="+filename+".csv");
        ServletOutputStream out = response.getOutputStream();

        String content;
        if (tipo.equals("examen")) {
            content = reporteDao.getReporteExamen(from, to);
        }
        else if (tipo.equals("biopsia")) {
            content = reporteDao.getReporteBiopsia(from, to);
        }
        else if (tipo.equals("frote")) {
            content = reporteDao.getReporteFrote(from, to);
        } else {
            content = "";
        }
        out.println(content);
    }
}
