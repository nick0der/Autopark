package edu.nick.cursach.service.Transport.interfaces;

import edu.nick.cursach.model.Transport;

import java.util.ArrayList;
import java.util.List;

public interface ITransportService {

    List<Transport> getAll();
    List<Transport> getPassangerTransportList();
    Transport get(String id);
}
