package edu.nick.cursach.dao.Repair.interfaces;

import edu.nick.cursach.model.RemovedTransport;
import edu.nick.cursach.model.Repair;

import java.util.List;

public interface IRepairDao {
    Repair save (Repair repair);
    Repair get (String id);
    List<Repair> getAll();
    Repair edit (Repair repair);
    Repair delete(String id);
}
