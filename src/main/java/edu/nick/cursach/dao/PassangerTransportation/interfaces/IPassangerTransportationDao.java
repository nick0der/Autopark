package edu.nick.cursach.dao.PassangerTransportation.interfaces;

import edu.nick.cursach.model.Master;
import edu.nick.cursach.model.PassangerTransportation;

import java.util.List;

public interface IPassangerTransportationDao {
    PassangerTransportation save (PassangerTransportation passangerTransportation);
    PassangerTransportation get (String id);
    List<PassangerTransportation> getAll();
    PassangerTransportation edit (PassangerTransportation passangerTransportation);
    PassangerTransportation delete(String id);
}
