package edu.nick.cursach.repository;

import edu.nick.cursach.model.Chief;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChiefRepository extends MongoRepository<Chief, String> {
}
