package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.AddedTransportForm;
import edu.nick.cursach.form.AncillaryTransportForm;
import edu.nick.cursach.model.AddedTransport;
import edu.nick.cursach.model.AncillaryTransport;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.service.AncillaryTransport.impls.AncillaryTransportServiceImpl;
import edu.nick.cursach.service.StorageObj.impls.StorageObjServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/ancillaryTransport")
public class AncillaryTransportWEBController {

    @Autowired
    StorageObjServiceImpl storageObjService;

    @Autowired
    AncillaryTransportServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("ancillaryTransports", service.getAll());
        return "ancillaryTransportList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("ancillaryTransports", service.getAll());
        return "redirect:/web/ancillaryTransport/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        AncillaryTransportForm ancillaryTransportForm = new AncillaryTransportForm();

        Map<String, Integer> mavs = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        model.addAttribute("mavs", mavs);
        model.addAttribute("ancillaryTransportForm", ancillaryTransportForm);

        return "ancillaryTransportAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("ancillaryTransportForm") AncillaryTransportForm ancillaryTransportForm){

        AncillaryTransport ancillaryTransport = new AncillaryTransport();

        ancillaryTransport.setName("name");
        ancillaryTransport.setDescription("description");
        ancillaryTransport.setBrand(ancillaryTransportForm.getBrand());
        ancillaryTransport.setMission(ancillaryTransportForm.getMission());
        ancillaryTransport.setStorageObj(storageObjService.get(ancillaryTransportForm.getStorageObj()));
        ancillaryTransport.setTrackNumber(ancillaryTransportForm.getTrackNumber());

        service.save(ancillaryTransport);
        model.addAttribute("ancillaryTransports", service.getAll());
        return "redirect:/web/ancillaryTransport/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){



        AncillaryTransport ancillaryTransport = service.get(id);
        Map<String, Integer> mavs = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        String dflt = ancillaryTransport.getStorageObj().getId();

        AncillaryTransportForm ancillaryTransportForm = new AncillaryTransportForm();



        ancillaryTransportForm.setBrand(ancillaryTransport.getBrand());
        ancillaryTransportForm.setMission(ancillaryTransport.getMission());
        ancillaryTransportForm.setStorageObj(ancillaryTransport.getStorageObj().getId());
        ancillaryTransportForm.setTrackNumber(ancillaryTransport.getTrackNumber());

        model.addAttribute("mavs", mavs);
        model.addAttribute("ancillaryTransportForm", ancillaryTransportForm);
        model.addAttribute("dflt", dflt);

        return "ancillaryTransportAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("ancillaryTransportForm") AncillaryTransportForm ancillaryTransportForm){

        AncillaryTransport ancillaryTransport = new AncillaryTransport();

        ancillaryTransport.setId(id);
        ancillaryTransport.setName(service.get(id).getName());
        ancillaryTransport.setDescription(service.get(id).getDescription());
        ancillaryTransport.setDateCreated(service.get(id).getDateCreated());
        ancillaryTransport.setDateModified(service.get(id).getDateModified());

        ancillaryTransport.setBrand(ancillaryTransportForm.getBrand());
        ancillaryTransport.setMission(ancillaryTransportForm.getMission());
        ancillaryTransport.setStorageObj(storageObjService.get(ancillaryTransportForm.getStorageObj()));
        ancillaryTransport.setTrackNumber(ancillaryTransportForm.getTrackNumber());

        service.edit(ancillaryTransport);
        model.addAttribute("ancillaryTransports", service.getAll());
        return "redirect:/web/ancillaryTransport/list";
    }
}
