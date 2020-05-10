package edu.nick.cursach.repository;

import edu.nick.cursach.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, String> {
}
