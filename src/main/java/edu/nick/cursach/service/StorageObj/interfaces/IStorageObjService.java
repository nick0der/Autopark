package edu.nick.cursach.service.StorageObj.interfaces;

import edu.nick.cursach.model.StorageObj;

import java.util.List;

public interface IStorageObjService {
    StorageObj save (StorageObj storageObj);
    StorageObj get (String id);
    List<StorageObj> getAll();
    StorageObj edit (StorageObj storageObj);
    StorageObj delete(String id);
}
