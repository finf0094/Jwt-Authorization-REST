package com.lombard.service.exceptions;

import java.util.Date;

public class AppError {
    private int status;
    private String message;
    private Date timeStamp;

    public AppError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = new Date();
    }
}
