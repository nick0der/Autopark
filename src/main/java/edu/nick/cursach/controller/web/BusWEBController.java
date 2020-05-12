package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.BusForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.Bus;
import edu.nick.cursach.model.Route;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.service.Bus.impls.BusServiceImpl;
import edu.nick.cursach.service.Route.impls.RouteServiceImpl;
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
@RequestMapping("/web/bus")
public class BusWEBController {

    @Autowired
    StorageObjServiceImpl storageObjService;

    @Autowired
    RouteServiceImpl routeService;

    @Autowired
    BusServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("buses", service.getAll());
        return "busList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<Bus> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("buses", list);
        return "busList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<Bus> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<Bus> sortedList = service.sortedByBrand(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("buses", sortedList);
        return "busList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<Bus> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/bus/list" : "busList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("buses", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("buses", service.getAll());
        return "redirect:/web/bus/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        BusForm busForm = new BusForm();

        Map<String, String> mavs1 = routeService.getAll().stream().collect(
                Collectors.toMap(Route::getId, Route::getFullTitle));
        Map<String, Integer> mavs2 = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));
        List<String> types = new ArrayList<>(Arrays.asList("Economy Class", "Business Class", "First Class"));

        model.addAttribute("mavs1", mavs1);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("types", types);
        model.addAttribute("busForm", busForm);

        return "busAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("busForm") BusForm busForm){

        Bus bus = new Bus();

        bus.setName("name");
        bus.setDescription("description");

        bus.setBrand(busForm.getBrand());
        bus.setSeatingCapacity(busForm.getSeatingCapacity());
        bus.setServiceClass(busForm.getServiceClass());
        bus.setRoute(routeService.get(busForm.getRoute()));
        bus.setStorageObj(storageObjService.get(busForm.getStorageObj()));
        bus.setTrackNumber(busForm.getTrackNumber());

        service.save(bus);
        model.addAttribute("buses", service.getAll());
        return "redirect:/web/bus/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Bus bus = service.get(id);

        Map<String, String> mavs1 = routeService.getAll().stream().collect(
                Collectors.toMap(Route::getId, Route::getFullTitle));

        Map<String, Integer> mavs2 = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        List<String> types = new ArrayList<>(Arrays.asList("Economy Class", "Business Class", "First Class"));

        String dflt1 = bus.getRoute().getId();
        String dflt2 = bus.getStorageObj().getId();

        BusForm busForm = new BusForm();

        busForm.setBrand(bus.getBrand());
        busForm.setSeatingCapacity(bus.getSeatingCapacity());
        busForm.setServiceClass(bus.getServiceClass());

        busForm.setRoute((bus.getRoute().getFullTitle()));
        busForm.setStorageObj(bus.getStorageObj().getId());
        busForm.setTrackNumber(bus.getTrackNumber());

        model.addAttribute("mavs1", mavs1);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("types", types);
        model.addAttribute("busForm", busForm);
        model.addAttribute("dflt1", dflt1);
        model.addAttribute("dflt2", dflt2);

        return "busAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("busForm") BusForm busForm){

        Bus bus = new Bus();

        bus.setId(id);
        bus.setName(service.get(id).getName());
        bus.setDescription(service.get(id).getDescription());
        bus.setDateCreated(service.get(id).getDateCreated());
        bus.setDateModified(service.get(id).getDateModified());

        bus.setBrand(busForm.getBrand());
        bus.setSeatingCapacity(busForm.getSeatingCapacity());
        bus.setServiceClass(busForm.getServiceClass());
        bus.setRoute(routeService.get(busForm.getRoute()));
        bus.setStorageObj(storageObjService.get(busForm.getStorageObj()));
        bus.setTrackNumber(busForm.getTrackNumber());

        service.edit(bus);
        model.addAttribute("buses", service.getAll());
        return "redirect:/web/bus/list";
    }
}
