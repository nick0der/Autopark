package edu.nick.cursach.service.TeamLeader.impls;

import edu.nick.cursach.repository.TeamLeaderRepository;
import edu.nick.cursach.model.TeamLeader;
import edu.nick.cursach.service.TeamLeader.interfaces.ITeamLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        teamLeader.setDateModified(LocalDateTime.now());
        return repository.save(teamLeader);
    }

    @Override
    public TeamLeader delete(String id) {
        TeamLeader teamLeader = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return teamLeader;
    }
}
