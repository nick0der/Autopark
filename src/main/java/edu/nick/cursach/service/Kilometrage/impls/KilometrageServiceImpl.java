package edu.nick.cursach.service.Kilometrage.impls;

import edu.nick.cursach.dao.Kilometrage.impls.KilometrageDaoImplFake;
import edu.nick.cursach.repository.KilometrageRepository;
import edu.nick.cursach.model.Kilometrage;
import edu.nick.cursach.service.Kilometrage.interfaces.IKilometrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class KilometrageServiceImpl implements IKilometrageService {

    @Autowired
    KilometrageDaoImplFake dao;

    @Autowired
    KilometrageRepository repository;

    @PostConstruct
    void init(){
//        List<Kilometrage> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public Kilometrage save(Kilometrage kilometrage) {
        kilometrage.setDateCreated(LocalDateTime.now());
        kilometrage.setDateModified(LocalDateTime.now());
        return repository.save(kilometrage);
    }

    @Override
    public Kilometrage get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Kilometrage> getAll() {
        return repository.findAll();
    }

    @Override
    public Kilometrage edit(Kilometrage kilometrage) {
        kilometrage.setDateModified(LocalDateTime.now());
        return repository.save(kilometrage);
    }

    @Override
    public Kilometrage delete(String id) {
        Kilometrage kilometrage = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return kilometrage;
    }
}
