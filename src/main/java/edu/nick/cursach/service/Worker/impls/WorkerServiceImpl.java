package edu.nick.cursach.service.Worker.impls;

import edu.nick.cursach.repository.WorkerRepository;
import edu.nick.cursach.model.Worker;
import edu.nick.cursach.service.Worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements IWorkerService {

    @Autowired
    WorkerRepository repository;

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

    public List<Worker> search(String word) {
        List<Worker> found = this.getAll().stream()
                .filter(chief -> chief.getLastName().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Worker> sortedByLastName(List<Worker> list, String order) {

        list.sort(Comparator.comparing(Worker::getLastName));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
