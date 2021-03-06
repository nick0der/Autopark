package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.UsageOfAncillaryTransportForm;
import edu.nick.cursach.model.AncillaryTransport;
import edu.nick.cursach.model.UsageOfAncillaryTransport;
import edu.nick.cursach.service.AncillaryTransport.impls.AncillaryTransportServiceImpl;
import edu.nick.cursach.service.UsageOfAncillaryTransport.impls.UsageOfAncillaryTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/usageOfAncillaryTransport")
public class UsageOfAncillaryTransportWEBController {


    @Autowired
    AncillaryTransportServiceImpl ancillaryTransportService;

    @Autowired
    UsageOfAncillaryTransportServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("usageOfAncillaryTransports", service.getAll());
        return "usageOfAncillaryTransportList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("usageOfAncillaryTransports", service.getAll());
        return "redirect:/web/usageOfAncillaryTransport/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        UsageOfAncillaryTransportForm usageOfAncillaryTransportForm = new UsageOfAncillaryTransportForm();

        Map<String, String> mavs = ancillaryTransportService.getAll().stream().collect(
                Collectors.toMap(AncillaryTransport::getId, AncillaryTransport::getBrandAndTrackNumber));

        model.addAttribute("mavs", mavs);
        model.addAttribute("usageOfAncillaryTransportForm", usageOfAncillaryTransportForm);

        return "usageOfAncillaryTransportAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("usageOfAncillaryTransportForm")
            UsageOfAncillaryTransportForm usageOfAncillaryTransportForm){

        UsageOfAncillaryTransport usageOfAncillaryTransport = new UsageOfAncillaryTransport();

        usageOfAncillaryTransport.setName("name");
        usageOfAncillaryTransport.setDescription("description");
        usageOfAncillaryTransport.setDateUsed(LocalDate.parse(usageOfAncillaryTransportForm.getDateUsed()));
        usageOfAncillaryTransport.setAncillaryTransport(ancillaryTransportService.get(usageOfAncillaryTransportForm.getAncillaryTransport()));

        service.save(usageOfAncillaryTransport);
        model.addAttribute("usageOfAncillaryTransports", service.getAll());
        return "redirect:/web/usageOfAncillaryTransport/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        UsageOfAncillaryTransport usageOfAncillaryTransport = service.get(id);

        Map<String, String> mavs = ancillaryTransportService.getAll().stream().collect(
                Collectors.toMap(AncillaryTransport::getId, AncillaryTransport::getBrandAndTrackNumber));

        String dflt = usageOfAncillaryTransport.getAncillaryTransport().getId();

        UsageOfAncillaryTransportForm usageOfAncillaryTransportForm = new UsageOfAncillaryTransportForm();

        usageOfAncillaryTransportForm.setDateUsed(usageOfAncillaryTransport.getDateUsed().toString());
        usageOfAncillaryTransportForm.setAncillaryTransport(usageOfAncillaryTransport.getAncillaryTransport().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("dflt", dflt);
        model.addAttribute("usageOfAncillaryTransportForm", usageOfAncillaryTransportForm);

        return "usageOfAncillaryTransportAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("usageOfAncillaryTransportForm") UsageOfAncillaryTransportForm usageOfAncillaryTransportForm){

        UsageOfAncillaryTransport usageOfAncillaryTransport = new UsageOfAncillaryTransport();

        usageOfAncillaryTransport.setId(id);
        usageOfAncillaryTransport.setName(service.get(id).getName());
        usageOfAncillaryTransport.setDescription(service.get(id).getDescription());
        usageOfAncillaryTransport.setDateCreated(service.get(id).getDateCreated());
        usageOfAncillaryTransport.setDateModified(service.get(id).getDateModified());

        usageOfAncillaryTransport.setDateUsed(LocalDate.parse(usageOfAncillaryTransportForm.getDateUsed()));
        usageOfAncillaryTransport.setAncillaryTransport(ancillaryTransportService.get(usageOfAncillaryTransportForm.getAncillaryTransport()));

        service.edit(usageOfAncillaryTransport);
        model.addAttribute("usageOfAncillaryTransports", service.getAll());
        return "redirect:/web/usageOfAncillaryTransport/list";
    }
}
