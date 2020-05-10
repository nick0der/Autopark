package edu.nick.cursach.service.Taxi.impls;

import edu.nick.cursach.dao.Taxi.impls.TaxiDaoImplFake;
import edu.nick.cursach.repository.TaxiRepository;
import edu.nick.cursach.model.Taxi;
import edu.nick.cursach.service.Taxi.interfaces.ITaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaxiServiceImpl implements ITaxiService {

    @Autowired
    TaxiDaoImplFake dao;

    @Autowired
    TaxiRepository repository;

    @PostConstruct
    void init(){
//        List<Taxi> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public Taxi save(Taxi taxi) {
        taxi.setDateCreated(LocalDateTime.now());
        taxi.setDateModified(LocalDateTime.now());
        return repository.save(taxi);
    }

    @Override
    public Taxi get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Taxi> getAll() {
        return repository.findAll();
    }

    @Override
    public Taxi edit(Taxi taxi) {
        taxi.setDateModified(LocalDateTime.now());
        return repository.save(taxi);
    }

    @Override
    public Taxi delete(String id) {
        Taxi taxi = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return taxi;
    }
}
