package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.PassangerTransportation;
import edu.nick.cursach.service.PassangerTransportation.impls.PassangerTransportationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passangerTransportation")
public class PassangerTransportationAPIController {

    @Autowired
    PassangerTransportationServiceImpl service;

    @RequestMapping("/get/list")
    List<PassangerTransportation> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    PassangerTransportation getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    PassangerTransportation create(@RequestBody PassangerTransportation passangerTransportation) {
        return service.save(passangerTransportation);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    PassangerTransportation edit(@RequestBody PassangerTransportation passangerTransportation) {
        return service.edit(passangerTransportation);
    }

    @RequestMapping("/delete/{id}")
    PassangerTransportation delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
