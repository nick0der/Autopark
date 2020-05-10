package edu.nick.cursach.dao.TeamLeader.interfaces;

import edu.nick.cursach.model.Taxi;
import edu.nick.cursach.model.TeamLeader;

import java.util.List;

public interface ITeamLeaderDao {
    TeamLeader save (TeamLeader teamLeader);
    TeamLeader get (String id);
    List<TeamLeader> getAll();
    TeamLeader edit (TeamLeader teamLeader);
    TeamLeader delete(String id);
}
