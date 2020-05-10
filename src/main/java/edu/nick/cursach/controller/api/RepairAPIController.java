package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Repair;
import edu.nick.cursach.service.Repair.impls.RepairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repair")
public class RepairAPIController {

    @Autowired
    RepairServiceImpl service;

    @RequestMapping("/get/list")
    List<Repair> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Repair getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Repair create(@RequestBody Repair repair) {
        return service.save(repair);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Repair edit(@RequestBody Repair repair) {
        return service.edit(repair);
    }

    @RequestMapping("/delete/{id}")
    Repair delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
