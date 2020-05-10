package edu.nick.cursach.service.WorkingTeam.interfaces;

import edu.nick.cursach.model.WorkingTeam;

import java.util.List;

public interface IWorkingTeamService {
    WorkingTeam save (WorkingTeam workingTeam);
    WorkingTeam get (String id);
    List<WorkingTeam> getAll();
    WorkingTeam edit (WorkingTeam workingTeam);
    WorkingTeam delete(String id);
}
