package edu.nick.cursach.service.PassangerTransportation.interfaces;

import edu.nick.cursach.model.PassangerTransportation;

import java.util.List;

public interface IPassangerTransportationService {
    PassangerTransportation save (PassangerTransportation passangerTransportation);
    PassangerTransportation get (String id);
    List<PassangerTransportation> getAll();
    PassangerTransportation edit (PassangerTransportation passangerTransportation);
    PassangerTransportation delete(String id);

}
