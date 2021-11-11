package com.finview.back.model.user;

import org.springframework.data.annotation.Id;


public record User(
        @Id
        String email,
        String password
) {
}
