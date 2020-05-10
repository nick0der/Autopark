package edu.nick.cursach.controller.api;

import edu.nick.cursach.model.StorageObj;
import edu.nick.cursach.service.StorageObj.impls.StorageObjServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storageObj")
public class StorageObjAPIController {

    @Autowired
    StorageObjServiceImpl service;

    @RequestMapping("/get/list")
    List<StorageObj> getAll(){
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    StorageObj getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    StorageObj create(@RequestBody StorageObj storageObj) {
        return service.save(storageObj);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    StorageObj edit(@RequestBody StorageObj storageObj) {
        return service.edit(storageObj);
    }

    @RequestMapping("/delete/{id}")
    StorageObj delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
