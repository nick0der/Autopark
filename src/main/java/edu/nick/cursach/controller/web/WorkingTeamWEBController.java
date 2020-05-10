package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.WorkerForm;
import edu.nick.cursach.form.WorkingTeamForm;
import edu.nick.cursach.model.TeamLeader;
import edu.nick.cursach.model.Worker;
import edu.nick.cursach.model.WorkingTeam;
import edu.nick.cursach.service.TeamLeader.impls.TeamLeaderServiceImpl;
import edu.nick.cursach.service.Worker.impls.WorkerServiceImpl;
import edu.nick.cursach.service.WorkingTeam.impls.WorkingTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/workingTeam")
public class WorkingTeamWEBController {

    @Autowired
    TeamLeaderServiceImpl teamLeaderService;

    @Autowired
    WorkingTeamServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("workingTeams", service.getAll());
        return "workingTeamList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("workingTeams", service.getAll());
        return "redirect:/web/workingTeam/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){

        WorkingTeamForm workingTeamForm = new WorkingTeamForm();

        Map<String, String> mavs = teamLeaderService.getAll().stream().collect(
                Collectors.toMap(TeamLeader::getId, TeamLeader::getFullName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("workingTeamForm", workingTeamForm);
        return "workingTeamAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("workingTeamForm") WorkingTeamForm workingTeamForm){

        WorkingTeam workingTeam = new WorkingTeam();

        workingTeam.setName("name");
        workingTeam.setDescription("description");

        workingTeam.setNumber(workingTeamForm.getNumber() );
        workingTeam.setTeamLeader(teamLeaderService.get(workingTeamForm.getTeamLeader()));

        service.save(workingTeam);
        model.addAttribute("workingTeams", service.getAll());
        return "redirect:/web/workingTeam/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        WorkingTeam workingTeam = service.get(id);
        WorkingTeamForm workingTeamForm = new WorkingTeamForm();

        Map<String, String> mavs = teamLeaderService.getAll().stream().collect(
                Collectors.toMap(TeamLeader::getId, TeamLeader::getFullName));
        String dflt = workingTeam.getTeamLeader().getId();

        workingTeamForm.setNumber(workingTeam.getNumber());
        workingTeamForm.setTeamLeader(workingTeam.getTeamLeader().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("dflt", dflt);
        model.addAttribute("workingTeamForm", workingTeamForm);
        return "workingTeamAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("workingTeamForm") WorkingTeamForm workingTeamForm){

        WorkingTeam workingTeam = new WorkingTeam();

        workingTeam.setId(id);
        workingTeam.setName(service.get(id).getName());
        workingTeam.setDescription(service.get(id).getDescription());
        workingTeam.setDateCreated(service.get(id).getDateCreated());
        workingTeam.setDateModified(service.get(id).getDateModified());

        workingTeam.setNumber(workingTeamForm.getNumber());
        workingTeam.setTeamLeader(teamLeaderService.get(workingTeamForm.getTeamLeader()));

        service.edit(workingTeam);
        model.addAttribute("workingTeams", service.getAll());
        return "redirect:/web/workingTeam/list";
    }
}
