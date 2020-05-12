package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.SearchForm;
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
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/transportation")
public class TransportationWEBController {

    @Autowired
    FreightTransportServiceImpl freightTransportService;

    @Autowired
    TransportationServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("transportations", service.getAll());
        return "transportationList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<Transportation> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("transportations", list);
        return "transportationList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<Transportation> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<Transportation> sortedList = service.sortedByDate(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("transportations", sortedList);
        return "transportationList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<Transportation> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/transportation/list" : "transportationList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("transportations", list);
        return toReturn;
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
