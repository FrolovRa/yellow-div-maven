package com.helios.test.model;

public class Response {

    private final int number;

    private final String color;

    public Response(int number, String color) {
        this.color = color;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }
}
