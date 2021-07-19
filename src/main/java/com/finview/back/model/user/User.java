package com.finview.back.model.user;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class User {

    @Id
    private String email;
    private String password;
}
