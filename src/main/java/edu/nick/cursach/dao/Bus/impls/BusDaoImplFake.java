package edu.nick.cursach.dao.bus.impls;

import edu.nick.cursach.dao.Bus.interfaces.IBusDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BusDaoImplFake implements IBusDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Bus save(Bus bus) {
        return null;
    }

    @Override
    public Bus get(String id) {
        return null;
    }

    @Override
    public List<Bus> getAll() {
        return this.dataSet.getBuses();
    }

    @Override
    public Bus edit(Bus bus) {
        return null;
    }

    @Override
    public Bus delete(String id) {
        return null;
    }
}
