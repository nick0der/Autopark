package edu.nick.cursach.repository;

import edu.nick.cursach.model.Master;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MasterRepository extends MongoRepository<Master, String> {
}
