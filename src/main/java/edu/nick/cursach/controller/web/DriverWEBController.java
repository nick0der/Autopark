package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.DriverForm;
import edu.nick.cursach.model.AncillaryTransport;
import edu.nick.cursach.model.Driver;
import edu.nick.cursach.model.FreightTransport;
import edu.nick.cursach.model.Transport;
import edu.nick.cursach.service.AncillaryTransport.impls.AncillaryTransportServiceImpl;
import edu.nick.cursach.service.Bus.impls.BusServiceImpl;
import edu.nick.cursach.service.Driver.impls.DriverServiceImpl;
import edu.nick.cursach.service.FreightTransport.impls.FreightTransportServiceImpl;
import edu.nick.cursach.service.RouteTaxi.impls.RouteTaxiServiceImpl;
import edu.nick.cursach.service.Taxi.impls.TaxiServiceImpl;
import edu.nick.cursach.service.Transport.impls.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/driver")
public class DriverWEBController {

    @Autowired
    TransportServiceImpl transportService;

    @Autowired
    DriverServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("drivers", service.getAll());
        return "driverList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("drivers", service.getAll());
        return "redirect:/web/driver/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        DriverForm driverForm = new DriverForm();

        Map<String, String> mavs = transportService.getAll().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        model.addAttribute("mavs", mavs);
        model.addAttribute("driverForm", driverForm);

        return "driverAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("driverForm") DriverForm driverForm){

        Driver driver = new Driver();

        driver.setName("name");
        driver.setDescription("description");

        driver.setFirstName(driverForm.getFirstName());
        driver.setLastName(driverForm.getLastName());
        driver.setPatronymic(driverForm.getPatronymic());

        driver.setTransport(transportService.get(driverForm.getTransport()));
        driver.setSalary(driverForm.getSalary());
        driver.setExperience(driverForm.getExperience());

        service.save(driver);
        model.addAttribute("drivers", service.getAll());
        return "redirect:/web/driver/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Driver driver = service.get(id);

        Map<String, String> mavs = transportService.getAll().stream().collect(
                Collectors.toMap(Transport::getId, Transport::getBrandAndTrackNumber));

        String dflt = driver.getTransport().getId();

        DriverForm driverForm = new DriverForm();

        driverForm.setFirstName(driver.getFirstName());
        driverForm.setLastName(driver.getLastName());
        driverForm.setPatronymic(driver.getPatronymic());
        driverForm.setSalary(driver.getSalary());
        driverForm.setExperience(driver.getExperience());
        driverForm.setTransport(driver.getTransport().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("driverForm", driverForm);
        model.addAttribute("dflt", dflt);

        return "driverAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("driverForm") DriverForm driverForm){

        Driver driver = new Driver();

        driver.setId(id);
        driver.setName(service.get(id).getName());
        driver.setDescription(service.get(id).getDescription());
        driver.setDateCreated(service.get(id).getDateCreated());
        driver.setDateModified(service.get(id).getDateModified());

        driver.setFirstName(driverForm.getFirstName());
        driver.setLastName(driverForm.getLastName());
        driver.setPatronymic(driverForm.getPatronymic());
        driver.setSalary(driverForm.getSalary());
        driver.setExperience(driverForm.getExperience());
        driver.setTransport(transportService.get(driverForm.getTransport()));

        service.edit(driver);
        model.addAttribute("drivers", service.getAll());
        return "redirect:/web/driver/list";
    }
}
