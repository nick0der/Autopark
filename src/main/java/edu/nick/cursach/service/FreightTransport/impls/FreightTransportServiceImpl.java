package edu.nick.cursach.service.FreightTransport.impls;

import edu.nick.cursach.dao.FreightTransport.impls.FreightTransportDaoImplFake;
import edu.nick.cursach.repository.FreightTransportRepository;
import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.service.FreightTransport.interfaces.IFreightTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FreightTransportServiceImpl implements IFreightTransportService {

    @Autowired
    FreightTransportDaoImplFake dao;

    @Autowired
    FreightTransportRepository repository;

    @PostConstruct
    void init(){
//        List<FreightTransport> list = dao.getAll();
//        repository.saveAll(list);
    }

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
}
