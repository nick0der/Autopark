package edu.nick.cursach.service.Route.impls;

import edu.nick.cursach.model.Transport;
import edu.nick.cursach.repository.RouteRepository;
import edu.nick.cursach.model.Route;
import edu.nick.cursach.service.Route.interfaces.IRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        route.setDateCreated(repository.findById(route.getId()).orElse(null).getDateCreated());
        route.setDateModified(LocalDateTime.now());
        return repository.save(route);
    }

    @Override
    public Route delete(String id) {
        Route route = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return route;
    }

    public List<Route> search(String word) {
        List<Route> found = this.getAll().stream()
                .filter(route -> route.getFullTitle().toUpperCase().contains(word.toUpperCase()))
                .collect(Collectors.toList());
        return found;
    }

    public List<Route> sortedByPoint(List<Route> list, String order, String point) {
        if (point.contains("start")) {
            list.sort(Comparator.comparing(Route::getStart));
        } else {
            list.sort(Comparator.comparing(Route::getFinish));
        }
        if (order.contains("desc")) { Collections.reverse(list); }
        return list;
    }

}
