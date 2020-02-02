package com.finview.back.repository;

import com.finview.back.model.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<User, String> {
    Optional<User> findFirstByEmail(String email);
}
