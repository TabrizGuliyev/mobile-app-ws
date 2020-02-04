package com.tabrizguliyev.app.ws.exceptions;

public class UserServiceException extends RuntimeException {


    private static final long serialVersionUID = 6752573358120132191L;

    public UserServiceException(String message){
        super(message);
    }

}
