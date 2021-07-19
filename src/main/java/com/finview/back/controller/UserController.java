package com.finview.back.controller;

import com.finview.back.mapper.UsersMapper;
import com.finview.back.model.exception.NotFoundException;
import com.finview.back.model.user.UserDto;
import com.finview.back.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@ConditionalOnProperty("feature.user.enable")
public class UserController {
    private final UsersService service;
    private final UsersMapper mapper;

    @PostMapping
    public UserDto saveUser(@RequestBody @Valid UserDto userDto) {
        var user = mapper.map(userDto);
        var dbUser = service.save(user);
        return mapper.map(dbUser);
    }

    @GetMapping
    public UserDto get(@RequestParam("email") String email) {
        return service.get(email)
                .map(mapper::map)
                .orElseThrow(() -> new NotFoundException("No user found for email:" + email));
    }
}
