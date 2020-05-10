package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.AddedTransport;
import edu.nick.cursach.service.AddedTransport.impls.AddedTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addedTransport")
public class AddedTransportAPIController {

    @Autowired
    AddedTransportServiceImpl service;

    @RequestMapping("/get/list")
    List<AddedTransport> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    AddedTransport getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    AddedTransport create(@RequestBody AddedTransport addedTransport) {
        return service.save(addedTransport);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    AddedTransport edit(@RequestBody AddedTransport addedTransport) {
        return service.edit(addedTransport);
    }

    @RequestMapping("/delete/{id}")
    AddedTransport delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
