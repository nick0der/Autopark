package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.RemovedTransportForm;
import edu.nick.cursach.model.RemovedTransport;
import edu.nick.cursach.service.RemovedTransport.impls.RemovedTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/web/removedTransport")
public class RemovedTransportWEBController {

    @Autowired
    RemovedTransportServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("removedTransports", service.getAll());
        return "removedTransportList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("removedTransports", service.getAll());
        return "redirect:/web/removedTransport/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        RemovedTransportForm removedTransportForm = new RemovedTransportForm();
        model.addAttribute("removedTransportForm", removedTransportForm);

        return "removedTransportAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("removedTransportForm") RemovedTransportForm removedTransportForm){

        RemovedTransport removedTransport = new RemovedTransport();

        removedTransport.setName("name");
        removedTransport.setDescription("description");
        removedTransport.setDateRemoved(LocalDate.parse(removedTransportForm.getDateRemoved()));
        removedTransport.setBrand(removedTransportForm.getBrand());
        removedTransport.setInfo(removedTransportForm.getInfo());
        service.save(removedTransport);
        model.addAttribute("removedTransports", service.getAll());
        return "redirect:/web/removedTransport/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        RemovedTransport removedTransport = service.get(id);
        RemovedTransportForm removedTransportForm = new RemovedTransportForm();

        removedTransportForm.setBrand(removedTransport.getBrand());
        removedTransportForm.setDateRemoved(removedTransport.getDateRemoved().toString());
        removedTransportForm.setInfo(removedTransport.getInfo());

        model.addAttribute("removedTransportForm", removedTransportForm);

        return "removedTransportAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("removedTransportForm") RemovedTransportForm removedTransportForm){

        RemovedTransport removedTransport = new RemovedTransport();

        removedTransport.setId(id);
        removedTransport.setName(service.get(id).getName());
        removedTransport.setDescription(service.get(id).getDescription());
        removedTransport.setDateCreated(service.get(id).getDateCreated());
        removedTransport.setDateModified(service.get(id).getDateModified());

        removedTransport.setDateRemoved(LocalDate.parse(removedTransportForm.getDateRemoved()));
        removedTransport.setBrand(removedTransportForm.getBrand());
        removedTransport.setInfo(removedTransportForm.getInfo());

        service.edit(removedTransport);
        model.addAttribute("removedTransports", service.getAll());
        return "redirect:/web/removedTransport/list";
    }
}
