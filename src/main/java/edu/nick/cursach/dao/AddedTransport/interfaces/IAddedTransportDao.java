package edu.nick.cursach.dao.AddedTransport.interfaces;
import edu.nick.cursach.model.AddedTransport;

import java.util.List;

public interface IAddedTransportDao {
    AddedTransport save (AddedTransport addedTransport);
    AddedTransport get (String id);
    List<AddedTransport> getAll();
    AddedTransport edit (AddedTransport addedTransport);
    AddedTransport delete(String id);

}
