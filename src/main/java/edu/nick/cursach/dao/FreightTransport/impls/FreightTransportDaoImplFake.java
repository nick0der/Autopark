package edu.nick.cursach.dao.FreightTransport.impls;

import edu.nick.cursach.dao.FreightTransport.interfaces.IFreightTransportDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.FreightTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FreightTransportDaoImplFake implements IFreightTransportDao {

    @Autowired
    DataSet dataSet;

    @Override
    public FreightTransport save(FreightTransport freightTransport) {
        return null;
    }

    @Override
    public FreightTransport get(String id) {
        return null;
    }

    @Override
    public List<FreightTransport> getAll() {
        return dataSet.getFreightTransports();
    }

    @Override
    public FreightTransport edit(FreightTransport freightTransport) {
        return null;
    }

    @Override
    public FreightTransport delete(String id) {
        return null;
    }
}
