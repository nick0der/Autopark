package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.service.FreightTransport.impls.FreightTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/freightTransport")
public class FreightTransportAPIController {

    @Autowired
    FreightTransportServiceImpl service;

    @RequestMapping("/get/list")
    List<FreightTransport> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    FreightTransport getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    FreightTransport create(@RequestBody FreightTransport freightTransport) {
        return service.save(freightTransport);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    FreightTransport edit(@RequestBody FreightTransport freightTransport) {
        return service.edit(freightTransport);
    }

    @RequestMapping("/delete/{id}")
    FreightTransport delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
