package edu.nick.cursach.service.FreightTransport.impls;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.repository.FreightTransportRepository;
import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.service.FreightTransport.interfaces.IFreightTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FreightTransportServiceImpl implements IFreightTransportService {

    @Autowired
    FreightTransportRepository repository;

    @Override
    public FreightTransport save(FreightTransport freightTransport) {
        freightTransport.setDateCreated(LocalDateTime.now());
        freightTransport.setDateModified(LocalDateTime.now());
        return repository.save(freightTransport);
    }

    @Override
    public FreightTransport get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<FreightTransport> getAll() {
        return repository.findAll();
    }

    @Override
    public FreightTransport edit(FreightTransport freightTransport) {
        freightTransport.setDateModified(LocalDateTime.now());
        return repository.save(freightTransport);
    }

    @Override
    public FreightTransport delete(String id) {
        FreightTransport freightTransport = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return freightTransport;
    }

    public List<FreightTransport> search(String word) {
        List<FreightTransport> found = this.getAll().stream()
                .filter(freightTransport -> freightTransport.getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<FreightTransport> sortedByBrand(List<FreightTransport> list, String order) {
        list.sort(Comparator.comparing(Transport::getBrand));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
