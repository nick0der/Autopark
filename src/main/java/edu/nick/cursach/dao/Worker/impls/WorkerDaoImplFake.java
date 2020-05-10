package edu.nick.cursach.dao.Worker.impls;

import edu.nick.cursach.dao.Worker.interfaces.IWorkerDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerDaoImplFake implements IWorkerDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Worker save(Worker worker) {
        return null;
    }

    @Override
    public Worker get(String id) {
        return null;
    }

    @Override
    public List<Worker> getAll() {
        return dataSet.getWorkers();
    }

    @Override
    public Worker edit(Worker worker) {
        return null;
    }

    @Override
    public Worker delete(String id) {
        return null;
    }
}
