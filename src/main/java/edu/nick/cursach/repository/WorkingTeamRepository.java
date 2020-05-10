package edu.nick.cursach.repository;

import edu.nick.cursach.model.WorkingTeam;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkingTeamRepository extends MongoRepository<WorkingTeam, String> {
}
