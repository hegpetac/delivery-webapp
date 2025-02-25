package com.backend.user.entity;

public enum ERole {
    CUSTOMER,
    DRIVER,
    HANDLER;

    ERole() {}

    public String value() {
        return name();
    }

    public static ERole fromValue(String value) {
        return valueOf(value);
    }
}
