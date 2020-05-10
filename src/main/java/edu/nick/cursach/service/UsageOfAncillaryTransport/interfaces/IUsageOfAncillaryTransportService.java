package edu.nick.cursach.service.UsageOfAncillaryTransport.interfaces;

import edu.nick.cursach.model.UsageOfAncillaryTransport;

import java.util.List;

public interface IUsageOfAncillaryTransportService {
    UsageOfAncillaryTransport save (UsageOfAncillaryTransport usageOfAncillaryTransport);
    UsageOfAncillaryTransport get (String id);
    List<UsageOfAncillaryTransport> getAll();
    UsageOfAncillaryTransport edit (UsageOfAncillaryTransport usageOfAncillaryTransport);
    UsageOfAncillaryTransport delete(String id);
}
