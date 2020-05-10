package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Bus;
import edu.nick.cursach.service.Bus.impls.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusAPIController {

    @Autowired
    BusServiceImpl service;

    @RequestMapping("/get/list")
    List<Bus> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Bus getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Bus create(@RequestBody Bus bus) {
        return service.save(bus);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Bus edit(@RequestBody Bus bus) {
        return service.edit(bus);
    }

    @RequestMapping("/delete/{id}")
    Bus delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
