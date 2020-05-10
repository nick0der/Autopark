package edu.nick.cursach.dao.RouteTaxi.impls;

import edu.nick.cursach.dao.RouteTaxi.interfaces.IRouteTaxiDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.RouteTaxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteTaxiDaoImplFake implements IRouteTaxiDao {

    @Autowired
    DataSet dataSet;

    @Override
    public RouteTaxi save(RouteTaxi routeTaxi) {
        return null;
    }

    @Override
    public RouteTaxi get(String id) {
        return null;
    }

    @Override
    public List<RouteTaxi> getAll() {
        return dataSet.getRouteTaxis();
    }

    @Override
    public RouteTaxi edit(RouteTaxi routeTaxi) {
        return null;
    }

    @Override
    public RouteTaxi delete(String id) {
        return null;
    }
}
