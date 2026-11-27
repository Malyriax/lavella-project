package com.lavella.exception;

public class ResourceConflictException extends RuntimeException {
    public ResourceConflictException(String message){
        super(message);
    }

    public ResourceConflictException(String name, Object id){
        super(name + " business logic error: " + id);
    }
}
