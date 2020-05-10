package edu.nick.cursach.service.Master.interfaces;

import edu.nick.cursach.model.Master;

import java.util.List;

public interface IMasterService {
    Master save (Master master);
    Master get (String id);
    List<Master> getAll();
    Master edit (Master master);
    Master delete(String id);
}
