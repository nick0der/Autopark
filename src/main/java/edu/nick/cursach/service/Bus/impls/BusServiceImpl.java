package edu.nick.cursach.service.Bus.impls;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.repository.BusRepository;
import edu.nick.cursach.model.Bus;
import edu.nick.cursach.service.Bus.interfaces.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements IBusService {

    @Autowired
    BusRepository repository;

    @Override
    public Bus save(Bus bus) {
        bus.setDateCreated(LocalDateTime.now());
        bus.setDateModified(LocalDateTime.now());
        return repository.save(bus);
    }

    @Override
    public Bus get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Bus> getAll() {
        return repository.findAll();
    }

    @Override
    public Bus edit(Bus bus) {
        bus.setDateCreated(repository.findById(bus.getId()).orElse(null).getDateCreated());
        bus.setDateModified(LocalDateTime.now());
        return repository.save(bus);
    }

    @Override
    public Bus delete(String id) {
        Bus bus = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return bus;
    }

    public List<Bus> search(String word) {
        List<Bus> found = this.getAll().stream()
                .filter(bus -> bus.getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Bus> sortedByBrand(List<Bus> list, String order) {

        list.sort(Comparator.comparing(Transport::getBrand));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
