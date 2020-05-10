package edu.nick.cursach.repository;

import edu.nick.cursach.model.PassangerTransportation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassangerTransportationRepository extends MongoRepository<PassangerTransportation, String> {
}
