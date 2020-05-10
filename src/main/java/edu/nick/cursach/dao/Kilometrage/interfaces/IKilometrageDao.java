package edu.nick.cursach.dao.Kilometrage.interfaces;

import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.model.Kilometrage;

import java.util.List;

public interface IKilometrageDao {
    Kilometrage save (Kilometrage kilometrage);
    Kilometrage get (String id);
    List<Kilometrage> getAll();
    FreightTransport edit (Kilometrage kilometrage);
    FreightTransport delete(String id);
}
