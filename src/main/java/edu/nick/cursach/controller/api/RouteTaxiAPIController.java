package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.RouteTaxi;
import edu.nick.cursach.service.RouteTaxi.impls.RouteTaxiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routeTaxi")
public class RouteTaxiAPIController {

    @Autowired
    RouteTaxiServiceImpl service;

    @RequestMapping("/get/list")
    List<RouteTaxi> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    RouteTaxi getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    RouteTaxi create(@RequestBody RouteTaxi routeTaxi) {
        return service.save(routeTaxi);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    RouteTaxi edit(@RequestBody RouteTaxi routeTaxi) {
        return service.edit(routeTaxi);
    }

    @RequestMapping("/delete/{id}")
    RouteTaxi delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
