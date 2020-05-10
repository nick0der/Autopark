package edu.nick.cursach.dao.Master.impls;

import edu.nick.cursach.dao.Master.interfaces.IMasterDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Master;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MasterDaoImplFake implements IMasterDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Master save(Master master) {
        return null;
    }

    @Override
    public Master get(String id) {
        return null;
    }

    @Override
    public List<Master> getAll() {
        return dataSet.getMasters();
    }

    @Override
    public Master edit(Master master) {
        return null;
    }

    @Override
    public Master delete(String id) {
        return null;
    }
}
