package edu.nick.cursach.service.Driver.impls;

import edu.nick.cursach.repository.DriverRepository;
import edu.nick.cursach.model.Driver;
import edu.nick.cursach.service.Driver.interfaces.IDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements IDriverService {

    @Autowired
    DriverRepository repository;

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

    public List<Driver> search(String word) {
        List<Driver> found = this.getAll().stream()
                .filter(chief -> chief.getLastName().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Driver> sortedByLastName(List<Driver> list, String order) {

        list.sort(Comparator.comparing(Driver::getLastName));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
