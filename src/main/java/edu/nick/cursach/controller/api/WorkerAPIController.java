package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Worker;
import edu.nick.cursach.service.Worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
public class WorkerAPIController {

    @Autowired
    WorkerServiceImpl service;

    @RequestMapping("/get/list")
    List<Worker> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Worker getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Worker create(@RequestBody Worker worker) {
        return service.save(worker);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Worker edit(@RequestBody Worker worker) {
        return service.edit(worker);
    }

    @RequestMapping("/delete/{id}")
    Worker delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
