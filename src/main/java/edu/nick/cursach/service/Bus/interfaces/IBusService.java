package edu.nick.cursach.service.Bus.interfaces;

import edu.nick.cursach.model.Bus;

import java.util.List;

public interface IBusService {
    Bus save (Bus bus);
    Bus get (String id);
    List<Bus> getAll();
    Bus edit (Bus bus);
    Bus delete(String id);
}
