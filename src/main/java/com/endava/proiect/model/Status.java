package com.endava.proiect.model;

public enum Status {

    AVAILABLE("available"),
    ORDERED("ordered");

    private String value;

    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
