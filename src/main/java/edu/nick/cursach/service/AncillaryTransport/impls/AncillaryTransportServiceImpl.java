package edu.nick.cursach.service.AncillaryTransport.impls;

import edu.nick.cursach.model.AddedTransport;
import edu.nick.cursach.model.Transport;
import edu.nick.cursach.repository.AncillaryTransportRepository;
import edu.nick.cursach.model.AncillaryTransport;
import edu.nick.cursach.service.AncillaryTransport.interfaces.IAncillaryTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AncillaryTransportServiceImpl implements IAncillaryTransportService {

    @Autowired
    AncillaryTransportRepository repository;

    @Override
    public AncillaryTransport save(AncillaryTransport ancillaryTransport) {
        ancillaryTransport.setDateCreated(LocalDateTime.now());
        ancillaryTransport.setDateModified(LocalDateTime.now());
        return repository.save(ancillaryTransport);
    }

    @Override
    public AncillaryTransport get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<AncillaryTransport> getAll() {
        return repository.findAll();
    }

    @Override
    public AncillaryTransport edit(AncillaryTransport ancillaryTransport) {
        ancillaryTransport.setDateCreated(repository.findById(ancillaryTransport.getId()).orElse(null).getDateCreated());
        ancillaryTransport.setDateModified(LocalDateTime.now());
        return repository.save(ancillaryTransport);
    }

    @Override
    public AncillaryTransport delete(String id) {
        AncillaryTransport ancillaryTransport = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return ancillaryTransport;
    }

    public List<AncillaryTransport> search(String word) {
        List<AncillaryTransport> found = this.getAll().stream()
                .filter(ancillaryTransport -> ancillaryTransport.getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<AncillaryTransport> sortedByBrand(List<AncillaryTransport> list, String order) {

        list.sort(Comparator.comparing(Transport::getBrand));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
