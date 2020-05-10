package edu.nick.cursach.dao.Transportation.interfaces;

import edu.nick.cursach.model.TeamLeader;
import edu.nick.cursach.model.Transportation;

import java.util.List;

public interface ITransportationDao {
    Transportation save (Transportation transportation);
    Transportation get (String id);
    List<Transportation> getAll();
    Transportation edit (Transportation transportation);
    Transportation delete(String id);
}
