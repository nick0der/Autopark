package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Chief;
import edu.nick.cursach.service.Chief.impls.ChiefServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chief")
public class ChiefAPIController {

    @Autowired
    ChiefServiceImpl service;

    @RequestMapping("/get/list")
    List<Chief> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Chief getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Chief create(@RequestBody Chief chief) {
        return service.save(chief);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Chief edit(@RequestBody Chief chief) {
        return service.edit(chief);
    }

    @RequestMapping("/delete/{id}")
    Chief delete(@PathVariable("id") String id) {
        return service.delete(id);
    }


}
