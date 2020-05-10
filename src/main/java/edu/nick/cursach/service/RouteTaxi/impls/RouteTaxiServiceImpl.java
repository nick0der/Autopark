package edu.nick.cursach.service.RouteTaxi.impls;

import edu.nick.cursach.dao.RouteTaxi.impls.RouteTaxiDaoImplFake;
import edu.nick.cursach.repository.RouteTaxiRepository;
import edu.nick.cursach.model.RouteTaxi;
import edu.nick.cursach.service.RouteTaxi.interfaces.IRouteTaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteTaxiServiceImpl implements IRouteTaxiService {

    @Autowired
    RouteTaxiDaoImplFake dao;

    @Autowired
    RouteTaxiRepository repository;

    @PostConstruct
    void init(){
//        List<RouteTaxi> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public RouteTaxi save(RouteTaxi routeTaxi) {
        routeTaxi.setDateCreated(LocalDateTime.now());
        routeTaxi.setDateModified(LocalDateTime.now());
        return repository.save(routeTaxi);
    }

    @Override
    public RouteTaxi get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<RouteTaxi> getAll() {
        return repository.findAll();
    }

    @Override
    public RouteTaxi edit(RouteTaxi routeTaxi) {
        routeTaxi.setDateModified(LocalDateTime.now());
        return repository.save(routeTaxi);
    }

    @Override
    public RouteTaxi delete(String id) {
        RouteTaxi routeTaxi = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return routeTaxi;
    }
}
