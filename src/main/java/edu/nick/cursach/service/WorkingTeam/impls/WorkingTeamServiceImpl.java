package edu.nick.cursach.service.WorkingTeam.impls;

import edu.nick.cursach.repository.WorkingTeamRepository;
import edu.nick.cursach.model.WorkingTeam;
import edu.nick.cursach.service.WorkingTeam.interfaces.IWorkingTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkingTeamServiceImpl implements IWorkingTeamService {

    @Autowired
    WorkingTeamRepository repository;

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

    public List<WorkingTeam> search(Integer word) {
        if ((word == 0)||(word == null)) {
            return this.getAll();
        }
        List<WorkingTeam> found = this.getAll().stream()
                .filter(workingTeam -> Integer.toString(workingTeam.getNumber()).contains(word.toString()))
                .collect(Collectors.toList());
        return found;
    }

    public List<WorkingTeam> sortedByNumber(List<WorkingTeam> list, String order) {
        Collections.sort(list, (o1, o2) -> {
            if (o1.getNumber() == o2.getNumber()) {
                return 0;
            } else if (o1.getNumber() < o2.getNumber()) {
                return -1;
            }
            return 1; });
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
