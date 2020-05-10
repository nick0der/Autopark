package edu.nick.cursach.repository;

import edu.nick.cursach.model.RouteTaxi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteTaxiRepository extends MongoRepository<RouteTaxi, String> {
}
