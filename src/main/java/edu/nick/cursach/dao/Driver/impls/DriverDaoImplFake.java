package edu.nick.cursach.dao.Driver.impls;

import edu.nick.cursach.dao.Driver.interfaces.IDriverDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DriverDaoImplFake implements IDriverDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Driver save(Driver driver) {
        return null;
    }

    @Override
    public Driver get(String id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return dataSet.getDrivers();
    }

    @Override
    public Driver edit(Driver driver) {
        return null;
    }

    @Override
    public Driver delete(String id) {
        return null;
    }
}
