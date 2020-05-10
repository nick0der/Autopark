package edu.nick.cursach.repository;

import edu.nick.cursach.model.StorageObj;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StorageObjRepository extends MongoRepository<StorageObj, String> {
}
