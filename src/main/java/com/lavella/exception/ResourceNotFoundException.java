package com.lavella.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String name, Object id){
        super(name + " not found with id: " + id);
    }
}
