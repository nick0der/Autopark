package edu.nick.cursach.repository;

import edu.nick.cursach.model.Transportation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransportationRepository extends MongoRepository<Transportation, String> {
}
