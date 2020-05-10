package edu.nick.cursach.dao.Route.impls;

import edu.nick.cursach.dao.Route.interfaces.IRouteDao;
import edu.nick.cursach.dataSet.DataSet;
import edu.nick.cursach.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteDaoImplFake implements IRouteDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Route save(Route route) {
        return null;
    }

    @Override
    public Route get(String id) {
        return null;
    }

    @Override
    public List<Route> getAll() {
        return dataSet.getRoutes();
    }

    @Override
    public Route edit(Route route) {
        return null;
    }

    @Override
    public Route delete(String id) {
        return null;
    }
}
