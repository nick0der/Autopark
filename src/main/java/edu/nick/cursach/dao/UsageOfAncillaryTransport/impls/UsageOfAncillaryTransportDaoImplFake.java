package edu.nick.cursach.dao.UsageOfAncillaryTransport.impls;

import edu.nick.cursach.dao.UsageOfAncillaryTransport.interfaces.IUsageOfAncillaryTransportDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.UsageOfAncillaryTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsageOfAncillaryTransportDaoImplFake implements IUsageOfAncillaryTransportDao {

    @Autowired
    DataSet dataSet;

    @Override
    public UsageOfAncillaryTransport save(UsageOfAncillaryTransport usageOfAncillaryTransport) {
        return null;
    }

    @Override
    public UsageOfAncillaryTransport get(String id) {
        return null;
    }

    @Override
    public List<UsageOfAncillaryTransport> getAll() {
        return dataSet.getUsageOfAncillaryTransports();
    }

    @Override
    public UsageOfAncillaryTransport edit(UsageOfAncillaryTransport usageOfAncillaryTransport) {
        return null;
    }

    @Override
    public UsageOfAncillaryTransport delete(String id) {
        return null;
    }
}
