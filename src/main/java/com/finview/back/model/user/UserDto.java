package com.finview.back.model.user;

import javax.validation.constraints.NotNull;


@NotNull
public record UserDto(
        @NotNull
        String email,
        @NotNull
        String password
) {
}
