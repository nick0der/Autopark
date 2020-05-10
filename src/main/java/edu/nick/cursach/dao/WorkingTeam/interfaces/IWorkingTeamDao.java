package edu.nick.cursach.dao.WorkingTeam.interfaces;

import edu.nick.cursach.model.Worker;
import edu.nick.cursach.model.WorkingTeam;

import java.util.List;

public interface IWorkingTeamDao {
    WorkingTeam save (WorkingTeam workingTeam);
    WorkingTeam get (String id);
    List<WorkingTeam> getAll();
    WorkingTeam edit (WorkingTeam workingTeam);
    WorkingTeam delete(String id);
}
