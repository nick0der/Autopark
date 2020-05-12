package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.RouteForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.Route;
import edu.nick.cursach.service.Route.impls.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/route")
public class RouteWEBController {

    @Autowired
    RouteServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", service.getAll());
        return "routeList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<Route> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", list);
        return "routeList";
    }

    @RequestMapping(value = "/list/sorted/{point}/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order,
                     @PathVariable("point") String point){

        List<Route> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<Route> sortedList = service.sortedByPoint(list, order, point);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", sortedList);
        return "routeList";
    }

    @RequestMapping(value = "/list/sorted/{point}/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<Route> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/route/list" : "routeList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("routes", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("routes", service.getAll());
        return "redirect:/web/route/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        RouteForm routeForm = new RouteForm();
        model.addAttribute("routeForm", routeForm);
        return "routeAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("routeForm") RouteForm routeForm){

        Route route = new Route();

        route.setName("name");
        route.setDescription("description");
        route.setStart(routeForm.getStart());
        route.setFinish(routeForm.getFinish());
        route.setDistance(routeForm.getDistance());

        service.save(route);
        model.addAttribute("routes", service.getAll());
        return "redirect:/web/route/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Route route = service.get(id);
        RouteForm routeForm = new RouteForm();

        routeForm.setStart(route.getStart());
        routeForm.setFinish(route.getFinish());
        routeForm.setDistance(route.getDistance());

        model.addAttribute("routeForm", routeForm);
        return "routeAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("routeForm") RouteForm routeForm){

        Route route = new Route();

        route.setId(id);
        route.setName(service.get(id).getName());
        route.setDescription(service.get(id).getDescription());
        route.setDateCreated(service.get(id).getDateCreated());
        route.setDateModified(service.get(id).getDateModified());

        route.setStart(routeForm.getStart());
        route.setFinish(routeForm.getFinish());
        route.setDistance(routeForm.getDistance());

        service.edit(route);
        model.addAttribute("routes", service.getAll());
        return "redirect:/web/route/list";
    }
}
