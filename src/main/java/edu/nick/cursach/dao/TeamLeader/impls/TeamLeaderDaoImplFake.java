package edu.nick.cursach.dao.TeamLeader.impls;

import edu.nick.cursach.dao.TeamLeader.interfaces.ITeamLeaderDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.TeamLeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamLeaderDaoImplFake implements ITeamLeaderDao {

    @Autowired
    DataSet dataSet;

    @Override
    public TeamLeader save(TeamLeader teamLeader) {
        return null;
    }

    @Override
    public TeamLeader get(String id) {
        return null;
    }

    @Override
    public List<TeamLeader> getAll() {
        return dataSet.getTeamLeaders();
    }

    @Override
    public TeamLeader edit(TeamLeader teamLeader) {
        return null;
    }

    @Override
    public TeamLeader delete(String id) {
        return null;
    }
}
