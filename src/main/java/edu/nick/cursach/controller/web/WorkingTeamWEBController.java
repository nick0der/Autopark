package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.SearchForm;
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

    private Integer searchWord = 0;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = 0;
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workingTeams", service.getAll());
        return "workingTeamList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString().length() != 0 ? Integer.parseInt(searchForm.getString()) : 0;
        List<WorkingTeam> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workingTeams", list);
        return "workingTeamList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<WorkingTeam> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<WorkingTeam> sortedList = service.sortedByNumber(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workingTeams", sortedList);
        return "workingTeamList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString().length() != 0 ? Integer.parseInt(searchForm.getString()) : 0;
        List<WorkingTeam> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/workingTeam/list" : "workingTeamList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("workingTeams", list);
        return toReturn;
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
