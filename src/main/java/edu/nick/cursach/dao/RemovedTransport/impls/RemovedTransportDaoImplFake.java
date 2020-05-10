package edu.nick.cursach.dao.RemovedTransport.impls;

import edu.nick.cursach.dao.RemovedTransport.interfaces.IRemovedTransportDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.RemovedTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RemovedTransportDaoImplFake implements IRemovedTransportDao {

    @Autowired
    DataSet dataSet;

    @Override
    public RemovedTransport save(RemovedTransport removedTransport) {
        return null;
    }

    @Override
    public RemovedTransport get(String id) {
        return null;
    }

    @Override
    public List<RemovedTransport> getAll() {
        return dataSet.getRemovedTransports();
    }

    @Override
    public RemovedTransport edit(RemovedTransport removedTransport) {
        return null;
    }

    @Override
    public RemovedTransport delete(String id) {
        return null;
    }
}
