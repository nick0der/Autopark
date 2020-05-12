package edu.nick.cursach.service.Master.impls;

import edu.nick.cursach.repository.MasterRepository;
import edu.nick.cursach.model.Master;
import edu.nick.cursach.service.Master.interfaces.IMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MasterServiceImpl implements IMasterService {

    @Autowired
    MasterRepository repository;

    @Override
    public Master save(Master master) {
        master.setDateCreated(LocalDateTime.now());
        master.setDateModified(LocalDateTime.now());
        return repository.save(master);
    }

    @Override
    public Master get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Master> getAll() {
        return repository.findAll();
    }

    @Override
    public Master edit(Master master) {
        master.setDateModified(LocalDateTime.now());
        return repository.save(master);
    }

    @Override
    public Master delete(String id) {
        Master master = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return master;
    }

    public List<Master> search(String word) {
        List<Master> found = this.getAll().stream()
                .filter(master -> master.getLastName().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Master> sortedByLastName(List<Master> list, String order) {

        list.sort(Comparator.comparing(Master::getLastName));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
