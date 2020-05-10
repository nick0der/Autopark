package edu.nick.cursach.repository;

import edu.nick.cursach.model.Repair;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepairRepository extends MongoRepository<Repair, String> {
}
