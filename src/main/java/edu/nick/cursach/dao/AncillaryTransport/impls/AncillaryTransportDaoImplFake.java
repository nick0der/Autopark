package edu.nick.cursach.dao.AncillaryTransport.impls;

import edu.nick.cursach.dao.AncillaryTransport.interfaces.IAncillaryTransportDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.AncillaryTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AncillaryTransportDaoImplFake implements IAncillaryTransportDao {

    @Autowired
    DataSet dataSet;

    @Override
    public AncillaryTransport save(AncillaryTransport ancillaryTransport) {
        return null;
    }

    @Override
    public AncillaryTransport get(String id) {
        return null;
    }

    @Override
    public List<AncillaryTransport> getAll() {
        return dataSet.getAncillaryTransports();
    }

    @Override
    public AncillaryTransport edit(AncillaryTransport ancillaryTransport) {
        return null;
    }

    @Override
    public AncillaryTransport delete(String id) {
        return null;
    }
}
