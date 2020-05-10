package edu.nick.cursach.service.Chief.interfaces;

import edu.nick.cursach.model.Chief;

import java.util.List;

public interface IChiefService {
    Chief save (Chief chief);
    Chief get (String id);
    List<Chief> getAll();
    Chief edit (Chief chief);
    Chief delete(String id);
}
