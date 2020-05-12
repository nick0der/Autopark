package edu.nick.cursach.service.PassangerTransportation.impls;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.repository.PassangerTransportationRepository;
import edu.nick.cursach.model.PassangerTransportation;
import edu.nick.cursach.service.PassangerTransportation.interfaces.IPassangerTransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassangerTransportationServiceImpl implements IPassangerTransportationService {

    @Autowired
    PassangerTransportationRepository repository;

    @Override
    public PassangerTransportation save(PassangerTransportation passangerTransportation) {
        passangerTransportation.setDateCreated(LocalDateTime.now());
        passangerTransportation.setDateModified(LocalDateTime.now());
        return repository.save(passangerTransportation);
    }

    @Override
    public PassangerTransportation get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PassangerTransportation> getAll() {
        return repository.findAll();
    }

    @Override
    public PassangerTransportation edit(PassangerTransportation passangerTransportation) {
        passangerTransportation.setDateModified(LocalDateTime.now());
        return repository.save(passangerTransportation);
    }

    @Override
    public PassangerTransportation delete(String id) {
        PassangerTransportation passangerTransportation = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return passangerTransportation;
    }

    public List<PassangerTransportation> search(String word) {
        List<PassangerTransportation> found = this.getAll().stream()
                .filter(passangerTransportation -> passangerTransportation.getTransport().getBrand().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<PassangerTransportation> sortedByDate(List<PassangerTransportation> list, String order) {

        list.sort(Comparator.comparing(PassangerTransportation::getDateTransported));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
