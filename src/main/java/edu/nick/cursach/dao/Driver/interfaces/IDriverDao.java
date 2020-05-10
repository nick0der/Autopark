package edu.nick.cursach.dao.Driver.interfaces;

import edu.nick.cursach.model.Chief;
import edu.nick.cursach.model.Driver;

import java.util.List;

public interface IDriverDao {
    Driver save (Driver driver);
    Driver get (String id);
    List<Driver> getAll();
    Driver edit (Driver driver);
    Driver delete(String id);
}
