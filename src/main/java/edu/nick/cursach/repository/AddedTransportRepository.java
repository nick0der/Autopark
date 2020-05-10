package edu.nick.cursach.repository;

import edu.nick.cursach.model.AddedTransport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddedTransportRepository extends MongoRepository <AddedTransport, String> {
}
