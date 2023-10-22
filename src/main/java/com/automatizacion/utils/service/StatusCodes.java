package com.automatizacion.utils.service;

public enum StatusCodes {

    OK(200, "Servicio Exitoso", "200 OK");

    private int code;
    private String description;
    private String detail;

    StatusCodes(int code, String description, String detail) {
        this.code = code;
        this.description = description;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getDetail() {
        return detail;
    }
}