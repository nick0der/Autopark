package edu.nick.cursach.dao.Master.interfaces;
import edu.nick.cursach.model.Master;

import java.util.List;

public interface IMasterDao {
    Master save (Master master);
    Master get (String id);
    List<Master> getAll();
    Master edit (Master master);
    Master delete(String id);
}
