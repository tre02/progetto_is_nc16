package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Evento;
import model.EventoDAO;
import model.Organizzatore;
import model.OrganizzatoreDAO;

import java.io.IOException;

@WebServlet({"/AggiuntaEventoServlet"})
public class AggiuntaEventoServlet extends HttpServlet {
    public AggiuntaEventoServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Evento p = new Evento();
        EventoDAO dao = new EventoDAO();
        p.setNomeEvento(request.getParameter("nomeEvento"));
        p.setId_evento(Integer.parseInt(request.getParameter("ID_evento")));
        p.setPosti_disponibili(request.getIntHeader("posti_disponibili"));
        p.setData_evento(request.getParameter("data"));
        p.setLuogo(request.getParameter("luogo"));
        p.setOra(request.getParameter("ora"));
        p.setTipo(request.getParameter("tipo"));
        if(dao.doRetrieveById(Integer.parseInt(request.getParameter("ID_evento")))!=null) {
            if(request.getSession().getAttribute("organizzatore")!= null){
                Organizzatore temp = (Organizzatore) request.getSession().getAttribute("organizzatore");
                OrganizzatoreDAO daoOrg = new OrganizzatoreDAO();
                temp.setEventi_organizzati(temp.getEventi_organizzati()+1);
                daoOrg.doUpdate(temp);
            }
            dao.doSave(p);
        }else{
            response.sendRedirect(request.getContextPath() + "webapp/error.jsp");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServletAmministratore");
        dispatcher.forward(request, response);
    }
}