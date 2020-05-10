package edu.nick.cursach.dao.RemovedTransport.interfaces;

import edu.nick.cursach.model.PassangerTransportation;
import edu.nick.cursach.model.RemovedTransport;

import java.util.List;

public interface IRemovedTransportDao {
    RemovedTransport save (RemovedTransport removedTransport);
    RemovedTransport get (String id);
    List<RemovedTransport> getAll();
    RemovedTransport edit (RemovedTransport removedTransport);
    RemovedTransport delete(String id);
}
