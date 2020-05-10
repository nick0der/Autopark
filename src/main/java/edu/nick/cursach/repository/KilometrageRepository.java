package edu.nick.cursach.repository;

import edu.nick.cursach.model.Kilometrage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KilometrageRepository extends MongoRepository<Kilometrage, String> {
}
