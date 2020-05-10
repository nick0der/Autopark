package edu.nick.cursach.repository;

import edu.nick.cursach.model.TeamLeader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamLeaderRepository extends MongoRepository<TeamLeader, String> {
}
