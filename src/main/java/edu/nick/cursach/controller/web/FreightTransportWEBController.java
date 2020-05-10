package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.FreightTransportForm;
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

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("freightTransports", service.getAll());
        return "freightTransportList";
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
