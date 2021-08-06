package com.endava.proiect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class BookRentedException extends BaseException {

    public BookRentedException(String message, String errorCode) {
        super(message, errorCode);
    }

    public BookRentedException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
