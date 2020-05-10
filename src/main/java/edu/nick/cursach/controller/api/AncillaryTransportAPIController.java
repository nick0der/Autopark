package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.AncillaryTransport;
import edu.nick.cursach.service.AncillaryTransport.impls.AncillaryTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ancillaryTransport")
public class AncillaryTransportAPIController {

    @Autowired
    AncillaryTransportServiceImpl service;

    @RequestMapping("/get/list")
    List<AncillaryTransport> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    AncillaryTransport getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    AncillaryTransport create(@RequestBody AncillaryTransport ancillaryTransport) {
        return service.save(ancillaryTransport);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    AncillaryTransport edit(@RequestBody AncillaryTransport ancillaryTransport) {
        return service.edit(ancillaryTransport);
    }

    @RequestMapping("/delete/{id}")
    AncillaryTransport delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
