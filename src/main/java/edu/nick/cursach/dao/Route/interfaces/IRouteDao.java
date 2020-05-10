package edu.nick.cursach.dao.Route.interfaces;

import edu.nick.cursach.model.Repair;
import edu.nick.cursach.model.Route;

import java.util.List;

public interface IRouteDao {
    Route save (Route route);
    Route get (String id);
    List<Route> getAll();
    Route edit (Route route);
    Route delete(String id);
}
