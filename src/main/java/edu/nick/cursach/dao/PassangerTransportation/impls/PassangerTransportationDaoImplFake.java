package edu.nick.cursach.dao.PassangerTransportation.impls;

import edu.nick.cursach.dao.PassangerTransportation.interfaces.IPassangerTransportationDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.PassangerTransportation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassangerTransportationDaoImplFake implements IPassangerTransportationDao {

    @Autowired
    DataSet dataSet;

    @Override
    public PassangerTransportation save(PassangerTransportation passangerTransportation) {
        return null;
    }

    @Override
    public PassangerTransportation get(String id) {
        return null;
    }

    @Override
    public List<PassangerTransportation> getAll() {
        return dataSet.getPassangerTransportations();
    }

    @Override
    public PassangerTransportation edit(PassangerTransportation passangerTransportation) {
        return null;
    }

    @Override
    public PassangerTransportation delete(String id) {
        return null;
    }
}
