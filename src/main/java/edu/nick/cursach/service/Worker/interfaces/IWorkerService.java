package edu.nick.cursach.service.Worker.interfaces;

import edu.nick.cursach.model.Worker;

import java.util.List;

public interface IWorkerService {
    Worker save (Worker worker);
    Worker get (String id);
    List<Worker> getAll();
    Worker edit (Worker worker);
    Worker delete(String id);
}
