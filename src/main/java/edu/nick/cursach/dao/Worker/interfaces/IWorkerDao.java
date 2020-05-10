package edu.nick.cursach.dao.Worker.interfaces;

import edu.nick.cursach.model.UsageOfAncillaryTransport;
import edu.nick.cursach.model.Worker;

import java.util.List;

public interface IWorkerDao {
    Worker save (Worker worker);
    Worker get (String id);
    List<Worker> getAll();
    Worker edit (Worker worker);
    Worker delete(String id);
}
