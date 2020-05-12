package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.SearchForm;
import edu.nick.cursach.model.Chief;
import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.form.StorageObjForm;
import edu.nick.cursach.service.Chief.impls.ChiefServiceImpl;
import edu.nick.cursach.service.StorageObj.impls.StorageObjServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/storageObj")
public class StorageObjWEBController {

    @Autowired
    ChiefServiceImpl chiefService;

    @Autowired
    StorageObjServiceImpl service;

    private Integer searchWord = 0;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model){
        searchWord = 0;
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("storageObjs", service.getAll());
        return "storageObjList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
        searchWord = searchForm.getString().length() != 0 ? Integer.parseInt(searchForm.getString()) : 0;
        List<StorageObj> list = service.search(searchWord);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("storageObjs", list);
        return "storageObjList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.GET)
    String getSorted(Model model, @PathVariable("order") String order){

        List<StorageObj> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        List<StorageObj> sortedList = service.sortedByNumber(list, order);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("storageObjs", sortedList);
        return "storageObjList";
    }

    @RequestMapping(value = "/list/sorted/{order}", method = RequestMethod.POST)
    String searchSorted(Model model, @ModelAttribute("searchForm") SearchForm searchForm, @PathVariable("order") String order){
        searchWord = searchForm.getString().length() != 0 ? Integer.parseInt(searchForm.getString()) : 0;
        List<StorageObj> list = searchWord.equals("") ? service.getAll() : service.search(searchWord);
        String toReturn = searchWord.equals("") ? "redirect:/web/storageObj/list" : "storageObjList";
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("storageObjs", list);
        return toReturn;
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model, @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("storageObjs", service.getAll());
        return "redirect:/web/storageObj/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        StorageObjForm storageObjForm = new StorageObjForm();
        Map<String, String> mavs = chiefService.getAll().stream().collect(
                Collectors.toMap(Chief::getId, Chief::getFullName));

        List<String> types = new ArrayList<>(Arrays.asList("garage", "department", "box", "workshop", "storage"));

        model.addAttribute("mavs", mavs);
        model.addAttribute("types", types);
        model.addAttribute("storageObjForm", storageObjForm);
        return "storageObjAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("storageObjForm") StorageObjForm storageObjForm){

        StorageObj storageObj = new StorageObj();

        storageObj.setName("name");
        storageObj.setDescription("description");

        storageObj.setType(storageObjForm.getType());
        storageObj.setArea(storageObjForm.getArea());
        storageObj.setNumber(storageObjForm.getNumber());
        storageObj.setCapacity(storageObjForm.getCapacity());
        storageObj.setChief(chiefService.get(storageObjForm.getChief()));

        service.save(storageObj);
        model.addAttribute("storageObjs", service.getAll());
        return "redirect:/web/storageObj/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        StorageObj storageObj = service.get(id);
        StorageObjForm storageObjForm = new StorageObjForm();

        Map<String, String> mavs = chiefService.getAll().stream().collect(
                Collectors.toMap(Chief::getId, Chief::getFullName));

        String dflt = storageObj.getChief().getId();

        storageObjForm.setType(storageObj.getType());
        storageObjForm.setArea(storageObj.getArea());
        storageObjForm.setNumber(storageObj.getNumber());
        storageObjForm.setCapacity(storageObj.getCapacity());
        storageObjForm.setChief(storageObj.getChief().getId());


        List<String> types = new ArrayList<>(Arrays.asList("garage", "department", "box", "workshop", "storage"));

        model.addAttribute("types", types);
        model.addAttribute("mavs", mavs);
        model.addAttribute("dflt", dflt);
        model.addAttribute("storageObjForm", storageObjForm);
        return "storageObjAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("storageObjForm") StorageObjForm storageObjForm){

        StorageObj storageObj = new StorageObj();

        storageObj.setId(id);
        storageObj.setName(service.get(id).getName());
        storageObj.setDescription(service.get(id).getDescription());
        storageObj.setDateCreated(service.get(id).getDateCreated());
        storageObj.setDateModified(service.get(id).getDateModified());

        storageObj.setType(storageObjForm.getType());
        storageObj.setArea(storageObjForm.getArea());
        storageObj.setNumber(storageObjForm.getNumber());
        storageObj.setCapacity(storageObjForm.getCapacity());
        storageObj.setChief(chiefService.get(storageObjForm.getChief()));

        service.edit(storageObj);
        model.addAttribute("storageObjs", service.getAll());
        return "redirect:/web/storageObj/list";
    }
}
