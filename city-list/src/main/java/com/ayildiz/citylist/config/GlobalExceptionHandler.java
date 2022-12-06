package com.ayildiz.citylist.config;

/*
 * @author abdurrahman.yildiz
 * @created on 11/30/2022
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<?> handleExceptions(Throwable exc) {
        logger.error(exc.getMessage(), exc);
        return new ResponseEntity<>(exc.getMessage(), getStatusCode(exc));
    }

    public HttpStatus getStatusCode(Throwable exc) {

        switch (exc.getClass().getSimpleName()) {
            case "IllegalArgumentException":
            case "CityNotFoundException":
                return HttpStatus.BAD_REQUEST;
            default:
                break;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
