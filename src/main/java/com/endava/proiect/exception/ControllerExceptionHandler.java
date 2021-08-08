package com.endava.proiect.exception;

import com.endava.proiect.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    private ErrorDto handleBaseException(Exception exception, HttpStatus status) {
        BaseException baseException = (BaseException) exception;
        return new ErrorDto(baseException.getErrorCode(), baseException.getMessage(), status.value());
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorDto handleNotFound(HttpServletRequest request, Exception exception) {
        return handleBaseException(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BookRentedException.class})
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorDto handleForbidden(HttpServletRequest request, Exception exception) {
        return handleBaseException(exception, HttpStatus.FORBIDDEN);
    }
}
