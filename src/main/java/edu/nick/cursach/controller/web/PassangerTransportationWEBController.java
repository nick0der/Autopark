package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.PassangerTransportationForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.PassangerTransportation;
import edu.nick.cursach.model.Transport;
import edu.nick.cursach.service.PassangerTransportation.impls.PassangerTransportationServiceImpl;
import edu.nick.cursach.service.Transport.impls.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/passangerTransportation")
public class PassangerTransportationWEBController {

    @Autowired
    TransportServiceImpl transportService;

    @Autowired
    PassangerTransportationServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passangerTransportations", service.getAll());
        return "passangerTransportationList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<PassangerTransportation> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passangerTransportations", list);
        return "passangerTransportationList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<PassangerTransportation> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<PassangerTransportation> sortedList = service.sortedByDate(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passangerTransportations", sortedList);
        return "passangerTransportationList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<PassangerTransportation> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/passangerTransportation/list" : "passangerTransportationList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("passangerTransportations", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("passangerTransportations", service.getAll());
        return "redirect:/web/passangerTransportation/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        PassangerTransportationForm passangerTransportationForm = new PassangerTransportationForm();

        Map<String, String> mavs = transportService.getPassangerTransportList().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        model.addAttribute("mavs", mavs);
        model.addAttribute("passangerTransportationForm", passangerTransportationForm);

        return "passangerTransportationAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("passangerTransportationForm") PassangerTransportationForm passangerTransportationForm){

        PassangerTransportation passangerTransportation = new PassangerTransportation();

        passangerTransportation.setName("name");
        passangerTransportation.setDescription("description");
        passangerTransportation.setDateTransported(LocalDate.parse(passangerTransportationForm.getDateTransported()));
        passangerTransportation.setNumberOfPassangers(passangerTransportationForm.getNumberOfPassangers());
        passangerTransportation.setTransport(transportService.get(passangerTransportationForm.getTransport()));

        service.save(passangerTransportation);
        model.addAttribute("passangerTransportations", service.getAll());
        return "redirect:/web/passangerTransportation/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        PassangerTransportation passangerTransportation = service.get(id);

        Map<String, String> mavs = transportService.getPassangerTransportList().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        String dflt = passangerTransportation.getTransport().getId();

        PassangerTransportationForm passangerTransportationForm = new PassangerTransportationForm();

        passangerTransportationForm.setDateTransported(passangerTransportation.getDateTransported().toString());
        passangerTransportationForm.setNumberOfPassangers(passangerTransportation.getNumberOfPassangers());
        passangerTransportationForm.setTransport(passangerTransportation.getTransport().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("passangerTransportationForm", passangerTransportationForm);
        model.addAttribute("dflt", dflt);

        return "passangerTransportationAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("passangerTransportationForm") PassangerTransportationForm passangerTransportationForm){

        PassangerTransportation passangerTransportation = new PassangerTransportation();

        passangerTransportation.setId(id);
        passangerTransportation.setName(service.get(id).getName());
        passangerTransportation.setDescription(service.get(id).getDescription());
        passangerTransportation.setDateCreated(service.get(id).getDateCreated());
        passangerTransportation.setDateModified(service.get(id).getDateModified());

        passangerTransportation.setDateTransported(LocalDate.parse(passangerTransportationForm.getDateTransported()));
        passangerTransportation.setNumberOfPassangers(passangerTransportationForm.getNumberOfPassangers());
        passangerTransportation.setTransport(transportService.get(passangerTransportationForm.getTransport()));

        service.edit(passangerTransportation);
        model.addAttribute("passangerTransportations", service.getAll());
        return "redirect:/web/passangerTransportation/list";
    }
}
