package edu.nick.cursach.repository;

import edu.nick.cursach.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository <Bus, String> {
}
