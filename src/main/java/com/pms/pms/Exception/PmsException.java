package com.pms.pms.Exception;

import org.springframework.http.HttpStatus;

public class PmsException extends RuntimeException{

    private HttpStatus status;

    public PmsException() {
    }

    public PmsException( HttpStatus status, String message) {
        super(message);
        this.status = status;
    }



}
