package com.ti.api.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ti.api.Documents.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}