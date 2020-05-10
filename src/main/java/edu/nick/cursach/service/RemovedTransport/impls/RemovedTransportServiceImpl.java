package edu.nick.cursach.service.RemovedTransport.impls;

import edu.nick.cursach.dao.RemovedTransport.impls.RemovedTransportDaoImplFake;
import edu.nick.cursach.repository.RemovedTransportRepository;
import edu.nick.cursach.model.RemovedTransport;
import edu.nick.cursach.service.RemovedTransport.interfaces.IRemovedTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RemovedTransportServiceImpl implements IRemovedTransportService {

    @Autowired
    RemovedTransportDaoImplFake dao;

    @Autowired
    RemovedTransportRepository repository;

    @PostConstruct
    void init(){
//        List<RemovedTransport> list = dao.getAll();
//        repository.saveAll(list);
    }

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
        removedTransport.setDateModified(LocalDateTime.now());
        return repository.save(removedTransport);
    }

    @Override
    public RemovedTransport delete(String id) {
        RemovedTransport removedTransport = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return removedTransport;
    }
}
