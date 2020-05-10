package edu.nick.cursach.dao.StorageObj.interfaces;

import edu.nick.cursach.model.RouteTaxi;
import edu.nick.cursach.model.StorageObj;

import java.util.List;

public interface IStorageObjDao {
    StorageObj save (StorageObj storageObj);
    StorageObj get (String id);
    List<StorageObj> getAll();
    StorageObj edit (StorageObj storageObj);
    StorageObj delete(String id);
}
