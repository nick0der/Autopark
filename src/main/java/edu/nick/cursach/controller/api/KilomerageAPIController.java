package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Kilometrage;
import edu.nick.cursach.service.Kilometrage.impls.KilometrageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kilometrage")
public class KilomerageAPIController {

    @Autowired
    KilometrageServiceImpl service;

    @RequestMapping("/get/list")
    List<Kilometrage> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Kilometrage getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Kilometrage create(@RequestBody Kilometrage kilometrage) {
        return service.save(kilometrage);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Kilometrage edit(@RequestBody Kilometrage kilometrage) {
        return service.edit(kilometrage);
    }

    @RequestMapping("/delete/{id}")
    Kilometrage delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
