package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.Route;
import edu.nick.cursach.service.Route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
public class RouteAPIController {

    @Autowired
    RouteServiceImpl service;

    @RequestMapping("/get/list")
    List<Route> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Route getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Route create(@RequestBody Route route) {
        return service.save(route);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Route edit(@RequestBody Route route) {
        return service.edit(route);
    }

    @RequestMapping("/delete/{id}")
    Route delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
