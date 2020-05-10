package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.TransportationForm;
import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.model.Transportation;
import edu.nick.cursach.service.FreightTransport.impls.FreightTransportServiceImpl;
import edu.nick.cursach.service.Transportation.impls.TransportationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/transportation")
public class TransportationWEBController {

    @Autowired
    FreightTransportServiceImpl freightTransportService;

    @Autowired
    TransportationServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("transportations", service.getAll());
        return "transportationList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("transportations", service.getAll());
        return "redirect:/web/transportation/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        TransportationForm transportationForm = new TransportationForm();

        Map<String, String> mavs = freightTransportService.getAll().stream().collect(
                Collectors.toMap(FreightTransport::getId, FreightTransport::getBrandAndTrackNumber));

        model.addAttribute("mavs", mavs);
        model.addAttribute("transportationForm", transportationForm);

        return "transportationAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("transportationForm") TransportationForm transportationForm){

        Transportation transportation = new Transportation();

        transportation.setName("name");
        transportation.setDescription("description");
        transportation.setDateTransported(LocalDate.parse(transportationForm.getDateTransported()));
        transportation.setWeight(transportationForm.getWeight());
        transportation.setFreightTransport(freightTransportService.get(transportationForm.getFreightTransport()));

        service.save(transportation);
        model.addAttribute("transportations", service.getAll());
        return "redirect:/web/transportation/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Transportation transportation = service.get(id);

        Map<String, String> mavs = freightTransportService.getAll().stream().collect(
                Collectors.toMap(FreightTransport::getId, FreightTransport::getBrandAndTrackNumber));

        String dflt = transportation.getFreightTransport().getId();

        TransportationForm transportationForm = new TransportationForm();

        transportationForm.setDateTransported(transportation.getDateTransported().toString());
        transportationForm.setWeight(transportation.getWeight());
        transportationForm.setFreightTransport(transportation.getFreightTransport().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("transportationForm", transportationForm);
        model.addAttribute("dflt", dflt);

        return "transportationAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("transportationForm") TransportationForm transportationForm){

        Transportation transportation = new Transportation();

        transportation.setId(id);
        transportation.setName(service.get(id).getName());
        transportation.setDescription(service.get(id).getDescription());
        transportation.setDateCreated(service.get(id).getDateCreated());
        transportation.setDateModified(service.get(id).getDateModified());

        transportation.setDateTransported(LocalDate.parse(transportationForm.getDateTransported()));
        transportation.setWeight(transportationForm.getWeight());
        transportation.setFreightTransport(freightTransportService.get(transportationForm.getFreightTransport()));

        service.edit(transportation);
        model.addAttribute("transportations", service.getAll());
        return "redirect:/web/transportation/list";
    }
}
