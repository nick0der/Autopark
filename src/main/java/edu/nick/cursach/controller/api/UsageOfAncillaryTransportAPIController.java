package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.UsageOfAncillaryTransport;
import edu.nick.cursach.service.UsageOfAncillaryTransport.impls.UsageOfAncillaryTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usageOfAncillaryTransport")
public class UsageOfAncillaryTransportAPIController {

    @Autowired
    UsageOfAncillaryTransportServiceImpl service;

    @RequestMapping("/get/list")
    List<UsageOfAncillaryTransport> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    UsageOfAncillaryTransport getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    UsageOfAncillaryTransport create(@RequestBody UsageOfAncillaryTransport usageOfAncillaryTransport) {
        return service.save(usageOfAncillaryTransport);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    UsageOfAncillaryTransport edit(@RequestBody UsageOfAncillaryTransport usageOfAncillaryTransport) {
        return service.edit(usageOfAncillaryTransport);
    }

    @RequestMapping("/delete/{id}")
    UsageOfAncillaryTransport delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
