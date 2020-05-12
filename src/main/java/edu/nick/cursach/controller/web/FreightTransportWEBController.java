package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.FreightTransportForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.service.FreightTransport.impls.FreightTransportServiceImpl;
import edu.nick.cursach.service.StorageObj.impls.StorageObjServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/freightTransport")
public class FreightTransportWEBController {

    @Autowired
    StorageObjServiceImpl storageObjService;

    @Autowired
    FreightTransportServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("freightTransports", service.getAll());
        return "freightTransportList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<FreightTransport> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("freightTransports", list);
        return "freightTransportList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<FreightTransport> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<FreightTransport> sortedList = service.sortedByBrand(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("freightTransports", sortedList);
        return "freightTransportList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<FreightTransport> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/freightTransport/list" : "freightTransportList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("freightTransports", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("freightTransports", service.getAll());
        return "redirect:/web/freightTransport/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        FreightTransportForm freightTransportForm = new FreightTransportForm();

        Map<String, Integer> mavs = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        List<String> types = new ArrayList<>(Arrays.asList("Heavy Truck", "Tipper", "Van", "Box Truck", "Refuse Track"));

        model.addAttribute("mavs", mavs);
        model.addAttribute("types", types);
        model.addAttribute("freightTransportForm", freightTransportForm);

        return "freightTransportAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("freightTransportForm") FreightTransportForm freightTransportForm){

        FreightTransport freightTransport = new FreightTransport();

        freightTransport.setName("name");
        freightTransport.setDescription("description");

        freightTransport.setBrand(freightTransportForm.getBrand());
        freightTransport.setLoadCapacity(freightTransportForm.getLoadCapacity());
        freightTransport.setType(freightTransportForm.getType());
        freightTransport.setStorageObj(storageObjService.get(freightTransportForm.getStorageObj()));
        freightTransport.setTrackNumber(freightTransportForm.getTrackNumber());

        service.save(freightTransport);
        model.addAttribute("freightTransports", service.getAll());
        return "redirect:/web/freightTransport/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        FreightTransport freightTransport = service.get(id);

        Map<String, Integer> mavs = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        List<String> types = new ArrayList<>(Arrays.asList("Heavy Truck", "Tipper", "Van", "Box Truck", "Refuse Track"));

        String dflt = freightTransport.getStorageObj().getId();

        FreightTransportForm freightTransportForm = new FreightTransportForm();

        freightTransportForm.setBrand(freightTransport.getBrand());
        freightTransportForm.setLoadCapacity(freightTransport.getLoadCapacity());
        freightTransportForm.setType(freightTransport.getType());
        freightTransportForm.setStorageObj(freightTransport.getStorageObj().getId());
        freightTransportForm.setTrackNumber(freightTransport.getTrackNumber());

        model.addAttribute("mavs", mavs);
        model.addAttribute("freightTransportForm", freightTransportForm);
        model.addAttribute("types", types);
        model.addAttribute("dflt", dflt);

        return "freightTransportAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("freightTransportForm") FreightTransportForm freightTransportForm){

        FreightTransport freightTransport = new FreightTransport();

        freightTransport.setId(id);
        freightTransport.setName(service.get(id).getName());
        freightTransport.setDescription(service.get(id).getDescription());
        freightTransport.setDateCreated(service.get(id).getDateCreated());
        freightTransport.setDateModified(service.get(id).getDateModified());

        freightTransport.setBrand(freightTransportForm.getBrand());
        freightTransport.setLoadCapacity(freightTransportForm.getLoadCapacity());
        freightTransport.setType(freightTransportForm.getType());
        freightTransport.setStorageObj(storageObjService.get(freightTransportForm.getStorageObj()));
        freightTransport.setTrackNumber(freightTransportForm.getTrackNumber());

        service.edit(freightTransport);
        model.addAttribute("freightTransports", service.getAll());
        return "redirect:/web/freightTransport/list";
    }
}
