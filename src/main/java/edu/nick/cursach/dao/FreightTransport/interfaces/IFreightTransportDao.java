package edu.nick.cursach.dao.FreightTransport.interfaces;

import edu.nick.cursach.model.Driver;
import edu.nick.cursach.model.FreightTransport;

import java.util.List;

public interface IFreightTransportDao {
    FreightTransport save (FreightTransport freightTransport);
    FreightTransport get (String id);
    List<FreightTransport> getAll();
    FreightTransport edit (FreightTransport freightTransport);
    FreightTransport delete(String id);
}
