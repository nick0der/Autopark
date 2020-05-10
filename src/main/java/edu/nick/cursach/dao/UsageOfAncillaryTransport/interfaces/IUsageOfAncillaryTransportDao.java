package edu.nick.cursach.dao.UsageOfAncillaryTransport.interfaces;

import edu.nick.cursach.model.Transportation;
import edu.nick.cursach.model.UsageOfAncillaryTransport;

import java.util.List;

public interface IUsageOfAncillaryTransportDao {
    UsageOfAncillaryTransport save (UsageOfAncillaryTransport usageOfAncillaryTransport);
    UsageOfAncillaryTransport get (String id);
    List<UsageOfAncillaryTransport> getAll();
    UsageOfAncillaryTransport edit (UsageOfAncillaryTransport usageOfAncillaryTransport);
    UsageOfAncillaryTransport delete(String id);
}
