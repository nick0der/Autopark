package edu.nick.cursach.dao.AddedTransport.impls;

import edu.nick.cursach.dao.AddedTransport.interfaces.IAddedTransportDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.AddedTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddedTransportDaoImplFake implements IAddedTransportDao {

    @Autowired
    DataSet dataSet;

    @Override
    public AddedTransport save(AddedTransport addedTransport) {
        return null;
    }

    @Override
    public AddedTransport get(String id) {
        return null;
    }

    @Override
    public List<AddedTransport> getAll() {
        return dataSet.getAddedTransports();
    }

    @Override
    public AddedTransport edit(AddedTransport addedTransport) {
        return null;
    }

    @Override
    public AddedTransport delete(String id) {
        return null;
    }
}
