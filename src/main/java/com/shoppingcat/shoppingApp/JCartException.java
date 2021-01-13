package com.shoppingcat.shoppingApp;

public class JCartException extends RuntimeException {

    public JCartException(){
        super();
    }

    public  JCartException(String message,Throwable cause,boolean enableSuppression,boolean writebleStackTrace){
        super(message,cause,enableSuppression,writebleStackTrace);
    }
    public  JCartException(String message,Throwable cause){
        super(message,cause);
    }
    public  JCartException(String message){
        super(message);
    }
    public JCartException(Throwable cause){
        super(cause);
    }

}
