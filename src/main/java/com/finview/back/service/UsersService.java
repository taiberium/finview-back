package com.finview.back.service;

import com.finview.back.model.user.User;
import com.finview.back.repository.UsersRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@ConditionalOnProperty("feature.user.enable")
public record UsersService(
        UsersRepository repository
) {
    public User save(User user) {
        return repository.save(user);
    }

    public Optional<User> get(String email) {
        return repository.findById(email);
    }
}
