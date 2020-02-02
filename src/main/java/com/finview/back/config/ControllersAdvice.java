package com.finview.back.config;

import com.finview.back.model.exception.ExceptionDto;
import com.finview.back.model.exception.HttpException;
import com.finview.back.model.exception.InternalServerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;


@ControllerAdvice
@Slf4j
public class ControllersAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ExceptionDto> handleUnpredictedExceptions(MethodArgumentNotValidException e) {
        exceptionWarnLog(e);
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionDto("Validation Failed", e.getMessage()));
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ExceptionDto> handleHttpException(HttpException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new ExceptionDto(e.getMessage(), e.getDetailed()));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionDto> handleUnpredictedExceptions(Exception e) {
        exceptionErrorLog(e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionDto(e.getMessage(), null));
    }



    private void exceptionWarnLog(Exception e) {
        log.warn(e.getMessage(), e);
    }

    private void exceptionErrorLog(Exception e) {
        log.error(e.getMessage(), e);
    }
}
