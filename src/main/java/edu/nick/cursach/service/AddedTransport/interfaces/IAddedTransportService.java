package edu.nick.cursach.service.AddedTransport.interfaces;

import edu.nick.cursach.model.AddedTransport;

import java.util.List;

public interface IAddedTransportService {
    AddedTransport save (AddedTransport addedTransport);
    AddedTransport get (String id);
    List<AddedTransport> getAll();
    AddedTransport edit (AddedTransport addedTransport);
    AddedTransport delete(String id);
}
