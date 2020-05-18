package edu.nick.cursach.service.RouteTaxi.impls;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.repository.RouteTaxiRepository;
import edu.nick.cursach.model.RouteTaxi;
import edu.nick.cursach.service.RouteTaxi.interfaces.IRouteTaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteTaxiServiceImpl implements IRouteTaxiService {

    @Autowired
    RouteTaxiRepository repository;

    @Override
    public RouteTaxi save(RouteTaxi routeTaxi) {
        routeTaxi.setDateCreated(LocalDateTime.now());
        routeTaxi.setDateModified(LocalDateTime.now());
        return repository.save(routeTaxi);
    }

    @Override
    public RouteTaxi get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<RouteTaxi> getAll() {
        return repository.findAll();
    }

    @Override
    public RouteTaxi edit(RouteTaxi routeTaxi) {
        routeTaxi.setDateCreated(repository.findById(routeTaxi.getId()).orElse(null).getDateCreated());
        routeTaxi.setDateModified(LocalDateTime.now());
        return repository.save(routeTaxi);
    }

    @Override
    public RouteTaxi delete(String id) {
        RouteTaxi routeTaxi = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return routeTaxi;
    }

    public List<RouteTaxi> search(String word) {
        List<RouteTaxi> found = this.getAll().stream()
                .filter(routeTaxi -> routeTaxi.getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<RouteTaxi> sortedByBrand(List<RouteTaxi> list, String order) {

        list.sort(Comparator.comparing(Transport::getBrand));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
