package com.finview.back.model.exception;

import lombok.Value;

@Value
public class ExceptionDto {
    private final String message;
    private final String detailed;
}

