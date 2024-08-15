package com.mango.profile_builder.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mango.profile_builder.model.UserIdentity;

@Repository
public interface UserIdentityRepository extends MongoRepository<UserIdentity, String> {

}
