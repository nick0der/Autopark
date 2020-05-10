package edu.nick.cursach.service.Route.impls;

import edu.nick.cursach.dao.Route.impls.RouteDaoImplFake;
import edu.nick.cursach.repository.RouteRepository;
import edu.nick.cursach.model.Route;
import edu.nick.cursach.service.Route.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteServiceImpl implements IRouteService {

    @Autowired
    RouteDaoImplFake dao;

    @Autowired
    RouteRepository repository;

    @PostConstruct
    void init(){
//        List<Route> list = dao.getAll();
//        repository.saveAll(list);
    }

    @Override
    public Route save(Route route) {
        route.setDateCreated(LocalDateTime.now());
        route.setDateModified(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Route> getAll() {
        return repository.findAll();
    }

    @Override
    public Route edit(Route route) {
        route.setDateModified(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route delete(String id) {
        Route route = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return route;
    }
}
