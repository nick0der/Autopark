package edu.nick.cursach.service.Taxi.interfaces;

import edu.nick.cursach.model.Taxi;

import java.util.List;

public interface ITaxiService {
    Taxi save (Taxi taxi);
    Taxi get (String id);
    List<Taxi> getAll();
    Taxi edit (Taxi taxi);
    Taxi delete(String id);
}
