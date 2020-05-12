package edu.nick.cursach.service.Chief.impls;

import edu.nick.cursach.repository.ChiefRepository;
import edu.nick.cursach.model.Chief;
import edu.nick.cursach.service.Chief.interfaces.IChiefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChiefServiceImpl implements IChiefService {

    @Autowired
    ChiefRepository repository;

    @Override
    public Chief save(Chief chief) {
        chief.setDateCreated(LocalDateTime.now());
        chief.setDateModified(LocalDateTime.now());
        return repository.save(chief);
    }

    @Override
    public Chief get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Chief> getAll() {
        return repository.findAll();
    }

    @Override
    public Chief edit(Chief chief) {
        chief.setDateModified(LocalDateTime.now());
        return repository.save(chief);
    }

    @Override
    public Chief delete(String id) {
        Chief chief = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return chief;
    }

    public List<Chief> search(String word) {
        List<Chief> found = this.getAll().stream()
                .filter(chief -> chief.getLastName().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Chief> sortedByLastName(List<Chief> list, String order) {

        list.sort(Comparator.comparing(Chief::getLastName));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
