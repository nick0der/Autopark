package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.KilometrageForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.Kilometrage;
import edu.nick.cursach.model.Transport;
import edu.nick.cursach.service.Kilometrage.impls.KilometrageServiceImpl;
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
@RequestMapping("/web/kilometrage")
public class KilometrageWEBController {

    @Autowired
    TransportServiceImpl transportService;

    @Autowired
    KilometrageServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("kilometrages", service.getAll());
        return "kilometrageList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<Kilometrage> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("kilometrages", list);
        return "kilometrageList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<Kilometrage> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<Kilometrage> sortedList = service.sortedByDate(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("kilometrages", sortedList);
        return "kilometrageList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<Kilometrage> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/kilometrage/list" : "kilometrageList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("kilometrages", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("kilometrages", service.getAll());
        return "redirect:/web/kilometrage/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        KilometrageForm kilometrageForm = new KilometrageForm();

        Map<String, String> mavs = transportService.getAll().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        model.addAttribute("mavs", mavs);
        model.addAttribute("kilometrageForm", kilometrageForm);

        return "kilometrageAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("kilometrageForm") KilometrageForm kilometrageForm){

        Kilometrage kilometrage = new Kilometrage();

        kilometrage.setName("name");
        kilometrage.setDescription("description");
        kilometrage.setDateRecorded(LocalDate.parse(kilometrageForm.getDateRecorded()));
        kilometrage.setKilometers(kilometrageForm.getKilometers());
        kilometrage.setTransport(transportService.get(kilometrageForm.getTransport()));

        service.save(kilometrage);
        model.addAttribute("kilometrages", service.getAll());
        return "redirect:/web/kilometrage/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Kilometrage kilometrage = service.get(id);

        Map<String, String> mavs = transportService.getAll().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        String dflt = kilometrage.getTransport().getId();

        KilometrageForm kilometrageForm = new KilometrageForm();

        kilometrageForm.setDateRecorded(kilometrage.getDateRecorded().toString());
        kilometrageForm.setKilometers(kilometrage.getKilometers());
        kilometrageForm.setTransport(kilometrage.getTransport().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("kilometrageForm", kilometrageForm);
        model.addAttribute("dflt", dflt);

        return "kilometrageAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("kilometrageForm") KilometrageForm kilometrageForm){

        Kilometrage kilometrage = new Kilometrage();

        kilometrage.setId(id);
        kilometrage.setName(service.get(id).getName());
        kilometrage.setDescription(service.get(id).getDescription());
        kilometrage.setDateCreated(service.get(id).getDateCreated());
        kilometrage.setDateModified(service.get(id).getDateModified());

        kilometrage.setDateRecorded(LocalDate.parse(kilometrageForm.getDateRecorded()));
        kilometrage.setKilometers(kilometrageForm.getKilometers());
        kilometrage.setTransport(transportService.get(kilometrageForm.getTransport()));

        service.edit(kilometrage);
        model.addAttribute("kilometrages", service.getAll());
        return "redirect:/web/kilometrage/list";
    }
}
