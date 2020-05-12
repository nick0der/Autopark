package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.MasterForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.form.TeamLeaderForm;
import edu.nick.cursach.model.Master;
import edu.nick.cursach.model.TeamLeader;
import edu.nick.cursach.service.Master.impls.MasterServiceImpl;
import edu.nick.cursach.service.TeamLeader.impls.TeamLeaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/teamLeader")
public class TeamLeaderWEBController {

    @Autowired
    MasterServiceImpl masterService;

    @Autowired
    TeamLeaderServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("teamLeaders", service.getAll());
        return "teamLeaderList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<TeamLeader> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("teamLeaders", list);
        return "teamLeaderList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<TeamLeader> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<TeamLeader> sortedList = service.sortedByLastName(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("teamLeaders", sortedList);
        return "teamLeaderList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<TeamLeader> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/teamLeader/list" : "teamLeaderList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("teamLeaders", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("teamLeaders", service.getAll());
        return "redirect:/web/teamLeader/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){

        TeamLeaderForm teamLeaderForm = new TeamLeaderForm();

        Map<String, String> mavs = masterService.getAll().stream().collect(
                Collectors.toMap(Master::getId, Master::getFullName));

        model.addAttribute("mavs", mavs);
        model.addAttribute("teamLeaderForm", teamLeaderForm);
        return "teamLeaderAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("teamLeaderForm") TeamLeaderForm teamLeaderForm){

        TeamLeader teamLeader = new TeamLeader();

        teamLeader.setName("name");
        teamLeader.setDescription("description");

        teamLeader.setFirstName(teamLeaderForm.getFirstName());
        teamLeader.setLastName(teamLeaderForm.getLastName());
        teamLeader.setPatronymic(teamLeaderForm.getPatronymic());
        teamLeader.setSalary(teamLeaderForm.getSalary());
        teamLeader.setExperience(teamLeaderForm.getExperience());
        teamLeader.setMaster(masterService.get(teamLeaderForm.getMaster()));

        service.save(teamLeader);
        model.addAttribute("teamLeaders", service.getAll());
        return "redirect:/web/teamLeader/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        TeamLeader teamLeader = service.get(id);
        TeamLeaderForm teamLeaderForm = new TeamLeaderForm();

        Map<String, String> mavs = masterService.getAll().stream().collect(
                Collectors.toMap(Master::getId, Master::getFullName));
        String dflt = teamLeader.getMaster().getId();

        teamLeaderForm.setFirstName(teamLeader.getFirstName());
        teamLeaderForm.setLastName(teamLeader.getLastName());
        teamLeaderForm.setPatronymic(teamLeader.getPatronymic());
        teamLeaderForm.setSalary(teamLeader.getSalary());
        teamLeaderForm.setExperience(teamLeader.getExperience());
        teamLeaderForm.setMaster(teamLeader.getMaster().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("dflt", dflt);
        model.addAttribute("teamLeaderForm", teamLeaderForm);
        return "teamLeaderAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("teamLeaderForm") TeamLeaderForm teamLeaderForm){

        TeamLeader teamLeader = new TeamLeader();

        teamLeader.setId(id);
        teamLeader.setName(service.get(id).getName());
        teamLeader.setDescription(service.get(id).getDescription());
        teamLeader.setDateCreated(service.get(id).getDateCreated());
        teamLeader.setDateModified(service.get(id).getDateModified());

        teamLeader.setFirstName(teamLeaderForm.getFirstName());
        teamLeader.setLastName(teamLeaderForm.getLastName());
        teamLeader.setPatronymic(teamLeaderForm.getPatronymic());
        teamLeader.setSalary(teamLeaderForm.getSalary());
        teamLeader.setExperience(teamLeaderForm.getExperience());

        teamLeader.setMaster(masterService.get(teamLeaderForm.getMaster()));

        service.edit(teamLeader);
        model.addAttribute("teamLeaders", service.getAll());
        return "redirect:/web/teamLeader/list";
    }
}
