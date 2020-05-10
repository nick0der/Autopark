package edu.nick.cursach.service.AddedTransport.impls;

import edu.nick.cursach.dao.AddedTransport.impls.AddedTransportDaoImplFake;
import edu.nick.cursach.repository.AddedTransportRepository;
import edu.nick.cursach.model.AddedTransport;
import edu.nick.cursach.service.AddedTransport.interfaces.IAddedTransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AddedTransportServiceImpl implements IAddedTransportService {

    @Autowired
    AddedTransportDaoImplFake dao;

    @Autowired
    AddedTransportRepository repository;

    @PostConstruct
    void init(){
//        List<AddedTransport> list = dao.getAll();
//        repository.saveAll(list);
    }

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

}
