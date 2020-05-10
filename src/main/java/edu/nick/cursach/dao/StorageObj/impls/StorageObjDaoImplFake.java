package edu.nick.cursach.dao.StorageObj.impls;

import edu.nick.cursach.dao.StorageObj.interfaces.IStorageObjDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.StorageObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StorageObjDaoImplFake implements IStorageObjDao {

    @Autowired
    DataSet dataSet;

    @Override
    public StorageObj save(StorageObj storageObj) {
        return null;
    }

    @Override
    public StorageObj get(String id) {
        return null;
    }

    @Override
    public List<StorageObj> getAll() {
        return dataSet.getStorageObjs();
    }

    @Override
    public StorageObj edit(StorageObj storageObj) {
        return null;
    }

    @Override
    public StorageObj delete(String id) {
        return null;
    }
}
