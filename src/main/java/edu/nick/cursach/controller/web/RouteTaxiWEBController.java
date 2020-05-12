package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.RouteTaxiForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.Route;
import edu.nick.cursach.model.RouteTaxi;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.service.Route.impls.RouteServiceImpl;
import edu.nick.cursach.service.RouteTaxi.impls.RouteTaxiServiceImpl;
import edu.nick.cursach.service.StorageObj.impls.StorageObjServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/routeTaxi")
public class RouteTaxiWEBController {

    @Autowired
    StorageObjServiceImpl storageObjService;

    @Autowired
    RouteServiceImpl routeService;

    @Autowired
    RouteTaxiServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routeTaxis", service.getAll());
        return "routeTaxiList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<RouteTaxi> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routeTaxis", list);
        return "routeTaxiList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<RouteTaxi> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<RouteTaxi> sortedList = service.sortedByBrand(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routeTaxis", sortedList);
        return "routeTaxiList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<RouteTaxi> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/routeTaxi/list" : "routeTaxiList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routeTaxis", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("routeTaxis", service.getAll());
        return "redirect:/web/routeTaxi/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        RouteTaxiForm routeTaxiForm = new RouteTaxiForm();

        Map<String, String> mavs1 = routeService.getAll().stream().collect(
                Collectors.toMap(Route::getId, Route::getFullTitle));
        Map<String, Integer> mavs2 = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        model.addAttribute("mavs1", mavs1);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("routeTaxiForm", routeTaxiForm);

        return "routeTaxiAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("routeTaxiForm") RouteTaxiForm routeTaxiForm){

        RouteTaxi routeTaxi = new RouteTaxi();

        routeTaxi.setName("name");
        routeTaxi.setDescription("description");

        routeTaxi.setBrand(routeTaxiForm.getBrand());
        routeTaxi.setSeatingCapacity(routeTaxiForm.getSeatingCapacity());
        routeTaxi.setNumber(routeTaxiForm.getNumber());
        routeTaxi.setRoute(routeService.get(routeTaxiForm.getRoute()));
        routeTaxi.setStorageObj(storageObjService.get(routeTaxiForm.getStorageObj()));
        routeTaxi.setTrackNumber(routeTaxiForm.getTrackNumber());

        service.save(routeTaxi);
        model.addAttribute("routeTaxis", service.getAll());
        return "redirect:/web/routeTaxi/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        RouteTaxi routeTaxi = service.get(id);

        Map<String, String> mavs1 = routeService.getAll().stream().collect(
                Collectors.toMap(Route::getId, Route::getFullTitle));

        Map<String, Integer> mavs2 = storageObjService.getAll().stream().collect(
                Collectors.toMap(StorageObj::getId, StorageObj::getNumber));

        String dflt1 = routeTaxi.getRoute().getId();
        String dflt2 = routeTaxi.getStorageObj().getId();

        RouteTaxiForm routeTaxiForm = new RouteTaxiForm();

        routeTaxiForm.setBrand(routeTaxi.getBrand());
        routeTaxiForm.setSeatingCapacity(routeTaxi.getSeatingCapacity());
        routeTaxiForm.setNumber(routeTaxi.getNumber());

        routeTaxiForm.setRoute((routeTaxi.getRoute().getId()));
        routeTaxiForm.setStorageObj(routeTaxi.getStorageObj().getId());
        routeTaxiForm.setTrackNumber(routeTaxi.getTrackNumber());

        model.addAttribute("mavs1", mavs1);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("dflt1", dflt1);
        model.addAttribute("dflt2", dflt2);
        model.addAttribute("routeTaxiForm", routeTaxiForm);

        return "routeTaxiAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("routeTaxiForm") RouteTaxiForm routeTaxiForm){

        RouteTaxi routeTaxi = new RouteTaxi();

        routeTaxi.setId(id);
        routeTaxi.setName(service.get(id).getName());
        routeTaxi.setDescription(service.get(id).getDescription());
        routeTaxi.setDateCreated(service.get(id).getDateCreated());
        routeTaxi.setDateModified(service.get(id).getDateModified());

        routeTaxi.setBrand(routeTaxiForm.getBrand());
        routeTaxi.setSeatingCapacity(routeTaxiForm.getSeatingCapacity());
        routeTaxi.setNumber(routeTaxiForm.getNumber());
        routeTaxi.setRoute(routeService.get(routeTaxiForm.getRoute()));
        routeTaxi.setStorageObj(storageObjService.get(routeTaxiForm.getStorageObj()));
        routeTaxi.setTrackNumber(routeTaxiForm.getTrackNumber());

        service.edit(routeTaxi);
        model.addAttribute("routeTaxis", service.getAll());
        return "redirect:/web/routeTaxi/list";
    }
}
