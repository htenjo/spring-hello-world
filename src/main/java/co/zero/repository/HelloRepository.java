package co.zero.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.zero.model.HelloModel;

public interface HelloRepository extends MongoRepository<HelloModel, String> {
}
