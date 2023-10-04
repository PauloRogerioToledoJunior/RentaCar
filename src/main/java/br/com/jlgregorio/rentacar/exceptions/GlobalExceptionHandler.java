package br.com.jlgregorio.rentacar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({Exception.class})
    public final ResponseEntity<CustomerException>
                handleAllExceptions(Exception exception, WebRequest request){
        CustomerException customerException = new CustomerException(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customerException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public final ResponseEntity<CustomerException>
    handleResourceNotFoundException(Exception exception, WebRequest request){
        CustomerException customerException = new CustomerException(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(customerException, HttpStatus.NOT_FOUND);
    }
}
