package edu.nick.cursach.repository;

import edu.nick.cursach.model.FreightTransport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FreightTransportRepository extends MongoRepository<FreightTransport, String> {
}
