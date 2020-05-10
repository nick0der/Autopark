package edu.nick.cursach.service.FreightTransport.interfaces;

import edu.nick.cursach.model.FreightTransport;

import java.util.List;

public interface IFreightTransportService {
    FreightTransport save (FreightTransport freightTransport);
    FreightTransport get (String id);
    List<FreightTransport> getAll();
    FreightTransport edit (FreightTransport freightTransport);
    FreightTransport delete(String id);
}
