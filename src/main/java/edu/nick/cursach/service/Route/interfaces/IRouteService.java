package edu.nick.cursach.service.Route.interfaces;

import edu.nick.cursach.model.Route;

import java.util.List;

public interface IRouteService {
    Route save (Route route);
    Route get (String id);
    List<Route> getAll();
    Route edit (Route route);
    Route delete(String id);
}
