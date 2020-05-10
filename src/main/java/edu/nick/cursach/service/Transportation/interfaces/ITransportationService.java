package edu.nick.cursach.service.Transportation.interfaces;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.model.Transportation;

import java.util.List;

public interface ITransportationService {
    Transportation save (Transportation transportation);
    Transportation get (String id);
    List<Transportation> getAll();
    Transportation edit (Transportation transportation);
    Transportation delete(String id);
}
