package edu.nick.cursach.service.TeamLeader.interfaces;

import edu.nick.cursach.model.TeamLeader;

import java.util.List;

public interface ITeamLeaderService {
    TeamLeader save (TeamLeader teamLeader);
    TeamLeader get (String id);
    List<TeamLeader> getAll();
    TeamLeader edit (TeamLeader teamLeader);
    TeamLeader delete(String id);
}
