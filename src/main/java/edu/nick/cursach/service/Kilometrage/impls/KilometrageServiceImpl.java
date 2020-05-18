package edu.nick.cursach.service.Kilometrage.impls;

import edu.nick.cursach.repository.KilometrageRepository;
import edu.nick.cursach.model.Kilometrage;
import edu.nick.cursach.service.Kilometrage.interfaces.IKilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KilometrageServiceImpl implements IKilometrageService {

    @Autowired
    KilometrageRepository repository;

    @Override
    public Kilometrage save(Kilometrage kilometrage) {
        kilometrage.setDateCreated(LocalDateTime.now());
        kilometrage.setDateModified(LocalDateTime.now());
        return repository.save(kilometrage);
    }

    @Override
    public Kilometrage get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Kilometrage> getAll() {
        return repository.findAll();
    }

    @Override
    public Kilometrage edit(Kilometrage kilometrage) {
        kilometrage.setDateCreated(repository.findById(kilometrage.getId()).orElse(null).getDateCreated());
        kilometrage.setDateModified(LocalDateTime.now());
        return repository.save(kilometrage);
    }

    @Override
    public Kilometrage delete(String id) {
        Kilometrage kilometrage = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return kilometrage;
    }

    public List<Kilometrage> search(String word) {
        List<Kilometrage> found = this.getAll().stream()
                .filter(kilometrage -> kilometrage.getTransport().getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Kilometrage> sortedByDate(List<Kilometrage> list, String order) {

        list.sort(Comparator.comparing(Kilometrage::getDateRecorded));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
