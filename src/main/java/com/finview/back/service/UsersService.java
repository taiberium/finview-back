package com.finview.back.service;

import com.finview.back.model.user.User;
import com.finview.back.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public Optional<User> get(String email) {
        return repository.findFirstByEmail(email);
    }
}
