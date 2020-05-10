package edu.nick.cursach.service.AncillaryTransport.impls;

import edu.nick.cursach.repository.AncillaryTransportRepository;
import edu.nick.cursach.model.AncillaryTransport;
import edu.nick.cursach.service.AncillaryTransport.interfaces.IAncillaryTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        ancillaryTransport.setDateModified(LocalDateTime.now());
        return repository.save(ancillaryTransport);
    }

    @Override
    public AncillaryTransport delete(String id) {
        AncillaryTransport ancillaryTransport = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return ancillaryTransport;
    }
}
