package com.limluc.vc2wt.exception;

public class VCClientException extends RuntimeException {

    public VCClientException(String message, Exception e) {
        super(message);
    }

}
