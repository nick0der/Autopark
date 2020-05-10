package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Transportation;
import edu.nick.cursach.service.Transportation.impls.TransportationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transportation")
public class TransportationAPIController {

    @Autowired
    TransportationServiceImpl service;

    @RequestMapping("/get/list")
    List<Transportation> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Transportation getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Transportation create(@RequestBody Transportation transportation) {
        return service.save(transportation);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Transportation edit(@RequestBody Transportation transportation) {
        return service.edit(transportation);
    }

    @RequestMapping("/delete/{id}")
    Transportation delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
