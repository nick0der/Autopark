package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.DriverForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.Driver;
import edu.nick.cursach.model.Transport;
import edu.nick.cursach.service.Driver.impls.DriverServiceImpl;
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

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drivers", service.getAll());
        return "driverList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<Driver> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drivers", list);
        return "driverList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<Driver> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<Driver> sortedList = service.sortedByLastName(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drivers", sortedList);
        return "driverList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<Driver> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/driver/list" : "driverList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drivers", list);
        return toReturn;
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
