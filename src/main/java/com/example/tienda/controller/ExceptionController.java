package com.example.tienda.controller;


import com.example.tienda.exception.NotFoundLaptopException;
import com.example.tienda.exception.UserRegisterException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController  {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> exception(Exception e){
        return ResponseEntity.internalServerError().body("Errooooooor");
    }
    @ExceptionHandler(UserRegisterException.class)
    public ResponseEntity<?> userException(Exception e){
        Map<String,Object> error=new HashMap<>();
        error.put("message",e.getMessage());
        error.put("status",HttpStatus.CONFLICT.value());
        error.put("cause",e.getCause());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    @ExceptionHandler({NoHandlerFoundException.class, ChangeSetPersister.NotFoundException.class})
    public ResponseEntity<?> notFoundException(NoHandlerFoundException e){
        Map<String,Object> error=new HashMap<>();
        error.put("message",e.getMessage());
        error.put("status",e.getStatusCode().value());
        error.put("cause",e.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<?> NumberFormatException(NumberFormatException e){
        Map<String,Object> error=new HashMap<>();
        error.put("message","Formato del  id incorrecto");
        error.put("status",HttpStatus.CONFLICT.value());
        error.put("cause",e.getCause());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
    @ExceptionHandler(NotFoundLaptopException.class)
    public ResponseEntity<?> notFoundLaptopException(NotFoundLaptopException e){
        Map<String,Object> error=new HashMap<>();
        error.put("message",e.getMessage());
        error.put("status",HttpStatus.NOT_FOUND.value());
        error.put("cause",e.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
