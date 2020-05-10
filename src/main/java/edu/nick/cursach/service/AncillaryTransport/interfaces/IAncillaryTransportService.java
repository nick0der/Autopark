package edu.nick.cursach.service.AncillaryTransport.interfaces;

import edu.nick.cursach.model.AncillaryTransport;

import java.util.List;

public interface IAncillaryTransportService {
    AncillaryTransport save (AncillaryTransport ancillaryTransport);
    AncillaryTransport get (String id);
    List<AncillaryTransport> getAll();
    AncillaryTransport edit (AncillaryTransport ancillaryTransport);
    AncillaryTransport delete(String id);
}
