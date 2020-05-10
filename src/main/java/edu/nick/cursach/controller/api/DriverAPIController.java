package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Driver;
import edu.nick.cursach.service.Driver.impls.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverAPIController {

    @Autowired
    DriverServiceImpl service;

    @RequestMapping("/get/list")
    List<Driver> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Driver getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Driver create(@RequestBody Driver driver) {
        return service.save(driver);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Driver edit(@RequestBody Driver driver) {
        return service.edit(driver);
    }

    @RequestMapping("/delete/{id}")
    Driver delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
