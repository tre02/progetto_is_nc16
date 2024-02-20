package model;

import jakarta.servlet.http.HttpServletRequest;

public class EventoDAOObserverJSP implements EventoDAOObserver {
    private HttpServletRequest request;

    public EventoDAOObserverJSP(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public void updateEventList() {
        request.setAttribute("refreshPage", true);
    }
}