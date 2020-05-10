package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.RemovedTransport;
import edu.nick.cursach.service.RemovedTransport.impls.RemovedTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/removedTransport")
public class RemovedTransportAPIController {

    @Autowired
    RemovedTransportServiceImpl service;

    @RequestMapping("/get/list")
    List<RemovedTransport> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    RemovedTransport getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    RemovedTransport create(@RequestBody RemovedTransport removedTransport) {
        return service.save(removedTransport);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    RemovedTransport edit(@RequestBody RemovedTransport removedTransport) {
        return service.edit(removedTransport);
    }

    @RequestMapping("/delete/{id}")
    RemovedTransport delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
