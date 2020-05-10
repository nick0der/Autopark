package edu.nick.cursach.service.Driver.impls;

import edu.nick.cursach.dao.Driver.impls.DriverDaoImplFake;
import edu.nick.cursach.repository.DriverRepository;
import edu.nick.cursach.model.Driver;
import edu.nick.cursach.service.Driver.interfaces.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DriverServiceImpl implements IDriverService {

    @Autowired
    DriverDaoImplFake dao;

    @Autowired
    DriverRepository repository;

    @PostConstruct
    void init(){
//        List<Driver> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public Driver save(Driver driver) {
        driver.setDateCreated(LocalDateTime.now());
        driver.setDateModified(LocalDateTime.now());
        return repository.save(driver);
    }

    @Override
    public Driver get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Driver> getAll() {
        return repository.findAll();
    }

    @Override
    public Driver edit(Driver driver) {
        driver.setDateModified(LocalDateTime.now());
        return repository.save(driver);
    }

    @Override
    public Driver delete(String id) {
        Driver driver = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return driver;
    }
}
