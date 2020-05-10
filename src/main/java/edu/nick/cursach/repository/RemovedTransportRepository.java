package edu.nick.cursach.repository;

import edu.nick.cursach.model.RemovedTransport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RemovedTransportRepository extends MongoRepository<RemovedTransport, String> {
}
