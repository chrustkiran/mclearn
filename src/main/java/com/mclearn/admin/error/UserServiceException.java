package com.mclearn.admin.error;

public class UserServiceException extends RuntimeException{
    public UserServiceException(String message) {
        super(message);
    }
}
