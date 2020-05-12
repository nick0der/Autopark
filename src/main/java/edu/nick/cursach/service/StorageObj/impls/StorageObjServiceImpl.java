package edu.nick.cursach.service.StorageObj.impls;

import edu.nick.cursach.repository.StorageObjRepository;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.service.StorageObj.interfaces.IStorageObjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageObjServiceImpl implements IStorageObjService {

    @Autowired
    StorageObjRepository repository;

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

    public List<StorageObj> search(Integer word) {
        if ((word == 0)||(word == null)) {
            return this.getAll();
        }
        List<StorageObj> found = this.getAll().stream()
                .filter(storageObj -> Integer.toString(storageObj.getNumber()).contains(word.toString()))
                .collect(Collectors.toList());
        return found;
    }

    public List<StorageObj> sortedByNumber(List<StorageObj> list, String order) {
        Collections.sort(list, (o1, o2) -> {
                    if (o1.getNumber() == o2.getNumber()) {
                        return 0;
                    } else if (o1.getNumber() < o2.getNumber()) {
                        return -1;
                    }
                    return 1; });
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
