package edu.nick.cursach.service.Taxi.impls;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.repository.TaxiRepository;
import edu.nick.cursach.model.Taxi;
import edu.nick.cursach.service.Taxi.interfaces.ITaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaxiServiceImpl implements ITaxiService {

    @Autowired
    TaxiRepository repository;

    @Override
    public Taxi save(Taxi taxi) {
        taxi.setDateCreated(LocalDateTime.now());
        taxi.setDateModified(LocalDateTime.now());
        return repository.save(taxi);
    }

    @Override
    public Taxi get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Taxi> getAll() {
        return repository.findAll();
    }

    @Override
    public Taxi edit(Taxi taxi) {
        taxi.setDateCreated(repository.findById(taxi.getId()).orElse(null).getDateCreated());
        taxi.setDateModified(LocalDateTime.now());
        return repository.save(taxi);
    }

    @Override
    public Taxi delete(String id) {
        Taxi taxi = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return taxi;
    }

    public List<Taxi> search(String word) {
        List<Taxi> found = this.getAll().stream()
                .filter(taxi -> taxi.getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Taxi> sortedByBrand(List<Taxi> list, String order) {
        list.sort(Comparator.comparing(Transport::getBrand));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
