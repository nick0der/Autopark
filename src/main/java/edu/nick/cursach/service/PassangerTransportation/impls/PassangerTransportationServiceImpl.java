package edu.nick.cursach.service.PassangerTransportation.impls;

import edu.nick.cursach.dao.PassangerTransportation.impls.PassangerTransportationDaoImplFake;
import edu.nick.cursach.repository.PassangerTransportationRepository;
import edu.nick.cursach.model.PassangerTransportation;
import edu.nick.cursach.service.PassangerTransportation.interfaces.IPassangerTransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PassangerTransportationServiceImpl implements IPassangerTransportationService {

    @Autowired
    PassangerTransportationDaoImplFake dao;

    @Autowired
    PassangerTransportationRepository repository;

    @PostConstruct
    void init(){
//        List<PassangerTransportation> list = dao.getAll();
//        repository.saveAll(list);
    }

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
}
