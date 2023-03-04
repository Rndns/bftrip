package com.portfolio.bftrip.exception;

public class NotValidImageException extends RuntimeException {

    private static final String MESSAGE = "유효하지 않은 파일형식입니다.";

    public NotValidImageException() {
        super(MESSAGE);
    }
}
