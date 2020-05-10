package edu.nick.cursach.dao.Repair.impls;

import edu.nick.cursach.dao.Repair.interfaces.IRepairDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepairDaoImplFake implements IRepairDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Repair save(Repair repair) {
        return null;
    }

    @Override
    public Repair get(String id) {
        return null;
    }

    @Override
    public List<Repair> getAll() {
        return dataSet.getRepairs();
    }

    @Override
    public Repair edit(Repair repair) {
        return null;
    }

    @Override
    public Repair delete(String id) {
        return null;
    }
}
