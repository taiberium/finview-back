package com.finview.back.model.user;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@NotNull
public class UserDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
}
