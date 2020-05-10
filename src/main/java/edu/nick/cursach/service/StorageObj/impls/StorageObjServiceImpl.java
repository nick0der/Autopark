package edu.nick.cursach.service.StorageObj.impls;

import edu.nick.cursach.dao.StorageObj.impls.StorageObjDaoImplFake;
import edu.nick.cursach.repository.StorageObjRepository;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.service.StorageObj.interfaces.IStorageObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StorageObjServiceImpl implements IStorageObjService {

    @Autowired
    StorageObjDaoImplFake dao;

    @Autowired
    StorageObjRepository repository;

    @PostConstruct
    void init(){
//        List<StorageObj> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public StorageObj save(StorageObj storageObj) {
        storageObj.setDateCreated(LocalDateTime.now());
        storageObj.setDateModified(LocalDateTime.now());
        return repository.save(storageObj);
    }

    @Override
    public StorageObj get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<StorageObj> getAll() {
        return repository.findAll();
    }

    @Override
    public StorageObj edit(StorageObj storageObj) {
        storageObj.setDateModified(LocalDateTime.now());
        return repository.save(storageObj);
    }

    @Override
    public StorageObj delete(String id) {
        StorageObj storageObj = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return storageObj;
    }
}
