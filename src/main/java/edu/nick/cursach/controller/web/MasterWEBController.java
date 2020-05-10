package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.MasterForm;
import edu.nick.cursach.model.Chief;
import edu.nick.cursach.model.Master;
import edu.nick.cursach.model.Route;
import edu.nick.cursach.service.Chief.impls.ChiefServiceImpl;
import edu.nick.cursach.service.Master.impls.MasterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/master")
public class MasterWEBController {

    @Autowired
    ChiefServiceImpl chiefService;

    @Autowired
    MasterServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("masters", service.getAll());
        return "masterList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("masters", service.getAll());
        return "redirect:/web/master/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        MasterForm masterForm = new MasterForm();
        Map<String, String> mavs = chiefService.getAll().stream().collect(
                Collectors.toMap(Chief::getId, Chief::getFullName));
        model.addAttribute("mavs", mavs);
        model.addAttribute("masterForm", masterForm);
        return "masterAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("masterForm") MasterForm masterForm){

        Master master = new Master();

        master.setName("name");
        master.setDescription("description");

        master.setFirstName(masterForm.getFirstName());
        master.setLastName(masterForm.getLastName());
        master.setPatronymic(masterForm.getPatronymic());
        master.setSalary(masterForm.getSalary());
        master.setExperience(masterForm.getExperience());
        master.setChief(chiefService.get(masterForm.getChief()));

        service.save(master);
        model.addAttribute("masters", service.getAll());
        return "redirect:/web/master/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Master master = service.get(id);
        MasterForm masterForm = new MasterForm();

        Map<String, String> mavs = chiefService.getAll().stream().collect(
                Collectors.toMap(Chief::getId, Chief::getFullName));
        String dflt = master.getChief().getId();

        masterForm.setFirstName(master.getFirstName());
        masterForm.setLastName(master.getLastName());
        masterForm.setPatronymic(master.getPatronymic());
        masterForm.setSalary(master.getSalary());
        masterForm.setExperience(master.getExperience());
        masterForm.setChief(master.getChief().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("dflt", dflt);
        model.addAttribute("masterForm", masterForm);
        return "masterAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("masterForm") MasterForm masterForm){

        Master master = new Master();

        master.setId(id);
        master.setName(service.get(id).getName());
        master.setDescription(service.get(id).getDescription());
        master.setDateCreated(service.get(id).getDateCreated());
        master.setDateModified(service.get(id).getDateModified());

        master.setFirstName(masterForm.getFirstName());
        master.setLastName(masterForm.getLastName());
        master.setPatronymic(masterForm.getPatronymic());
        master.setSalary(masterForm.getSalary());
        master.setExperience(masterForm.getExperience());
        master.setChief(chiefService.get(masterForm.getChief()));

        service.edit(master);
        model.addAttribute("masters", service.getAll());
        return "redirect:/web/master/list";
    }
}
