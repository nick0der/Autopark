package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Taxi;
import edu.nick.cursach.service.Taxi.impls.TaxiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxi")
public class TaxiAPIController {

    @Autowired
    TaxiServiceImpl service;

    @RequestMapping("/get/list")
    List<Taxi> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Taxi getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Taxi create(@RequestBody Taxi taxi) {
        return service.save(taxi);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Taxi edit(@RequestBody Taxi taxi) {
        return service.edit(taxi);
    }

    @RequestMapping("/delete/{id}")
    Taxi delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
