package edu.nick.cursach.service.RemovedTransport.impls;

import edu.nick.cursach.repository.RemovedTransportRepository;
import edu.nick.cursach.model.RemovedTransport;
import edu.nick.cursach.service.RemovedTransport.interfaces.IRemovedTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RemovedTransportServiceImpl implements IRemovedTransportService {

    @Autowired
    RemovedTransportRepository repository;

    @Override
    public RemovedTransport save(RemovedTransport removedTransport) {
        removedTransport.setDateCreated(LocalDateTime.now());
        removedTransport.setDateModified(LocalDateTime.now());
        return repository.save(removedTransport);
    }

    @Override
    public RemovedTransport get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<RemovedTransport> getAll() {
        return repository.findAll();
    }

    @Override
    public RemovedTransport edit(RemovedTransport removedTransport) {
        removedTransport.setDateCreated(repository.findById(removedTransport.getId()).orElse(null).getDateCreated());
        removedTransport.setDateModified(LocalDateTime.now());
        return repository.save(removedTransport);
    }

    @Override
    public RemovedTransport delete(String id) {
        RemovedTransport removedTransport = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return removedTransport;
    }

    public List<RemovedTransport> search(String word) {
        List<RemovedTransport> found = this.getAll().stream()
                .filter(removedTransport -> removedTransport.getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<RemovedTransport> sortedByDate(List<RemovedTransport> list, String order) {

        list.sort(Comparator.comparing(RemovedTransport::getDateRemoved));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
