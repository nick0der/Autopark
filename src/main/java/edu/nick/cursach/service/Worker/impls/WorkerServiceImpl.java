package edu.nick.cursach.service.Worker.impls;

import edu.nick.cursach.dao.Worker.impls.WorkerDaoImplFake;
import edu.nick.cursach.repository.WorkerRepository;
import edu.nick.cursach.model.Worker;
import edu.nick.cursach.service.Worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkerServiceImpl implements IWorkerService {

    @Autowired
    WorkerDaoImplFake dao;

    @Autowired
    WorkerRepository repository;

    @PostConstruct
    void init(){
//        List<Worker> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public Worker save(Worker worker) {
        worker.setDateCreated(LocalDateTime.now());
        worker.setDateModified(LocalDateTime.now());
        return repository.save(worker);
    }

    @Override
    public Worker get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Worker> getAll() {
        return repository.findAll();
    }

    @Override
    public Worker edit(Worker worker) {
        worker.setDateModified(LocalDateTime.now());
        return repository.save(worker);
    }

    @Override
    public Worker delete(String id) {
        Worker worker = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return worker;
    }
}
