package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.ChiefForm;
import edu.nick.cursach.model.Chief;
import edu.nick.cursach.service.Chief.impls.ChiefServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/chief")
public class ChiefWEBController {

    @Autowired
    ChiefServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("chiefs", service.getAll());
        return "chiefList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("chiefs", service.getAll());
        return "redirect:/web/chief/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        ChiefForm chiefForm = new ChiefForm();
        model.addAttribute("chiefForm", chiefForm);
        return "chiefAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("chiefForm") ChiefForm chiefForm){

        Chief chief = new Chief();

        chief.setName("name");
        chief.setDescription("description");

        chief.setFirstName(chiefForm.getFirstName());
        chief.setLastName(chiefForm.getLastName());
        chief.setPatronymic(chiefForm.getPatronymic());
        chief.setSalary(chiefForm.getSalary());
        chief.setExperience(chiefForm.getExperience());

        service.save(chief);
        model.addAttribute("chiefs", service.getAll());
        return "redirect:/web/chief/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Chief chief = service.get(id);
        ChiefForm chiefForm = new ChiefForm();

        chiefForm.setFirstName(chief.getFirstName());
        chiefForm.setLastName(chief.getLastName());
        chiefForm.setPatronymic(chief.getPatronymic());
        chiefForm.setSalary(chief.getSalary());
        chiefForm.setExperience(chief.getExperience());

        model.addAttribute("chiefForm", chiefForm);
        return "chiefAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("chiefForm") ChiefForm chiefForm){

        Chief chief = new Chief();

        chief.setId(id);
        chief.setName(service.get(id).getName());
        chief.setDescription(service.get(id).getDescription());
        chief.setDateCreated(service.get(id).getDateCreated());
        chief.setDateModified(service.get(id).getDateModified());

        chief.setFirstName(chiefForm.getFirstName());
        chief.setLastName(chiefForm.getLastName());
        chief.setPatronymic(chiefForm.getPatronymic());
        chief.setSalary(chiefForm.getSalary());
        chief.setExperience(chiefForm.getExperience());


        service.edit(chief);
        model.addAttribute("chiefs", service.getAll());
        return "redirect:/web/chief/list";
    }
}
