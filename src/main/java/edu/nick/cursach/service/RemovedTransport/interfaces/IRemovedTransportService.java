package edu.nick.cursach.service.RemovedTransport.interfaces;

import edu.nick.cursach.model.RemovedTransport;

import java.util.List;

public interface IRemovedTransportService {
    RemovedTransport save (RemovedTransport removedTransport);
    RemovedTransport get (String id);
    List<RemovedTransport> getAll();
    RemovedTransport edit (RemovedTransport removedTransport);
    RemovedTransport delete(String id);
}
