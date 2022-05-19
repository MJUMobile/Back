package com.mju.mobile.Exception.Auth;

public class AuthNotFoundException extends RuntimeException{

    public AuthNotFoundException() {
        super();
    }

    public AuthNotFoundException(String message) {
        super(message);
    }

    public AuthNotFoundException(String message, Throwable th) {
        super(message, th);
    }
}
