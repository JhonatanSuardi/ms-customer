package com.financials.customer.core.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException{

    //Should we created an interface for the excpetions? (Controller advice)

    public EntityNotFoundException(String message){
        super(message);
    }

    public HttpStatus getHttpStatus(){
        return HttpStatus.NOT_FOUND;
    }
}
