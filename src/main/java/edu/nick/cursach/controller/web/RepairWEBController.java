package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.RepairForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.Repair;
import edu.nick.cursach.model.Transport;
import edu.nick.cursach.model.WorkingTeam;
import edu.nick.cursach.service.Repair.impls.RepairServiceImpl;
import edu.nick.cursach.service.Transport.impls.TransportServiceImpl;
import edu.nick.cursach.service.WorkingTeam.impls.WorkingTeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/repair")
public class RepairWEBController {


    @Autowired
    TransportServiceImpl transportService;

    @Autowired
    WorkingTeamServiceImpl workingTeamService;

    @Autowired
    RepairServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("repairs", service.getAll());
        return "repairList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<Repair> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("repairs", list);
        return "repairList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<Repair> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<Repair> sortedList = service.sortedByDate(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("repairs", sortedList);
        return "repairList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<Repair> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/repair/list" : "repairList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("repairs", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("repairs", service.getAll());
        return "redirect:/web/repair/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        RepairForm repairForm = new RepairForm();

        Map<String, String> mavs1 = transportService.getAll().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        Map<String, Integer> mavs2 = workingTeamService.getAll().stream().collect(
                Collectors.toMap(WorkingTeam::getId, WorkingTeam::getNumber));

        model.addAttribute("mavs1", mavs1);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("repairForm", repairForm);

        return "repairAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("repairForm") RepairForm repairForm){

        Repair repair = new Repair();

        repair.setName("name");
        repair.setDescription("description");
        repair.setDateRepaired(LocalDate.parse(repairForm.getDateRepaired()));
        repair.setTransport(transportService.get(repairForm.getTransport()));
        repair.setWorkingTeam(workingTeamService.get(repairForm.getWorkingTeam()));
        repair.setCost(repairForm.getCost());
        repair.setEngines(repairForm.getEngines());
        repair.setTransmissions(repairForm.getTransmissions());
        repair.setBridges(repairForm.getBridges());
        repair.setChassis(repairForm.getChassis());


        service.save(repair);
        model.addAttribute("repairs", service.getAll());
        return "redirect:/web/repair/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Repair repair = service.get(id);

        Map<String, String> mavs1 = transportService.getAll().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        Map<String, Integer> mavs2 = workingTeamService.getAll().stream().collect(
                Collectors.toMap(WorkingTeam::getId, WorkingTeam::getNumber));


        String dflt1 = repair.getTransport().getId();
        String dflt2 = repair.getWorkingTeam().getId();

        RepairForm repairForm = new RepairForm();

        repairForm.setDateRepaired(repair.getDateRepaired().toString());
        repairForm.setTransport(repair.getTransport().getId());
        repairForm.setWorkingTeam(repair.getWorkingTeam().getId());
        repairForm.setCost(repair.getCost());
        repairForm.setEngines(repair.getEngines());
        repairForm.setTransmissions(repair.getTransmissions());
        repairForm.setBridges(repair.getBridges());
        repairForm.setChassis(repair.getChassis());

        model.addAttribute("mavs1", mavs1);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("dflt1", dflt1);
        model.addAttribute("dflt2", dflt2);
        model.addAttribute("repairForm", repairForm);

        return "repairAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("repairForm") RepairForm repairForm){

        Repair repair = new Repair();

        repair.setId(id);
        repair.setName(service.get(id).getName());
        repair.setDescription(service.get(id).getDescription());
        repair.setDateCreated(service.get(id).getDateCreated());
        repair.setDateModified(service.get(id).getDateModified());

        repair.setDateRepaired(LocalDate.parse(repairForm.getDateRepaired()));
        repair.setTransport(transportService.get(repairForm.getTransport()));
        repair.setWorkingTeam(workingTeamService.get(repairForm.getWorkingTeam()));
        repair.setCost(repairForm.getCost());
        repair.setEngines(repairForm.getEngines());
        repair.setTransmissions(repairForm.getTransmissions());
        repair.setBridges(repairForm.getBridges());
        repair.setChassis(repairForm.getChassis());

        service.edit(repair);
        model.addAttribute("repairs", service.getAll());
        return "redirect:/web/repair/list";
    }
}
