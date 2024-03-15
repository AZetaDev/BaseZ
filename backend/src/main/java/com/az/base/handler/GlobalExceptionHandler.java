package com.az.base.handler;

import com.az.base.exception.*;
import com.az.base.record.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorMessage> handleAccessDeniedException(AccessDeniedException ex) {
        return createErrorMessage(ex, HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN.toString(), ex.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorMessage> handleConflictException(ConflictException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ErrorMessage> handleExpiredJwtException(ExpiredJwtException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(io.jsonwebtoken.ExpiredJwtException.class)
    public ResponseEntity<ErrorMessage> handleNormalExpiredJwtException(io.jsonwebtoken.ExpiredJwtException ex) {
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.FORBIDDEN.value(),
                "JWT CADUCAO! Menuda CAGADA!",
                "TEAAAA POOOOOOOT",
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorMessage> handleForbiddenException(ForbiddenException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ErrorMessage> handleInternalServerException(InternalServerException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(NotFoundException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(NullpointerException.class)
    public ResponseEntity<ErrorMessage> handleNullpointerException(NullpointerException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<ErrorMessage> handleUnAuthorizedException(UnAuthorizedException ex) {
        return createErrorMessage(ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGenericException(Exception ex) {
        ErrorMessage errorMessage = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error",
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorMessage> createErrorMessage(CustomException ex) {
        ErrorMessage errorMessage = new ErrorMessage(
                ex.getHttpStatus().value(),
                ex.getMessage(),
                ex.getErrorCode(),
                ex.getErrorDetails(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
    }

    private ResponseEntity<ErrorMessage> createErrorMessage(Exception ex, HttpStatus httpStatus, String code, String details) {
        ErrorMessage errorMessage = new ErrorMessage(
                httpStatus.value(),
                ex.getMessage(),
                code,
                details,
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorMessage, httpStatus);
    }
}
