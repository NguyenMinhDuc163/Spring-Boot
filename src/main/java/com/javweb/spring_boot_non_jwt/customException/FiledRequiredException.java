package com.javweb.spring_boot_non_jwt.customException;

public class FiledRequiredException extends RuntimeException{
    public FiledRequiredException(String message) {
        super(message);
    }

}
