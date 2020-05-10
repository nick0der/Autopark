package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.StorageObjForm;
import edu.nick.cursach.form.TaxiForm;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.model.Taxi;
import edu.nick.cursach.service.StorageObj.impls.StorageObjServiceImpl;
import edu.nick.cursach.service.Taxi.impls.TaxiServiceImpl;
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
@RequestMapping("/web/taxi")
public class TaxiWEBController {

    @Autowired
    StorageObjServiceImpl storageObjService;

    @Autowired
    TaxiServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("taxis", service.getAll());
        return "taxiList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("taxis", service.getAll());
        return "redirect:/web/taxi/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        TaxiForm taxiForm = new TaxiForm();
        Map<String, Integer> mavs = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        List<String> types = new ArrayList<>(Arrays.asList("sedan", "coupe", "hatchback", "estate", "cabriolet",
                "minivan", "off-road", "pick-up"));

        model.addAttribute("mavs", mavs);
        model.addAttribute("types", types);
        model.addAttribute("taxiForm", taxiForm);
        return "taxiAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("taxiForm") TaxiForm taxiForm){

        Taxi taxi = new Taxi();

        taxi.setName("name");
        taxi.setDescription("description");

        taxi.setBrand(taxiForm.getBrand());
        taxi.setSeatingCapacity(taxiForm.getSeatingCapacity());
        taxi.setBodyType(taxiForm.getBodyType());
        taxi.setTrackNumber(taxiForm.getTrackNumber());
        taxi.setStorageObj(storageObjService.get(taxiForm.getStorageObj()));

        service.save(taxi);
        model.addAttribute("taxis", service.getAll());
        return "redirect:/web/taxi/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Taxi taxi = service.get(id);
        TaxiForm taxiForm = new TaxiForm();

        Map<String, Integer> mavs = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        List<String> types = new ArrayList<>(Arrays.asList("sedan", "coupe", "hatchback", "estate", "cabriolet",
                "minivan", "off-road", "pick-up"));

        String dflt = taxi.getStorageObj().getId();


        taxiForm.setBrand(taxi.getBrand());
        taxiForm.setSeatingCapacity(taxi.getSeatingCapacity());
        taxiForm.setBodyType(taxi.getBodyType());
        taxiForm.setTrackNumber(taxi.getTrackNumber());
        taxiForm.setStorageObj(taxi.getStorageObj().getId());

        model.addAttribute("types", types);
        model.addAttribute("mavs", mavs);
        model.addAttribute("dflt", dflt);
        model.addAttribute("taxiForm", taxiForm);
        return "taxiAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("taxiForm") TaxiForm taxiForm){

        Taxi taxi = new Taxi();

        taxi.setId(id);
        taxi.setName(service.get(id).getName());
        taxi.setDescription(service.get(id).getDescription());
        taxi.setDateCreated(service.get(id).getDateCreated());
        taxi.setDateModified(service.get(id).getDateModified());

        taxi.setBrand(taxiForm.getBrand());
        taxi.setSeatingCapacity(taxiForm.getSeatingCapacity());
        taxi.setBodyType(taxiForm.getBodyType());
        taxi.setTrackNumber(taxiForm.getTrackNumber());
        taxi.setStorageObj(storageObjService.get(taxiForm.getStorageObj()));

        service.edit(taxi);
        model.addAttribute("taxis", service.getAll());
        return "redirect:/web/taxi/list";
    }
}
