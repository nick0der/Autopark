package edu.nick.cursach.service.TeamLeader.impls;

import edu.nick.cursach.repository.TeamLeaderRepository;
import edu.nick.cursach.model.TeamLeader;
import edu.nick.cursach.service.TeamLeader.interfaces.ITeamLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamLeaderServiceImpl implements ITeamLeaderService {

    @Autowired
    TeamLeaderRepository repository;

    @Override
    public TeamLeader save(TeamLeader teamLeader) {
        teamLeader.setDateCreated(LocalDateTime.now());
        teamLeader.setDateModified(LocalDateTime.now());
        return repository.save(teamLeader);
    }

    @Override
    public TeamLeader get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<TeamLeader> getAll() {
        return repository.findAll();
    }

    @Override
    public TeamLeader edit(TeamLeader teamLeader) {
        teamLeader.setDateCreated(repository.findById(teamLeader.getId()).orElse(null).getDateCreated());
        teamLeader.setDateModified(LocalDateTime.now());
        return repository.save(teamLeader);
    }

    @Override
    public TeamLeader delete(String id) {
        TeamLeader teamLeader = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return teamLeader;
    }

    public List<TeamLeader> search(String word) {
        List<TeamLeader> found = this.getAll().stream()
                .filter(teamLeader -> teamLeader.getLastName().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<TeamLeader> sortedByLastName(List<TeamLeader> list, String order) {
        list.sort(Comparator.comparing(TeamLeader::getLastName));
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }
}
