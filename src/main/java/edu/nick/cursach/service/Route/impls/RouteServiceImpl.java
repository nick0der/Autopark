package edu.nick.cursach.service.Route.impls;

import edu.nick.cursach.repository.RouteRepository;
import edu.nick.cursach.model.Route;
import edu.nick.cursach.service.Route.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RouteServiceImpl implements IRouteService {

    @Autowired
    RouteRepository repository;

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
