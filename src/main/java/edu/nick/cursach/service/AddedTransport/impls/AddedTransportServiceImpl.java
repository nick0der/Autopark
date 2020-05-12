package edu.nick.cursach.service.AddedTransport.impls;

import edu.nick.cursach.repository.AddedTransportRepository;
import edu.nick.cursach.model.AddedTransport;
import edu.nick.cursach.service.AddedTransport.interfaces.IAddedTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddedTransportServiceImpl implements IAddedTransportService {

    @Autowired
    AddedTransportRepository repository;

    @Override
    public AddedTransport save(AddedTransport addedTransport) {
        addedTransport.setDateCreated(LocalDateTime.now());
        addedTransport.setDateModified(LocalDateTime.now());
         return repository.save(addedTransport);
    }

    @Override
    public AddedTransport get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AddedTransport> getAll() {
        return repository.findAll();
    }

    @Override
    public AddedTransport edit(AddedTransport addedTransport) {
        addedTransport.setDateModified(LocalDateTime.now());
        return repository.save(addedTransport);
    }

    @Override
    public AddedTransport delete(String id) {
        AddedTransport addedTransport = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return addedTransport;
    }

    public List<AddedTransport> search(String word) {
        List<AddedTransport> found = this.getAll().stream()
                .filter(addedTransport -> addedTransport.getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<AddedTransport> sortedByDate(List<AddedTransport> list, String order) {

        list.sort(Comparator.comparing(AddedTransport::getDateAdded));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
