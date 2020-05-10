package edu.nick.cursach.repository;

import edu.nick.cursach.model.Taxi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaxiRepository extends MongoRepository<Taxi, String> {
}
