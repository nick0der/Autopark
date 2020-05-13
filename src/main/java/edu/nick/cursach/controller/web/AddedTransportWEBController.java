package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.AddedTransportForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.AddedTransport;
import edu.nick.cursach.service.AddedTransport.impls.AddedTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/web/addedTransport")
public class AddedTransportWEBController {

    String searchWord = "";

    @Autowired
    AddedTransportServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("addedTransports", service.getAll());
        return "addedTransportList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        //TODO delete
        HttpSecurity http;
        searchWord = searchForm.getString();
        List<AddedTransport> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("addedTransports", list);
        return "addedTransportList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<AddedTransport> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<AddedTransport> sortedList = service.sortedByDate(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("addedTransports", sortedList);
        return "addedTransportList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<AddedTransport> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/addedTransport/list" : "addedTransportList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("addedTransports", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("addedTransports", service.getAll());
        return "redirect:/web/addedTransport/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        AddedTransportForm addedTransportForm = new AddedTransportForm();
        model.addAttribute("addedTransportForm", addedTransportForm);

        return "addedTransportAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("addedTransportForm") AddedTransportForm addedTransportForm){

        AddedTransport addedTransport = new AddedTransport();
        System.out.println(addedTransportForm.getBrand());
        addedTransport.setName("name");
        addedTransport.setDescription("description");
        addedTransport.setDateAdded(LocalDate.parse(addedTransportForm.getDateAdded()));
        addedTransport.setBrand(addedTransportForm.getBrand());
        addedTransport.setInfo(addedTransportForm.getInfo());

        service.save(addedTransport);
        model.addAttribute("addedTransports", service.getAll());
        return "redirect:/web/addedTransport/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        AddedTransport addedTransport = service.get(id);
        AddedTransportForm addedTransportForm = new AddedTransportForm();

        addedTransportForm.setBrand(addedTransport.getBrand());
        addedTransportForm.setDateAdded(addedTransport.getDateAdded().toString());
        addedTransportForm.setInfo(addedTransport.getInfo());

        model.addAttribute("addedTransportForm", addedTransportForm);

        return "addedTransportAdd";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("addedTransportForm") AddedTransportForm addedTransportForm){

        AddedTransport addedTransport = new AddedTransport();

        addedTransport.setId(id);
        addedTransport.setName(service.get(id).getName());
        addedTransport.setDescription(service.get(id).getDescription());
        addedTransport.setDateCreated(service.get(id).getDateCreated());
        addedTransport.setDateModified(service.get(id).getDateModified());

        addedTransport.setDateAdded(LocalDate.parse(addedTransportForm.getDateAdded()));
        addedTransport.setBrand(addedTransportForm.getBrand());
        addedTransport.setInfo(addedTransportForm.getInfo());

        service.edit(addedTransport);
        model.addAttribute("addedTransports", service.getAll());
        return "redirect:/web/addedTransport/list";
    }
}
