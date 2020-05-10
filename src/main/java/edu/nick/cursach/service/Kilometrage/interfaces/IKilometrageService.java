package edu.nick.cursach.service.Kilometrage.interfaces;

import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.model.Kilometrage;

import java.util.List;

public interface IKilometrageService {
    Kilometrage save (Kilometrage kilometrage);
    Kilometrage get (String id);
    List<Kilometrage> getAll();
    Kilometrage edit (Kilometrage kilometrage);
    Kilometrage delete(String id);
}
