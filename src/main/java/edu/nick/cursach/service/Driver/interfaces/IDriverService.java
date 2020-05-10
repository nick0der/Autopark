package edu.nick.cursach.service.Driver.interfaces;

import edu.nick.cursach.model.Driver;

import java.util.List;

public interface IDriverService {
    Driver save (Driver driver);
    Driver get (String id);
    List<Driver> getAll();
    Driver edit (Driver driver);
    Driver delete(String id);
}
