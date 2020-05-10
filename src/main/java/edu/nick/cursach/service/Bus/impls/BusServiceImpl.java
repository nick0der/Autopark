package edu.nick.cursach.service.Bus.impls;

import edu.nick.cursach.dao.bus.impls.BusDaoImplFake;
import edu.nick.cursach.repository.BusRepository;
import edu.nick.cursach.model.Bus;
import edu.nick.cursach.service.Bus.interfaces.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusServiceImpl implements IBusService {

    @Autowired
    BusDaoImplFake dao;

    @Autowired
    BusRepository repository;

    @PostConstruct
    void init(){
//        List<Bus> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public Bus save(Bus bus) {
        bus.setDateCreated(LocalDateTime.now());
        bus.setDateModified(LocalDateTime.now());
        return repository.save(bus);
    }

    @Override
    public Bus get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Bus> getAll() {
        return repository.findAll();
    }

    @Override
    public Bus edit(Bus bus) {
        bus.setDateModified(LocalDateTime.now());
        return repository.save(bus);
    }

    @Override
    public Bus delete(String id) {
        Bus bus = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return bus;
    }
}
