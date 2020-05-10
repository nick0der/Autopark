package edu.nick.cursach.service.RouteTaxi.interfaces;

import edu.nick.cursach.model.RouteTaxi;

import java.util.List;

public interface IRouteTaxiService {
    RouteTaxi save (RouteTaxi routeTaxi);
    RouteTaxi get (String id);
    List<RouteTaxi> getAll();
    RouteTaxi edit (RouteTaxi routeTaxi);
    RouteTaxi delete(String id);
}
