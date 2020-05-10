package edu.nick.cursach.dao.Chief.interfaces;

import edu.nick.cursach.model.Bus;
import edu.nick.cursach.model.Chief;

import java.util.List;

public interface IChiefDao {
    Chief save (Chief chief);
    Chief get (String id);
    List<Chief> getAll();
    Chief edit (Chief chief);
    Chief delete(String id);
}
