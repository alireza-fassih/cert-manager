package ir.fassih.homework.certmanager.controller

import ir.fassih.homework.certmanager.configuration.ApiResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import javax.servlet.http.HttpServletRequest


@RestControllerAdvice
class MyErrorController  {

    val logger : Logger = LoggerFactory.getLogger(javaClass);

    @ExceptionHandler( AccessDeniedException::class )
    fun handleError( ex : AccessDeniedException ): ApiResponse {
        return ApiResponse(403, "Access Denied")
    }



    @ExceptionHandler( Exception::class )
    fun totalException(ex: ExceptionHandler): ApiResponse {
        return ApiResponse(500, "Internal errror")
    }


}


@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler( AccessDeniedException::class )
    fun handleAccessDeniedException(ex : Exception , request: WebRequest ) : ResponseEntity<String> {
        return ResponseEntity<String>("Access denied message here", HttpHeaders(), HttpStatus.FORBIDDEN);
    }


}