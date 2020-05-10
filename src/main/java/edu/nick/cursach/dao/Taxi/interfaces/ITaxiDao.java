package edu.nick.cursach.dao.Taxi.interfaces;

import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.model.Taxi;

import java.util.List;

public interface ITaxiDao {
    Taxi save (Taxi taxi);
    Taxi get (String id);
    List<Taxi> getAll();
    Taxi edit (Taxi taxi);
    Taxi delete(String id);
}

