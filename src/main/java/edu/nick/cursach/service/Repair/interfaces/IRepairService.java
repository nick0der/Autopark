package edu.nick.cursach.service.Repair.interfaces;

import edu.nick.cursach.model.Repair;

import java.util.List;

public interface IRepairService {
    Repair save (Repair repair);
    Repair get (String id);
    List<Repair> getAll();
    Repair edit (Repair repair);
    Repair delete(String id);
}
