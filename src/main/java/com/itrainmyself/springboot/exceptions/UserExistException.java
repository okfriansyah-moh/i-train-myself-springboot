package com.itrainmyself.springboot.exceptions;

public class UserExistException extends Exception {

    private static final long serialVersionUID = 1L;

    public UserExistException(String message) {
        super(message);
    }
}
