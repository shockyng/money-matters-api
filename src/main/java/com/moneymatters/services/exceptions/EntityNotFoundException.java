package com.moneymatters.services.exceptions;

public class EntityNotFoundException extends RuntimeException{

    static final long serialVersionUID = 1L;

    public EntityNotFoundException(Object id) {
        super("Resource not found. User from Id " + id);
    }

}