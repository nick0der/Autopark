package edu.nick.cursach.service.UsageOfAncillaryTransport.impls;

import edu.nick.cursach.repository.UsageOfAncillaryTransportRepository;
import edu.nick.cursach.model.UsageOfAncillaryTransport;
import edu.nick.cursach.service.UsageOfAncillaryTransport.interfaces.IUsageOfAncillaryTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsageOfAncillaryTransportServiceImpl implements IUsageOfAncillaryTransportService {

    @Autowired
    UsageOfAncillaryTransportRepository repository;

    @Override
    public UsageOfAncillaryTransport save(UsageOfAncillaryTransport usageOfAncillaryTransport) {
        usageOfAncillaryTransport.setDateCreated(LocalDateTime.now());
        usageOfAncillaryTransport.setDateModified(LocalDateTime.now());
        return repository.save(usageOfAncillaryTransport);
    }

    @Override
    public UsageOfAncillaryTransport get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<UsageOfAncillaryTransport> getAll() {
        return repository.findAll();
    }

    @Override
    public UsageOfAncillaryTransport edit(UsageOfAncillaryTransport usageOfAncillaryTransport) {
        usageOfAncillaryTransport.setDateModified(LocalDateTime.now());
        return repository.save(usageOfAncillaryTransport);
    }

    @Override
    public UsageOfAncillaryTransport delete(String id) {
        UsageOfAncillaryTransport usageOfAncillaryTransport = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return usageOfAncillaryTransport;
    }

    public List<UsageOfAncillaryTransport> search(String word) {
        List<UsageOfAncillaryTransport> found = this.getAll().stream()
                .filter(usageOfAncillaryTransport -> usageOfAncillaryTransport.getAncillaryTransport().getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<UsageOfAncillaryTransport> sortedByDate(List<UsageOfAncillaryTransport> list, String order) {
        list.sort(Comparator.comparing(UsageOfAncillaryTransport::getDateUsed));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
