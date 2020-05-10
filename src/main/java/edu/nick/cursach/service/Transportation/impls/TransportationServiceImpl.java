package edu.nick.cursach.service.Transportation.impls;

import edu.nick.cursach.repository.TransportationRepository;
import edu.nick.cursach.model.Transportation;
import edu.nick.cursach.service.Transportation.interfaces.ITransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransportationServiceImpl implements ITransportationService {

    @Autowired
    TransportationRepository repository;

    @Override
    public Transportation save(Transportation transportation) {
        transportation.setDateCreated(LocalDateTime.now());
        transportation.setDateModified(LocalDateTime.now());
        return repository.save(transportation);
    }

    @Override
    public Transportation get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Transportation> getAll() {
        return repository.findAll();
    }

    @Override
    public Transportation edit(Transportation transportation) {
        transportation.setDateModified(LocalDateTime.now());
        return repository.save(transportation);
    }

    @Override
    public Transportation delete(String id) {
        Transportation transportation = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return transportation;
    }
}
