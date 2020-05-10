package edu.nick.cursach.dao.Taxi.impls;

import edu.nick.cursach.dao.Taxi.interfaces.ITaxiDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaxiDaoImplFake implements ITaxiDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Taxi save(Taxi taxi) {
        return null;
    }

    @Override
    public Taxi get(String id) {
        return null;
    }

    @Override
    public List<Taxi> getAll() {
        return dataSet.getTaxis();
    }

    @Override
    public Taxi edit(Taxi taxi) {
        return null;
    }

    @Override
    public Taxi delete(String id) {
        return null;
    }
}
