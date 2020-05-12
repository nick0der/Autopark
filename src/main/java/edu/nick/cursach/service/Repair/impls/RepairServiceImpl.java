package edu.nick.cursach.service.Repair.impls;

import edu.nick.cursach.repository.RepairRepository;
import edu.nick.cursach.model.Repair;
import edu.nick.cursach.service.Repair.interfaces.IRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepairServiceImpl implements IRepairService {

    @Autowired
    RepairRepository repository;

    @Override
    public Repair save(Repair repair) {
        repair.setDateCreated(LocalDateTime.now());
        repair.setDateModified(LocalDateTime.now());
        return repository.save(repair);
    }

    @Override
    public Repair get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Repair> getAll() {
        return repository.findAll();
    }

    @Override
    public Repair edit(Repair repair) {
        repair.setDateModified(LocalDateTime.now());
        return repository.save(repair);
    }

    @Override
    public Repair delete(String id) {
        Repair repair = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return repair;
    }

    public List<Repair> search(String word) {
        List<Repair> found = this.getAll().stream()
                .filter(repair -> repair.getTransport().getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Repair> sortedByDate(List<Repair> list, String order) {

        list.sort(Comparator.comparing(Repair::getDateRepaired));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
