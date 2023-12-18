package com.mclearn.admin.error;

public class InValidRequest extends RuntimeException {
    public InValidRequest(String message) {
        super(message);
    }

    protected String foo() {
        return "";
    }
}
