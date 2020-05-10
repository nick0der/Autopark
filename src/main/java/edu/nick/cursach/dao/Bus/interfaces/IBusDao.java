package edu.nick.cursach.dao.Bus.interfaces;

import edu.nick.cursach.model.Bus;

import java.util.List;

public interface IBusDao {
    Bus save (Bus bus);
    Bus get (String id);
    List<Bus> getAll();
    Bus edit (Bus bus);
    Bus delete(String id);
}
