package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Master;
import edu.nick.cursach.service.Master.impls.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/master")
public class MasterAPIController {

    @Autowired
    MasterServiceImpl service;

    @RequestMapping("/get/list")
    List<Master> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Master getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Master create(@RequestBody Master master) {
        return service.save(master);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Master edit(@RequestBody Master master) {
        return service.edit(master);
    }

    @RequestMapping("/delete/{id}")
    Master delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
