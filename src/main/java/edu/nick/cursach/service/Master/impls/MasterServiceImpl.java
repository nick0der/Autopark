package edu.nick.cursach.service.Master.impls;

import edu.nick.cursach.dao.Master.impls.MasterDaoImplFake;
import edu.nick.cursach.repository.MasterRepository;
import edu.nick.cursach.model.Master;
import edu.nick.cursach.service.Master.interfaces.IMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MasterServiceImpl implements IMasterService {

    @Autowired
    MasterDaoImplFake dao;

    @Autowired
    MasterRepository repository;

    @PostConstruct
    void init(){
//        List<Master> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public Master save(Master master) {
        master.setDateCreated(LocalDateTime.now());
        master.setDateModified(LocalDateTime.now());
        return repository.save(master);
    }

    @Override
    public Master get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Master> getAll() {
        return repository.findAll();
    }

    @Override
    public Master edit(Master master) {
        master.setDateModified(LocalDateTime.now());
        return repository.save(master);
    }

    @Override
    public Master delete(String id) {
        Master master = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return master;
    }
}
