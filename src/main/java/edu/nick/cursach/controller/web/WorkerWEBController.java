package edu.nick.cursach.controller.web;

import edu.nick.cursach.form.WorkerForm;
import edu.nick.cursach.model.Worker;
import edu.nick.cursach.model.WorkingTeam;
import edu.nick.cursach.service.Worker.impls.WorkerServiceImpl;
import edu.nick.cursach.service.WorkingTeam.impls.WorkingTeamServiceImpl;
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
@RequestMapping("/web/worker")
public class WorkerWEBController {


    @Autowired
    WorkingTeamServiceImpl workingTeamService;

    @Autowired
    WorkerServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("workers", service.getAll());
        return "workerList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("workers", service.getAll());
        return "redirect:/web/worker/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){

        WorkerForm workerForm = new WorkerForm();

        Map<String, Integer> mavs = workingTeamService.getAll().stream().collect(
                Collectors.toMap(WorkingTeam::getId, WorkingTeam::getNumber));

        List<String> types = new ArrayList<>(Arrays.asList("mechanic", "technician", "welder", "detailer", "electrician"));

        model.addAttribute("mavs", mavs);
        model.addAttribute("types", types);
        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("workerForm") WorkerForm workerForm){

        Worker worker = new Worker();

        worker.setName("name");
        worker.setDescription("description");

        worker.setSpeciality(workerForm.getSpeciality());
        worker.setFirstName(workerForm.getFirstName());
        worker.setLastName(workerForm.getLastName());
        worker.setPatronymic(workerForm.getPatronymic());
        worker.setSalary(workerForm.getSalary());
        worker.setExperience(workerForm.getExperience());
        worker.setWorkingTeam(workingTeamService.get(workerForm.getWorkingTeam()));

        service.save(worker);
        model.addAttribute("workers", service.getAll());
        return "redirect:/web/worker/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){

        Worker worker = service.get(id);
        WorkerForm workerForm = new WorkerForm();

        Map<String, Integer> mavs = workingTeamService.getAll().stream().collect(
                Collectors.toMap(WorkingTeam::getId, WorkingTeam::getNumber));

        List<String> types = new ArrayList<>(Arrays.asList("mechanic", "technician", "welder", "detailer", "electrician"));

        String dflt = worker.getWorkingTeam().getId();

        workerForm.setSpeciality(worker.getSpeciality());
        workerForm.setFirstName(worker.getFirstName());
        workerForm.setLastName(worker.getLastName());
        workerForm.setPatronymic(worker.getPatronymic());
        workerForm.setSalary(worker.getSalary());
        workerForm.setExperience(worker.getExperience());
        workerForm.setWorkingTeam(worker.getWorkingTeam().getId());

        model.addAttribute("mavs", mavs);
        model.addAttribute("types", types);
        model.addAttribute("dflt", dflt);
        model.addAttribute("workerForm", workerForm);
        return "workerAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("workerForm") WorkerForm workerForm){

        Worker worker = new Worker();

        worker.setId(id);
        worker.setName(service.get(id).getName());
        worker.setDescription(service.get(id).getDescription());
        worker.setDateCreated(service.get(id).getDateCreated());
        worker.setDateModified(service.get(id).getDateModified());

        worker.setSpeciality(workerForm.getSpeciality());
        worker.setFirstName(workerForm.getFirstName());
        worker.setLastName(workerForm.getLastName());
        worker.setPatronymic(workerForm.getPatronymic());
        worker.setSalary(workerForm.getSalary());
        worker.setExperience(workerForm.getExperience());

        worker.setWorkingTeam(workingTeamService.get(workerForm.getWorkingTeam()));

        service.edit(worker);
        model.addAttribute("workers", service.getAll());
        return "redirect:/web/worker/list";
    }
}
