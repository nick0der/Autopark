package edu.nick.cursach.dao.Chief.impls;

import edu.nick.cursach.dao.Chief.interfaces.IChiefDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Chief;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChiefDaoImplFake implements IChiefDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Chief save(Chief chief) {
        return null;
    }

    @Override
    public Chief get(String id) {
        return null;
    }

    @Override
    public List<Chief> getAll() {
        return dataSet.getChiefs();
    }

    @Override
    public Chief edit(Chief chief) {
        return null;
    }

    @Override
    public Chief delete(String id) {
        return null;
    }
}
