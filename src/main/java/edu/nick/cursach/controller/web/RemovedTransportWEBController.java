package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.RemovedTransportForm;
import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.RemovedTransport;
import edu.nick.cursach.service.RemovedTransport.impls.RemovedTransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/web/removedTransport")
public class RemovedTransportWEBController {

    @Autowired
    RemovedTransportServiceImpl service;

    private String searchWord = "";

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = "";
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("removedTransports", service.getAll());
        return "removedTransportList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString();
        List<RemovedTransport> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("removedTransports", list);
        return "removedTransportList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<RemovedTransport> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<RemovedTransport> sortedList = service.sortedByDate(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("removedTransports", sortedList);
        return "removedTransportList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString();
        List<RemovedTransport> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/removedTransport/list" : "removedTransportList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("removedTransports", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("removedTransports", service.getAll());
        return "redirect:/web/removedTransport/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        RemovedTransportForm removedTransportForm = new RemovedTransportForm();
        model.addAttribute("removedTransportForm", removedTransportForm);

        return "removedTransportAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("removedTransportForm") RemovedTransportForm removedTransportForm){

        RemovedTransport removedTransport = new RemovedTransport();

        removedTransport.setName("name");
        removedTransport.setDescription("description");
        removedTransport.setDateRemoved(LocalDate.parse(removedTransportForm.getDateRemoved()));
        removedTransport.setBrand(removedTransportForm.getBrand());
        removedTransport.setInfo(removedTransportForm.getInfo());
        service.save(removedTransport);
        model.addAttribute("removedTransports", service.getAll());
        return "redirect:/web/removedTransport/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        RemovedTransport removedTransport = service.get(id);
        RemovedTransportForm removedTransportForm = new RemovedTransportForm();

        removedTransportForm.setBrand(removedTransport.getBrand());
        removedTransportForm.setDateRemoved(removedTransport.getDateRemoved().toString());
        removedTransportForm.setInfo(removedTransport.getInfo());

        model.addAttribute("removedTransportForm", removedTransportForm);

        return "removedTransportAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("removedTransportForm") RemovedTransportForm removedTransportForm){

        RemovedTransport removedTransport = new RemovedTransport();

        removedTransport.setId(id);
        removedTransport.setName(service.get(id).getName());
        removedTransport.setDescription(service.get(id).getDescription());
        removedTransport.setDateCreated(service.get(id).getDateCreated());
        removedTransport.setDateModified(service.get(id).getDateModified());

        removedTransport.setDateRemoved(LocalDate.parse(removedTransportForm.getDateRemoved()));
        removedTransport.setBrand(removedTransportForm.getBrand());
        removedTransport.setInfo(removedTransportForm.getInfo());

        service.edit(removedTransport);
        model.addAttribute("removedTransports", service.getAll());
        return "redirect:/web/removedTransport/list";
    }
}
