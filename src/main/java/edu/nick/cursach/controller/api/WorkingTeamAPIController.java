package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.WorkingTeam;
import edu.nick.cursach.service.WorkingTeam.impls.WorkingTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workingTeam")
public class WorkingTeamAPIController {

    @Autowired
    WorkingTeamServiceImpl service;

    @RequestMapping("/get/list")
    List<WorkingTeam> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    WorkingTeam getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    WorkingTeam create(@RequestBody WorkingTeam workingTeam) {
        return service.save(workingTeam);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    WorkingTeam edit(@RequestBody WorkingTeam workingTeam) {
        return service.edit(workingTeam);
    }

    @RequestMapping("/delete/{id}")
    WorkingTeam delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
