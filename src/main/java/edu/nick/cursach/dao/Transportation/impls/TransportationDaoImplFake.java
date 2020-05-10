package edu.nick.cursach.dao.Transportation.impls;

import edu.nick.cursach.dao.Transportation.interfaces.ITransportationDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Transportation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransportationDaoImplFake implements ITransportationDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Transportation save(Transportation transportation) {
        return null;
    }

    @Override
    public Transportation get(String id) {
        return null;
    }

    @Override
    public List<Transportation> getAll() {
        return dataSet.getTransportations();
    }

    @Override
    public Transportation edit(Transportation transportation) {
        return null;
    }

    @Override
    public Transportation delete(String id) {
        return null;
    }
}
