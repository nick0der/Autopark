package edu.nick.cursach.service.WorkingTeam.impls;

import edu.nick.cursach.dao.WorkingTeam.impls.WorkingTeamDaoImplFake;
import edu.nick.cursach.repository.WorkingTeamRepository;
import edu.nick.cursach.model.WorkingTeam;
import edu.nick.cursach.service.WorkingTeam.interfaces.IWorkingTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkingTeamServiceImpl implements IWorkingTeamService {

    @Autowired
    WorkingTeamDaoImplFake dao;

    @Autowired
    WorkingTeamRepository repository;

    @PostConstruct
    void init(){
//        List<WorkingTeam> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public WorkingTeam save(WorkingTeam workingTeam) {
        workingTeam.setDateCreated(LocalDateTime.now());
        workingTeam.setDateModified(LocalDateTime.now());
        return repository.save(workingTeam);
    }

    @Override
    public WorkingTeam get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<WorkingTeam> getAll() {
        return repository.findAll();
    }

    @Override
    public WorkingTeam edit(WorkingTeam workingTeam) {
        workingTeam.setDateModified(LocalDateTime.now());
        return repository.save(workingTeam);
    }

    @Override
    public WorkingTeam delete(String id) {
        WorkingTeam workingTeam = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return workingTeam;
    }
}
