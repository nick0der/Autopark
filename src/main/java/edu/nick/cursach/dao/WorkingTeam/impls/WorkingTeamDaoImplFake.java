package edu.nick.cursach.dao.WorkingTeam.impls;

import edu.nick.cursach.dao.WorkingTeam.interfaces.IWorkingTeamDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.WorkingTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkingTeamDaoImplFake implements IWorkingTeamDao {

    @Autowired
    DataSet dataSet;

    @Override
    public WorkingTeam save(WorkingTeam workingTeam) {
        return null;
    }

    @Override
    public WorkingTeam get(String id) {
        return null;
    }

    @Override
    public List<WorkingTeam> getAll() {
        return dataSet.getWorkingTeams();
    }

    @Override
    public WorkingTeam edit(WorkingTeam workingTeam) {
        return null;
    }

    @Override
    public WorkingTeam delete(String id) {
        return null;
    }
}
