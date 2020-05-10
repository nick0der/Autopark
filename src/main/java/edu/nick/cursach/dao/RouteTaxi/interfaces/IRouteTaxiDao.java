package edu.nick.cursach.dao.RouteTaxi.interfaces;

import edu.nick.cursach.model.Route;
import edu.nick.cursach.model.RouteTaxi;

import java.util.List;

public interface IRouteTaxiDao {
    RouteTaxi save (RouteTaxi routeTaxi);
    RouteTaxi get (String id);
    List<RouteTaxi> getAll();
    RouteTaxi edit (RouteTaxi routeTaxi);
    RouteTaxi delete(String id);
}
