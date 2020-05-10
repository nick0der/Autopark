package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.TeamLeader;
import edu.nick.cursach.service.TeamLeader.impls.TeamLeaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teamLeader")
public class TeamLeaderAPIController {

    @Autowired
    TeamLeaderServiceImpl service;

    @RequestMapping("/get/list")
    List<TeamLeader> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    TeamLeader getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    TeamLeader create(@RequestBody TeamLeader teamLeader) {
        return service.save(teamLeader);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    TeamLeader edit(@RequestBody TeamLeader teamLeader) {
        return service.edit(teamLeader);
    }

    @RequestMapping("/delete/{id}")
    TeamLeader delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
