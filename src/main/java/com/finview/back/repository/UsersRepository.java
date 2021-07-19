package com.finview.back.repository;

import com.finview.back.model.user.User;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface UsersRepository extends KeyValueRepository<User, String> {
}
