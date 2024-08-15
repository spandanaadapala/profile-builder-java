package com.mango.profile_builder.exception;

public class UserAlreadyExistException extends RuntimeException {
 public UserAlreadyExistException(String message){
    super(message);
 }
}
