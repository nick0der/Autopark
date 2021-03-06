package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.AddedTransportForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.AddedTransport;
import edu.nick.cursach.service.AddedTransport.impls.AddedTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/web/addedTransport")
public class AddedTransportWEBController {

    @Autowired
    AddedTransportServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("addedTransports", service.getAll());
        return "addedTransportList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("addedTransports", service.getAll());
        return "redirect:/web/addedTransport/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        AddedTransportForm addedTransportForm = new AddedTransportForm();
        model.addAttribute("addedTransportForm", addedTransportForm);

        return "addedTransportAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("addedTransportForm") AddedTransportForm addedTransportForm){

        AddedTransport addedTransport = new AddedTransport();

        addedTransport.setName("name");
        addedTransport.setDescription("description");
        addedTransport.setDateAdded(LocalDate.parse(addedTransportForm.getDateAdded()));
        addedTransport.setBrand(addedTransportForm.getBrand());
        addedTransport.setInfo(addedTransportForm.getInfo());

        service.save(addedTransport);
        model.addAttribute("addedTransports", service.getAll());
        return "redirect:/web/addedTransport/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        AddedTransport addedTransport = service.get(id);
        AddedTransportForm addedTransportForm = new AddedTransportForm();

        addedTransportForm.setBrand(addedTransport.getBrand());
        addedTransportForm.setDateAdded(addedTransport.getDateAdded().toString());
        addedTransportForm.setInfo(addedTransport.getInfo());

        model.addAttribute("addedTransportForm", addedTransportForm);

        return "addedTransportAdd";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("addedTransportForm") AddedTransportForm addedTransportForm){

        AddedTransport addedTransport = new AddedTransport();

        addedTransport.setId(id);
        addedTransport.setName(service.get(id).getName());
        addedTransport.setDescription(service.get(id).getDescription());
        addedTransport.setDateCreated(service.get(id).getDateCreated());
        addedTransport.setDateModified(service.get(id).getDateModified());

        addedTransport.setDateAdded(LocalDate.parse(addedTransportForm.getDateAdded()));
        addedTransport.setBrand(addedTransportForm.getBrand());
        addedTransport.setInfo(addedTransportForm.getInfo());

        service.edit(addedTransport);
        model.addAttribute("addedTransports", service.getAll());
        return "redirect:/web/addedTransport/list";
    }
}
