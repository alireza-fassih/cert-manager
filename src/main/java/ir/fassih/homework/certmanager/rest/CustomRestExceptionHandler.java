package ir.fassih.homework.certmanager.rest;

import ir.fassih.homework.certmanager.rest.model.ActionResult;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomRestExceptionHandler {


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(BadCredentialsException.class)
    public ActionResult<String> badCredentialsExceptionHandler(BadCredentialsException ex) {
        return new ActionResult<>("CredentialsNotFound");
    }


}
